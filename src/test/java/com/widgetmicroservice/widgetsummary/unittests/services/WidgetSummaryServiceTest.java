package com.widgetmicroservice.widgetsummary.unittests.services;

import com.widgetmicroservice.widgetsummary.enums.Gender;
import com.widgetmicroservice.widgetsummary.models.ProcessedWidget;
import com.widgetmicroservice.widgetsummary.repositories.WidgetSummaryRepository;
import com.widgetmicroservice.widgetsummary.services.WidgetSummaryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(WidgetSummaryService.class)
public class WidgetSummaryServiceTest {

    @Autowired
    WidgetSummaryService undertest;

    @MockBean
    WidgetSummaryRepository widgetSummaryRepository;

    @Test
    public void getAllWidgetSummaries_HappyPath() {
        // given
        List expected = List.of(new ProcessedWidget(1L, "Bob", "Smith", 20, Gender.MALE, 150.0, 80.0, 1643));
        when(widgetSummaryRepository.findAll()).thenReturn(expected);
        // when
        List actual = undertest.getAllWidgetSummaries();
        // then
        assertThat(actual).isEqualTo(expected);
        verify(widgetSummaryRepository, times(1)).findAll();
    }

    @Test
    public void getWidgetSummaryById_HappyPath() {
        // given
        ProcessedWidget expected = new ProcessedWidget(1L, "Bob", "Smith", 20, Gender.MALE, 150.0, 80.0, 1643);
        when(widgetSummaryRepository.findById(expected.getId())).thenReturn(Optional.of(expected));
        // when
        Optional<ProcessedWidget> actual = undertest.getWidgetSummaryById(expected.getId());
        // then
        assertThat(actual).isEqualTo(Optional.of(expected));
        verify(widgetSummaryRepository, times(1)).findById(expected.getId());
    }

    @Test
    public void createWidgetSummary() {
    }

    @Test
    public void deleteWidgetSummary() {
    }
}