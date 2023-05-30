package lam.ss8.controller;

import lam.ss8.model.User;
import lam.ss8.service.IUserService;
import lam.ss8.validate.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping("/")
    public ModelAndView showFormRegister(){
        ModelAndView modelAndView = new ModelAndView("/register");
        modelAndView.addObject("register",new User());
        return modelAndView;
    }
    @PostMapping("/add")
    public String register(@ModelAttribute("register") User user, BindingResult bindingResult){
        new UserValidate().checkValidate(user,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/register";
        }else {
            userService.save(user);
            return "/result";
        }


    }
}

