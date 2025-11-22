package com.example.FinalJava.service;

import com.example.FinalJava.dto.req.SubjectPostRequest;
import com.example.FinalJava.dto.req.SubjectPutRequest;
import com.example.FinalJava.dto.res.SubjectAllResponse;
import com.example.FinalJava.dto.res.SubjectGetResponse;
import com.example.FinalJava.dto.res.SubjectPostResponse;
import com.example.FinalJava.dto.res.SubjectPutResponse;

import java.util.List;

public interface SubjectService {

    List<SubjectAllResponse> getSubjects();
    SubjectGetResponse getSubject(int id);
    SubjectPostResponse addSubject(SubjectPostRequest subjectPostRequest);
    SubjectPutResponse updateSubject(int id,SubjectPutRequest subjectPutRequest);
    void deleteSubject(int id);
}
