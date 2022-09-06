package com.widgetmicroservice.widgetsummary.services;

import com.widgetmicroservice.widgetsummary.models.ProcessedWidget;
import com.widgetmicroservice.widgetsummary.repositories.WidgetSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<ProcessedWidget> getWidgetSummaryById(Long id) {
        return widgetSummaryRepository.findById(id);
    }

    public void createWidgetSummary(ProcessedWidget processedWidget) {
        widgetSummaryRepository.save(processedWidget);
    }

    public void deleteWidgetSummary(Long id) {
        widgetSummaryRepository.deleteById(id);
    }
}
