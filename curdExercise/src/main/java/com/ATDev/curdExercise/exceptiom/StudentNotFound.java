package com.ATDev.curdExercise.exceptiom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Student Not Found")
public class StudentNotFound extends Exception{
}
