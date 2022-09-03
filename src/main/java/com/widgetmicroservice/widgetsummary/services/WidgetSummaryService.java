package com.widgetmicroservice.widgetsummary.services;

import com.widgetmicroservice.widgetsummary.models.ProcessedWidget;
import com.widgetmicroservice.widgetsummary.repositories.WidgetSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WidgetSummaryService {

    private final WidgetSummaryRepository widgetSummaryRepository;

    @Autowired
    public WidgetSummaryService(WidgetSummaryRepository widgetSummaryRepository) {
        this.widgetSummaryRepository = widgetSummaryRepository;
    }

    public List<ProcessedWidget> getAllWidgetSummaries() {
        return widgetSummaryRepository.findAll();
    }

    public void storeProcessedWidget(ProcessedWidget processedWidget) {
        widgetSummaryRepository.save(processedWidget);
    }
}
