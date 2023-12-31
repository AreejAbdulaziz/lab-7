package com.example.lab7.Service;

import com.example.lab7.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    ArrayList<Teacher>teachers=new ArrayList<>();
    public ArrayList<Teacher>getTeachers(){
        return teachers;
    }
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }
    public boolean updateTeacher(String id,Teacher teacher){
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId().equals(id)){
                teachers.set(i,teacher);
                return true;
            }
        } return false;
    }
    public boolean deleteTeacher(String id){
       for(int i=0;i<teachers.size();i++){
           if(teachers.get(i).getId().equals(id)){
               teachers.remove(i);
               return true;
           }
       }
        return false;
    }
    public boolean changePosition(String id){
        for (Teacher t:teachers){
            if(t.getId().equals(id)){
                if (t.getPosition().equals("teacher")){
                    t.setPosition("doctor");
                    return true;
                } else if (t.getPosition().equals("doctor")) {
                    t.setPosition("professor");
                    return true;
                }
            }
        }  return false;
    }
    public boolean deduction(String id){
        for(Teacher t:teachers){
           if (t.getId().equals(id)){
               t.setSalary(t.getSalary()/2);
               return true;
            }

        } return false;
    }
}
