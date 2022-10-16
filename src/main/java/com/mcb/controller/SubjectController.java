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
import com.mcb.entity.Subject;
import com.mcb.entity.SubjectTeacher;
import com.mcb.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	SubjectService subjectService;

	@PostMapping
	public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
		Subject updatedSubject = subjectService.addSubject(subject);
		return new ResponseEntity<Subject>(updatedSubject, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject) {
		Subject updatedSubject = subjectService.updateSubject(subject);
		return new ResponseEntity<Subject>(updatedSubject, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Subject>> getAllSubject() {
		List<Subject> subject = subjectService.getAllSubject();
		return new ResponseEntity<List<Subject>>(subject, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Subject> getSubjectById(@PathVariable long id) {
		Subject subject = subjectService.getSubjectById(id);
		return new ResponseEntity<Subject>(subject, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBySubjectId(@PathVariable long id) {
		subjectService.deleteBySubjectId(id);
		return new ResponseEntity<String>("Subject Deleted", HttpStatus.OK);
	}

	@PostMapping("/teacher")
	public ResponseEntity<SubjectTeacher> addsubjectTeacher(@RequestBody SubjectTeacher subjectTeacher) {
		SubjectTeacher updatedSubjectTeacher = subjectService.addSubjectTeacher(subjectTeacher);
		return new ResponseEntity<SubjectTeacher>(updatedSubjectTeacher, HttpStatus.OK);
	}

	@PutMapping("/teacher")
	public ResponseEntity<SubjectTeacher> updatesubjectTeacher(@RequestBody SubjectTeacher subjectTeacher) {
		SubjectTeacher updatedSubjectTeacher = subjectService.updateSubjectTeacher(subjectTeacher);

		return new ResponseEntity<SubjectTeacher>(updatedSubjectTeacher, HttpStatus.OK);
	}

	@GetMapping("/teacher")
	public ResponseEntity<List<SubjectTeacher>> getAllsubjectTeacher() {
		List<SubjectTeacher> subject = subjectService.getAllSubjectTeacher();

		return new ResponseEntity<List<SubjectTeacher>>(subject, HttpStatus.OK);
	}

	@DeleteMapping("/teacher/{teacherId}/{subjectId}")
	public ResponseEntity<String> deletesubjectTeacher(@PathVariable long teacherId, @PathVariable long subjectId) {
		subjectService.deleteSubjectTeacher(teacherId, subjectId);

		return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
	}

	@GetMapping("/teacher/{id}")
	public ResponseEntity<List<SubjectTeacher>> findsubjectTeacher(@PathVariable long id) {
		List<SubjectTeacher> list = subjectService.findsubjectTeacher(id);
		return new ResponseEntity<List<SubjectTeacher>>(list, HttpStatus.OK);
	}

}
