package models;

public class Days {

	private String days;
	private TimeRange timeRange;
	
	public Days(String days,TimeRange timeRange) {
		this.days = days;
		this.timeRange = timeRange;
	}
	
	

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public TimeRange getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(TimeRange timeRange) {
		this.timeRange = timeRange;
	}
	
	
}
