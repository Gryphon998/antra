-- liquibase formatted sql
-- preconditions onFail:HALT onError:HALT

-- ========================================
-- INITIAL TABLES
-- ========================================

-- changeset qhuangfu:01
-- table for student
CREATE TABLE students (
     id          BIGINT PRIMARY KEY,
     name        VARCHAR(100) NOT NULL,
     email       VARCHAR(255) UNIQUE,
     created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- table for teacher
CREATE TABLE teachers (
     id          BIGINT PRIMARY KEY,
     name        VARCHAR(100) NOT NULL,
     email       VARCHAR(255) UNIQUE,
     created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Junction table: student_teacher
CREATE TABLE student_teacher (
     student_id  BIGINT NOT NULL,
     teacher_id  BIGINT NOT NULL,
     assigned_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

     PRIMARY KEY (student_id, teacher_id),

     CONSTRAINT fk_student
         FOREIGN KEY (student_id)
             REFERENCES students (id)
             ON DELETE CASCADE,

     CONSTRAINT fk_teacher
         FOREIGN KEY (teacher_id)
             REFERENCES teachers (id)
             ON DELETE CASCADE
);