package com.bilalberek.demo.service;

import com.bilalberek.demo.dto.SchoolDto;
import com.bilalberek.demo.mapper.SchoolMapper;
import com.bilalberek.demo.model.School;
import com.bilalberek.demo.model.Student;
import com.bilalberek.demo.repository.SchoolRepository;
import com.bilalberek.demo.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SchoolServiceTest {

    @Mock
    private SchoolRepository schoolRepository;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private SchoolService schoolService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetSchools() {
        // Arrange
        School school = new School();
        school.setTitle("Test School");

        when(schoolRepository.findAll()).thenReturn(Collections.singletonList(school));

        // Act
        List<SchoolDto> schools = schoolService.getSchools();

        // Assert
        assertEquals(1, schools.size());
        assertEquals("Test School", schools.get(0).name());
        verify(schoolRepository, times(1)).findAll();
    }

    @Test
    void testSaveSchool() {
        // Arrange
        School school = new School();
        school.setTitle("Test School");

        when(schoolRepository.save(any(School.class))).thenReturn(school);

        // Act
        SchoolDto result = schoolService.saveSchool(school);

        // Assert
        assertNotNull(result);
        assertEquals("Test School", result.name());
        verify(schoolRepository, times(1)).save(school);
    }

    @Test
    void testAddStudentFromSchool_StudentAlreadyRegistered() {
        // Arrange
        Long schoolId = 1L;
        Long studentId = 1L;
        School school = new School();
        Student student = new Student();
        student.setId(studentId);
        school.setId(schoolId);
        student.setName("John");
        student.setSchool(school);
        school.setStudentList(Collections.singletonList(student));

        when(schoolRepository.findById(schoolId)).thenReturn(Optional.of(school));
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

        // Act
        ResponseEntity<?> response = schoolService.addStudentFromSchool(schoolId, studentId);

        // Assert
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertTrue(response.getBody().toString().contains("is already registered"));
        verify(schoolRepository, times(1)).findById(schoolId);
        verify(studentRepository, times(1)).findById(studentId);
    }

    @Test
    void testAddStudentFromSchool_SuccessfullyRegistered() {
        // Arrange
        Long schoolId = 1L;
        Long studentId = 1L;
        School school = new School();
        school.setTitle("Test School");
        Student student = new Student();
        student.setName("John");

        when(schoolRepository.findById(schoolId)).thenReturn(Optional.of(school));
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

        // ActOptional.of(schoo
        ResponseEntity<?> response = schoolService.addStudentFromSchool(schoolId, studentId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().toString().contains("is registered successfully"));
        verify(schoolRepository, times(1)).findById(schoolId);
        verify(studentRepository, times(1)).findById(studentId);
        verify(schoolRepository, times(1)).save(school);
    }

    @Test
    void testGetSchool() {
        // Arrange
        Long schoolId = 1L;
        School school = new School();
        school.setTitle("Test School");

        when(schoolRepository.findById(schoolId)).thenReturn(Optional.of(school));

        // Act
        SchoolDto result = schoolService.getSchool(schoolId);

        // Assert
        assertNotNull(result);
        assertEquals("Test School", result.name());
        verify(schoolRepository, times(1)).findById(schoolId);
    }
}
