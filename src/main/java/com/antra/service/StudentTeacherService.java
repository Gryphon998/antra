package com.antra.service;

import com.antra.repository.StudentTeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class StudentTeacherService {
    private final StudentTeacherRepository studentTeacherRepository;

    public StudentTeacherService(StudentTeacherRepository studentTeacherRepository) {
        this.studentTeacherRepository = studentTeacherRepository;
    }

    @Transactional
    public void assignTeacher(Long studentId, Long teacherId) {
        studentTeacherRepository.insert(studentId, teacherId);
    }

    @Transactional
    public void unassignTeacher(Long studentId, Long teacherId) {
        studentTeacherRepository.delete(studentId, teacherId);
    }
}
