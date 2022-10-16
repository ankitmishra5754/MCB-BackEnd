package com.mcb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcb.entity.Subject;
import com.mcb.entity.SubjectTeacher;
import com.mcb.repository.SubjectRepository;
import com.mcb.repository.SubjectTeacherRepository;
import com.mcb.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private SubjectTeacherRepository subjectTeacherRepository;

	@Override
	public Subject addSubject(Subject subject) {
		return subjectRepository.save(subject);
	}

	@Override
	public Subject updateSubject(Subject subject) {
		subjectRepository.saveOrUpdate(subject.getSubjectId(), subject.getTitle());
		return subject;
	}

	@Override
	public List<Subject> getAllSubject() {
		return subjectRepository.findAll();
	}

	@Override
	public Subject getSubjectById(Long id) {
		return subjectRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteBySubjectId(Long id) {
		subjectRepository.deleteById(id);
	}

	@Override
	public SubjectTeacher addSubjectTeacher(SubjectTeacher subjectTeacher) {
		return subjectTeacherRepository.save(subjectTeacher);
	}

	@Override
	public SubjectTeacher updateSubjectTeacher(SubjectTeacher subjectTeacher) {
		subjectTeacherRepository.saveOrUpdate(subjectTeacher.getId().getSubjectId(),
				subjectTeacher.getId().getTeacherId(), subjectTeacher.getGroup_id());
		return subjectTeacher;
	}

	@Override
	public List<SubjectTeacher> getAllSubjectTeacher() {
		return subjectTeacherRepository.findAll();
	}

	@Override
	public void deleteSubjectTeacher(long teacherId, long studentId) {
		subjectTeacherRepository.deleteSubjectTeacher(teacherId, studentId);

	}

	@Override
	public List<SubjectTeacher> findsubjectTeacher(long id) {
		return subjectTeacherRepository.findAllByIdTeacherId(id);
	}

}
