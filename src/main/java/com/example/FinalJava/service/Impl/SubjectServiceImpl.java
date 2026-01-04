package com.example.FinalJava.service.Impl;
import com.example.FinalJava.dto.req.SubjectPostRequest;
import com.example.FinalJava.dto.req.SubjectPutRequest;
import com.example.FinalJava.dto.res.SubjectAllResponse;
import com.example.FinalJava.dto.res.SubjectGetResponse;
import com.example.FinalJava.dto.res.SubjectPostResponse;
import com.example.FinalJava.dto.res.SubjectPutResponse;
import com.example.FinalJava.entity.SubjectEntity;
import com.example.FinalJava.entity.TeacherEntity;
import com.example.FinalJava.exception.EntityNotFoundException;
import com.example.FinalJava.exception.NotFoundException;
import com.example.FinalJava.mapper.SubjectMapper;
import com.example.FinalJava.repostory.SubjectRepostory;
import com.example.FinalJava.repostory.TeacherRepostory;
import com.example.FinalJava.service.SubjectService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepostory subjectRepostory;
    private final SubjectMapper subjectMapper;
    private final TeacherRepostory teacherRepostory;

    public SubjectServiceImpl(SubjectRepostory subjectRepostory, SubjectMapper subjectMapper, TeacherRepostory teacherRepostory) {
        this.subjectRepostory = subjectRepostory;
        this.subjectMapper = subjectMapper;
        this.teacherRepostory = teacherRepostory;
    }

    @Override
    public List<SubjectAllResponse> getSubjects() {
        List<SubjectEntity> subjectEntities=subjectRepostory.findAll();
        return subjectMapper.mapEntityForSubjectAllResponse(subjectEntities);
    }

    @Override
    public SubjectGetResponse getSubject(int id) {
        SubjectEntity entity=subjectRepostory.findById(id)
                .orElseThrow(()->new NotFoundException("Məlumat tapılmadı!"));

         SubjectGetResponse response=subjectMapper.toGetResponse(entity);
         response.setMessage("Id " + id + "məlumat tapıldı!");

         return response;
    }

    @Override
    public SubjectPostResponse addSubject(SubjectPostRequest subjectPostRequest) {
        TeacherEntity teacher =teacherRepostory.findById(subjectPostRequest.getTeacherId())
                .orElseThrow(()->new NotFoundException("Müəllim tapılmadı!"));

        SubjectPostResponse response=subjectMapper.toPostResponse(teacher);
        response.setMessage("Məlumat əlavə olundu!");

        return response;

    }

    @Transactional
    @Override
    public SubjectPutResponse updateSubject(int id, SubjectPutRequest subjectPutRequest) {
        SubjectEntity entity=subjectRepostory.findById(id)
                 .orElseThrow(()->new NotFoundException("Məlumat tapılmadı!"));

        entity.setName(subjectPutRequest.getName());
        entity.setCredits(subjectPutRequest.getCredits());

        SubjectPutResponse response=new SubjectPutResponse();
        response.setName(entity.getName());
        response.setCredits(entity.getCredits());
        response.setMessage("Məlumat uğurla dəyişdirildi!");

        return response;
    }


    @Transactional
    @Override
    public void deleteSubject(int id) {
        SubjectEntity subjectEntity = subjectRepostory.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "ID " + id + " üçün fənn tapılmadı!"
                ));
        subjectRepostory.delete(subjectEntity);
        System.out.println("ID " + id + " məlumat silindi!");
    }

}
