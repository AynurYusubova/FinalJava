package com.example.FinalJava.service.Impl;

import com.example.FinalJava.dto.req.SubjectPostRequest;
import com.example.FinalJava.dto.req.SubjectPutRequest;
import com.example.FinalJava.dto.res.SubjectAllResponse;
import com.example.FinalJava.dto.res.SubjectGetResponse;
import com.example.FinalJava.dto.res.SubjectPostResponse;
import com.example.FinalJava.dto.res.SubjectPutResponse;
import com.example.FinalJava.entity.SubjectEntity;
import com.example.FinalJava.entity.TeacherEntity;
import com.example.FinalJava.mapper.SubjectMapper;
import com.example.FinalJava.repostory.SubjectRepostory;
import com.example.FinalJava.repostory.TeacherRepostory;
import com.example.FinalJava.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepostory subjectRepostory;

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private TeacherRepostory teacherRepostory;


    @Override
    public List<SubjectAllResponse> getSubjects() {
        List<SubjectEntity> subjectEntities=subjectRepostory.findAll();
        return subjectMapper.mapEntityForSubjectAllResponse(subjectEntities);
    }

    @Override
    public SubjectGetResponse getSubject(int id) {
        Optional<SubjectEntity> subjectEntity=subjectRepostory.findById(id);

        if(subjectEntity.isEmpty()){
            return SubjectGetResponse.builder()
                    .message("ID " + id + " üçün fənn tapılmadı!")
            .build();
        }

        SubjectEntity subjectEntity1=subjectEntity.get();
        return SubjectGetResponse.builder()
                .name(subjectEntity1.getName())
                 .credits(subjectEntity1.getCredits())
                .message("ID" + id + " məlumat tapıldı!")
                .build();
    }

    @Override
    public SubjectPostResponse addSubject(SubjectPostRequest subjectPostRequest) {
        SubjectEntity subjectEntity=new SubjectEntity();
        subjectEntity.setName(subjectPostRequest.getName());
        subjectEntity.setCredits(subjectPostRequest.getCredits());

        TeacherEntity teacher =teacherRepostory.findById(subjectPostRequest.getTeacherId()).orElse(null);
        subjectEntity.setTeacher(teacher);

        subjectRepostory.save(subjectEntity);
        return SubjectPostResponse.builder()
                .name(subjectEntity.getName())
                .credits(subjectEntity.getCredits())
                .message("Məlumat uğurla əlavə olundu!")
                .build();
    }

    @Override
    public SubjectPutResponse updateSubject(int id, SubjectPutRequest subjectPutRequest) {
        Optional<SubjectEntity> subjectEntity=subjectRepostory.findById(id);

        if(subjectEntity.isEmpty()){
            return SubjectPutResponse.builder()
                    .message("ID " + id + " üçün fənn tapılmadı!")
                    .build();
        }

        SubjectEntity subjectEntity1=subjectEntity.get();
        return SubjectPutResponse.builder()
                .name(subjectEntity1.getName())
                .credits(subjectEntity1.getCredits())
                .message("Məlumat uğurla dəyişdirildi!")
                .build();
    }

    @Override
    public void deleteSubject(int id) {
        Optional<SubjectEntity> subject = subjectRepostory.findById(id);
        if(subject.isEmpty()){
            System.out.println("ID " + id + " üçün fənn tapılmadı!");
            return;
        }
        System.out.println("ID " + id + "məlumat silindi!" );
        subjectRepostory.delete(subject.get());
    }
}
