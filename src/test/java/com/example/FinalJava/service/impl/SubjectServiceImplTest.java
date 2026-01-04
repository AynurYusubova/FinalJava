package com.example.FinalJava.service.impl;


import com.example.FinalJava.dto.req.SubjectPostRequest;
import com.example.FinalJava.dto.req.SubjectPutRequest;
import com.example.FinalJava.dto.res.SubjectAllResponse;
import com.example.FinalJava.dto.res.SubjectGetResponse;
import com.example.FinalJava.dto.res.SubjectPostResponse;
import com.example.FinalJava.dto.res.SubjectPutResponse;
import com.example.FinalJava.entity.SubjectEntity;
import com.example.FinalJava.entity.TeacherEntity;
import com.example.FinalJava.mapper.SubjectMapper;
import com.example.FinalJava.repostory.StudentRepostory;
import com.example.FinalJava.repostory.SubjectRepostory;
import com.example.FinalJava.repostory.TeacherRepostory;
import com.example.FinalJava.service.Impl.SubjectServiceImpl;
import com.example.FinalJava.service.SubjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = {
        SubjectAllResponse.class,
        SubjectEntity.class,
        SubjectService.class,
        SubjectServiceImpl.class,
        SubjectRepostory.class,
        StudentRepostory.class,
        SubjectMapper.class,
        TeacherRepostory.class,
        SubjectGetResponse.class,
        SubjectPostResponse.class,
        SubjectPostRequest.class,
        SubjectPutResponse.class,
        SubjectPutRequest.class,
})
public class SubjectServiceImplTest {
    @MockitoBean
    private SubjectRepostory subjectRepostory;

    @MockitoBean
    private StudentRepostory studentRepostory;

    @MockitoBean
    private SubjectMapper subjectMapper;

    @MockitoBean
    private TeacherRepostory teacherRepostory;

    @Autowired
    private SubjectService subjectService;

    private List<SubjectEntity> subjectEntities;

    private List <SubjectAllResponse> subjectAllResponse;

    private SubjectEntity subject;

    private SubjectGetResponse subjectResponse;

    private TeacherEntity teacher;

    private SubjectPostResponse subjectPostResponse;

    private SubjectPostRequest subjectPostRequest;

    private SubjectPutResponse subjectPutResponse;

    private SubjectPutRequest subjectPutRequest;


    @BeforeEach
    public void setUp() {
        subjectAllResponse =MockData.subjectAllResponse();
        subjectEntities =MockData.subjectEntities();
        subject=MockData.subject();
        subjectResponse=MockData.subjectResponse();
        subjectPostRequest=MockData.subjectPostRequest();
        teacher =MockData.teacherEntity();
        subjectPostResponse=MockData.subjectPostResponse();
        subjectPutRequest=MockData.subjectPutRequest();
        subjectPutResponse=MockData.subjectPutResponse();

    }


    @Test
    public void whenGetAllSubjects(){
        when(subjectRepostory.findAll()).thenReturn(subjectEntities);
        when(subjectMapper.mapEntityForSubjectAllResponse(subjectEntities)).thenReturn(subjectAllResponse);


        subjectService.getSubjects();

        verify(subjectRepostory,times(1)).findAll();
        verify(subjectMapper,times(1)).mapEntityForSubjectAllResponse(subjectEntities);
    }


    @Test
    public void whenGetSubject(){
        int id=1;
        when(subjectRepostory.findById(id)).thenReturn(Optional.of(subject));
        when(subjectMapper.toGetResponse(subject)).thenReturn(subjectResponse);


        subjectService.getSubject(id);

        verify(subjectRepostory,times(1)).findById(id);
        verify(subjectMapper,times(1)).toGetResponse(subject);
    }


    @Test
    public void whenAddSubject(){
        when(teacherRepostory.findById(2)).thenReturn(Optional.of(teacher));
        when(subjectMapper.toPostResponse(teacher)).thenReturn(subjectPostResponse);


        subjectPostResponse =subjectService.addSubject(subjectPostRequest);

        verify(teacherRepostory,times(1)).findById(2);
        verify(subjectMapper,times(1)).toPostResponse(teacher);
    }


    @Test
    public void whenUpdateSubject(){
        when(subjectRepostory.findById(1)).thenReturn(Optional.of(subject));
        when(subjectMapper.toPutResponse(subject)).thenReturn(subjectPutResponse);

        subjectPutResponse=subjectService.updateSubject(1,subjectPutRequest);

        verify(subjectRepostory,times(1)).findById(1);
        verify(subjectMapper,times(1)).toPutResponse(subject);
    }


    @Test
    public void whenDeleteSubject(){
        int id=1;
        when(subjectRepostory.findById(1)).thenReturn(Optional.of(subject));

        subjectService.deleteSubject(id);

        verify(subjectRepostory,times(1)).findById(1);
        verify(subjectRepostory,times(1)).delete(subject);
    }
}
