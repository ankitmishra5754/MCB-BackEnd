package com.mcb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mcb.entity.SubjectTeacher;

@Repository
public interface SubjectTeacherRepository extends JpaRepository<SubjectTeacher, Long> {

	List<SubjectTeacher> findAllByIdTeacherId(Long id);

	@Modifying
	@Query(value="update subject_teacher set group_id=?3 where subject_Id=?1 and teacher_id=?2",nativeQuery = true)
	Integer saveOrUpdate(Long subid,Long teacherId,Long grpId);

	@Modifying
	@Query(value="delete from subject_teacher  where teacher_Id=?1 and subject_id=?2",nativeQuery = true)
	void deleteSubjectTeacher(long teacherId,long subjectId);
	
	 

}
