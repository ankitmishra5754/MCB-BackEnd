package com.mcb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcb.entity.Student;
import com.mcb.entity.SubjectTeacher;
import com.mcb.repository.StudentRepository;
import com.mcb.repository.SubjectTeacherRepository;
import com.mcb.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SubjectTeacherRepository subjectTeacherRepository;

	@Override
	public Long getNumberOfStudentForTeacherId(Long id) {
		List<SubjectTeacher> subjectTeachers = subjectTeacherRepository.findAllByIdTeacherId(id);
		List<Long> groups = new ArrayList<>();
		if (subjectTeachers != null && subjectTeachers.size() > 0) {
			groups = subjectTeachers.stream().map(s -> s.getGroup_id()).collect(Collectors.toList());
		}
		List<Student> studentList = studentRepository.findAllByGroupIdIn(groups);
		Long count = studentList.stream().count();
		return count;
	}

	@Override
	public Student addStudent(Student student) {

		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		studentRepository.saveOrUpdate(student.getStudentId(), student.getGroupId());
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student getStudentById(long id) {
		return studentRepository.findById(id).orElse(null);
	}
}
