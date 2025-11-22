package com.example.FinalJava.controller;
import com.example.FinalJava.dto.req.TeacherPostRequest;
import com.example.FinalJava.dto.req.TeacherPutRequest;
import com.example.FinalJava.dto.res.TeacherAllResponse;
import com.example.FinalJava.dto.res.TeacherGetResponse;
import com.example.FinalJava.dto.res.TeacherPostResponse;
import com.example.FinalJava.dto.res.TeacherPutResponse;
import com.example.FinalJava.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/apiteac")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/get")
    List<TeacherAllResponse> getTeachers() {
        return teacherService.getTeachers();
    }

    @GetMapping("/get/{id}")
    public TeacherGetResponse getTeacherById(@PathVariable int id){
        return teacherService.getTeacherById(id);
    }


    @PostMapping("/post")
    public TeacherPostResponse postTeacher(@RequestBody TeacherPostRequest teacherPostRequest){
        return teacherService.postTeacher(teacherPostRequest);
    }


    @PutMapping("/put/{id}")
    public TeacherPutResponse putTeacher(@PathVariable(name="id") int id, @RequestBody TeacherPutRequest teacherPutRequest){
        return teacherService.putTeacher(id,teacherPutRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTeacher(@PathVariable(name="id") int id){
        teacherService.deleteTeacher(id);
    }



}
