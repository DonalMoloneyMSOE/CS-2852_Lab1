/*
 *CS 2852 - 011
 *Fall 2017
 *Lab 1 - Dot 2 Dot Generator
 *Name: Donal Moloney
 *Created: 9/5/2017
 */
package Moloneyda;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/*
 * This class creates the GUI and runs it
 * This class extends Application
 */
public class CS2852Lab1 extends Application{
    public static void main(String[] args) {
            launch(args);
    }

    /*
    * This method creates and shows the GUI
    * @throws IOException when encountering problems to create the GUI
    */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DotToDot.fxml"));
        primaryStage.setTitle("Dot to Dot");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }
}
