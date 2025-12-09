package com.antra.mapper;

import com.antra.dto.StudentDTO;
import com.antra.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO toDTO(StudentEntity student);

    StudentEntity toEntity(StudentDTO studentDTO);

    List<StudentDTO> toDtoList(List<StudentEntity> studentEntityList);
}
