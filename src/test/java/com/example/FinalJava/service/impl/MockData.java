package com.example.FinalJava.service.impl;
import com.example.FinalJava.dto.req.StudentPostRequest;
import com.example.FinalJava.dto.req.StudentPutRequest;
import com.example.FinalJava.dto.res.StudentAllResponse;
import com.example.FinalJava.dto.res.StudentGetResponse;
import com.example.FinalJava.dto.res.StudentPostResponse;
import com.example.FinalJava.dto.res.StudentPutResponse;
import com.example.FinalJava.entity.StudentEntity;
import com.example.FinalJava.entity.UniEntity;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class MockData {


    public static UniEntity uniBDU() {
        return UniEntity.builder()
                .id(1)
                .name("BDU")
                .build();
    }

    public static UniEntity uniUNEC() {
        return UniEntity.builder()
                .id(2)
                .name("UNEC")
                .build();
    }


    public static StudentEntity studentEntity1() {
        return StudentEntity.builder()
                .id(1)
                .name("Aynur")
                .surname("Yusubova")
                .email("aynur@gmail.com")
                .birthday(LocalDate.of(2004, 4, 5))
                .course(3)
                .annualFree(0)
                .uni(uniBDU())
                .build();
    }

    public static StudentEntity studentEntity2() {
        return StudentEntity.builder()
                .id(2)
                .name("Elvin")
                .surname("Aliyev")
                .email("elvin@gmail.com")
                .birthday(LocalDate.of(2003, 3, 10))
                .course(2)
                .annualFree(100)
                .uni(uniUNEC())
                .build();
    }

    public static List<StudentEntity> studentEntities() {
        return Arrays.asList(studentEntity1(), studentEntity2());
    }


    public static List<StudentAllResponse> studentAllResponse() {
        return Arrays.asList(
                new StudentAllResponse(1, "Aynur", "Yusubova", "aynur@gmail.com",
                        LocalDate.of(2004, 4, 5), 3, 0.0),
                new StudentAllResponse(2, "Elvin", "Aliyev", "elvin@gmail.com",
                        LocalDate.of(2003, 3, 10), 2, 100.0)
        );
    }

    public static StudentEntity entity(){
        return StudentEntity.builder()
                .id(1)
                .name("Aynur")
                .surname("Yusubova")
                .email("aynur@gmail.com")
                .birthday(LocalDate.of(2004, 4, 5))
                .course(3)
                .annualFree(0)
                .uni(uniBDU())
                .build();
    }

    public static StudentGetResponse response(){
        return StudentGetResponse.builder()
                .name("Aynur")
                .surname("Yusubova")
                .email("aynur@gmail.com")
                .birthday(LocalDate.of(2004, 4, 5))
                .course(3)
                .annualFree(0)
                .message("ll")
                .build();
    }

    public static UniEntity uni(){
        return UniEntity.builder()
                .id(1)
                .name("Naile")
                .faculty("Riyaziyyat")
                .students(student())
                .build();
    }

    public static List <StudentEntity> student(){
          return  List.of(entity());
    }


    public static StudentPostResponse response1(){
        return StudentPostResponse.builder()
                .name("Aynur")
                .surname("Yusubova")
                .email("aynur@gmail.com")
                .birthday(LocalDate.of(2004, 4, 5))
                .course(3)
                .annualFree(0)
                .message("ll")
                .build();
    }

    public static StudentPostRequest studentPostRequest(){
        return StudentPostRequest.builder()
                .name("Aynur")
                .surname("Yusubova")
                .email("aynur@gmail.com")
                .birthday(LocalDate.of(2004, 4, 5))
                .course(3)
                .annualFree(0)
                .uniId(1)
                .build();
    }

    public static StudentPostResponse studentPostResponse(){
       return StudentPostResponse.builder()
                .name("Aynur")
                .surname("Yusubova")
                .email("aynur@gmail.com")
                .birthday(LocalDate.of(2004, 4, 5))
                .course(3)
                .annualFree(0)
                .message("ll")
                .build();
    }



    public static StudentPutResponse response2(){
        return StudentPutResponse.builder()
                .name("Aynur")
                .surname("Yusubova")
                .email("aynur@gmail.com")
                .birthday(LocalDate.of(2004, 4, 5))
                .course(3)
                .annualFree(0)
                .message("ll")
                .build();
    }

    public static StudentPutRequest studentPutRequest(){
        return StudentPutRequest.builder()
                .name("Aynur")
                .surname("Yusubova")
                .email("aynur@gmail.com")
                .birthday(LocalDate.of(2004, 4, 5))
                .course(3)
                .annualFree(0)
                .build();
    }

}
