package com.brohan.simpleapi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

// will have all resources for api
@RestController
@RequestMapping(path="api/v1/student") // when ran locally, the address will be localhost:8080/api/v1/student/
public class StudentController {
    private final StudentService studentService;

    @Autowired // this instantiates studentService - so its an actual instance
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping //this is a GET method
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping // this is a POST method
    //@RequestBody is taking the student object from the
    // request body.
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {

        studentService.updateStudent(studentId, name, email);
    }
}
