package com.lzt.order.controller;


import com.lzt.order.service.IdService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value= "/id")
public class IdController {

    @Resource
    IdService idService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public void home(HttpServletRequest request, HttpServletResponse response){
        idService.getId();
    }
}
