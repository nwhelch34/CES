package com.example.CES;


import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class CESController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PaymentCardRepository paymentCardRepo;

    @Autowired
    private AddressRepository addressRepo;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping("/login")
    public ModelAndView login(ModelAndView model) {
        model.setViewName("login");

        return model;
    }

    @RequestMapping("/login/forgotpass")
    public ModelAndView forgotPass(ModelAndView model) {
        model.setViewName("forgotpw");

        return model;
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDto());
        model.addAttribute("paymentCard", new PaymentCard());
        model.addAttribute("address", new Address());
        return "Registration";
    }

    @PostMapping("/process_register")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model, Address address, PaymentCard paymentCard) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "Registration";
        }

        addressRepo.save(address);
        userDto.setAddress(address);
        userService.saveUser(userDto);
        User user = userService.findUserByEmail(userDto.getEmail());
        paymentCard.setUser(user);
        paymentCardRepo.save(paymentCard);


        return "home";
    }


    @RequestMapping("/editprofile/{email}")
    public String showEditProfile(@PathVariable(value="email") String email, Model model) {
        model.addAttribute("user", userService.findUserByEmail(email));
        return "editprofile";
    }

    @PostMapping("/process_editProfile")
    public String processEditProfile(@ModelAttribute("user") User user) {
    // Update the user information
    userService.updateUser(user);
    return "home";
}

}
