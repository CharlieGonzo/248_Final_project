package controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeSet;

import app.start;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.Instructor;
import models.InstructorBag;
import models.Section;
import models.SectionBag;
public class CourseSetView implements Initializable{
	
		@FXML
		Button returnListButton;

	    @FXML
	    private Label InstructorInfo;
	    
	    Instructor current;
	    
	    @FXML
	    private ListView<Section> assigned;
	    
	    @FXML
	    private ListView<Section> available;
	    
	    private TreeSet<Section> availableSection = SectionBag.Start().getList();

	    @FXML
	    private ListView<?> courseView;

	    @FXML
	    private Button fridayAft;

	    @FXML
	    private Button fridayE;

	    @FXML
	    private Button fridayEvening;
	    
	    List<Button> buttons;

	    @FXML
	    private Button fridayLateAft;

	    @FXML
	    private Button fridayMorning;

	    @FXML
	    private Button fridayNight;

	    @FXML
	    private GridPane grid;

	    @FXML
	    private Button mondayAft;

	    @FXML
	    private Button mondayEarly;

	    @FXML
	    private Button mondayEvening;

	    @FXML
	    private Button mondayLateAft;

	    @FXML
	    private Button mondayMorning;

	    @FXML
	    private Button mondayNight;

	    @FXML
	    private Button returnToInstructor;

	    @FXML
	    private BorderPane scheduleView;

	    @FXML
	    private Button shceduleButton;

	    @FXML
	    private Button thursdayAft;

	    @FXML
	    private Button thursdayEarly;

	    @FXML
	    private Button thursdayEvening;

	    @FXML
	    private Button thursdayLateAft;

	    @FXML
	    private Button thursdayMorning;

	    @FXML
	    private Button thursdayNight;

	    @FXML
	    private Button tuesdayAft;

	    @FXML
	    private Button tuesdayEarly;

	    @FXML
	    private Button tuesdayEvening;
	    
	    @FXML
	    private Label warning;
	    
	    @FXML
	    private Label warning1;

	    @FXML
	    private Button tuesdayLateAft;

	    @FXML
	    private Button tuesdayMorning;

	    @FXML
	    private Button tuesdayNight;

	    @FXML
	    private Button wednesdayAft;

	    @FXML
	    private Button wednesdayEarly;

	    @FXML
	    private Button wednesdayEvening;

	    @FXML
	    private Button wednesdayLateAft;

	    @FXML
	    private Button wednesdayMorning;

	    @FXML
	    private Button wednesdayNight;
	    
	    

	    @FXML
	    void showSchedule(ActionEvent event) {
	    	int count1 = 0;
			for(int j = 0;j<5;j++) {
				for(int i = 0;i<6;i++) {
				
					if(current.getAvailability()[i][j] == true) {
						buttons.get(count1).setTextFill(Color.GREEN);
					}else {
						buttons.get(count1).setTextFill(Color.RED);
					}
					count1++;
				}
			}
					
			
			
			
			if(scheduleView.isVisible()) {
				scheduleView.setVisible(false);
				scheduleView.setDisable(true);
			}else {
				scheduleView.setVisible(true);
				scheduleView.setDisable(false);
			}
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			 
		        	//available.getItems().addAll(value);
		     
			  buttons = List.of( mondayEarly,mondayMorning,mondayAft,mondayLateAft,mondayEvening,mondayNight,tuesdayEarly,tuesdayMorning,tuesdayAft,tuesdayLateAft,tuesdayEvening,tuesdayNight,wednesdayEarly,wednesdayMorning,wednesdayAft,wednesdayLateAft,wednesdayEvening,wednesdayNight,thursdayEarly,thursdayMorning,thursdayAft,thursdayLateAft,thursdayEvening,thursdayNight,fridayE,fridayMorning,fridayAft,fridayLateAft,fridayEvening,fridayNight);
			  assigned.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Section>() {

				@Override
				public void changed(ObservableValue<? extends Section> arg0, Section arg1, Section arg2) {
					// TODO Auto-generated method stub
					Section sec = assigned.getSelectionModel().getSelectedItem();
					for(int i = 0;i<current.getCurrentSections().size();i++) {
						if(current.getCurrentSections().get(i).getCRN().equals(sec.getCRN())) {
							current.getCurrentSections().remove(i);
							break;
						}
					}
					assigned.getItems().clear();
					assigned.getItems().addAll(current.getCurrentSections());
					availableSection.add(sec);
					available.getItems().clear();
					ArrayList<Section> sec1 = new  ArrayList<>(availableSection);
					available.getItems().addAll(current.isAvailableAndCampusMatch(sec1));
					
					start.save();
				}
			 
			  });
			  
			  available.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Section>() {

					@Override
					public void changed(ObservableValue<? extends Section> arg0, Section arg1, Section arg2) {
						// TODO Auto-generated method stub
						
						if((current.isSecondCourse() && current.getCurrentSections().size() == 2 && current.isThirdcourse() == false)) {
							
								warning1.setVisible(true);
							
						
						}else if((current.isThirdcourse() && current.getCurrentSections().size() == 3)) {
							warning1.setVisible(true);
						
						}else {
						warning1.setVisible(false);
						 Section section = available.getSelectionModel().getSelectedItem();
						 boolean work = true;
				
							 if (!current.getCurrentSections().isEmpty()) {
								    for (int i = 0; i < current.getCurrentSections().size(); i++) {
								        for (int j = 0; j < section.getTimeRange().size(); j++) {
								            for (int k = 0; k < current.getCurrentSections().get(i).getTimeRange().size(); k++) {
								                if (section.getTimeRange().get(j).ableTo(current.getCurrentSections().get(i).getTimeRange().get(k)) == false) {
								                   
								                    work = false;
								                }
								            }
								        }
								    }
								}
							 
						 
						 String CRN = section.getCRN();
						
						 if(work) {
							 Iterator<Section> iterator = availableSection.iterator();
							    while (iterator.hasNext()) {
							        Section sec = iterator.next();
							        if (sec.getCRN().equals(CRN)) {
							            iterator.remove(); // Safely remove the element
							        }
							    }		
							 	current.getCurrentSections().add(section);
								assigned.getItems().clear();
								assigned.getItems().addAll(current.getCurrentSections());
								available.getItems().clear();
								 ArrayList<Section> sec = new  ArrayList<>(availableSection);
								available.getItems().addAll(current.isAvailableAndCampusMatch(sec));
							 if(warning.isVisible())
								 warning.setVisible(false);
						 }else {
							 warning.setVisible(true);
						 }
						 start.save();
					}
					}
					
				  });
			  
			 
		}
		
		public void load(ActionEvent action) {
			available.getItems().clear();
			 ArrayList<Section> sec = new  ArrayList<>(availableSection);
			available.getItems().addAll(current.isAvailableAndCampusMatch(sec));
			
			assigned.getItems().clear();
			assigned.getItems().addAll(current.getCurrentSections());
			
		}
		
		public void returnList(ActionEvent event) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/MainView.fxml"));
			 Parent root =new VBox();;
			 try {
				root = loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				
		
				Stage stage;
				Scene scene;	
				stage = (Stage)(InstructorInfo.getScene().getWindow());
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();

		}
		
		public void setInstructor(Instructor inst) {
			this.current = inst;
			InstructorInfo.setText(current.toString());
	}

}
