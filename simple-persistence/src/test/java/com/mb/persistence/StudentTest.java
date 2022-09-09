package com.mb.persistence;

import com.mb.persistence.models.Student;
import com.mb.persistence.repositories.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void insertStudent() {
        Student student = new Student();
        student.setFirstName("Tona");
        student.setLastName("Chheun");
        student.setEmail("tona@mb.com");
        student = studentRepository.save(student);
        Assertions.assertEquals("Tona", student.getFirstName());
    }
}
