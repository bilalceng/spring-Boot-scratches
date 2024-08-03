package com.bilalberek.demo.repository;

import com.bilalberek.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Student, Long> {


    //@Query("SELECT p FROM Person p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Student> findAllByNameContainingIgnoreCase(@Param("name") String name);
}
