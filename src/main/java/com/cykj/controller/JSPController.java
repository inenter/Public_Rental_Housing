package com.cykj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: LQB
 * @Description:
 * @create: 2022/11/26 9:49
 */
@Controller()
public class JSPController {

    @RequestMapping("/index")
    public String index(){
        return "jsp/index";
    }

    @RequestMapping("/house")
    public String house(){
        return "jsp/house";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest req){
        if (req.getSession().getAttribute("acc") != null){
            return "redirect:/index";
        }
        return "jsp/login";
    }

    @RequestMapping("/register")
    public String register(){
        return "jsp/register";
    }

    @RequestMapping("/information")
    public String information(HttpServletRequest req){
        if (req.getSession().getAttribute("acc") != null){
            return "jsp/information";
        }
        return "jsp/login";
    }
}
