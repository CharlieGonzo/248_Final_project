package models;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import javafx.scene.paint.Color;

public class Instructor implements Comparable<Instructor>,Serializable{
	private String id;
	private String firstName;
	private String lastName;
	private String homePhone;
	private String rank;
	private boolean firstTime;
	private boolean ammerman;
	private boolean grant;
	private boolean riverhead;
	private  boolean ONL;
	private String earlyAfternoons;
	private String campus;
	private boolean[][] Availability;
	private boolean secondCourse;
	private String earlyMorningDays;
	private String morningDays;
	private String afternoonDays;
	private boolean sat;
	private String lateAfternoonDays;
	private String EveningDays;
	private String homeCampus;
	private ArrayList<String> courseList;
	private ArrayList<TimeRange> availabilitySlot;
	
	private boolean sun;
	private String city;
	private String stateAndZip;
	private LocalDate dateStarted;
	private boolean Thirdcourse;
	private String courses;
	private String address;
	private String busPhone;
	private ArrayList<PastCourse> courseTaught;
	private ArrayList<Section> currentSections;
	
	public Instructor(ArrayList<String> s) {
		super();
		Availability = new boolean[6][5];
		courseTaught = new ArrayList<>();
		availabilitySlot = new ArrayList<>();
		currentSections = new ArrayList<>();;
		firstTime = true;
		ammerman = false;
		grant = false;
		riverhead = false;
		id = s.get(0);
		firstName = s.get(1).substring(1);
		lastName = s.get(2).substring(1,s.get(2).length()-1);
		homePhone = s.get(3);
		sun = s.get(25).equals("sun");
		rank = s.get(4);
		ONL = s.get(5).equals("Y");
		campus = s.get(6);
		if(campus.contains(String.valueOf('A')))
			ammerman = true;
		if(campus.contains(String.valueOf('W')))
			grant = true;
		if(campus.contains(String.valueOf('E'))) {
			riverhead = true;
		secondCourse = s.get(7).equals("Y");
		earlyMorningDays = s.get(9);
		courseList = new ArrayList<>();
		morningDays = s.get(23);
		afternoonDays = s.get(10);
	
		earlyAfternoons = s.get(24);
		sat = s.get(11).equals("sat");
		lateAfternoonDays = s.get(12);
		EveningDays = s.get(13);
		homeCampus = s.get(15);
		address = s.get(16);
		busPhone = s.get(29);
		city = s.get(30).substring(1);
		stateAndZip = s.get(31).substring(1,s.get(31).length()-1);
		
		String[] date = s.get(17).split("/");
		//System.out.println(LocalDate.of(Integer.valueOf(date[2]),Integer.valueOf(date[1]),Integer.valueOf(date[0])));
		dateStarted = LocalDate.of(Integer.valueOf(date[2]),Integer.valueOf(date[1]),Integer.valueOf(date[0]));
		if(dateStarted == null) {
			dateStarted = LocalDate.of(1996, 5, 20);
		}
		Thirdcourse = s.get(21).equals("Y");
		for(int i = 0;i<s.size();i++) {
			try {
			if(s.get(i).substring(0,3).equals("MAT")) {
				courseList.add(s.get(i));
			}
			}catch(Exception e) {
				
			}
		}
		
		String early = this.getEarlyMorningDays();
		
		try {
		if(early.charAt(1) == 'M') {
			availabilitySlot.add(new TimeRange(7,0,8,0,"Monday","AM"));
			Availability[0][0] = true;
			
			
		}
		}catch(Exception e) {
			
		}
		try {
		if(early.charAt(2) == 'T') {
			availabilitySlot.add(new TimeRange(7,0,8,0,"Tuesday","AM"));
			Availability[0][1] = true;
		}
		}catch(Exception e) {
			
		}
		try {
		if(early.charAt(3) == 'W') {
			availabilitySlot.add(new TimeRange(7,0,8,0,"Wednesday","AM"));
			Availability[0][2] = true;
		}
		}catch(Exception e) {
			
		}
		try {
		if(early.charAt(4) == 'T') {
			availabilitySlot.add(new TimeRange(7,0,8,0,"Thursday","AM"));
			Availability[0][3] = true;
		}
		}catch(Exception e) {
			
		}
		try {
		if(early.charAt(5) == 'F') {
			availabilitySlot.add(new TimeRange(7,0,8,0,"Friday","AM"));
			Availability[0][4] = true;
		}
		}catch(Exception e) {
			
		}
		/////////////////////////////////////////////////////////////////////////
		char[] c =  this.getMorningDays().toCharArray();
		
		
			try {
				if(c[0] == 'M') {
					availabilitySlot.add(new TimeRange(8,0,12,0,"Monday","AM"));
					Availability[1][0] = true;
				}
				}catch(Exception e) {
					
				}
				try {
				if(c[1] == 'T') {
					Availability[1][1] = true;
					availabilitySlot.add(new TimeRange(8,0,12,0,"Tuesday","AM"));
				}
				}catch(Exception e) {
					
				}
				try {
				if(c[2] == 'W') {
					Availability[1][2] = true;
					availabilitySlot.add(new TimeRange(8,0,12,0,"Wednesday","AM"));
				}
				}catch(Exception e) {
					
				}
				try {
				if(c[3] == 'T') {
					Availability[1][3] = true;
					availabilitySlot.add(new TimeRange(8,0,12,0,"Thursday","AM"));
				}
				}catch(Exception e) {
					
				}
				try {
				if(c[4] == 'F') {
					availabilitySlot.add(new TimeRange(8,0,12,0,"Friday","AM"));
					Availability[1][4] = true;
				}
				}catch(Exception e) {
					
				}
			
		//////////////////////////////////////////////////////////////////
        early = this.getAfternoonDays();
		
		try {
		if(early.charAt(1) == 'M') {
			availabilitySlot.add(new TimeRange(3+12,0,4+12,0,"Monday","PM"));
			Availability[3][0] = true;
		}
		}catch(Exception e) {
			
		}
		try {
		if(early.charAt(2) == 'T') {
			availabilitySlot.add(new TimeRange(3+12,0,4+12,0,"Tuesday","PM"));
			Availability[3][1] = true;
		}
		}catch(Exception e) {
			
		}
		try {
		if(early.charAt(3) == 'W') {
			availabilitySlot.add(new TimeRange(3+12,0,4+12,0,"Wednesday","PM"));
			System.out.println(early.charAt(3));
			Availability[3][2] = true;
		}
		}catch(Exception e) {
			
		}
		try {
		if(early.charAt(4) == 'T') {
			availabilitySlot.add(new TimeRange(3+12,0,4+12,0,"Thursday","PM"));
			Availability[3][3] = true;
		}
		}catch(Exception e) {
			
		}
		try {
		if(early.charAt(5) == 'F') {
			availabilitySlot.add(new TimeRange(3+12,0,4+12,0,"Friday","PM"));
			Availability[3][4] = true;
		}
		}catch(Exception e) {
			
		}
		
		////////////////////////////////////////////////////////////////////////////
		
		c =  this.getEarlyAfternoons().toCharArray();
	
		
		
			try {
				if(c[0] == 'M') {
					availabilitySlot.add(new TimeRange(12,0,3+12,0,"Monday","PM"));
					
					Availability[2][0] = true;
				}
				}catch(Exception e) {
					
				}
				try {
				if(c[1] == 'T') {
					availabilitySlot.add(new TimeRange(12,0,3+12,0,"Tuesday","PM"));
					Availability[2][1] = true;
				
				}
				}catch(Exception e) {
					
				}
				try {
				if(c[2] == 'W') {
					availabilitySlot.add(new TimeRange(12,0,3+12,0,"Wednesday","PM"));
					Availability[2][2] = true;
				}
				}catch(Exception e) {
					
				}
				try {
				if(c[3] == 'T') {
					availabilitySlot.add(new TimeRange(12,0,3+12,0,"Thursday","PM"));
					Availability[2][3] = true;
				}
				}catch(Exception e) {
					
				}
				try {
				if(c[4] == 'F') {
					availabilitySlot.add(new TimeRange(12,0,3+12,0,"Friday","PM"));
					Availability[2][4] = true;
				}
				}catch(Exception e) {
					
				}
			
			
		
		
		/////////////////////////////////////////////////////////////////////////////////////////
		c =  this.getLateAfternoonDays().toCharArray();
		
		
		
			try {
				if(c[0] == 'M') {
					availabilitySlot.add(new TimeRange(4+13,0,7+13,0,"Monday","PM"));
					Availability[4][0] = true;
				}
				}catch(Exception e) {
					
				}
				try {
				if(c[1] == 'T') {
					availabilitySlot.add(new TimeRange(4+13,0,7+13,0,"Tuesday","PM"));
					Availability[4][1] = true;
					
				}
				}catch(Exception e) {
					
				}
				try {
				if(c[2] == 'W') {
					availabilitySlot.add(new TimeRange(4+13,0,7+13,0,"Wednesday","PM"));
					Availability[4][2] = true;
				}
				}catch(Exception e) {
					
				}
				try {
				if(c[3] == 'T') {
					availabilitySlot.add(new TimeRange(4+13,0,7+13,0,"Thursday","PM"));
					Availability[4][3] = true;
				}
				}catch(Exception e) {
					
				}
				try {
				if(c[4] == 'F') {
					availabilitySlot.add(new TimeRange(4+13,0,7+13,0,"Friday","PM"));
					Availability[4][4] = true;
				}
				}catch(Exception e) {
					
				}
			
			
		
		
		
		
		////////////////////////////////////////////////////////////////////////////////
		c =  this.getEveningDays().toCharArray();
		
		
		
			
			try {
				if(c[0] == 'M') {
					availabilitySlot.add(new TimeRange(7+13,0,10+13,0,"Monday","PM"));
					Availability[5][0] = true;
				}
				}catch(Exception e) {
					
				}
				try {
				if(c[1] == 'T') {
					availabilitySlot.add(new TimeRange(7+12,0,10+12,0,"Tuesday","PM"));
					Availability[5][1] = true;
					
				}
				}catch(Exception e) {
					
				}
				try {
				if(c[2] == 'W') {
					availabilitySlot.add(new TimeRange(7+12,0,10+12,0,"Wednesday","PM"));
					Availability[5][2] = true;
				}
				}catch(Exception e) {
					
				}
				try {
				if(c[3] == 'T' ) {
					availabilitySlot.add(new TimeRange(7+12,0,10+12,0,"Thursday","PM"));
					Availability[5][3] = true;
				}
				}catch(Exception e) {
					
				}
				try {
				if(c[4] == 'F') {
					availabilitySlot.add(new TimeRange(7+12,0,10+12,0,"Friday","PM"));
					System.out.println(c[4]);
					Availability[5][4] = true;
				}
				}catch(Exception e) {
					
				}
				}
			}
			
		
	
	
	public boolean isFirstTime() {
		return firstTime;
	}

