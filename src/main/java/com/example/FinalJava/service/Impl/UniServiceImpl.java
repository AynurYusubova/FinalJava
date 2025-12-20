package com.example.FinalJava.service.Impl;
import com.example.FinalJava.dto.req.UniPostRequest;
import com.example.FinalJava.dto.req.UniPutRequest;
import com.example.FinalJava.dto.res.UniAllResponse;
import com.example.FinalJava.dto.res.UniGetResponse;
import com.example.FinalJava.dto.res.UniPostResponse;
import com.example.FinalJava.dto.res.UniPutResponse;
import com.example.FinalJava.entity.UniEntity;
import com.example.FinalJava.exception.NotFoundException;
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

    private final UniRepostory uniRepostory;
    private final UniMapper uniMapper;

    public UniServiceImpl(UniRepostory uniRepostory, UniMapper uniMapper) {
        this.uniRepostory = uniRepostory;
        this.uniMapper = uniMapper;
    }

    @Override
    public List<UniAllResponse> getAlluni() {
        List<UniEntity> uniEntities = uniRepostory.findAll();
        return uniMapper.mapEntityForUniAllResponse(uniEntities);
    }


    @Override
    public UniGetResponse getuni(int id) {
        UniEntity entity = uniRepostory.findById(id)
                .orElseThrow(()->new NotFoundException("Universitet tapılmadı!"));

        UniGetResponse response=uniMapper.toGetResponse(entity);
        response.setMessage("ID " + id + " üçün universitet tapılmadı!");
        return response;
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
        UniEntity entity=uniRepostory.findById(id)
                .orElseThrow(()-> new NotFoundException("Məlumat tapılmadı!"));

        UniPutResponse response=uniMapper.toPutResponse(entity);
        response.setMessage("Məlumat uğurla dəyişdirildi!");

        return response;
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
