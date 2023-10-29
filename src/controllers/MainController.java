package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Instructor;
import models.InstructorBag;
import models.Section;

public class MainController implements Initializable {
	

    @FXML
    private ListView<Instructor> InstructorList;

    @FXML
    private Button buttonStart;
	
	
	Instructor current;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		 for(Instructor value:InstructorBag.Start().getInstructorList()) {
	        	InstructorList.getItems().add(value);
	        }
		 
		 InstructorList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Instructor>() {

				@Override
				public void changed(ObservableValue<? extends Instructor> arg0, Instructor arg1, Instructor arg2) {
					// TODO Auto-generated method stub
					 current = InstructorList.getSelectionModel().getSelectedItem();
					//System.out.println(String.valueOf(current.getId()));
					 FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/CourseSetView.fxml"));
					 Parent root =new VBox();;
					 try {
						root = loader.load();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
						
						CourseSetView scene2Controller = loader.getController();
						scene2Controller.setInstructor(current);
						Stage stage;
						Scene scene;	
						stage = (Stage)(InstructorList.getScene().getWindow());
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
				
				}
				  
			  });
	}
	
	@FXML
	public void selectInstructor(ActionEvent action) {
		
	}
	
	public void changeToCourseView(ActionEvent action) {
		
	}

}
