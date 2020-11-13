package com.project.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class WebController {
   /* @RequestMapping(value = "/web", method = RequestMethod.GET)
    public ModelAndView index(){
        //log.debug("called index");
        System.out.println("called index");
        //model and view
        ModelAndView model = new ModelAndView("index");
        return model;
    }*/
    @RequestMapping(value = "/web", method = RequestMethod.GET)
    public String index(){
        //log.debug("called index");
        System.out.println("called index return String");
        return "index";
    }
}
