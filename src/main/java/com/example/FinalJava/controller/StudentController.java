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
@RequestMapping("/apistu")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getst")
    List<StudentAllResponse> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/gets/{id}")
    StudentGetResponse getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @PostMapping("/postst")
    public StudentPostResponse addStudent(@RequestBody StudentPostRequest studentPostRequest){
        return studentService.addStudent(studentPostRequest);
    }

    @PutMapping("/putst/{id}")
    public StudentPutResponse updateStudent(@PathVariable(name="id") int id, @RequestBody StudentPutRequest studentPutRequest){
        return studentService.updateStudent(id,studentPutRequest);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable(name="id") int id){
        studentService.deleteStudent(id);
    }
}
