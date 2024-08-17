package com.bilalberek.demo.mapper;

import com.bilalberek.demo.dto.StudentDto;
import com.bilalberek.demo.dto.StudentResponseDto;
import com.bilalberek.demo.model.Student;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
class StudentMapperTest {
  private  StudentMapper studentMapper;
  static  private Student student;

  @BeforeAll
  static void beforeAll(){
     student = new Student();
  }

  @BeforeEach
  void setUp(){
    studentMapper = new StudentMapper();
  }

  @Test
  public void shouldMapStudentDtoToStudent(){
    StudentDto dto = new StudentDto(
            "bilal",
            "bilal@gmail.com",
            54L
    );

     student = studentMapper.toStudent(dto);

    assertEquals(student.getName(), dto.name());
    assertEquals(student.getEmail(), dto.email());
    assertNotNull(student.getSchool());
    assertEquals(student.getSchool().getId(), dto.schoolId());

  }
  @Test
  public void ShouldMapStudentToStudentResponseDto(){

    StudentResponseDto studentResponseDto = studentMapper.toStudentDto(student);
    assertEquals(studentResponseDto.email(), student.getEmail());
    assertEquals(studentResponseDto.name(), student.getName());
    assertEquals(studentResponseDto.schoolId(), studentResponseDto.schoolId());
  }

}