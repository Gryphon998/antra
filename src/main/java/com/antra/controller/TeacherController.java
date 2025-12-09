package com.antra.controller;

import com.antra.dto.TeacherDTO;
import com.antra.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<TeacherDTO>> getTeachersByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(teacherService.getTeachersByStudentId(studentId));
    }
}
