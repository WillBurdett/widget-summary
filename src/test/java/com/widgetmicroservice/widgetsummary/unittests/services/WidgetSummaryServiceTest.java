package com.widgetmicroservice.widgetsummary.unittests.services;

import com.widgetmicroservice.widgetsummary.repositories.WidgetSummaryRepository;
import com.widgetmicroservice.widgetsummary.services.WidgetSummaryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@WebMvcTest(WidgetSummaryService.class)
public class WidgetSummaryServiceTest {

    @Autowired
    WidgetSummaryService undertest;

    @MockBean
    WidgetSummaryRepository widgetSummaryRepository;

    @Test
    public void getAllWidgetSummaries() {
    }

    @Test
    public void getWidgetSummaryById() {
    }

    @Test
    public void createWidgetSummary() {
    }

    @Test
    public void deleteWidgetSummary() {
    }
}