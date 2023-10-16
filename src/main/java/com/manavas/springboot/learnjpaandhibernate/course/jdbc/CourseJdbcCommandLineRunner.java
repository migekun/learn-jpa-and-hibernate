package com.manavas.springboot.learnjpaandhibernate.course.jdbc;

import com.manavas.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRespository respository;
    @Override
    public void run(String... args) throws Exception {
        respository.insert(new Course(1, "Hibernate", "Navas"));
        respository.insert(new Course(2, "Hibernate JPA", "Navas"));
        respository.insert(new Course(3, "React", "Navas"));
        respository.deleteById(1);
        System.out.println(respository.findById(3));
    }
}
