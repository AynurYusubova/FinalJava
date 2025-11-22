package com.example.FinalJava.mapper;

import com.example.FinalJava.dto.res.UniAllResponse;
import com.example.FinalJava.entity.UniEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UniMapper {
    List<UniAllResponse> mapEntityForUniAllResponse(List<UniEntity> uniEntity);
}
