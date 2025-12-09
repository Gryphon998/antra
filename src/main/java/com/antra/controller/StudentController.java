package com.antra.controller;

import com.antra.dto.StudentDTO;
import com.antra.service.StudentService;
import com.antra.service.StudentTeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final StudentTeacherService studentTeacherService;

    public StudentController(StudentService studentService, StudentTeacherService studentTeacherService) {
        this.studentService = studentService;
        this.studentTeacherService = studentTeacherService;
    }


    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(
            @PathVariable Long id,
            @RequestBody StudentDTO student
    ) {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{studentId}/teachers/{teacherId}")
    public ResponseEntity<String> assignTeacherToStudent(
            @PathVariable Long studentId,
            @PathVariable Long teacherId
    ) {
        studentTeacherService.assignTeacher(studentId, teacherId);
        return ResponseEntity.ok("Teacher assigned to student successfully.");
    }

    @DeleteMapping("/{studentId}/teachers/{teacherId}")
    public ResponseEntity<String> unassignTeacherFromStudent(
            @PathVariable Long studentId,
            @PathVariable Long teacherId
    ) {
        studentTeacherService.unassignTeacher(studentId, teacherId);
        return ResponseEntity.ok("Teacher unassigned from student successfully.");
    }
}
