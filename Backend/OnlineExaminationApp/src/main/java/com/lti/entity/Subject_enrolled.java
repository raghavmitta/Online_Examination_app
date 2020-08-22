package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Subject_enrolled {
    @Id
    @GeneratedValue
	private int id;
    @JoinColumn
    @ManyToOne
    private Exam_Db exam_id;
    @JoinColumn
    @ManyToOne
    private Student_Info stu_id;
    private int Passing_level;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Exam_Db getExam_id() {
		return exam_id;
	}
	public void setExam_id(Exam_Db exam_id) {
		this.exam_id = exam_id;
	}
	public Student_Info getStu_id() {
		return stu_id;
	}
	public void setStu_id(Student_Info stu_id) {
		this.stu_id = stu_id;
	}
	public int getPassing_level() {
		return Passing_level;
	}
	public void setPassing_level(int passing_level) {
		Passing_level = passing_level;
	}
  
}
