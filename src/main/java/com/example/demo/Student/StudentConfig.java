package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {

            Student abed = new Student(
                    "Abednego Wambua",
                    "abedxh@gmail.com",
                    LocalDate.of(1995, JANUARY, 13)
            );
            Student caro = new Student(
                    "Caro Wambua",
                    "caro98@gmail.com",
                    LocalDate.of(1998, JANUARY, 7)
            );
//            studentRepository.saveAll(
//                    List.of(caro, abed)
//            );

        };
    }
}
