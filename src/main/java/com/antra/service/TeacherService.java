package com.antra.service;

import com.antra.dto.TeacherDTO;
import com.antra.entity.TeacherEntity;
import com.antra.mapper.TeacherMapper;
import com.antra.repository.StudentTeacherRepository;
import com.antra.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    private static final TeacherMapper TEACHER_MAPPER = TeacherMapper.INSTANCE;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<TeacherDTO> getTeachersByStudentId(Long studentId) {
        return TEACHER_MAPPER.toDtoList(
                teacherRepository.findTeachersByStudentId(studentId)
        );
    }
}
