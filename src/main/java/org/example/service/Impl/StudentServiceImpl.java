package org.example.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.Student;
import org.example.entity.StudentEntity;
import org.example.repository.StudentRepo;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    ObjectMapper objectMapper;

    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentRepo.findAll());
    }

    @Override
    public ResponseEntity<?> addStudent(Student student) {

        StudentEntity studentEntity = objectMapper.convertValue(student, StudentEntity.class);
        StudentEntity saved = studentRepo.save(studentEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
