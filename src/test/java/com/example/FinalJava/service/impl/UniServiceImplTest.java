package com.example.FinalJava.service.impl;


import com.example.FinalJava.dto.req.UniPostRequest;
import com.example.FinalJava.dto.req.UniPutRequest;
import com.example.FinalJava.dto.res.UniAllResponse;
import com.example.FinalJava.dto.res.UniGetResponse;
import com.example.FinalJava.dto.res.UniPostResponse;
import com.example.FinalJava.dto.res.UniPutResponse;
import com.example.FinalJava.entity.UniEntity;
import com.example.FinalJava.mapper.UniMapper;
import com.example.FinalJava.repostory.UniRepostory;
import com.example.FinalJava.service.Impl.UniServiceImpl;
import com.example.FinalJava.service.UniService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = {
        UniServiceImpl.class,
        UniRepostory.class,
        UniMapper.class,
        UniService.class,
        UniAllResponse.class,
        UniEntity.class,
        UniGetResponse.class,
        UniPutRequest.class,
        UniPutResponse.class
})
public class UniServiceImplTest {

    @MockitoBean
    private UniRepostory uniRepostory;

    @MockitoBean
    private UniMapper uniMapper;

    @Autowired
    private UniService uniService;

    private List<UniAllResponse> uniAllResponse;

    private List<UniEntity> uniEntities;

    private UniEntity uni;

    private UniGetResponse uniGetResponse;

    private UniPutResponse uniPutResponse;

    private UniPutRequest uniPutRequest;

    private UniPostRequest  uniPostRequest;

    private UniPostResponse uniPostResponse;


    @BeforeEach
    public void init() {
        uniAllResponse = MockData.uniAllResponse();
        uniEntities = MockData.uniEntities();
        uni = MockData.uni();
        uniGetResponse = MockData.uniGetResponse();
        uniPutResponse =MockData.uniPutResponse();
        uniPutRequest = MockData.uniPutRequest();
        uniPostRequest = MockData.uniPostRequest();

    }


    @Test
    public void whenGetAllUni(){
        when(uniRepostory.findAll()).thenReturn(uniEntities);
        when(uniMapper.mapEntityForUniAllResponse(uniEntities)).thenReturn(uniAllResponse);

        uniService.getAlluni();

        verify(uniRepostory,times(1)).findAll();
        verify(uniMapper,times(1)).mapEntityForUniAllResponse(uniEntities);
    }


    @Test
    public void whenGetUniById(){
        int id=1;
        when(uniRepostory.findById(id)).thenReturn(Optional.of(uni));
        when(uniMapper.toGetResponse(uni)).thenReturn(uniGetResponse);

        uniService.getuni(id);

        verify(uniRepostory,times(1)).findById(id);
        verify(uniMapper,times(1)).toGetResponse(uni);
    }



    @Test
    public void whenAddUni(){
        when(uniRepostory.save(uni)).thenReturn(uni);

        uniPostResponse=uniService.adduni(uniPostRequest);

        verify(uniRepostory,times(1)).save(any());

    }


    @Test
    public void whenUpdateUni(){
        int id=1;
        when(uniRepostory.findById(id)).thenReturn(Optional.of(uni));
        when(uniMapper.toPutResponse(uni)).thenReturn(uniPutResponse);


        uniPutResponse=uniService.updateuni(id,uniPutRequest);

        verify(uniRepostory,times(1)).findById(id);
        verify(uniMapper,times(1)).toPutResponse(uni);
    }


    @Test
    public void whenDeleteUni(){
        int id=1;
        when(uniRepostory.findById(id)).thenReturn(Optional.of(uni));

        uniService.deleteuni(id);

        verify(uniRepostory,times(1)).findById(id);
        verify(uniRepostory,times(1)).delete(uni);
    }

}
