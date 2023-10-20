package com.manavas.springboot.learnjpaandhibernate.course;

import com.manavas.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.manavas.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.manavas.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repositoryJdbc;

    @Autowired
    private CourseJpaRepository repositoryJpa;

    @Autowired
    private CourseSpringDataJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
        //jdbcRepository();
        //jpaRepository();
        springJpaRepository();
    }

    private void jdbcRepository() {
        repositoryJdbc.insert(new Course(1, "Hibernate", "Navas"));
        repositoryJdbc.insert(new Course(2, "Hibernate JPA", "Navas"));
        repositoryJdbc.insert(new Course(3, "React", "Navas"));
        repositoryJdbc.deleteById(1);
        System.out.println(repositoryJdbc.findById(3));
    }

    private void jpaRepository() {
        repositoryJpa.insert(new Course(1, "Hibernate", "Navas"));
        repositoryJpa.insert(new Course(2, "Hibernate JPA", "Navas"));
        repositoryJpa.insert(new Course(3, "React", "Navas"));
        repositoryJpa.deleteById(1);
        System.out.println(repositoryJpa.findById(3));
    }

    private void springJpaRepository() {
        repository.save(new Course(1, "Hibernate", "Navas"));
        repository.save(new Course(2, "Hibernate JPA", "Navas"));
        repository.save(new Course(3, "React", "Navas"));
        repository.deleteById(1L);
        System.out.println(repository.findById(3L));
        System.out.println("All courses: " + repository.findAll());
        System.out.println("Count: " + repository.count());
        System.out.println("Author: " + repository.findByAuthor("Navas"));
        System.out.println("By name: " + repository.findByName("React"));
    }
}
