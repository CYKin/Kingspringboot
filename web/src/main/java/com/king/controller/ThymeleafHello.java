package com.king.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wangchangyong
 * @create 2018/05/22 14:17
 */
@Controller
@RequestMapping("/th")
public class ThymeleafHello {

    @RequestMapping(value = "/thymeleafHello")
    public ModelAndView hello(String name) {
        ModelAndView modelAndView = new ModelAndView("thymeleaf/thymeleafHello");
        modelAndView.addObject("name",name);
        return modelAndView;
    }
}
