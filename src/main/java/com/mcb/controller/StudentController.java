package com.mcb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcb.entity.Student;
import com.mcb.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> student = studentService.getAllStudent();
		return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable long id) {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student updatedstudent = studentService.addStudent(student);
		return new ResponseEntity<Student>(updatedstudent, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		Student updatedstudent = studentService.updateStudent(student);
		return new ResponseEntity<Student>(updatedstudent, HttpStatus.OK);
	}

	@GetMapping("/count/{teacherId}")
	public ResponseEntity<Long> getNumberOfStudentForTeacherId(@PathVariable long teacherId) {
		Long count = studentService.getNumberOfStudentForTeacherId(teacherId);
		return new ResponseEntity<Long>(count, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable long id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
	}

}
