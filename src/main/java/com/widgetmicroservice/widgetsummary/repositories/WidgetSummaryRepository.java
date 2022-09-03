package com.widgetmicroservice.widgetsummary.repositories;

import com.widgetmicroservice.widgetsummary.models.ProcessedWidget;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WidgetSummaryRepository extends MongoRepository<ProcessedWidget, Long> {
}
