package com.widgetmicroservice.widgetsummary.unittests;

import com.widgetmicroservice.widgetsummary.controllers.WidgetSummaryController;
import com.widgetmicroservice.widgetsummary.enums.Gender;
import com.widgetmicroservice.widgetsummary.models.ProcessedWidget;
import com.widgetmicroservice.widgetsummary.services.WidgetSummaryService;
import com.widgetmicroservice.widgetsummary.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(WidgetSummaryController.class)
public class WidgetSummaryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WidgetSummaryService widgetService;

    @Test
    public void getAllWidgetSummaries_HappyPath() throws Exception {
        // given
        ProcessedWidget expected = new ProcessedWidget(1L, "Bob", "Smith", 20, Gender.MALE, 150.0, 80.0, 1643);
        when(widgetService.getAllWidgetSummaries()).thenReturn(List.of(expected));

        // when
        this.mockMvc.perform(MockMvcRequestBuilders.get("/summary").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].firstName", is("Bob")))
                .andExpect(jsonPath("$[0].lastName", is("Smith")))
                .andExpect(jsonPath("$[0].age", is(20)))
                .andExpect(jsonPath("$[0].gender", is("MALE")))
                .andExpect(jsonPath("$[0].height", is(150.0)))
                .andExpect(jsonPath("$[0].weight", is(80.0)))
                .andExpect(jsonPath("$[0].bmr", is(1643)));
        // then
        verify(widgetService, times(1)).getAllWidgetSummaries();
    }

    @Test
    public void getWidgetSummaryById_HappyPath() throws Exception {
        // given
        long id = 1L;
        ProcessedWidget expected = new ProcessedWidget(id, "Bob", "Smith", 20, Gender.MALE, 150.0, 80.0, 1643);
        when(widgetService.getWidgetSummaryById(id)).thenReturn(Optional.of(expected));

        // when
        this.mockMvc.perform(MockMvcRequestBuilders.get("/summary/"+id).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstName", is("Bob")))
                .andExpect(jsonPath("$.lastName", is("Smith")))
                .andExpect(jsonPath("$.age", is(20)))
                .andExpect(jsonPath("$.gender", is("MALE")))
                .andExpect(jsonPath("$.height", is(150.0)))
                .andExpect(jsonPath("$.weight", is(80.0)))
                .andExpect(jsonPath("$.bmr", is(1643)));
        // then
        verify(widgetService, times(1)).getWidgetSummaryById(id);
    }

    @Test
    public void createWidgetSummary_HappyPath() throws Exception {
        // given
        ProcessedWidget expected = new ProcessedWidget(1L, "Bob", "Smith", 20, Gender.MALE, 150.0, 80.0, 1643);
        // when
        mockMvc.perform(post("/summary").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(expected)));
        // then
        verify(widgetService, times(1)).createWidgetSummary(expected);
    }

    @Test
    public void deleteWidgetSummaryById_HappyPath() throws Exception {
        // given
        Long id = 1L;
        // when
        mockMvc.perform(delete("/summary/" + id));
        // then
        verify(widgetService, times(1)).deleteWidgetSummaryById(id);
    }
}