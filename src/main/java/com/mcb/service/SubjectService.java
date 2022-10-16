package com.mcb.service;

import java.util.List;

import com.mcb.entity.Subject;
import com.mcb.entity.SubjectTeacher;

public interface SubjectService {
	
	public Subject addSubject(Subject subject);
	
	public Subject getSubjectById(Long id);

	public Subject updateSubject(Subject subject);
	
	public void deleteBySubjectId(Long id);

	public List<Subject> getAllSubject();

	public SubjectTeacher addSubjectTeacher(SubjectTeacher subjectTeacher);

	public SubjectTeacher updateSubjectTeacher(SubjectTeacher subjectTeacher);

	public List<SubjectTeacher> getAllSubjectTeacher();

	public void deleteSubjectTeacher(long teacherId,long studentId);

	public List<SubjectTeacher> findsubjectTeacher(long id);

}
