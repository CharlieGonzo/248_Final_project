package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

public class SectionBag implements Serializable{
	public static SectionBag dataCenter = null;
	public TreeSet<Section> CourseList = new TreeSet<Section>();
	
	private SectionBag() {
		int count = 1;
		ArrayList<String> StringList = new ArrayList<>();
		//instructorMap = new HashMap<Integer,Instructor>();
		String csvFile = "CourseInformation - CourseInformation.csv"; // Replace with the path to your CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
          
            while ((line = br.readLine()) != null) {
            	
            	if(count != 2) {
            		count++;
            		
            	}else {
                // Split the line by the CSV delimiter (usually a comma)
            			String s = "";
            		for(int i = 0;i<line.length();i++) {
            			if(line.charAt(i)==',') {
            				StringList.add(s);
            				s = "";
            			}else {
            				s = s + line.charAt(i);
            			}
            			
            			
            		}
            	
            	CourseList.add(new Section(StringList));
            	
            	StringList.clear();
            		}
            	
            	}
           
        } catch (IOException e) {
            e.printStackTrace();
        }
       
	}
	
	public TreeSet<Section> getList(){
		return CourseList;
	}
	
	

	public static SectionBag Start() {
		if(dataCenter == null) {
			dataCenter = new SectionBag();
		}
		return dataCenter;
	}
	
	public static SectionBag Start(SectionBag sec) {
		if(dataCenter == null) {
			dataCenter = sec;
		}
		return dataCenter;
	}
}
