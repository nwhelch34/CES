package com.example.CES;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

//    User getCurrentUser(Authentication authentication);
    User findUserByEmail(String email);
    void updateUser(User user);
    List<UserDto> findAllUsers();
}