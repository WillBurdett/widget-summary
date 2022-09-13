package com.widgetmicroservice.widgetsummary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.BAD_REQUEST)
public class WidgetSummaryNotFound extends IllegalStateException{
    public WidgetSummaryNotFound(String message) {
        super(message);
    }
}
