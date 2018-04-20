package com.lzt.order.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value= "/")
public class HomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response){
        ModelAndView view = new ModelAndView("home");
        return view;
    }

}
