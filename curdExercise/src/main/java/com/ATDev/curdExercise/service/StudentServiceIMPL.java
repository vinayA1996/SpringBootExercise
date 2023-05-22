package com.ATDev.curdExercise.service;

import com.ATDev.curdExercise.domain.Student;
import com.ATDev.curdExercise.exceptiom.StudentAlreadyExists;
import com.ATDev.curdExercise.exceptiom.StudentNotFound;
import com.ATDev.curdExercise.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceIMPL implements StudentService{

    StudentRepository studentRepository;
    @Autowired
    public StudentServiceIMPL(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) throws StudentAlreadyExists {
        if(studentRepository.existsById(student.getRoll_no())){
            throw new StudentAlreadyExists();
        }
        return studentRepository.save(student);
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int studentId) throws StudentNotFound {

        if(!studentRepository.existsById(studentId)){
            throw new StudentNotFound();
        }
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Student editStudentDetails(Student student) throws StudentNotFound {
        if(!studentRepository.existsById(student.getRoll_no())){
            throw new StudentNotFound();
        }
        Student student1=studentRepository.getById(student.getRoll_no());
        if(!student.getName().equals(student1.getName()) && !student.getName().equals(null) ){
            student1.setName(student.getName());
        }
        if(student.getAge()!=student1.getAge() && student.getAge()!=0 ){
            student1.setAge(student.getAge());
        }
        if(student.getSandard()!=student1.getSandard() && student.getSandard()!=0 ){
            student1.setAge(student.getSandard());
        }
        if(student.getDivision()!=student1.getDivision() ){
            student1.setAge(student.getDivision());
        }

        return studentRepository.save(student1);
    }

    @Override
    public boolean deleteStudent(int studentRollNo) throws StudentNotFound {
        if(!studentRepository.existsById(studentRollNo)){
            throw new StudentNotFound();
        }
        studentRepository.deleteById(studentRollNo);
        return true;
    }
}
