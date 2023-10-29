package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Course implements Serializable{
	private String courseTitle;
	private String courseNumber;
	private String subject;
	
	public Course(String courseTitle,String courseNumber,String subject) {
		this.courseTitle = courseTitle;
		this.courseNumber = courseNumber;
		this.subject = subject;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
}
	