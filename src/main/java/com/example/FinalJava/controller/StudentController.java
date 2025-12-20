package com.example.FinalJava.controller;

import com.example.FinalJava.dto.req.StudentPostRequest;
import com.example.FinalJava.dto.req.StudentPutRequest;
import com.example.FinalJava.dto.res.StudentAllResponse;
import com.example.FinalJava.dto.res.StudentGetResponse;
import com.example.FinalJava.dto.res.StudentPostResponse;
import com.example.FinalJava.dto.res.StudentPutResponse;
import com.example.FinalJava.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentAllResponse> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    public StudentGetResponse getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @PostMapping("/students")
    public StudentPostResponse addStudent(@RequestBody StudentPostRequest studentPostRequest){
        return studentService.addStudent(studentPostRequest);
    }

    @PutMapping("/students/{id}")
    public StudentPutResponse updateStudent(@PathVariable(name="id") int id, @RequestBody StudentPutRequest studentPutRequest){
        return studentService.updateStudent(id,studentPutRequest);
    }


    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable(name="id") int id){
        studentService.deleteStudent(id);
    }
}
