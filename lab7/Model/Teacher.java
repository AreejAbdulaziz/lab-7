package com.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotNull(message="name cannot be null")
    @Size(min=5,message="enter name more than 4 characters")
    @Pattern(regexp="^[\\p{Alpha} ]*$",message="name should contain only alphabets")
    private String name;
    @NotNull(message="id cannot be null")
    @Size(min=9,max=9,message="enter id 9 characters")
    private String id;
    @Pattern(regexp = "^05\\d{8}$",message = "enter correct number from 10 digits and start with 05")
    private String phoneNumber;
    @Min(value = 21,message = "age start with 21")
    private int age;
    @NotNull(message="position cannot be null")
    @Pattern(regexp = "^(teacher|doctor|professor)$",message = "enter correct position")
    private String position;
    @NotNull(message="salary cannot be null")
    @Positive(message = "enter correct salary")
    private double salary;
}
