package com.belov.springdatajpa.domain;

import com.belov.springdatajpa.domain.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Embedded
    private com.belov.springdatajpa.domain.Contact contact;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Gender gender;

    @Column(nullable = false)
    private Integer age;

    @ManyToOne(optional = false)
    private City city;
}