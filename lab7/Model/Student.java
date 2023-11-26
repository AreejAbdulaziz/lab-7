package com.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Student {
    @NotNull(message="name cannot be null")
    @Size(min=5,message="enter name more than 4 characters")
    @Pattern(regexp="^[\\p{Alpha} ]*$",message="name should contain only alphabets")
    private String name;
    @NotNull(message="id cannot be null")
    @Size(min=9,max=9,message="enter id 9 characters")
    private String id;
    @Pattern(regexp = "^05\\d{8}$",message = "enter correct number from 10 digits and start with 05")
    private String phoneNumber;
    @Min(value = 17,message = "age start with 17")
    private int age;
//    @Min(1000)
//    @Max(1000)
    private int salary;
    @DecimalMin(value = "0.0", message = "GPA should not be less than 0.0")
    @DecimalMax(value = "4.0", message = "GPA should not be greater than 4.0")
    private double GPA;
    @NotNull(message="specialization cannot be null")
    @Size(min=9,message="enter correct specialization")
    private String specialization;
}
