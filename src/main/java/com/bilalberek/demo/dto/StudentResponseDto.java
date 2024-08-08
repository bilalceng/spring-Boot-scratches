package com.bilalberek.demo.dto;

        import com.bilalberek.demo.model.Student;

public record StudentResponseDto(
        String name,
        String email,
        Long schoolId
) {

    public static StudentResponseDto toStudentDto(Student student){
        return new StudentResponseDto(
                student.getName(),
                student.getEmail(),
                student.getSchool() != null ? student.getSchool().getId() : null
        );
    }
}
