package com.antra.repository;

import com.antra.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
    @Query(value = """
            SELECT t.* 
            FROM teachers t
            JOIN student_teacher st ON t.id = st.teacher_id
            WHERE st.student_id = :studentId
            """, nativeQuery = true)
    List<TeacherEntity> findTeachersByStudentId(@Param("studentId") Long studentId);
}
