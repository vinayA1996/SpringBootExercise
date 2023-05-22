package com.ATDev.curdExercise.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    int roll_no;
    String name;

    int age;
    int sandard;
    char division;


}
