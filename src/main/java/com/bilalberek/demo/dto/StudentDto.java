package com.bilalberek.demo.dto;

import com.bilalberek.demo.customconstraints.ValidEmail;
import com.bilalberek.demo.model.School;
import com.bilalberek.demo.model.Student;
import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty
        String name,
        @NotEmpty
        @ValidEmail
        String email,

        Long schoolId
) {

}
