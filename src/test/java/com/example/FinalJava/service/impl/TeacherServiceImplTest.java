package com.example.FinalJava.service.impl;


import com.example.FinalJava.dto.req.TeacherPostRequest;
import com.example.FinalJava.dto.req.TeacherPutRequest;
import com.example.FinalJava.dto.res.TeacherAllResponse;
import com.example.FinalJava.dto.res.TeacherGetResponse;
import com.example.FinalJava.dto.res.TeacherPostResponse;
import com.example.FinalJava.dto.res.TeacherPutResponse;
import com.example.FinalJava.entity.TeacherEntity;
import com.example.FinalJava.mapper.TeacherMapper;
import com.example.FinalJava.repostory.TeacherRepostory;
import com.example.FinalJava.service.Impl.TeacherServiceImpl;
import com.example.FinalJava.service.TeacherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = {
        TeacherServiceImpl.class,
        TeacherRepostory.class,
        TeacherMapper.class,
        TeacherService.class,
        TeacherAllResponse.class,
        TeacherEntity.class,
        TeacherGetResponse.class,

})
public class TeacherServiceImplTest {

    @MockitoBean
    private TeacherRepostory teacherRepostory;

    @MockitoBean
    private TeacherMapper teacherMapper;

    @Autowired
    private TeacherService teacherService;

    private List <TeacherAllResponse> teacherAllResponse;

    private List<TeacherEntity> teacherEntities;

    private TeacherEntity teacherEntity;

    private TeacherGetResponse teacherGetResponse;

    private TeacherPostResponse teacherPostResponse;

    private TeacherPostRequest teacherPostRequest;

    private TeacherPutResponse teacherPutResponse;

    private TeacherPutRequest teacherPutRequest;



    @BeforeEach
    public void init() {
        teacherAllResponse=MockData.teacherAllResponse();
        teacherEntities=MockData.teacherEntities();
        teacherEntity = MockData.teacherEntity();
        teacherGetResponse= MockData.teacherGetResponse();
        teacherPostResponse= MockData.teacherPostResponse();
        teacherPostRequest= MockData.teacherPostRequest();
        teacherPutResponse= MockData.teacherPutResponse();

    }

    @Test
    public void whenGetAllTeacher(){
        when(teacherRepostory.findAll()).thenReturn(teacherEntities);
        when(teacherMapper.mapEntityForTeacherAllResponse(teacherEntities)).thenReturn(teacherAllResponse);

        teacherService.getTeachers();

        verify(teacherRepostory,times(1)).findAll();
        verify(teacherMapper,times(1)).mapEntityForTeacherAllResponse(teacherEntities);
    }


    @Test
    public void whenGetTeacherById(){
        int id=1;
        when(teacherRepostory.findById(id)).thenReturn(Optional.of(teacherEntity));
        when(teacherMapper.toGetResponse(teacherEntity)).thenReturn(teacherGetResponse);


        teacherService.getTeacherById(id);

        verify(teacherRepostory,times(1)).findById(id);
        verify(teacherMapper,times(1)).toGetResponse(teacherEntity);
    }

    @Test
    public void whenAddTeacher(){
        when(teacherRepostory.save(teacherEntity)).thenReturn(teacherEntity);

        teacherPostResponse=teacherService.postTeacher(teacherPostRequest);

        verify(teacherRepostory,times(1)).save(any());

    }


    @Test
    public void whenPutTeacher(){
        int id=1;
        when(teacherRepostory.findById(id)).thenReturn(Optional.of(teacherEntity));
        when(teacherMapper.toPutResponse(teacherEntity)).thenReturn(teacherPutResponse);


        teacherPutResponse =teacherService.putTeacher(id,teacherPutRequest);


        verify(teacherRepostory,times(1)).findById(id);
        verify(teacherMapper,times(1)).toPutResponse(teacherEntity);
    }


    @Test
    public void whenDeleteTeacher(){
        int id=1;
        when(teacherRepostory.findById(id)).thenReturn(Optional.of(teacherEntity));


        teacherService.deleteTeacher(id);

        verify(teacherRepostory,times(1)).findById(id);
        verify(teacherRepostory,times(1)).delete(teacherEntity);
    }



}
