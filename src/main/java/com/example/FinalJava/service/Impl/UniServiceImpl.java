package com.example.FinalJava.service.Impl;
import com.example.FinalJava.dto.req.UniPostRequest;
import com.example.FinalJava.dto.req.UniPutRequest;
import com.example.FinalJava.dto.res.UniAllResponse;
import com.example.FinalJava.dto.res.UniGetResponse;
import com.example.FinalJava.dto.res.UniPostResponse;
import com.example.FinalJava.dto.res.UniPutResponse;
import com.example.FinalJava.entity.UniEntity;
import com.example.FinalJava.mapper.UniMapper;
import com.example.FinalJava.repostory.UniRepostory;
import com.example.FinalJava.service.UniService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UniServiceImpl implements UniService {
    @Autowired
    private UniRepostory uniRepostory;

    @Autowired
    private UniMapper uniMapper;



    @Override
    public List<UniAllResponse> getAlluni() {
        List<UniEntity> uniEntities = uniRepostory.findAll();
        return uniMapper.mapEntityForUniAllResponse(uniEntities);
    }


    @Override
    public UniGetResponse getuni(int id) {
        Optional<UniEntity> uniEntity = uniRepostory.findById(id);

        if (uniEntity.isEmpty()) {
            return UniGetResponse.builder()
                    .message("ID " + id + " üçün universitet tapılmadı!")
                    .build();
        }

        UniEntity uni = uniEntity.get();
        return UniGetResponse.builder()
                .name(uni.getName())
                .faculty(uni.getFaculty())
                .message("ID " + id + "üçün universitet tapıldı!")
                .build();
    }


    @Override
    public UniPostResponse adduni(UniPostRequest uniPostRequest) {
        UniEntity uniEntity=new UniEntity();
        uniEntity.setName(uniPostRequest.getName());
        uniEntity.setFaculty(uniPostRequest.getFaculty());
        uniRepostory.save(uniEntity);
        return UniPostResponse.builder()
                .name(uniPostRequest.getName())
                .faculty(uniEntity.getFaculty())
                .message("Məlumat uğurla əlavə olundu!")
                .build();
    }

    @Override
    public UniPutResponse updateuni(int id, UniPutRequest uniPutRequest) {
        Optional <UniEntity> uniEntity1=uniRepostory.findById(id);

        if(uniEntity1.isEmpty()){
            return UniPutResponse.builder().
                    message("ID " + id + " üçün universitet tapılmadı!")
                    .build();
        }

        UniEntity uniEntity=uniEntity1.get();
        uniEntity.setName(uniPutRequest.getName());
        uniEntity.setFaculty(uniPutRequest.getFaculty());
        uniRepostory.save(uniEntity);
        return UniPutResponse.builder().
                name(uniPutRequest.getName())
                .faculty(uniEntity.getFaculty())
                .message("Məlumat uğurla dəyişdirildi!")
                .build();

    }

    @Override
    public void deleteuni( int id) {
        Optional<UniEntity> uniEntity = uniRepostory.findById(id);
        if(uniEntity.isEmpty()){
            System.out.println("ID " + id + " üçün universitet tapılmadı!");
            return;
        }
        System.out.println("ID " + id + "məlumat silindi!" );
        uniRepostory.delete(uniEntity.get());
    }
}
