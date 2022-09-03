package com.widgetmicroservice.widgetsummary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class WidgetSummaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(WidgetSummaryApplication.class, args);
	}

}
