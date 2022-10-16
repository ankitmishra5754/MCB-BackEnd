package com.mcb.service;

import java.util.List;

import com.mcb.entity.Student;

public interface StudentService {

	public Long getNumberOfStudentForTeacherId(Long id);

	public Student addStudent(Student student);

	public Student updateStudent(Student student);

	public List<Student> getAllStudent();

	public void deleteStudent(long id);

	public Student getStudentById(long id);

}
