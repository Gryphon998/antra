package com.antra.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_teacher")
public class StudentTeacherEntity {
    @EmbeddedId
    private StudentTeacherIdEntity id = new StudentTeacherIdEntity();

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @ManyToOne
    @MapsId("teacherId")
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;
}
