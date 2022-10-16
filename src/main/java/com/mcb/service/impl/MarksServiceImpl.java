package com.mcb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcb.entity.Marks;
import com.mcb.repository.MarksRepository;
import com.mcb.service.MarksService;

@Service
public class MarksServiceImpl implements MarksService {

	@Autowired
	private MarksRepository marksRepository;

	@Override
	public Marks addMarks(Marks mark) {
		return marksRepository.save(mark);
	}

	@Override
	public Marks updateMarks(Marks mark) {
		marksRepository.saveOrUpdate(mark.getMarkId(), mark.getMarks());
		return mark;
	}

	@Override
	public List<Marks> getAllMarks() {
		return marksRepository.findAll();
	}

	@Override
	public Long getTotalMarksByStudentId(Long studentId) {
		return marksRepository.getTotalMarksByStudentId(studentId);
	}

	@Override
	public List<Marks> getAllSubjectMarksForStudent(Long studentId) {
		return marksRepository.getAllSubjectMarksForStudent(studentId);
	}

	@Override
	public void deleteById(Long id) {
		marksRepository.deleteById(id);
	}
}
