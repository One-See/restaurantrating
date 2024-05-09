package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;

public class RegisterUsercommand implements ICommand {
    private UserService userService;

    public RegisterUsercommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void invoke(List<String> tokens) {
        User user = this.userService.registerUser(tokens.get(1));
        System.out.println(user);
    }
}
