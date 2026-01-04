package com.example.FinalJava.service.Impl;
import com.example.FinalJava.dto.req.StudentPostRequest;
import com.example.FinalJava.dto.req.StudentPutRequest;
import com.example.FinalJava.dto.res.StudentAllResponse;
import com.example.FinalJava.dto.res.StudentGetResponse;
import com.example.FinalJava.dto.res.StudentPostResponse;
import com.example.FinalJava.dto.res.StudentPutResponse;
import com.example.FinalJava.entity.StudentEntity;
import com.example.FinalJava.entity.UniEntity;
import com.example.FinalJava.exception.NotFoundException;
import com.example.FinalJava.mapper.StudentMapper;
import com.example.FinalJava.repostory.StudentRepostory;
import com.example.FinalJava.repostory.UniRepostory;
import com.example.FinalJava.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepostory studentRepostory;
    private final StudentMapper studentMapper;
    private final UniRepostory uniRepostory;

    public StudentServiceImpl(StudentRepostory studentRepostory,
                              StudentMapper studentMapper,
                              UniRepostory uniRepostory) {
        this.studentRepostory = studentRepostory;
        this.studentMapper = studentMapper;
        this.uniRepostory = uniRepostory;
    }

    @Override
    public List<StudentAllResponse> getStudents() {
        List<StudentEntity> studentEntities = studentRepostory.findAll();
        return studentMapper.mapEntityForStudentAllResponse(studentEntities);
    }

    @Override
    public StudentGetResponse getStudent(int id) {
        StudentEntity entity = studentRepostory.findById(id)
                .orElseThrow(() -> new NotFoundException("Tələbə tapılmadı!"));

        StudentGetResponse response = studentMapper.toGetResponse(entity);
        response.setMessage("ID " + id + " məlumat tapıldı!");

        return response;

    }

    @Override
    public StudentPostResponse addStudent(StudentPostRequest studentPostRequest) {

        UniEntity uni = uniRepostory.findById(studentPostRequest.getUniId())
                .orElseThrow(() -> new NotFoundException("Universitet tapılmadı!"));

        StudentPostResponse response1=studentMapper.toPostResponse(uni);
        response1.setMessage("Məlumat əlavə olundu!");

        return response1;
    }

    @Transactional
    @Override
    public StudentPutResponse updateStudent(int id, StudentPutRequest studentPutRequest) {
        StudentEntity entity = studentRepostory.findById(id)
                .orElseThrow(()-> new NotFoundException("Məlumat tapılmadı!"));

                entity.setName(studentPutRequest.getName());
                entity.setSurname(studentPutRequest.getSurname());
                entity.setEmail(studentPutRequest.getEmail());
                entity.setBirthday(studentPutRequest.getBirthday());
                entity.setCourse(studentPutRequest.getCourse());
                entity.setAnnualFree(studentPutRequest.getAnnualFree());

                StudentPutResponse response2=new StudentPutResponse();
                response2.setName(entity.getName());
                response2.setSurname(entity.getSurname());
                response2.setEmail(entity.getEmail());
                response2.setBirthday(entity.getBirthday());
                response2.setCourse(entity.getCourse());
                response2.setAnnualFree(entity.getAnnualFree());
                response2.setMessage("Məlumat uğurla dəyişdirildi!");
                return response2;
    }

    @Transactional
    @Override
    public void deleteStudent(int id) {
        StudentEntity studentEntity = studentRepostory.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "ID " + id + " üçün tələbə tapılmadı!"
                ));
        studentRepostory.delete(studentEntity);
        log.info("ID " + id + " məlumat silindi!");
    }
}
