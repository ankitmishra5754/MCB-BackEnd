package com.mcb.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SUBJECT_TEACHER")
public class SubjectTeacher implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
    SujectTeacherId id;
	
    private Long group_id;
    
    
	
	public SujectTeacherId getId() {
		return id;
	}
	public void setId(SujectTeacherId id) {
		this.id = id;
	}
	public Long getGroup_id() {
		return group_id;
	}
	public void setGroup_id(Long group_id) {
		this.group_id = group_id;
	}
    
    
	
}
