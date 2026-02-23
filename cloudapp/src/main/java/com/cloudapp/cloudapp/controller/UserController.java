package com.cloudapp.cloudapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloudapp.cloudapp.model.User;
import com.cloudapp.cloudapp.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    //logger
    private static final org.slf4j.Logger log =
        org.slf4j.LoggerFactory.getLogger(UserController.class);

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String listUsers(Model model) {
        log.info("Listing all users"); //log
        model.addAttribute("users", service.findAll());
        return "users-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        log.info("Opening form to create a new user"); //log
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        log.info("Creating new user: {}", user.getEmail()); //log
        service.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        log.info("Editing user: {}, id");
        model.addAttribute("user", service.findById(id));
        return "user-form";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Integer id, @ModelAttribute("user") User user) {
        log.info("Updating user: {}, id");
        user.setId(id);
        service.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        log.warn("Deleting user: {}, id");
        service.deleteById(id);
        return "redirect:/users";
    }
    @GetMapping("/contacts")
    public String showAllContacts(Model model) {
    model.addAttribute("users", service.findAll());
    return "users-contacts";
    }
}
