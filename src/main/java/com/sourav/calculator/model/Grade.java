package com.sourav.calculator.model;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "grade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String score;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id1", referencedColumnName = "id", nullable = false)
    private Student student;
}
