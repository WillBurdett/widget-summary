package com.widgetmicroservice.widgetsummary.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/summary")
public class WidgetSummaryController {

    @RequestMapping(method = RequestMethod.GET)
    private String helloWorld(){
        return "Hello world!";
    }
}
