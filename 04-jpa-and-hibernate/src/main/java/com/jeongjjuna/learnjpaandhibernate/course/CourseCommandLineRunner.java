package com.jeongjjuna.learnjpaandhibernate.course;

import com.jeongjjuna.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS Jpa!", "jeongjjuna"));
        repository.insert(new Course(2, "Learn Azure Jpa!", "jeongjjuna"));
        repository.insert(new Course(3, "Learn DevOps Jpa!", "jeongjjuna"));

        repository.deleteById(1l);

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));


    }
}
