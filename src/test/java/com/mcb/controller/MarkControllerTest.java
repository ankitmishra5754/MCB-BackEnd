package com.mcb.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.mcb.service.MarksService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MarksController.class)
public class MarkControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MarksService marksService;

	@Test
	public void getMarkByStudentId() throws Exception {
		long studentId = 1114;
		mockMvc.perform(MockMvcRequestBuilders.get("/total/" + studentId).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void getAllSubjectMarksForStudent() throws Exception {
		long studentId = 1114;
		mockMvc.perform(MockMvcRequestBuilders.get("/allsubject/" + studentId).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

}
