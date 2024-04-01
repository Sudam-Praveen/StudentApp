package org.example.service;

import org.example.dto.Student;
import org.example.entity.StudentEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    public ResponseEntity<List<StudentEntity>> getAllStudents();
    public ResponseEntity<?> addStudent(Student student);
}
