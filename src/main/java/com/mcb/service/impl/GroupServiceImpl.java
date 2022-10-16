package com.mcb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcb.entity.Group;
import com.mcb.repository.GroupRepository;
import com.mcb.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupRepository groupRepository;

	@Override
	public Group updateGroup(Group group) {
		groupRepository.saveOrUpdate(group.getGroupId(), group.getName());
		return group;
	}

	@Override
	public List<Group> getAllGroup() {
		return groupRepository.findAll();
	}

	@Override
	public Group addGroup(Group group) {
		return groupRepository.save(group);
	}

	@Override
	public void deleteGroup(long id) {
		groupRepository.deleteById(id);
	}

	@Override
	public Group getGroupById(long id) {
		return groupRepository.findById(id).orElse(null);
	}
}
