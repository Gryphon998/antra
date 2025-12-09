package com.antra.service;

import com.antra.dto.StudentDTO;
import com.antra.entity.StudentEntity;
import com.antra.mapper.StudentMapper;
import com.antra.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private static final StudentMapper STUDENT_MAPPER = StudentMapper.INSTANCE;

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> getAllStudents() {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        return STUDENT_MAPPER.toDtoList(studentEntityList);
    }

    public StudentDTO getStudentById(Long id) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        return STUDENT_MAPPER.toDTO(student);
    }

    @Transactional
    public StudentDTO createStudent(StudentDTO student) {
        StudentEntity studentEntity = STUDENT_MAPPER.toEntity(student);
        StudentEntity saved = studentRepository.save(studentEntity);
        return STUDENT_MAPPER.toDTO(saved);
    }

    @Transactional
    public StudentDTO updateStudent(Long id, StudentDTO updatedStudent) {
        StudentEntity student = STUDENT_MAPPER.toEntity(getStudentById(id));

        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());

        StudentEntity saved = studentRepository.save(student);
        return STUDENT_MAPPER.toDTO(saved);
    }

    @Transactional
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

}
