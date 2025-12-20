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
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @GetMapping("/teachers")
    public List<TeacherAllResponse> getTeachers() {
        return teacherService.getTeachers();
    }

    @GetMapping("/teachers/{id}")
    public TeacherGetResponse getTeacherById(@PathVariable int id){
        return teacherService.getTeacherById(id);
    }


    @PostMapping("/teachers")
    public TeacherPostResponse postTeacher(@RequestBody TeacherPostRequest teacherPostRequest){
        return teacherService.postTeacher(teacherPostRequest);
    }


    @PutMapping("/teachers/{id}")
    public TeacherPutResponse putTeacher(@PathVariable(name="id") int id, @RequestBody TeacherPutRequest teacherPutRequest){
        return teacherService.putTeacher(id,teacherPutRequest);
    }

    @DeleteMapping("/teachers/{id}")
    public void deleteTeacher(@PathVariable(name="id") int id){
        teacherService.deleteTeacher(id);
    }



}
