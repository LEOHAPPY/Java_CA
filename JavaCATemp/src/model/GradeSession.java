package model;

import java.util.Date;

public class GradeSession {
	private String courseId;
	private String courseName;
	private Date start;
	private Date end;
	private int courseCredit;
	private  String courseGrade;
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public int getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}
	public String getCourseGrade() {
		return courseGrade;
	}
	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}
	public GradeSession(String courseId, String courseName, Date start, Date end, int courseCredit,
			String courseGrade) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.start = start;
		this.end = end;
		this.courseCredit = courseCredit;
		this.courseGrade = courseGrade;
	}
	public GradeSession() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GradeSession [courseId=" + courseId + ", courseName=" + courseName + ", start=" + start + ", end=" + end
				+ ", courseCredit=" + courseCredit + ", courseGrade=" + courseGrade + "]";
	}
	

}
