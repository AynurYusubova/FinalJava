package com.example.FinalJava.service;

import com.example.FinalJava.dto.req.StudentPostRequest;
import com.example.FinalJava.dto.req.StudentPutRequest;
import com.example.FinalJava.dto.res.StudentAllResponse;
import com.example.FinalJava.dto.res.StudentGetResponse;
import com.example.FinalJava.dto.res.StudentPostResponse;
import com.example.FinalJava.dto.res.StudentPutResponse;


import java.util.List;

public interface StudentService {
    List<StudentAllResponse> getStudents();

    StudentGetResponse getStudent(int id);
    StudentPostResponse addStudent(StudentPostRequest studentPostRequest);
    StudentPutResponse updateStudent(int id, StudentPutRequest studentPutRequest);
    void deleteStudent(int id);
}
