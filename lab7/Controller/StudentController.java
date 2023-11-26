package com.example.lab7.Controller;

import com.example.lab7.Model.Student;
import com.example.lab7.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    final StudentService studentService;
    @GetMapping("/get")
    public ResponseEntity getStudents(){
        ArrayList<Student> students=studentService.getStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody@Valid Student student, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body("student added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable String id, @RequestBody@Valid Student student, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isFound=studentService.updateStudent(id,student);
        if(isFound){
            return ResponseEntity.status(HttpStatus.OK).body("student updated");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id){
        boolean isFounf=studentService.deleteStudent(id);
        if(isFounf){
            return ResponseEntity.status(HttpStatus.OK).body("student deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");
    }
    @PutMapping("/increaseSalary")
    public ResponseEntity increaseSalary(){
        studentService.changeSalary();
        return ResponseEntity.status(HttpStatus.OK).body("done");
    }
    @PutMapping("/changeSpecialization/{id}")
    public ResponseEntity changeSpecialization(@PathVariable String id,@RequestBody@Valid String specialization){
        boolean isChanged=studentService.changeSpecialization(id,specialization);
        if(isChanged){
            return ResponseEntity.status(HttpStatus.OK).body("specialization changed");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("you GPA less than required");
    }
}
