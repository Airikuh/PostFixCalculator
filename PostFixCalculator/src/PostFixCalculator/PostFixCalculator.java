//Erika Valle-Baird 
//CIS 296
//Project 3
//11/19/2021


package PostFixCalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class PostFixCalculator extends Application{
       @Override
    public void start(Stage stage) throws Exception {
         Parent root = FXMLLoader.load(getClass().getResource("PostFixCalculatorFXML.fxml"));
         Scene scene = new Scene(root);
         stage.setTitle("PostFix Calculator");
         stage.setScene(scene);
         stage.show();
                        
    }
    
    
    public static void main(String[] args){
        launch(args);
    }

 
    
}
