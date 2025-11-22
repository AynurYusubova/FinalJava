package com.example.FinalJava.service;

import com.example.FinalJava.dto.req.UniPostRequest;
import com.example.FinalJava.dto.req.UniPutRequest;
import com.example.FinalJava.dto.res.UniAllResponse;
import com.example.FinalJava.dto.res.UniGetResponse;
import com.example.FinalJava.dto.res.UniPostResponse;
import com.example.FinalJava.dto.res.UniPutResponse;

import java.util.List;

public interface UniService {
    List<UniAllResponse> getAlluni();

    UniGetResponse getuni(int id);

    UniPostResponse adduni(UniPostRequest uniPostRequest);

    UniPutResponse updateuni(int id, UniPutRequest uniPutRequest);

    void deleteuni(int id);
}
