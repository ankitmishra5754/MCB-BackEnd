package com.mcb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mcb.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
	@Modifying
	@Transactional
	@Query(value = "update subject set title=?2 where subject_Id=?1", nativeQuery = true)
	Integer saveOrUpdate(Long subject, String title);

}
