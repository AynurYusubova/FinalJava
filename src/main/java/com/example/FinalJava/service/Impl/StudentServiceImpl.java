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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;




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


    @Override
    public StudentPutResponse updateStudent(int id, StudentPutRequest studentPutRequest) {
        StudentEntity entity = studentRepostory.findById(id)
                .orElseThrow(()-> new NotFoundException("Məlumat tapılmadı!"));

                StudentPutResponse response2=studentMapper.toPutResponse(entity);
                response2.setMessage("Məlumat uğurla dəyişdirildi!");

                return response2;
    }

    @Override
    public void deleteStudent(int id) {
        Optional<StudentEntity> student = studentRepostory.findById(id);
        if(student.isEmpty()){
              log.info("ID" + id + " üçün tələbə tapılmadı!" );
            return;
        }
        log.info("ID " + id + "məlumat silindi!" );
        studentRepostory.delete(student.get());
    }

}
