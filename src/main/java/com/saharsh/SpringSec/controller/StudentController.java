package com.saharsh.SpringSec.controller;

import com.saharsh.SpringSec.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> list = new ArrayList<>(List.of(
            new Student(1,"saharsh","java"),
            new Student(2,"Navin","ios")
    ));

    @GetMapping("students")
    public List<Student> getStudents(){
        return list;
    }

    @PostMapping("students")
    public void addStudent(@RequestBody Student s){
        list.add(s);
   }

//   @GetMapping("token")
//    public CsrfToken gettoken(HttpServletRequest request){
//        return (CsrfToken) request.getAttribute("_csrf");
//   }

}
