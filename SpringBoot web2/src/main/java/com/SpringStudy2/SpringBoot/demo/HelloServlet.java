package com.SpringStudy2.SpringBoot.demo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloServlet {
    @RequestMapping("/")
    public String home(){
        return "index";
    }
    @PostMapping("addInfo")
    public String addInfo(@RequestParam("id") int id, @RequestParam("name") String name, Model model){
        model.addAttribute("id",id);
        model.addAttribute("name",name);
        return "PrintInfo";
    }
    //In modelandView we have to manually do every stuff and also add the view name(i.e : result page name)
    @RequestMapping("usingModalAndView")
    public ModelAndView usingModalView(@RequestParam("id") int id, @RequestParam("name") String name, ModelAndView mv){
        mv.addObject("id",id);
        mv.addObject("name",name);
        mv.setViewName("PrintInfo");
        return mv;
    }
    //using ModelAttribute we can get all the values without writing @RequestParam in method signature this'll reduce task for us.
    @RequestMapping("usingModelAttribute")
    public String usingModelAttribute(@ModelAttribute Alien alien){
        return "PrintInfo";
    }
}
