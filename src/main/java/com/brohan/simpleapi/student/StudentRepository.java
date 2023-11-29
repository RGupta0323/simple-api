package com.brohan.simpleapi.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Repository is the interface created for anything that is accessing a database
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    // this will transform as an sql such as -
    // SELECT * FROM student where email='';
    @Query("SELECT s FROM Student s WHERE s.email=?1") // this is JBQL
    Optional<Student> findStudentByEmail(String email);
}
