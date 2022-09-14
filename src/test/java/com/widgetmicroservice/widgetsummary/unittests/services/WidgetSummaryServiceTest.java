package com.widgetmicroservice.widgetsummary.unittests.services;

import com.widgetmicroservice.widgetsummary.enums.Gender;
import com.widgetmicroservice.widgetsummary.exceptions.WidgetSummaryNotFound;
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
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
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
    public void getWidgetSummaryById_ThrowsWidgetSummaryNotFoundException() {
        // given
        Optional <ProcessedWidget> expected = Optional.empty();
        when(widgetSummaryRepository.findById(1L)).thenReturn(expected);
        // when
        assertThatThrownBy(() -> {
            undertest.getWidgetSummaryById(1L);
            // then
        }).isInstanceOf(WidgetSummaryNotFound.class)
                .hasMessage("widget summary with id 1 not found");
        verify(widgetSummaryRepository, times(1)).findById(1L);
    }

    @Test
    public void createWidgetSummary() {
        // given
        ProcessedWidget expected = new ProcessedWidget(1L, "Bob", "Smith", 20, Gender.MALE, 150.0, 80.0, 1643);
        // when
        undertest.createWidgetSummary(expected);
        // then
        verify(widgetSummaryRepository, times(1)).save(expected);
    }

    @Test
    public void deleteWidgetSummary() {
        // given
        Long expectedId = 1L;
        // when
        undertest.deleteWidgetSummary(expectedId);
        // then
        verify(widgetSummaryRepository, times(1)).deleteById(expectedId);
    }
}