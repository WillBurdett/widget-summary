package com.widgetmicroservice.widgetsummary.models;


import com.widgetmicroservice.widgetsummary.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class ProcessedWidget {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;
    private Double height;
    private Double weight;
    private Integer bmr;
}
