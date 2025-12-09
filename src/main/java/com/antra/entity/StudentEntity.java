package com.antra.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "students")
@ToString(callSuper = true)
public class StudentEntity extends BaseEntity  {

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", length = 255)
    private String email;
}
