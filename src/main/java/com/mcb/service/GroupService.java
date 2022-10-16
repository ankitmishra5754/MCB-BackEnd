package com.mcb.service;

import java.util.List;

import com.mcb.entity.Group;

public interface GroupService {

	public Group updateGroup(Group group);

	public List<Group> getAllGroup();

	public Group addGroup(Group group);

	public void deleteGroup(long id);

	public Group getGroupById(long id);
}
