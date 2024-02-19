package org.example.student.service;

import org.example.student.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudent();

    void addStudent(Student student);
}
