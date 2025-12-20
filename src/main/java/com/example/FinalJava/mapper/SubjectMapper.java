package com.example.FinalJava.mapper;

import com.example.FinalJava.dto.res.SubjectAllResponse;
import com.example.FinalJava.dto.res.SubjectGetResponse;
import com.example.FinalJava.dto.res.SubjectPostResponse;
import com.example.FinalJava.dto.res.SubjectPutResponse;
import com.example.FinalJava.entity.SubjectEntity;
import com.example.FinalJava.entity.TeacherEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    List<SubjectAllResponse> mapEntityForSubjectAllResponse(List<SubjectEntity> subjectEntity);
    SubjectGetResponse toGetResponse(SubjectEntity entity);
    SubjectPostResponse toPostResponse(TeacherEntity teacher);
    SubjectPutResponse toPutResponse(SubjectEntity entity);

}
