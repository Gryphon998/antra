package com.antra.mapper;

import com.antra.dto.TeacherDTO;
import com.antra.entity.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherDTO toDto(TeacherEntity teacher);
    List<TeacherDTO> toDtoList(List<TeacherEntity> teacherEntityList);
}
