package com.belov.springdatajpa;

import com.belov.springdatajpa.domain.City;
import com.belov.springdatajpa.domain.Person;
import com.belov.springdatajpa.domain.enums.Gender;
import com.belov.springdatajpa.repository.CityRepository;
import com.belov.springdatajpa.repository.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@SpringBootApplication
public class JpaCodeExampleApplication implements CommandLineRunner {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaCodeExampleApplication.class, args);
    }

//    //добавляем города и людей в БД
//    @Transactional
//    @Override
//    public void run(String... args) throws Exception {
//        List<City> cities = List.of(
//                City.builder().name("Moscow").build(),
//                City.builder().name("St-Petersburg").build(),
//                City.builder().name("EKB").build(),
//                City.builder().name("Kazan").build()
//        );
//                cityRepository.saveAll(cities);
//
//
//        List <Person> persons = List.of(
//
//                Person.builder()
//                .city(cities.get(1))
//                .age(18)
//                .contact(com.belov.orm.domain.Contact.builder()
//                        .firstName("Alex")
//                        .lastName("Bel")
//                        .phone("12345").build())
//                .gender(Gender.MALE)
//                .build(),
//
//                Person.builder()
//                .city(cities.get(2))
//                .age(26)
//                .contact(com.belov.orm.domain.Contact.builder()
//                        .firstName("Andrei")
//                        .lastName("Andreev")
//                        .phone("23456").build())
//                .gender(Gender.MALE)
//                .build(),
//
//                Person.builder()
//                .city(cities.get(3))
//                .age(33)
//                .contact(com.belov.orm.domain.Contact.builder()
//                        .firstName("Ann")
//                        .lastName("Lisaeva")
//                        .phone("34567").build())
//                .gender(Gender.FEMALE)
//                .build()
//                );
//
//        personRepository.saveAll(persons);
//    }
//}

//    //Поиск в базе данных
//    @Transactional
//    @Override
//    public void run(String... args) throws Exception {
//
//        //найдем персон по id и обновим в базе возраст
//        Optional<Person> optional = personRepository.findById(1L);
//        if (optional.isPresent()) {
//            //обновим данные у персон
//            Person person = optional.get();
//            person.setAge(40);
//            //проверяем, поменялся ли возраст
//            System.out.println(personRepository.findById(1L).get());
//            personRepository.save(person);
//            //проверяем, поменялся ли возраст еще раз
//            System.out.println(personRepository.findById(1L).get());
//        } else {
//            System.out.println("Person with this id is not finded");
//        }
//
//        // получим все города по 2 на странице c сортировкой по названиям городов
//        // пример работы с page
//        int pageSize = 2;
//        int totalPages = cityRepository.findAll(Pageable.ofSize(pageSize)).getTotalPages();
//        System.out.println(totalPages);
//        List<List<City>> pages = new ArrayList<>();
//        int pageNumber = 0;
//        List<City> citiesOnOnePage = new ArrayList<>();
//        do {
//            var cities = cityRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "name")))
//                    .stream().collect(Collectors.toList());
//            pages.add(cities);
//            pageNumber++;
//        } while (pageNumber < totalPages);
//        for(List<City> cities : pages){
//            System.out.println(cities);
//        }
//    }


    @Transactional
    @Override
    public void run(String... args) throws Exception {
        List<Person> personList = personRepository.findByAgeGreaterThan(18);
        personList.forEach(System.out::println);
    }
}