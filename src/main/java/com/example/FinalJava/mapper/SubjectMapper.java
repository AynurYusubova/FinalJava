package com.example.FinalJava.mapper;

import com.example.FinalJava.dto.res.SubjectAllResponse;
import com.example.FinalJava.dto.res.SubjectGetResponse;
import com.example.FinalJava.entity.SubjectEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    List<SubjectAllResponse> mapEntityForSubjectAllResponse(List<SubjectEntity> subjectEntity);

}
