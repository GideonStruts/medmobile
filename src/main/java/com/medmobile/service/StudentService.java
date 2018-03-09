package com.firstfewlines.service;

import com.firstfewlines.domain.Student;
import com.firstfewlines.repository.StudentRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    Map<Integer, Student> students = new HashMap<>();

    public Student addStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(int rollNo) throws Exception {

        if (students.containsKey(rollNo)) {
            return students.get(rollNo);
        } else {
            throw new Exception("Student not found");
        }
    }

    public void updateStudent(Student student) throws Exception {
        if (students.containsKey(student.getRollNo())) {
            students.put(student.getRollNo(), student);
        } else {
            throw new Exception("Student not found");
        }
    }

    public void deleteStudent(int rollNo) throws Exception {
        if (students.containsKey(rollNo)) {
            students.remove(rollNo);
        } else {
            throw new Exception("Student not found");
        }
    }
}
