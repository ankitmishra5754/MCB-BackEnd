package com.mcb.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mcb.entity.Student;
import com.mcb.repository.StudentRepository;
import com.mcb.service.StudentService;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

	@InjectMocks
	StudentService service;

	@Mock
	private StudentRepository studentRepository;

	@Test
	public void studentsByTeacheId() throws Exception {
		Student student1 = buildStudent(1L, "John", "Joe", 1L);
		Student student2 = buildStudent(2L, "Maarten", "Moens", 2L);

		List<Student> studentList = new ArrayList<Student>();
		studentList.add(student1);
		studentList.add(student2);

		List<Long> ids = new ArrayList<Long>();

		ids.add(student1.getGroupId());
		ids.add(student2.getGroupId());
		long savedStudentCount = service.getNumberOfStudentForTeacherId(1L);
		Assertions.assertEquals(savedStudentCount, 2);
	}

	private Student buildStudent(Long id, String firstName, String lastName, Long groupId) {
		Student student = new Student();
		student.setStudentId(id);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setGroupId(groupId);
		return student;
	}

}
