package com.bilalberek.demo.mapper;

import com.bilalberek.demo.dto.SchoolDto;
import com.bilalberek.demo.model.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public static SchoolDto toSchoolDto(School school){
        return new SchoolDto(
                school.getTitle()
        );
    }

}
