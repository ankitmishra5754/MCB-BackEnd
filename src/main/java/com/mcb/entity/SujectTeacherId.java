package com.mcb.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SujectTeacherId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long subjectId ;

    private Long teacherId ;

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
    
    

}
