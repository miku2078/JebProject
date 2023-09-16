package com.yuri.spring.controller;

import org.springframework.web.bind.annotation.*;
import com.yuri.spring.mapper.studentMapper;
import com.yuri.spring.entity.student;

import java.util.List;

@RestController
@CrossOrigin
public class studentController {
    private final studentMapper studentMapper;

    public studentController(studentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @GetMapping("/findStudent")
    public List<student> findStudent() {
        return studentMapper.findStudent();
    }

    @GetMapping("/deleteStudent")
    public boolean deleteStudent(String name) {
        System.out.println(name);
        return studentMapper.deleteStudent(name);
    }

    @PostMapping("/insertStudent")
    public int insertStudent(student student_) {
        System.out.println(student_);
        return studentMapper.insertStudent(student_);
    }

    @PostMapping("/updateStudent")
    public int updateStudent(student student_) {
        System.out.println(student_);
        return studentMapper.updateStudent(student_);
    }

    @PostMapping("/login")
    public student Login(Integer sno) {
        if(sno == null) {
            System.out.println("sno 为空值!");
            return null;
        }
        student students = studentMapper.login(sno);
        if(students == null) {
            return null;
        }
        System.out.println(students);
        return students;
    }
}
