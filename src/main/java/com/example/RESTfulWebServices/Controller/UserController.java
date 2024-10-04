package com.example.RESTfulWebServices.Controller;

import com.example.RESTfulWebServices.Model.User;

@Controller
public class UserController {

    @GetMapping("/userForm")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm"; // userForm.html view
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("name", user.getName());
        return "result"; // result.html view
    }
}
