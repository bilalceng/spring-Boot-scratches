package com.bilalberek.demo.dto;

        import com.bilalberek.demo.model.Student;

public record StudentResponseDto(
        String name,
        String email,
        Long schoolId
) {

}
