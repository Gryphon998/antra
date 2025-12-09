package com.antra.repository;

import com.antra.entity.StudentTeacherEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentTeacherRepository extends JpaRepository<StudentTeacherEntity, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO student_teacher (student_id, teacher_id) VALUES (:studentId, :teacherId)", nativeQuery = true)
    void insert(Long studentId, Long teacherId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM student_teacher WHERE student_id = :studentId AND teacher_id = :teacherId", nativeQuery = true)
    void delete(Long studentId, Long teacherId);


}
