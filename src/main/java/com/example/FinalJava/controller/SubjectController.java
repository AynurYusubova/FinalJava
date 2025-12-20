package com.example.FinalJava.controller;


import com.example.FinalJava.dto.req.SubjectPostRequest;
import com.example.FinalJava.dto.req.SubjectPutRequest;
import com.example.FinalJava.dto.res.SubjectAllResponse;
import com.example.FinalJava.dto.res.SubjectGetResponse;
import com.example.FinalJava.dto.res.SubjectPostResponse;
import com.example.FinalJava.dto.res.SubjectPutResponse;
import com.example.FinalJava.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {


    @Autowired
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }


    @GetMapping("/subjects")
    public List<SubjectAllResponse>  getSubjects() {
        return subjectService.getSubjects();
    }


    @GetMapping("/subjects/{id}")
    public SubjectGetResponse getSubject(@PathVariable int id) {
        return subjectService.getSubject(id);
    }

    @PostMapping("/subjects")
    public SubjectPostResponse addSubject(@RequestBody SubjectPostRequest subjectPostRequest) {
        return subjectService.addSubject(subjectPostRequest);
    }

    @PutMapping("/subjects/{id}")
    public SubjectPutResponse updateSubject(@PathVariable(name="id") int id,@RequestBody SubjectPutRequest subjectPutRequest) {
         return subjectService.updateSubject(id, subjectPutRequest);
    }

    @DeleteMapping("/subjects/{id}")
    public void deleteSubject(@PathVariable(name="id") int id){
        subjectService.deleteSubject(id);
    }
}
