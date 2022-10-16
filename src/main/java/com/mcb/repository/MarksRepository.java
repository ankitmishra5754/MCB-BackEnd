package com.mcb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mcb.entity.Marks;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Long> {

	@Query(value = "select * from marks where student_id=?1", nativeQuery = true)
	List<Marks> getAllSubjectMarksForStudent(Long studentId);

	@Query(value = "select sum(marks) from marks where student_id=?1", nativeQuery = true)
	Long getTotalMarksByStudentId(Long studentId);

	@Modifying
	@Transactional
	@Query(value = "update marks m set m.marks=?2 , date=sysdate where mark_id=?1", nativeQuery = true)
	Integer saveOrUpdate(Long markId, Long marks);

}
