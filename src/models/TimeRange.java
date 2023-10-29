package models;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TimeRange implements Serializable {
	private static final String endTime = null;
	private LocalTime start;
	private LocalTime end;
	private String day;
	private String timeOfDay;
	
	
	public String getTimeOfDay() {
		return timeOfDay;
	}

	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}
	
	public TimeRange(String startTime,String endTime,String day){
			this.day = day;
			
			try {
	        this.start = LocalTime.parse(startTime.replaceAll("(?<=\\d)(?=[A-Z])", " "), DateTimeFormatter.ofPattern("hh:mm a"));
			}catch(Exception e){
				
				this.start = LocalTime.parse(startTime.replaceAll("(?<=\\d)(?=[A-Z])", " "), DateTimeFormatter.ofPattern("h:mm a"));
			}
			try {
		        this.end = LocalTime.parse(endTime.replaceAll("(?<=\\d)(?=[A-Z])", " "), DateTimeFormatter.ofPattern("hh:mm a"));
				}catch(Exception e){
					
					this.end = LocalTime.parse(endTime.replaceAll("(?<=\\d)(?=[A-Z])", " "), DateTimeFormatter.ofPattern("h:mm a"));
				}
			
			
	}
	

	public TimeRange(int h1, int m1, int h2, int m2,String day,String timeOfDay) {
		
		this.start = LocalTime.of(h1, m1);
		this.end = LocalTime.of(h2, m2);
		System.out.println(start.toString() + end.toString());
		this.day = day;
		this.timeOfDay = timeOfDay;
	}
	
	public TimeRange(LocalTime start, LocalTime end,String day) {
		super();
		this.start = start;
		this.end = end;
		this.day = day;
	}

	@Override
	public String toString() {
		return "TimeRange [start=" + start + ", end=" + end + ", day=" + day + "]";
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public LocalTime getStart() {
		return start;
	}

	public void setStart(LocalTime start) {
		this.start = start;
	}

	public LocalTime getEnd() {
		return end;
	}

	public void setEnd(LocalTime end) {
		this.end = end;
	}
	
	public boolean ableTo(TimeRange other) {
		 return this.end.compareTo(other.getStart()) < 0 || this.start.compareTo(other.getEnd()) > 0;
	}
	
	
	
	

	public boolean overlapsWith(TimeRange other,ArrayList<TimeRange> time) {
		
		    // Check if the start time of one time range is before or equal to the end time of the other
		    // and if the end time of one time range is after or equal to the start time of the other 
		System.out.println(this.end.compareTo(other.getEnd()));
		System.out.println("//" + this.start.compareTo(other.getStart()));
		if( this.start.compareTo(other.getStart()) <= 0 && this.end.compareTo(other.getEnd()) >= 0 &&  this.day.equals(other.getDay()))
			return true;
			System.out.println(other.toString() + " " + this.toString());
		
			//return (this.start.compareTo(other.getEnd()) <= 0) && this.start.compareTo(other.getStart()) >= 0 && this.day.equals(other.getDay());
		
			return false;
	
		
	}

	
}
