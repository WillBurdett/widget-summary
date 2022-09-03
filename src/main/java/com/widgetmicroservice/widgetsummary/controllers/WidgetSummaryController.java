package com.widgetmicroservice.widgetsummary.controllers;

import com.widgetmicroservice.widgetsummary.models.ProcessedWidget;
import com.widgetmicroservice.widgetsummary.services.WidgetSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/summary")
public class WidgetSummaryController {

    private final WidgetSummaryService widgetSummaryService;

    @Autowired
    public WidgetSummaryController(WidgetSummaryService widgetSummaryService) {
        this.widgetSummaryService = widgetSummaryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    private List<ProcessedWidget> getAllWidgetSummaries(){
        return widgetSummaryService.getAllWidgetSummaries();
    }
    @RequestMapping(method = RequestMethod.POST)
    private void storeProcessedWidget(@RequestBody ProcessedWidget processedWidget){
        widgetSummaryService.storeProcessedWidget(processedWidget);
    }
}
