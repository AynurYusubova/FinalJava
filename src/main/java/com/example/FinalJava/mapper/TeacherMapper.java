package com.example.FinalJava.mapper;

import com.example.FinalJava.dto.res.TeacherAllResponse;
import com.example.FinalJava.dto.res.TeacherGetResponse;
import com.example.FinalJava.dto.res.TeacherPutResponse;
import com.example.FinalJava.entity.TeacherEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    List<TeacherAllResponse>  mapEntityForTeacherAllResponse(List<TeacherEntity> teacherEntity);
    TeacherGetResponse toGetResponse(TeacherEntity entity);
    TeacherPutResponse toPutResponse(TeacherEntity entity);
}
