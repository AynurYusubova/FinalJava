package com.example.FinalJava.service.Impl;

import com.example.FinalJava.dto.req.StudentPostRequest;
import com.example.FinalJava.dto.req.StudentPutRequest;
import com.example.FinalJava.dto.res.StudentAllResponse;
import com.example.FinalJava.dto.res.StudentGetResponse;
import com.example.FinalJava.dto.res.StudentPostResponse;
import com.example.FinalJava.dto.res.StudentPutResponse;
import com.example.FinalJava.entity.StudentEntity;
import com.example.FinalJava.entity.UniEntity;
import com.example.FinalJava.mapper.StudentMapper;
import com.example.FinalJava.repostory.StudentRepostory;
import com.example.FinalJava.repostory.UniRepostory;
import com.example.FinalJava.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepostory studentRepostory;

    @Autowired
    private StudentMapper studentMapper;


    @Autowired
    private UniRepostory uniRepostory;



    @Override
    public List<StudentAllResponse> getStudents() {
        List<StudentEntity> studentEntities = studentRepostory.findAll();
        return studentMapper.mapEntityForStudentAllResponse(studentEntities);
    }

    @Override
    public StudentGetResponse getStudent(int id) {
        Optional<StudentEntity> studentEntity = studentRepostory.findById(id);

        if(studentEntity.isEmpty()){
            return StudentGetResponse.builder()
                    .message("ID " + id + " üçün tələbə tapılmadı!")
                    .build();
        }

        StudentEntity studentEntity1 = studentEntity.get();
        return StudentGetResponse.builder()
                .name(studentEntity1.getName())
                .surname(studentEntity1.getSurname())
                .email(studentEntity1.getEmail())
                .annualFree(studentEntity1.getAnnualFree())
                .birthday(studentEntity1.getBirthday())
                .course(studentEntity1.getCourse())
                .message("ID" + id + " məlumat tapıldı!")
                .build();

    }

    @Override
    public StudentPostResponse addStudent(StudentPostRequest studentPostRequest) {
        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setName(studentPostRequest.getName());
        studentEntity.setSurname(studentPostRequest.getSurname());
        studentEntity.setEmail(studentPostRequest.getEmail());
        studentEntity.setAnnualFree(studentPostRequest.getAnnualFree());
        studentEntity.setBirthday(studentPostRequest.getBirthday());
        studentEntity.setCourse(studentPostRequest.getCourse());


        UniEntity uni = uniRepostory.findById(studentPostRequest.getUniId()).orElse(null);
        studentEntity.setUni(uni);


        studentRepostory.save(studentEntity);


        return StudentPostResponse.builder()
                .name(studentEntity.getName())
                .surname(studentEntity.getSurname())
                .email(studentEntity.getEmail())
                .annualFree(studentEntity.getAnnualFree())
                .birthday(studentEntity.getBirthday())
                .course(studentEntity.getCourse())
                .message("Məlumat uğurla əlavə olundu!")
                .build();

    }

    @Override
    public StudentPutResponse updateStudent(int id, StudentPutRequest studentPutRequest) {
        Optional<StudentEntity> studentEntit = studentRepostory.findById(id);

        if(studentEntit.isEmpty()){
            return StudentPutResponse.builder()
                    .message("ID " + id + " üçün tələbə tapılmadı!")
                    .build();
        }

        StudentEntity studentEntity1 = studentEntit.get();
        return StudentPutResponse.builder()
                .name(studentEntity1.getName())
                .surname(studentEntity1.getSurname())
                .email(studentEntity1.getEmail())
                .annualFree(studentEntity1.getAnnualFree())
                .birthday(studentEntity1.getBirthday())
                .course(studentEntity1.getCourse())
                .message("Məlumat uğurla dəyişdirildi!")
                .build();
    }

    @Override
    public void deleteStudent(int id) {
        Optional<StudentEntity> student = studentRepostory.findById(id);
        if(student.isEmpty()){
            System.out.println("ID " + id + " üçün tələbə tapılmadı!");
            return;
        }
        System.out.println("ID " + id + "məlumat silindi!" );
        studentRepostory.delete(student.get());
    }
}
