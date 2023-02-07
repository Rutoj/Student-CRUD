package net.javaguides.springboot.springboot.crudrestfulwebservices.repository;

import jakarta.persistence.Id;
import net.javaguides.springboot.springboot.crudrestfulwebservices.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Id> {
    Optional<Object> findAllById(long studentId);

    void deleteById(long studentId);
    // Optional<Object> findAllById(long studentId);
}
