package com.mcb.service;

import java.util.List;

import com.mcb.entity.Marks;

public interface MarksService {

	public Marks addMarks(Marks mark);

	public Marks updateMarks(Marks mark);

	public List<Marks> getAllMarks();

	public Long getTotalMarksByStudentId(Long studentId);

	public List<Marks> getAllSubjectMarksForStudent(Long studentId);
	
	public void deleteById(Long id);

}
