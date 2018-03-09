/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstfewlines.controller;

import com.firstfewlines.domain.Student;
import com.firstfewlines.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
class ApiController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/student/{rollNo}", method = RequestMethod.GET)
    Student getStudent(@PathVariable("rollNo") int rollNo) throws Exception {
        return studentService.getStudent(rollNo);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    Iterable<Student> getStudents() {
        return studentService.getStudents();
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void addStudent(@RequestBody Student student) throws Exception {
        studentService.addStudent(student);
    }

    @RequestMapping(value = "/student/{rollNo}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void updateStudent(@PathVariable("rollNo") int rollNo, @RequestBody Student student) throws Exception {
        student.setRollNo(rollNo);
        studentService.updateStudent(student);
    }

    @RequestMapping(value = "/student/{rollNo}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    void deleteStudent(@PathVariable("rollNo") int rollNo) throws Exception {
        studentService.deleteStudent(rollNo);
    }
}