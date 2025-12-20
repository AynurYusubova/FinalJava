package com.example.FinalJava.mapper;

import com.example.FinalJava.dto.res.StudentAllResponse;
import com.example.FinalJava.dto.res.StudentGetResponse;
import com.example.FinalJava.dto.res.StudentPostResponse;
import com.example.FinalJava.dto.res.StudentPutResponse;
import com.example.FinalJava.entity.StudentEntity;
import com.example.FinalJava.entity.UniEntity;
import org.mapstruct.Mapper;
import java.util.List;



@Mapper(componentModel = "spring")
public interface StudentMapper {
    List<StudentAllResponse> mapEntityForStudentAllResponse(List<StudentEntity> studentEntity);

    StudentGetResponse toGetResponse(StudentEntity entity);

    StudentPostResponse toPostResponse(UniEntity uni);

    StudentPutResponse toPutResponse(StudentEntity entity);


}

