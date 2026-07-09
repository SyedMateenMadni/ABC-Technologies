package com.abc.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/")
    public String home() {
        return "ABC Technologies Student Application is Running";
    }

    @GetMapping("/students")
    public String students() {
        return "Student API Working Successfully";
    }

}

