package com.rakx07.service;

import com.rakx07.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    static List<Student> studentList = new ArrayList<>();

    /**
     This annotation is used to mark a method that should be executed after the
     dependency injection is done but before the bean is put into service.
        - Runs only once after the bean is instantiated.
     */
    @PostConstruct
    public static void init() {
        studentList.add(new Student(101, "Rakib", "Batch - 2", 82));
        studentList.add(new Student(102, "ABC", "Batch - 1", 25));
        studentList.add(new Student(103, "ABD", "Batch - 2", 72));
        studentList.add(new Student(104, "Kohli", "Batch - 1", 79));
        studentList.add(new Student(105, "MR", "Batch - 3", 80));
    }

    public Student findById(Integer id) {
        for (Student s : studentList) {
            if (Objects.equals(s.getId(), id)){
                return s;
            }
        }
        return null;
    }

    public List<Student> getAllStudent() {
        return studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }
}
