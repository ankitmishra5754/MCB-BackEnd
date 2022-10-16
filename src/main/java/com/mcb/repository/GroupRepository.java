package com.mcb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mcb.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
	
	@Modifying
	@Transactional
	@Query(value="update groups set name=?2 where group_Id=?1",nativeQuery = true)
	void saveOrUpdate(Long groupId,String name);
	

}
