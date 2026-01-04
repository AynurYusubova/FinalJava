package com.example.FinalJava.service.impl;
import com.example.FinalJava.dto.req.*;
import com.example.FinalJava.dto.res.*;
import com.example.FinalJava.entity.StudentEntity;
import com.example.FinalJava.entity.SubjectEntity;
import com.example.FinalJava.entity.TeacherEntity;
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

    public static List <SubjectAllResponse> subjectAllResponse(){
        return Arrays.asList(
                new SubjectAllResponse(1,"Riyaziyyat",5),
                new SubjectAllResponse(2,"Az-dili",5)
        );
    }


    public static TeacherEntity teacherEntity(){
        return TeacherEntity.builder()
                .id(1)
                .name("Servan")
                .surname("Eziz")
                .build();
    }

    public static List <SubjectEntity> subjectEntities(){
        return Arrays.asList(
                new SubjectEntity(1,"Az-dili",7,teacherEntity())
        );
    }

    public static SubjectEntity subject(){
        return SubjectEntity.builder()
                .id(1)
                .name("Azdili")
                .credits(5)
                .teacher(teacherEntity())
                .build();
    }


    public static SubjectGetResponse subjectResponse(){
        return SubjectGetResponse.builder()
                .name("Azdili")
                .credits(7)
                .message("Message")
                .build();
    }

    public static SubjectPostRequest subjectPostRequest(){
        return SubjectPostRequest.builder()
                .name("Azdili")
                .credits(7)
                .teacherId(2)
                .build();
    }

    public static SubjectPostResponse subjectPostResponse(){
        return SubjectPostResponse.builder()
                .name("Azdili")
                .credits(7)
                .message("Message")
                .build();
    }


    public static SubjectPutRequest subjectPutRequest(){
        return SubjectPutRequest.builder()
                .name("Azdili")
                .credits(7)
                .build();
    }

    public static SubjectPutResponse subjectPutResponse(){
        return SubjectPutResponse.builder()
                .name("Azdili")
                .credits(7)
                .message("Message")
                .build();
    }


    public static List <TeacherAllResponse> teacherAllResponse(){
        return Arrays.asList(
                new TeacherAllResponse(1,"Elnur","Aliyev")
        );
    }

    public static List <TeacherEntity> teacherEntities(){
        return Arrays.asList(
                new TeacherEntity(1,"Elnur","Aliyev",subjectEntities())
        );
    }

   public static TeacherGetResponse teacherGetResponse(){
        return TeacherGetResponse.builder()
                .name("Lale")
                .surname("Aliyev")
                .message("Message")
                .build();
   }

   public static TeacherPostResponse teacherPostResponse(){
        return TeacherPostResponse.builder()
                .name("Araz")
                .surname("Aliyev")
                .message("Message")
                .build();
   }

   public static TeacherPostRequest teacherPostRequest(){
        return TeacherPostRequest.builder()
                .name("Araz")
                .surname("Aliyev")
                .build();
   }

   public static TeacherPutResponse teacherPutResponse(){
        return TeacherPutResponse.builder()
                .name("Araz")
                .surname("Aliyev")
                .message("Message")
                .build();
   }


   public static List <UniAllResponse> uniAllResponse(){
        return Arrays.asList(
                new UniAllResponse(1,"BDU","IT")
        );
   }

   public static List <UniEntity> uniEntities(){
        return Arrays.asList(
                new UniEntity(1,"BDU","IT",studentEntities())
        );
   }


   public static UniGetResponse uniGetResponse(){
        return UniGetResponse.builder()
                .name("BDU")
                .faculty("IT")
                .message("message")
                .build();
   }

   public static UniPutResponse uniPutResponse(){
        return UniPutResponse.builder()
                .name("BDU")
                .faculty("IT")
                .message("message")
                .build();

   }

   public static UniPutRequest uniPutRequest(){
        return UniPutRequest.builder()
                .name("BDU")
                .faculty("IT")
                .build();
   }


   public static UniPostRequest  uniPostRequest(){
        return UniPostRequest.builder()
                .name("BDU")
                .faculty("IT")
                .build();
   }

}
