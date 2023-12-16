package com.hotelmanagementDenyse.hotelmanagementdenyse.controller;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.User;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageControler {
//    @GetMapping("/editRoom")
//    public String getAbout(){
//        return "editRoom";
//    }

    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }
    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }
    @GetMapping("/accomodation")
    public String getAccomodation(){
        return "accomodation";
    }
    @GetMapping("/elements")
    public String getElements(){
        return "elements";
    }
    @GetMapping("/contact")
    public String getContact(){
        return "contact";
    }
    @GetMapping("/gallery")
    public String getGallery(){
        return "gallery";
    }
    @GetMapping("/login")
    public String getLogin(){
        return "login";

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate the session
        session.invalidate();

        // Redirect to the root URL
        return "redirect:/login";
    }
    @Autowired
    private UserService userService;

    @PostMapping("/loginAdmin")
    public String LoginAdmin(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
        User user=userService.login(email, password);
        if(user==null){
            model.addAttribute("error","Incorrect Username and Password");
            return "redirect:/login";
        }else{
            session.setAttribute("adminAuthenticated",user);
            return "redirect:/room";
        }

    }

}
