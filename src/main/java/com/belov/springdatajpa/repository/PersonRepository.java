package com.belov.springdatajpa.repository;

import com.belov.springdatajpa.domain.City;
import com.belov.springdatajpa.domain.Person;
import com.belov.springdatajpa.domain.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByCity(City city);

    //так как firstName - поле в Contact, необходимо писать через Contact!!!
    List<Person> findByContactFirstNameAndAge(String firstName, int age);

    List<Person> findByAgeGreaterThan(int age);

    List<Person> findByGender(Gender gender);
}