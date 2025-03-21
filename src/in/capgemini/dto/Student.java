package in.capgemini.dto;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer StudentId;
	private String StudentName;
	private String StudentCourse;
	private Integer Batchno;
	public Integer getStudentId() {
		return StudentId;
	}
	public void setStudentId(Integer studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentCourse() {
		return StudentCourse;
	}
	public void setStudentCourse(String studentCourse) {
		StudentCourse = studentCourse;
	}
	public Integer getBatchno() {
		return Batchno;
	}
	public void setBatchno(Integer batchno) {
		Batchno = batchno;
	}
	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", StudentName=" + StudentName + ", StudentCourse=" + StudentCourse
				+ ", Batchno=" + Batchno + "]";
	}
	
	
	
	
}
