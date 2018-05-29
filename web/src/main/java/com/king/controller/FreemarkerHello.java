package com.king.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wangchangyong
 * @create 2018/05/22 14:17
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerHello {

    @GetMapping(value = "/hello")
    public ModelAndView hello(String name) {
        ModelAndView modelAndView = new ModelAndView("freemarker/freemarkerHello");
        modelAndView.addObject("name",name);
        return modelAndView;
    }
}
