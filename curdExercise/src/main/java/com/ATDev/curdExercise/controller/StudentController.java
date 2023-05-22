package com.ATDev.curdExercise.controller;

import com.ATDev.curdExercise.domain.Student;
import com.ATDev.curdExercise.exceptiom.StudentAlreadyExists;
import com.ATDev.curdExercise.exceptiom.StudentNotFound;
import com.ATDev.curdExercise.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/student")
@RestController
public class StudentController {

StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) throws StudentAlreadyExists {
        return  new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }
    @GetMapping("/getStudents")
    public ResponseEntity<?> getStudendts()  {
        return  new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.CREATED);
    }
    @GetMapping("/getStudent/{rollno}")
    public ResponseEntity<?> getStudendtById(@PathVariable int rollno) throws StudentNotFound {
        return  new ResponseEntity<>(studentService.getStudentById(rollno), HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editStudent(@RequestBody Student student) throws  StudentNotFound {
        return  new ResponseEntity<>(studentService.editStudentDetails(student), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{rollno}")
    public ResponseEntity<?> deleteStudent(@PathVariable int rollno) throws  StudentNotFound {
        return  new ResponseEntity<>(studentService.deleteStudent(rollno), HttpStatus.CREATED);
    }

}
