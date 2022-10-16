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

import com.mcb.entity.Group;
import com.mcb.service.GroupService;

@RestController
@RequestMapping("/group")
public class GroupController {

	@Autowired
	GroupService groupService;

	@PostMapping
	public ResponseEntity<Group> addGroup(@RequestBody Group group) {
		Group updatedGroup = groupService.addGroup(group);
		return new ResponseEntity<Group>(updatedGroup, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Group> updateGroup(@RequestBody Group group) {
		Group updatedGroup = groupService.updateGroup(group);
		return new ResponseEntity<Group>(updatedGroup, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Group>> getAllGroup() {
		List<Group> grp = groupService.getAllGroup();
		return new ResponseEntity<List<Group>>(grp, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteGroup(@PathVariable long id) {
		groupService.deleteGroup(id);
		return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Group> getGroupById(@PathVariable long id) {
		Group group = groupService.getGroupById(id);
		return new ResponseEntity<>(group, HttpStatus.OK);
	}
}
