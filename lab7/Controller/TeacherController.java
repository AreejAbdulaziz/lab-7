package com.example.lab7.Controller;

import com.example.lab7.Model.Teacher;
import com.example.lab7.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    final TeacherService teacherService;
    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        ArrayList<Teacher>teachers=teacherService.getTeachers();
        return ResponseEntity.status(HttpStatus.OK).body(teachers);
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody@Valid Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body("teacher added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable String id,@RequestBody@Valid Teacher teacher,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isFound=teacherService.updateTeacher(id,teacher);
        if(isFound){
            return ResponseEntity.status(HttpStatus.OK).body("teacher updated");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id){
        boolean isFounf=teacherService.deleteTeacher(id);
        if(isFounf){
           return ResponseEntity.status(HttpStatus.OK).body("teacher deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");
    }

    @PutMapping("/change/{id}")
        public ResponseEntity changePosition(@PathVariable String id){
        boolean isFound=teacherService.changePosition(id);
        if(isFound){
            return ResponseEntity.status(HttpStatus.OK).body("position changed");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");
    }
    @PutMapping("/deduction/{id}")
    public ResponseEntity deduction(@PathVariable String id){
        boolean isDone=teacherService.deduction(id);
        if(isDone){
            return ResponseEntity.status(HttpStatus.OK).body("done");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");
    }
}
