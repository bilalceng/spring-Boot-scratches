package com.bilalberek.demo.dto;

import com.bilalberek.demo.model.School;
import com.bilalberek.demo.model.Student;

public record SchoolDto(
        String name
) {
    public static SchoolDto toSchoolDto(School school){
        return new SchoolDto(
                school.getTitle()
        );
    }
}
