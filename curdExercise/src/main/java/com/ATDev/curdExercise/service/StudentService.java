package com.ATDev.curdExercise.service;

import com.ATDev.curdExercise.domain.Student;
import com.ATDev.curdExercise.exceptiom.StudentAlreadyExists;
import com.ATDev.curdExercise.exceptiom.StudentNotFound;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student) throws StudentAlreadyExists;
    List<Student> getAllStudents();
    Student getStudentById(int studentId) throws StudentNotFound;
    Student editStudentDetails(Student student) throws StudentNotFound;
    boolean deleteStudent(int studentRollNo) throws StudentNotFound;

}
