package com.study.querydsl.domain.student.domain;

import com.study.querydsl.domain.student.domain.type.School;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.*;

@NoArgsConstructor(access = PROTECTED)
@Builder
@AllArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(
                name = "user_uk",
                columnNames = {"classNumber"}
        )
})
@Entity
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private School school;

    private Integer grade;

    private Integer classroom;

    private Integer classNumber;
}