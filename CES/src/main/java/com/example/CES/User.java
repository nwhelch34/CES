package com.example.CES;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserID")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "passwrd")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "enrolled_promotions")
    private int enrolledPromotions;



    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "AddressID")
    private Address address;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "UserTypeID")
    private UserTypes UserTypeID;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "UserStatusID")
    private UserStatus UserStatusID;


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getEnrolledPromotions() {
        return enrolledPromotions;
    }

    public void setEnrolledPromotions(int enrolledPromotions) {
        this.enrolledPromotions = enrolledPromotions;
    }

    public Address getAddress() {
        return address;
    }


    public UserTypes getUserTypeID() {
        return UserTypeID;
    }
    public void setUserTypeID(UserTypes userTypeID) {
        UserTypeID = userTypeID;
    }

    public UserStatus getUserStatusID() {
        return UserStatusID;
    }
    public void setUserStatusID(UserStatus userStatusID) {
        UserStatusID = userStatusID;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Role> roles = new ArrayList<>();

    public void setRoles(List<Role> roles) { this.roles = roles; }

    public List<Role> getRoles() { return roles; }

}