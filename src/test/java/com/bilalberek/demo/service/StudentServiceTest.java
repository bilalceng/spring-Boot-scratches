package com.bilalberek.demo.service;

import com.bilalberek.demo.dto.StudentDto;
import com.bilalberek.demo.dto.StudentResponseDto;
import com.bilalberek.demo.mapper.StudentMapper;
import com.bilalberek.demo.model.School;
import com.bilalberek.demo.model.Student;
import com.bilalberek.demo.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;
    @Mock
    StudentMapper studentMapper;
    @InjectMocks
    StudentService studentService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void shouldSuccessfullySaveAStudent(){
        StudentDto studentDto = new StudentDto("John Doe",
                "john.doe@example.com",
                1L
        );

        Student student = new Student(
                "John Doe",
                20,
                "john.doe@example.com",
                LocalDateTime.now()
        );

        Student savedStudent =  new Student(
                "John Doe",
                20,
                "john.doe@example.com",
                LocalDateTime.now()
        );

        savedStudent.setId(1L);

        when(studentMapper.toStudent(studentDto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toStudentDto(savedStudent)).thenReturn(new StudentResponseDto("John Doe",
                "john.doe@example.com",
                1L
        ));

        StudentResponseDto responseDto = studentService.saveStudent(studentDto);

        assertEquals(studentDto.name(), responseDto.name());
        assertEquals(studentDto.email(), responseDto.email());
        assertEquals(studentDto.schoolId(), responseDto.schoolId());

        verify(studentMapper, times(1)).toStudentDto(savedStudent);
        verify(studentRepository,times(1)).save(student);
        verify(studentMapper,times(1)).toStudent(studentDto);
    }


    @Test
    public void shouldSuccessfullyGetAllStudentsInDatabase(){
        Student savedStudentOne =  new Student(
                "John Doe",
                20,
                "john.doe@example.com",
                LocalDateTime.now()
        );
        savedStudentOne.setId(1L);

        Student savedStudentTwo =  new Student(
                "Ahmet Çelik",
                20,
                "ahmet.elik@example.com",
                LocalDateTime.now()
        );
        savedStudentOne.setId(2L);

        List<Student> students = Arrays.asList(savedStudentOne,savedStudentTwo);

        when(studentRepository.findAll()).thenReturn(students);

        when(studentMapper.toStudentDto(savedStudentOne)).thenReturn(new StudentResponseDto(
                "John Doe",
                "john.doe@example.com",
                1L
        ));

        when(studentMapper.toStudentDto(savedStudentTwo)).thenReturn(new StudentResponseDto(
                "Ahmet Çelik",
                "ahmet.elik@example.com",
                1L
        ));

        List<StudentResponseDto> results = studentService.findAllStudents();

        assertEquals(results.size(), 2);
        assertEquals(results.get(0).name(),students.get(0).getName());
        assertEquals(results.get(0).email(),students.get(0).getEmail());
        assertEquals(results.get(1).name(),students.get(1).getName());
        assertEquals(results.get(1).email(),students.get(1).getEmail());

        verify(studentMapper, times(1)).toStudentDto(savedStudentOne);
        verify(studentRepository,times(1)).findAll();

    }

    /**
     *
     public StudentResponseDto findStudentById(
     Long id
     ){
     Student obtainedStudent = studentRepository.findById(id).orElse(new Student());
     return studentMapper.toStudentDto(obtainedStudent);
     }
     */

    @Test
    public void  shouldReturnStudentResponseDtoByGivenId(){
        Long id = 1L;
        Student obtainedStudent = new Student(
                "John Doe",
                20,
                "john.doe@example.com",
                LocalDateTime.now()
        );
        obtainedStudent.setId(id);

        StudentResponseDto studentResponseDto = new StudentResponseDto(
                "John Doe",
                "john.doe@example.com",
                1L
        );

        when(studentMapper.toStudentDto(obtainedStudent)).thenReturn(studentResponseDto);

        when(studentRepository.findById(id)).thenReturn(Optional.of(obtainedStudent)); // Return the Optional containing the found student

        StudentResponseDto studentResponseDto1 = studentService.findStudentById(id);

        assertEquals(studentResponseDto.name(), studentResponseDto1.name());
        assertEquals(studentResponseDto.email(), studentResponseDto1.email());

        verify(studentMapper, times(1)).toStudentDto(obtainedStudent);
        verify(studentRepository, times(1)).findById(id);

    }

    /**
     *    public List<StudentResponseDto> findStudentByName(
     *              String name
     *     ){
     *          List<Student> obtainedStudentByName = studentRepository.findAllByNameContainingIgnoreCase(name);
     *          return obtainedStudentByName
     *                  .stream()
     *                  .map(studentMapper::toStudentDto)
     *                  .collect(Collectors.toList());
     *     }
     */

    @Test
    public void  shouldReturnStudentResponseDtoByGivenName(){
        School school = new School();
        school.setId(1L);

        Student studentOne = new Student(
                "John Doe",
                20,
                "john.doe@example.com",
                LocalDateTime.now()
        );
        studentOne.setSchool(school);

        Student studentTwo = new Student(
                "John dash",
                20,
                "john.dash@example.com",
                LocalDateTime.now()
        );
        studentTwo.setSchool(school);

        StudentResponseDto studentResponseDtoOne = new StudentResponseDto(
                "John Doe",
                "john.doe@example.com",
                1L
        );

        StudentResponseDto studentResponseDtoTwo = new StudentResponseDto(
                "John Dash",
                "john.dash@example.com",
                1L
        );

        List<Student> students = new ArrayList<>();
        students.add(studentTwo);
        students.add(studentOne);

        List<StudentResponseDto> expectedResults = new ArrayList<>();
        expectedResults.add(studentResponseDtoOne);
        expectedResults.add(studentResponseDtoTwo);

        when(studentRepository.findAllByNameContainingIgnoreCase("John")).thenReturn(students);
        when(studentMapper.toStudentDto(students.get(0))).thenReturn(expectedResults.get(0));
        when(studentMapper.toStudentDto(students.get(1))).thenReturn(expectedResults.get(1));

        List<StudentResponseDto> actualResults = studentService.findStudentByName("John");

        assertEquals(expectedResults.size(), actualResults.size());

        assertEquals(expectedResults.get(0).email(), actualResults.get(0).email());
        assertEquals(expectedResults.get(0).schoolId(), actualResults.get(0).schoolId());
        assertEquals(expectedResults.get(0).name(), actualResults.get(0).name());

        assertEquals(expectedResults.get(1).email(), actualResults.get(1).email());
        assertEquals(expectedResults.get(1).schoolId(), actualResults.get(1).schoolId());
        assertEquals(expectedResults.get(1).name(), actualResults.get(1).name());

        verify(studentMapper,times(2)).toStudentDto(any(Student.class));
        verify(studentRepository,times(1)).findAllByNameContainingIgnoreCase("John");
    }

    /**
     *     public void deleteStudentById(
     *          Long id
     *     ){
     *         studentRepository.deleteById(id);
     *     }
     */


    @Test
    public void shouldDeleteStudentById(){
        Long deletedId = 1L;

        /**
         * For void methods,
         * there's no need to specify behavior with when(...)
         * because there isn't anything to return.
         * Instead, you can directly call the method on the mock object.
         *
         */
        studentService.deleteStudentById(deletedId);

        verify(studentRepository,times(1)).deleteById(deletedId);

    }

}