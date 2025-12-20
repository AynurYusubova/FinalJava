package com.example.FinalJava.service.impl;

import com.example.FinalJava.dto.req.StudentPostRequest;
import com.example.FinalJava.dto.req.StudentPutRequest;
import com.example.FinalJava.dto.res.StudentAllResponse;
import com.example.FinalJava.dto.res.StudentGetResponse;
import com.example.FinalJava.dto.res.StudentPostResponse;
import com.example.FinalJava.dto.res.StudentPutResponse;
import com.example.FinalJava.entity.StudentEntity;
import com.example.FinalJava.entity.UniEntity;
import com.example.FinalJava.mapper.StudentMapper;
import com.example.FinalJava.repostory.StudentRepostory;
import com.example.FinalJava.repostory.UniRepostory;
import com.example.FinalJava.service.Impl.StudentServiceImpl;
import com.example.FinalJava.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {
        UniRepostory.class,
        StudentRepostory.class,
        StudentMapper.class,
        StudentService.class,
        StudentServiceImpl.class,
        StudentGetResponse.class,
        StudentEntity.class,
        StudentAllResponse.class,
        UniEntity.class,
        StudentPostResponse.class,
        StudentPostRequest.class,
})
public class StudentServiceImplTest {

    @MockitoBean
    private  StudentRepostory studentRepostory;

    @MockitoBean
    private StudentMapper studentMapper;


    @MockitoBean
    private  UniRepostory uniRepostory;


    @Autowired
    private StudentService studentService;

    private List<StudentAllResponse> getStudents;

    private StudentEntity  studentEntity;

    private  StudentEntity entity;

    private List<StudentEntity> studentEntities;

    private  StudentServiceImpl studentServiceImpl;

    private  StudentGetResponse response;

    private StudentPostResponse response1;

    private List <StudentAllResponse> studentAllResponse;

    private UniEntity uni;

    private StudentPostRequest studentPostRequest;

    private StudentPostResponse studentPostResponse;

    private StudentPutResponse response2;

    private StudentPutRequest studentPutRequest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        List <StudentAllResponse> studentAllResponse =MockData.studentAllResponse();
        studentEntities =MockData.studentEntities();
        entity =MockData.entity();
        response =MockData.response();
        uni = MockData.uni();
        response1 =MockData.response1();
        studentPostResponse=MockData.studentPostResponse();
        studentPostRequest =MockData.studentPostRequest();
        response2 =MockData.response2();
        studentPutRequest =MockData.studentPutRequest();


    }

    @Test
    void whenGetAllStudents(){
        when(studentRepostory.findAll()).thenReturn(studentEntities);
        when(studentMapper.mapEntityForStudentAllResponse(studentEntities)).thenReturn(studentAllResponse);



        studentService.getStudents();


        verify(studentRepostory, times(1)).findAll();
        verify(studentMapper, times(1)).mapEntityForStudentAllResponse(studentEntities);
    }



    @Test
    void whenGetStudentById(){
        int id=1;
        when(studentRepostory.findById(id)).thenReturn(Optional.of(entity));
        when(studentMapper.toGetResponse(entity)).thenReturn(response);

        studentService.getStudent(id);

        verify(studentRepostory, times(1)).findById(id);
        verify(studentMapper,times(1)).toGetResponse(entity);
    }


    @Test
    void whenAddStudent(){
        when(uniRepostory.findById(entity.getId())).thenReturn(Optional.of(uni));
        when(studentMapper.toPostResponse(uni)).thenReturn(response1);

        studentPostResponse = studentService.addStudent(studentPostRequest);


        verify(uniRepostory, times(1)).findById(entity.getId());
       verify(studentMapper,times(1)).toPostResponse(uni);
    }

    @Test
    void whenUpdateStudent(){
        when(studentRepostory.findById(entity.getId())).thenReturn(Optional.of(entity));
        when(studentMapper.toPutResponse(entity)).thenReturn(response2);

        response2=studentService.updateStudent(1,studentPutRequest);

        verify(studentRepostory, times(1)).findById(entity.getId());
        verify(studentMapper,times(1)).toPutResponse(entity);

    }


    @Test
    void whenDeleteStudent(){
        int id=1;
        when(studentRepostory.findById(id)).thenReturn(Optional.of(entity));

        studentService.deleteStudent(id);

        verify(studentRepostory, times(1)).findById(id);
        verify(studentRepostory, times(1)).delete(entity);
    }
}
