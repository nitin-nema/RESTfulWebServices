package com.example.RESTfulWebServices.Controller;

@Controller
public class HomeController {

    @RequestMapping(value = "/home",
        method = RequestedMethod.GET,
            params ="name"
    )
    public String home(Model model) {
        model.addAttribute("message", "Welcome to Spring MVC");
        return "home"; // Returns the home.html view
    }
}
