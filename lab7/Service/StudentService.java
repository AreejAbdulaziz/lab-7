package com.example.lab7.Service;

import com.example.lab7.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students=new ArrayList<>();
    public ArrayList<Student>getStudents(){
        return students;
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public boolean updateStudent(String id,Student student){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId().equals(id)){
                students.set(i,student);
                return true;
            }
        } return false;
    }
    public boolean deleteStudent(String id){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId().equals(id)){
                students.remove(i);
                return true;
            }
        }
        return false;
    }
    public void changeSalary(){
        for(int i=0;i<students.size();i++){
                if(students.get(i).getGPA()==4.0){
                    students.get(i).setSalary(students.get(i).getSalary()+1000);
                }
            }
        }
        public boolean changeSpecialization(String id,String specialization){
                for(int i=0;i<students.size();i++){
                    if(students.get(i).getId().equals(id)){
                        if(students.get(i).getGPA()>3.5){
                            students.get(i).setSpecialization(specialization);
                            return true;
                        }
                    }
                }
                return false;
        }
    }

