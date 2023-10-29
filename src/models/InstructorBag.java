package models;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Consumer;

import javafx.fxml.Initializable;

public class InstructorBag implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//public HashMap<Integer,Instructor> instructorMap;
	public static InstructorBag DataCenter = null;
	public TreeSet<Instructor> instructorList = new TreeSet<Instructor>();
		

	

	private InstructorBag() {
		int count = 1;
		
		ArrayList<String> StringList = new ArrayList<>();
		String csvFile = "InstructorsV2 - Sheet3.csv"; // Replace with the path to your CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean num = false;
            while ((line = br.readLine()) != null) {
            	{
            		if(line.charAt(5) == '-') {
            			System.out.println(StringList);
            			instructorList.add(new Instructor(StringList));
            			
              			StringList.clear();
            		}else {
            		
            			String s = "";
            		for(int i = 0;i<line.length();i++) {
            			if(line.charAt(i)==',') {
            				
            				StringList.add(s);
            				s = "";
            			}else {
            				s = s + line.charAt(i);
            			}
            			
            			
            		}
            		}
            	}
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
       
       
        
        csvFile = "Instructor_Frequency_v2 - Instructor_Recent_Courses_V2.tsv";
        count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	String line;
        	 while ((line = br.readLine()) != null) {
        		 System.out.println(line);
        		 if(count == 0) {
        			 count++;
        		 }else {
        			 StringList.clear();
        			String[] s3 = line.split("\t");
        			
        			Instructor inst = this.findInstructorById(s3[0]);
        		
        		
        			String s2 = s3[s3.length-1].substring(0,s3[s3.length-1].length());
        			String[] strin = s2.split(",");
        			
        			
        			for(int i = 0;i<strin.length;i++) {
        				for(int j = 0;j<strin[i].length();j++) {
        					if(strin[i].charAt(j) == ':') {
        						String coursename= strin[i].substring(0,j);
        						String coursename2= strin[i].substring(1,j);
        								
        					try {
        							if(i == 0) {
        								inst.addClassesTaught(new PastCourse(coursename));
            							inst.getTaughtCourse(strin[i].substring(0,j)).setAmountTaught(Character.getNumericValue(strin[i].charAt(strin[i].length()-1)));
        							}else {
        								
        								inst.addClassesTaught(new PastCourse(coursename2));
        								inst.getTaughtCourse(strin[i].substring(1,j)).setAmountTaught(Character.getNumericValue(strin[i].charAt(strin[i].length()-1)));
        							}
        						}
        					catch(Exception e) {
        						
        					}}
        				
        					
        				}
        			}
        		 }
        		 
        		 }
        		 
        }catch(Exception e) {
        	e.printStackTrace();
        }
        System.out.println(instructorList);
        
	}

	public Instructor findInstructorById(String id) {
	
			
		for(Instructor inst:instructorList) {
			
			if(inst.getId().equals(id)) {
			
				
				return inst;
			}
		}
		return null;
	}
	

	public void setInstructorList(TreeSet<Instructor> instructorList) {
		this.instructorList = instructorList;
	}

	public static InstructorBag Start(InstructorBag inst) {
		if(DataCenter == null) {
			DataCenter = inst;
		}
		return DataCenter;
	}
	
	public static InstructorBag Start() {
		if(DataCenter == null) {
			DataCenter = new InstructorBag();
		}
		return DataCenter;
	}


	public TreeSet<Instructor> getInstructorList() {
		return instructorList;
	}
	
	public Instructor getInstructor(String id) {
		 for (Instructor value : instructorList) {
			 if(value.getId() == id) {
				 return value;
			 }
		 }
		 return null;
	}


	
	}


