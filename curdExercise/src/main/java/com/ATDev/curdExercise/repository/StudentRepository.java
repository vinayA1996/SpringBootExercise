package com.ATDev.curdExercise.repository;

import com.ATDev.curdExercise.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
