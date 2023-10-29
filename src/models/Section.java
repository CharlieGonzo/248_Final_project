package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Section implements Comparable<Section>,Serializable {
	
	
	private String Term;
	private String subject;
	private Course course;
	private String courseNumber;
    private String courseTitle;
	private String CRN;
	//firstDayEvening - 0, firstDayDay - 1, saturday or sunday - 2, lateStartEvening - 4,lateStartDay- 5
	private boolean[] partOfTerm;
	private String campus;
	private boolean ammerman;
	private boolean grant;
	private boolean riverhead;
	private String instructionMethod;
	//monday - 0,tuesday - 1,wednesday - 2,thursday - 3,friday - 4,saturday - 5,sunday - 6,Only online - 7,BLND-8
	private String daysOffered;
	private String startTime;
	private String endTime;
	private String partOfDay;
	private ArrayList<TimeRange> timeRange;
	private boolean online;
	private boolean saturday;
	private boolean BLND;
	
	public Section(ArrayList<String> init){
		super();
		
		course = new Course(init.get(3), init.get(2),init.get(1));
		CRN = init.get(4);
		timeRange = new ArrayList<>();
		courseNumber = course.getCourseNumber();
		courseTitle = course.getCourseTitle();
		subject = course.getSubject();

		this.partOfTerm = new boolean[6];
			if(init.get(6).equals("FD")) {
				partOfTerm[1] = true;
			}
			if(init.get(6).equals("FE")) {
				partOfTerm[0] = true;
			}
			if(init.get(6).equals("ss")) {
				partOfTerm[2] = true;
			}
			if(init.get(6).equals("LS")) {
				partOfTerm[5] = true;
			}
			if(init.get(6).equals("LSE")) {
				partOfTerm[4] = true;
			}
		
		this.campus = init.get(7);
		if(campus.contains(String.valueOf('A')))
			ammerman = true;
		if(campus.contains(String.valueOf('W')))
			grant = true;
		if(campus.contains(String.valueOf('E')))
			riverhead = true;
		
		this.daysOffered = init.get(18);
		this.startTime = init.get(19);
		
		this.endTime = init.get(20);
		
		///
		if (daysOffered.equals("MW")) {
		    // Code to execute if the daysOffered is "MW"
		  System.out.println("here");
		    timeRange.add(new TimeRange(startTime,endTime,"Monday"));
		    timeRange.add(new TimeRange(startTime,endTime,"Wednesday"));
		    online = false;
		    saturday = false;
		    BLND = false;
		} else if (daysOffered.equals("TR")) {
		    // Code to execute if the daysOffered is "TR"
			 timeRange.add(new TimeRange(startTime,endTime,"Tuesday"));
			 timeRange.add(new TimeRange(startTime,endTime,"Thursday"));
			 online = false;
			 saturday = false;
			 BLND = false;
		} else if (daysOffered.equals("MWTR")) {
		    // Code to execute if the daysOffered is "MWTR"
			 timeRange.add(new TimeRange(startTime,endTime,"Monday"));
			    timeRange.add(new TimeRange(startTime,endTime,"Tuesday"));
			    timeRange.add(new TimeRange(startTime,endTime,"Thursday"));
			    timeRange.add(new TimeRange(startTime,endTime,"Friday"));
			    saturday = false;
			    online = false;
			    BLND = false;
		} else if (daysOffered.equals("O")) {
		    online = true;
		    BLND = false;
		    saturday = false;
		} else if (daysOffered.equals("S")) {
			online = false;
			saturday = true;
			BLND = false;
		    // Code to execute if the daysOffered is "S"
		    
		} else {
		    // Code to execute if the daysOffered doesn't match any of the specified values
			BLND = true;
		}
		
		
		if(init.get(9).equals("BLBD")) {
			this.instructionMethod = init.get(9);
		}else {
		this.instructionMethod = "In Person";
		

		}
	}
	
	
	
	



	public boolean isAmmerman() {
		return ammerman;
	}







	public void setAmmerman(boolean ammerman) {
		this.ammerman = ammerman;
	}







	public boolean isGrant() {
		return grant;
	}







	public void setGrant(boolean grant) {
		this.grant = grant;
	}







	public boolean isRiverhead() {
		return riverhead;
	}







	public void setRiverhead(boolean riverhead) {
		this.riverhead = riverhead;
	}







	







	







	@Override
	public String toString() {
		return "Section [courseNumber=" + courseNumber + ", courseTitle=" + courseTitle + ", CRN=" + CRN + ", campus="
				+ campus + ", instructionMethod=" + instructionMethod + ", daysOffered=" + daysOffered + ", startTime="
				+ startTime + ", endTime=" + endTime + ", online=" + online + ", saturday=" + saturday + ", BLND="
				+ BLND + "]";
	}







	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		return Objects.equals(CRN, other.CRN);
	}


	public String getTerm() {
		return Term;
	}


	public void setTerm(String term) {
		Term = term;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public String getDaysOffered() {
		return daysOffered;
	}


	public void setDaysOffered(String daysOffered) {
		this.daysOffered = daysOffered;
	}


	public String getPartOfDay() {
		return partOfDay;
	}


	public void setPartOfDay(String partOfDay) {
		this.partOfDay = partOfDay;
	}


	public ArrayList<TimeRange> getTimeRange() {
		return timeRange;
	}


	public void setTimeRange(ArrayList<TimeRange> timeRange) {
		this.timeRange = timeRange;
	}


	public boolean isOnline() {
		return online;
	}


	public void setOnline(boolean online) {
		this.online = online;
	}


	public boolean isSaturday() {
		return saturday;
	}


	public void setSaturday(boolean saturday) {
		this.saturday = saturday;
	}


	public boolean isBLND() {
		return BLND;
	}


	public void setBLND(boolean bLND) {
		BLND = bLND;
	}


	public String getCourseNumber() {
		return course.getCourseNumber();
	}
	public void setCourseNumber(String courseNumber) {
		course.setCourseNumber(courseNumber);
	}
	public String getCourseTitle() {
		return course.getCourseTitle();
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCRN() {
		return CRN;
	}
	public void setCRN(String cRN) {
		CRN = cRN;
	}
	public boolean[] getPartOfTerm() {
		return partOfTerm;
	}
	public void setPartOfTerm(boolean[] partOfTerm) {
		this.partOfTerm = partOfTerm;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getInstructionMethod() {
		return instructionMethod;
	}
	public void setInstructionMethod(String instructionMethod) {
		this.instructionMethod = instructionMethod;
	}
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	@Override
	public int compareTo(Section o) {
		// TODO Auto-generated method stub
		if(o.getCRN().equals(this.CRN)) {
			return 0;
		}
		if(Integer.valueOf(o.getCRN()) > Integer.valueOf(this.CRN))
			return -1;
		return 1;
	}
}
