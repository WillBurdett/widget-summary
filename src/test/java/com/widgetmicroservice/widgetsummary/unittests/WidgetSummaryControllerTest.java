package com.widgetmicroservice.widgetsummary.unittests;

import com.widgetmicroservice.widgetsummary.controllers.WidgetSummaryController;
import com.widgetmicroservice.widgetsummary.services.WidgetSummaryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(WidgetSummaryController.class)
public class WidgetSummaryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WidgetSummaryService widgetService;

    @Test
    public void getAllWidgetSummaries_HappyPath(){
        // given
        // when
        // then
    }

    @Test
    public void getWidgetSummaryById_HappyPath(){
        // given
        // when
        // then
    }

    @Test
    public void createWidgetSummary_HappyPath(){
        // given
        // when
        // then
    }

    @Test
    public void deleteWidgetSummaryById_HappyPath(){
        // given
        // when
        // then
    }


}