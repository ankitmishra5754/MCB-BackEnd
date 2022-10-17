package com.mcb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mcb.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query(value="select * from student where group_id = ?1 ;", nativeQuery = true)
	List<Student> findAllByGroupIdIn(List<Long> groups);

	@Modifying
	@Transactional
	@Query(value = "update student set group_id=?2 where student_id=?1", nativeQuery = true)
	Integer saveOrUpdate(Long student, Long grp);

}
