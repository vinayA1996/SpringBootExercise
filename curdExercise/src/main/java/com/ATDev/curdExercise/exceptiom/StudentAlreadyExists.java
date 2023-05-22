package com.ATDev.curdExercise.exceptiom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "Student Already Present Please")
public class StudentAlreadyExists extends  Exception{
}
