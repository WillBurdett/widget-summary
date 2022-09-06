package com.widgetmicroservice.widgetsummary.controllers;

import com.widgetmicroservice.widgetsummary.models.ProcessedWidget;
import com.widgetmicroservice.widgetsummary.services.WidgetSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    private Optional<ProcessedWidget> getWidgetSummaryById(@PathVariable Long id){
        return widgetSummaryService.getWidgetSummaryById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    private void storeProcessedWidget(@RequestBody ProcessedWidget processedWidget){
        widgetSummaryService.storeProcessedWidget(processedWidget);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    private void storeProcessedWidget(@PathVariable Long id){
        widgetSummaryService.deleteProcessedWidget(id);
    }
}
