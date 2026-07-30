package com.neverskip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.neverskip.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
List<Student> findBySection(String section);

@Query("SELECT DISTINCT s.className FROM Student s")
List<String> findDistinctClassNames();

@Query("SELECT AVG(s.score) FROM Student s")
Double findAverageScore();

}