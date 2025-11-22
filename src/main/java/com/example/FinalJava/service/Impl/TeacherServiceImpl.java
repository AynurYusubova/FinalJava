package com.example.FinalJava.service.Impl;

import com.example.FinalJava.dto.req.TeacherPostRequest;
import com.example.FinalJava.dto.req.TeacherPutRequest;
import com.example.FinalJava.dto.res.*;
import com.example.FinalJava.entity.TeacherEntity;
import com.example.FinalJava.mapper.TeacherMapper;
import com.example.FinalJava.repostory.TeacherRepostory;
import com.example.FinalJava.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepostory teacherRepostory;

    @Autowired
    private TeacherMapper teacherMapper;



    @Override
    public List<TeacherAllResponse> getTeachers() {
        List<TeacherEntity> teacherEntities = teacherRepostory.findAll();
        return teacherMapper.mapEntityForTeacherAllResponse(teacherEntities);
    }

    @Override
    public TeacherGetResponse getTeacherById(int id) {
        Optional<TeacherEntity> teacherEntity = teacherRepostory.findById(id);

        if(teacherEntity.isEmpty()){
            return TeacherGetResponse.builder()
                    .message("ID " + id + " üçün müəllim tapılmadı!")
                    .build();
        }

        TeacherEntity teacherEntity1 = teacherEntity.get();
        return TeacherGetResponse.builder()
                .name(teacherEntity1.getName())
                .surname(teacherEntity1.getSurname())
                .message("ID" + id + " məlumat tapıldı!")
                .build();

      }

    @Override
    public TeacherPostResponse postTeacher(TeacherPostRequest teacherPostRequest) {
        TeacherEntity teacherEntity=new TeacherEntity();
        teacherEntity.setName(teacherPostRequest.getName());
        teacherEntity.setSurname(teacherPostRequest.getSurname());
        teacherRepostory.save(teacherEntity);
        return TeacherPostResponse.builder()
                .name(teacherEntity.getName())
                .surname(teacherEntity.getSurname())
                .message("Məlumat uğurla əlavə olundu!")
                .build();
    }

    @Override
    public TeacherPutResponse putTeacher(int id, TeacherPutRequest teacherPutRequest) {
        Optional<TeacherEntity> teacherEntit = teacherRepostory.findById(id);

        if(teacherEntit.isEmpty()){
            return TeacherPutResponse.builder()
                    .message("ID " + id + " üçün müəllim tapılmadı!")
                    .build();
        }

        TeacherEntity teacherEntity1 = teacherEntit.get();
        return TeacherPutResponse.builder()
                .name(teacherEntity1.getName())
                .surname(teacherEntity1.getSurname())
                .message("Məlumat uğurla dəyişdirildi!")
                .build();
    }

    @Override
    public void deleteTeacher(int id) {
        Optional<TeacherEntity> teacher = teacherRepostory.findById(id);
        if(teacher.isEmpty()){
            System.out.println("ID " + id + " üçün müəllim tapılmadı!");
            return;
        }
        System.out.println("ID " + id + "məlumat silindi!" );
        teacherRepostory.delete(teacher.get());
    }


}

