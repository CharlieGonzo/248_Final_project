package app;


import java.io.IOException;
import java.io.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.InstructorBag;
import models.SectionBag;

public class start extends Application {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			
		
		Application.launch(args);
		}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		   String fileName = "Instructor.dat";
		   String course = "Section.dat";
	        if (!fileExists(fileName)) {
	            // Create an object to be saved
	        	InstructorBag.Start();
	    		SectionBag.Start();

	            try {
	                // Create a FileOutputStream
	                FileOutputStream fileOutputStream = new FileOutputStream(fileName);

	                // Create an ObjectOutputStream
	                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	                
	                FileOutputStream fileOutputStreamsec = new FileOutputStream("Section.dat");

	                // Create an ObjectOutputStream
	                ObjectOutputStream objectOutputStreamsec = new ObjectOutputStream(fileOutputStreamsec);
	                // Write the object to the .dat file
	                objectOutputStream.writeObject(InstructorBag.Start());
	                objectOutputStreamsec.writeObject(SectionBag.Start());

	                // Close the streams
	                objectOutputStream.close();
	                fileOutputStream.close();
	                objectOutputStreamsec.close();
	                fileOutputStreamsec.close();

	                System.out.println("Object has been saved to " + fileName);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } else {
	            // File already exists, so you can load it or perform other actions.
	        	 String fileName2 = "Instructor.dat";

	             InstructorBag loadedInt = loadInst(fileName2);
	             SectionBag loadedSec = loadSec("Section.dat");

	             if (loadedInt != null) {
	                 System.out.println("Object loaded from " + fileName2 + ": " + loadedInt);
	             } else {
	                 System.out.println("File " + fileName2 + " does not exist or could not be loaded.");
	             }
	             
	             InstructorBag.Start(loadedInt);
	             SectionBag.Start(loadedSec);
	        }
		AnchorPane root = FXMLLoader.load(getClass().getResource("/views/MainView.fxml"));
		Scene scene1 = new Scene(root);
		stage.setScene(scene1);
		//stage.setResizable(false);
		stage.show();
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			save();
		}));
	}
	
	 private static InstructorBag loadInst(String fileName) {
	        try {
	            FileInputStream fileInputStream = new FileInputStream(fileName);
	            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	            InstructorBag loadedObject = (InstructorBag) objectInputStream.readObject();
	            objectInputStream.close();
	            fileInputStream.close();
	            return loadedObject;
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	 
	 public static void save() {
		 try {
			 String fileName = "Instructor.dat";
             // Create a FileOutputStream
             FileOutputStream fileOutputStream = new FileOutputStream(fileName);

             // Create an ObjectOutputStream
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
             
             FileOutputStream fileOutputStreamsec = new FileOutputStream("Section.dat");

             // Create an ObjectOutputStream
             ObjectOutputStream objectOutputStreamsec = new ObjectOutputStream(fileOutputStreamsec);
             // Write the object to the .dat file
             objectOutputStream.writeObject(InstructorBag.Start());
             objectOutputStreamsec.writeObject(SectionBag.Start());

             // Close the streams
             objectOutputStream.close();
             fileOutputStream.close();
             objectOutputStreamsec.close();
             fileOutputStreamsec.close();

             System.out.println("Object has been saved to " + fileName);
         } catch (IOException e) {
             e.printStackTrace();
         }
	 }
	 
	 private static SectionBag loadSec(String fileName) {
	        try {
	            FileInputStream fileInputStream = new FileInputStream(fileName);
	            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	            SectionBag loadedObject = (SectionBag) objectInputStream.readObject();
	            objectInputStream.close();
	            fileInputStream.close();
	            return loadedObject;
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	
	 private boolean fileExists(String fileName) {
	        File file = new File(fileName);
	        return file.exists();
	    }
	 
	 
}
