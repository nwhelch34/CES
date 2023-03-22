package com.example.CES;


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
    private AddressRepository addressRepo;

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
    public ModelAndView forgotpw(ModelAndView model) {
        model.setViewName("forgotpw");

        return model;
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("address", new Address());
        return "Registration";
    }

    @PostMapping("/process_register")
    public String processRegister(User user, Address address) {
        String passwordToHash = user.getPassword();
        String generatedPassword = null;

        try
        {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(passwordToHash.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        user.setPassword(generatedPassword);

        userRepo.save(user);
        addressRepo.save(address);

        return "home";
    }

}
