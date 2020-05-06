/*
package com.example.demo.Service;

import com.example.demo.Model.Student;
import com.example.demo.Repository.ItemRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

///import com.example.demo.Repository.ItemRepo;

@Service
public class StudentService {

    @Autowired
    ItemRepoJPA itemRepo;

    public List<Student> fetchAllStudents(){
        return itemRepo.findAll();

    }

    public void addStudent(Student i){
        itemRepo.save(i);
    }

    public void deleteStudent(int id){
        itemRepo.deleteById(id);
    }

    public Student findStudentById(int id){
        return itemRepo.getOne(id);

    }

    public void updateStudent(Student i){
        itemRepo.save(i);
    }

}
*/