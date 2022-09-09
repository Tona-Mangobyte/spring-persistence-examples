package com.mb.persistence.repositories;

import com.mb.persistence.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