	public void setFirstTime(boolean firstTime) {
		this.firstTime = firstTime;
	}

	public String getEarlyAfternoons() {
		return earlyAfternoons;
	}
	
	public ArrayList<Section> isAvailableAndCampusMatch(ArrayList<Section> sections) {
	    // Check if time ranges overlap
		ArrayList<Section> newList = new ArrayList<>();
		System.out.println(this.getAfternoonDays());
		System.out.println(availabilitySlot.toString());
		for(int i = 0;i<availabilitySlot.size();i++) {
			TimeRange time = availabilitySlot.get(i);
			
		for(int j = 0;j<sections.size();j++) {
	    	Section section = sections.get(j);
	         for(int k = 0;k<section.getTimeRange().size();k++) {
	        	 // Check if one of the campus variables matches
	        
	    	if(time.overlapsWith(section.getTimeRange().get(k),availabilitySlot)) {
	    		
	                boolean campusMatch = (section.isAmmerman() &&	ammerman == true) ||
	                                     (section.isGrant() && grant) ||
	                                     (section.isRiverhead() && riverhead);
	                if (campusMatch) {
	                    newList.add(section);
	                }
	    }
	         }
		}
		}        
	    
	    return newList;
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




	public ArrayList<TimeRange> getAvailabilitySlot() {
		return availabilitySlot;
	}




	public void setAvailabilitySlot(ArrayList<TimeRange> availabilitySlot) {
		this.availabilitySlot = availabilitySlot;
	}




	public ArrayList<PastCourse> getCourseTaught() {
		return courseTaught;
	}
	

	public void setCourseTaught(ArrayList<PastCourse> courseTaught) {
		this.courseTaught = courseTaught;
	}
	

	public ArrayList<Section> getCurrentSections() {
		return currentSections;
	}

	public void setCurrentSections(ArrayList<Section> currentSections) {
		this.currentSections = currentSections;
	}

	public void setDateStarted(LocalDate dateStarted) {
		this.dateStarted = dateStarted;
	}

	public void setEarlyAfternoons(String earlyAfternoons) {
		this.earlyAfternoons = earlyAfternoons;
	}


	public String getEarlyMorningDays() {
		return earlyMorningDays;
	}


	public void setEarlyMorningDays(String earlyMorningDays) {
		this.earlyMorningDays = earlyMorningDays;
	}


	public String getId() {
		return id;
	}
	
	public boolean[][] getAvailability() {
		return Availability;
	}

	public void setAvailability(boolean[][] availability) {
		Availability = availability;
	}


	public void setId(String id) {
		this.id = id;
	}

	public void addClassesTaught(PastCourse c) {
		courseTaught.add(c);
	}
	
	public void addCurrentClasses(Section c) {
		currentSections.add(c);
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getHomePhone() {
		return homePhone;
	}


	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}


	public String getRank() {
		return rank;
	}


	public void setRank(String rank) {
		this.rank = rank;
	}


	public boolean isONL() {
		return ONL;
	}


	public void setONL(boolean oNL) {
		ONL = oNL;
	}


	public String getCampus() {
		return campus;
	}
	
	public void isCourseAvailable() {
		
	}


	public void setCampus(String campus) {
		this.campus = campus;
	}


	public boolean isSecondCourse() {
		return secondCourse;
	}


	public void setSecondCourse(boolean secondCourse) {
		this.secondCourse = secondCourse;
	}


	public String getMorningDays() {
		return morningDays;
	}


	public void setMorningDays(String morningDays) {
		this.morningDays = morningDays;
	}


	public String getAfternoonDays() {
		return afternoonDays;
	}


	public void setAfternoonDays(String afternoonDays) {
		this.afternoonDays = afternoonDays;
	}


	public boolean isSat() {
		return sat;
	}


	public void setSat(boolean sat) {
		this.sat = sat;
	}


	public String getLateAfternoonDays() {
		return lateAfternoonDays;
	}


	public void setLateAfternoonDays(String lateAfternoonDays) {
		this.lateAfternoonDays = lateAfternoonDays;
	}


	public String getEveningDays() {
		return EveningDays;
	}


	public void setEveningDays(String eveningDays) {
		EveningDays = eveningDays;
	}


	public String getHomeCampus() {
		return homeCampus;
	}
	
	


	public void setHomeCampus(String homeCampus) {
		this.homeCampus = homeCampus;
	}


	public boolean isSun() {
		return sun;
	}


	public void setSun(boolean sun) {
		this.sun = sun;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getStateAndZip() {
		return stateAndZip;
	}


	public void setStateAndZip(String stateAndZip) {
		this.stateAndZip = stateAndZip;
	}


	public LocalDate getDateStarted() {
		return dateStarted;
	}




	public boolean isThirdcourse() {
		return Thirdcourse;
	}


	public void setThirdcourse(boolean thirdcourse) {
		Thirdcourse = thirdcourse;
	}


	public String getCourses() {
		return courses;
	}


	public void setCourses(String courses) {
		this.courses = courses;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getBusPhone() {
		return busPhone;
	}


	public void setBusPhone(String busPhone) {
		this.busPhone = busPhone;
	}


	

	public ArrayList<String> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<String> courseList) {
		this.courseList = courseList;
	}

	

	



	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", campus=" + campus
				+ ", secondCourse=" + secondCourse + ", sat=" + sat + ", homeCampus=" + homeCampus + ", sun=" + sun
				+ ", city=" + city + ", stateAndZip=" + stateAndZip + ", dateStarted=" + dateStarted + ", Thirdcourse="
				+ Thirdcourse + "]";
	}




	@Override
	public int compareTo(Instructor o) {
		// TODO Auto-generated method stub
		if(o.getId() == this.id) {
			return 0;
		}
		System.out.println(o.getDateStarted());
		try {
		if(o.getDateStarted().isBefore(this.dateStarted))
			return 1;
		}catch(Exception e){
		return -1;
		}
		return -1;
	}
	
	public PastCourse getTaughtCourse(String past) {
		for(int i = 0;i<courseTaught.size();i++) {
			if(courseTaught.get(i).getCourseName().equals(past)) {
				return courseTaught.get(i);
			}
		}
		return null;
	}





	public boolean checkCourse(String substring) {
		for(int i = 0;i<courseTaught.size();i++) {
			if(courseTaught.get(i).getCourseName().equals(substring)) {
				return true;
			}
		}
		return false;
	}


	

	

	
	
	
	
	
	
}
