package net.javaguides.springboot.springboot.crudrestfulwebservices.controller;

import net.javaguides.springboot.springboot.crudrestfulwebservices.exception.ResourcNotFoundException;
import net.javaguides.springboot.springboot.crudrestfulwebservices.model.Student;
import net.javaguides.springboot.springboot.crudrestfulwebservices.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
 @Autowired
    private StudentRepository studentRepository;

 //Create All Student Api
    @GetMapping("/student")
    public List<Student> getAllStudent()
    {
        return studentRepository.findAll();
    }
  // Create Student
    @PostMapping("/student")
    public Student createStudent(@Validated @RequestBody Student student)
    {
        return studentRepository.save(student);
    }
    //get Student Id
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id")long studentId ) throws ResourcNotFoundException {
        Student student;
        student = (Student) studentRepository.findAllById(studentId)
                .orElseThrow(() ->  new ResourcNotFoundException("Student not found  for this id : :"+studentId));
        return ResponseEntity.ok().body(student);
    }
    //update Student
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id")long studentId ,@RequestBody Student studentDetails) throws ResourcNotFoundException {
        Student student;
        student = (Student) studentRepository.findAllById(studentId)
                .orElseThrow(() ->  new ResourcNotFoundException("Student not found  for this id : :"+studentId));
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setEmailId(studentDetails.getEmailId());

        studentRepository.save(student);
        return ResponseEntity.ok().body(student);
    }
    //delete employee
    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") long studentId) throws ResourcNotFoundException
    {

   studentRepository.findAllById(studentId)
                .orElseThrow(() ->  new ResourcNotFoundException("Student not found  for this id : :"+studentId));

         studentRepository.deleteById(studentId);
         return ResponseEntity.ok().build();
    }

}
