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

import com.mcb.entity.Marks;
import com.mcb.service.MarksService;

@RestController
@RequestMapping("/marks")
public class MarksController {

	@Autowired
	MarksService marksService;

	@PostMapping
	public ResponseEntity<Marks> addMarks(@RequestBody Marks mark) {
		System.out.print("marks : --------- " + mark);
		Marks marks = marksService.addMarks(mark);
		return new ResponseEntity<Marks>(marks, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Marks> updateMarks(@RequestBody Marks mark) {
		Marks marks = marksService.updateMarks(mark);
		return new ResponseEntity<Marks>(marks, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Marks>> getAllMarks() {
		List<Marks> marks = marksService.getAllMarks();
		return new ResponseEntity<List<Marks>>(marks, HttpStatus.OK);
	}

	@DeleteMapping("/{markId}")
	public ResponseEntity<String> deleteById(@PathVariable long markId) {
		marksService.deleteById(markId);
		return new ResponseEntity<String>("User deleted", HttpStatus.OK);
	}

	@GetMapping("/total/{studentId}")
	public ResponseEntity<Long> getTotalMarksByStudentId(@PathVariable long studentId) {
		Long marks = marksService.getTotalMarksByStudentId(studentId);
		return new ResponseEntity<Long>(marks, HttpStatus.OK);
	}

	@GetMapping("/allsubject/{studentId}")
	public ResponseEntity<List<Marks>> getAllSubjectMarksForStudent(@PathVariable long studentId) {
		List<Marks> marksList = marksService.getAllSubjectMarksForStudent(studentId);
		return new ResponseEntity<List<Marks>>(marksList, HttpStatus.OK);
	}

}
