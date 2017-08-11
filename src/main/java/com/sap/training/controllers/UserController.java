package com.sap.training.controllers;

        import com.sap.training.models.User;
        import com.sap.training.services.SecurityService;
        import com.sap.training.services.UserService;

        import org.springframework.security.core.Authentication;
        import org.springframework.security.core.context.SecurityContextHolder;
        import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.BindingResult;
        import org.springframework.validation.Validator;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

        import javax.annotation.Resource;
        import javax.swing.*;
        import javax.validation.Valid;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private Validator userValidator;

    @Resource
    private SecurityService securityService;


    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        if (securityService.isLogged()){
            return "redirect:/restaurants/";
        }

        User user = new User();
        model.addAttribute("user", user);

        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        User user = new User();
        user.setId(1);

        model.addAttribute("user", user);

        return "register";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@Valid User user, BindingResult bindingResult, Model model) {
        //userValidator.validate(userForm, bindingResult);

        userValidator.validate(user, bindingResult);


        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.saveUser(user);

        JOptionPane.showMessageDialog(null,"User registered");

        return "redirect:/";
    }


    @RequestMapping(value = {"/accessdenied"}, method = RequestMethod.GET)
    public String accessdenied(Model model) {

        return "redirect:/";
    }

    @RequestMapping(value="/pagenotfound", method = RequestMethod.GET)
    public String pagenotfound(){
        return "redirect:/";
    }

}
