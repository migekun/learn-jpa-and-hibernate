package com.manavas.springboot.learnjpaandhibernate.course.jdbc;

import com.manavas.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRespository {
    public static final String INSERT_SQL = """
        insert into course (id, name, author) 
        values (?, ?, ?);
    """;

    public static final String DELETE_SQL = """
            delete from course where id = ?;
            """;
    public static final String SELECT_SQL = """
            select * from course where id = ?;
            """;

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_SQL, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_SQL, id);
    }

    public Course findById(long id) {
        return springJdbcTemplate.queryForObject(SELECT_SQL,
                new BeanPropertyRowMapper<>(Course.class), id);
    }
}
