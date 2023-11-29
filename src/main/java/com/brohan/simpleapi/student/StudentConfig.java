package com.brohan.simpleapi.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static java.time.Month.JANUARY; // this is a static import
// with a static import we can access static members of a class
// directly without class name or any object.
// Instead of using Month.JANUARY now we can use JANUARY
// potential dis-advantage = it can make the code unreadable
// and harder to maintain if you are reusing this feature

@Configuration
public class StudentConfig {

    /*
        CommandLineRunner is an interface used to indicate that a
        bean should run when its is contained within a
        SpringApplication.
     */
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, JANUARY, 5)
            );

            Student alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, JANUARY, 5)
            );
            List<Student> students = new ArrayList();
            students.add(alex);
            students.add(mariam);
            //System.out.println("[StudentConfig.java line 47] students: " + students);
            repository.saveAll(
                    students
            );
        };
    }
}
