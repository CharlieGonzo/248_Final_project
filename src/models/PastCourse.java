package models;

import java.io.Serializable;
import java.util.Objects;

public class PastCourse implements Serializable{

	public String courseName;
	public int amountTaught;
	
	public PastCourse(String courseName) {
		this.courseName = courseName;
		amountTaught = 1;
	}

	
	@Override
	public String toString() {
		return "PastCourse [courseName=" + courseName + ", amountTaught=" + amountTaught + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PastCourse other = (PastCourse) obj;
		return Objects.equals(courseName, other.courseName);
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void addCount() {
		this.amountTaught++;
	}

	public int getAmountTaught() {
		return amountTaught;
	}

	public void setAmountTaught(int amountTaught) {
		this.amountTaught = amountTaught;
	}
	
	
}
