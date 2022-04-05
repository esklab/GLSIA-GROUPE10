package com.glsiA.projet.controller;


import com.glsiA.projet.models.User;
import com.glsiA.projet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("Users")
public class UserController {

    @Autowired
    private UserService userService;

    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/all")
    public String showAllUsers(Model model){
        model.addAttribute("users", userService.getList());
        return "users/listUser";
    }

    @GetMapping("/create")
    public String create(){
        return "users/addUser";
    }

    @PostMapping("/save")
    public String save(User user){
        user.setRole("VENDEUR");
        user.setPermission("");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect:/Users/all";
    }

    @PostMapping("/updatepassword")
    public String updatepassword(@RequestParam("username") String username, @RequestParam("newpassword") String newpassword){
        User user = userService.getUserByUsername(username);
        if(user != null){
            user.setPassword(passwordEncoder.encode(newpassword));
            userService.save(user);
            return "redirect:/forgetpassword?success";
        }
        return "redirect:/forgetpassword?error";
    }

    @GetMapping("/profile")
    public String userProfile(Model model)
    {
        model.addAttribute("user", userService.getCurrentUser());
        return "users/userProfile";
    }

    @GetMapping("/view/{id}")
    public String viewUser(@PathVariable("id") String username, Model model)
    {
        model.addAttribute("user", userService.getUserByUsername(username));
        return "users/viewUser";
    }

}
