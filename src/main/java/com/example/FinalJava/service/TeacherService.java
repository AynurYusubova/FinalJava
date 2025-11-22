package com.example.FinalJava.service;

import com.example.FinalJava.dto.req.TeacherPostRequest;
import com.example.FinalJava.dto.req.TeacherPutRequest;
import com.example.FinalJava.dto.res.TeacherAllResponse;
import com.example.FinalJava.dto.res.TeacherGetResponse;
import com.example.FinalJava.dto.res.TeacherPostResponse;
import com.example.FinalJava.dto.res.TeacherPutResponse;

import java.util.List;

public interface TeacherService {

    List<TeacherAllResponse> getTeachers();
    TeacherGetResponse getTeacherById(int id);
    TeacherPostResponse postTeacher(TeacherPostRequest teacherPostRequest);
    TeacherPutResponse putTeacher(int id,TeacherPutRequest teacherPutRequest);
    void deleteTeacher(int id);
}
