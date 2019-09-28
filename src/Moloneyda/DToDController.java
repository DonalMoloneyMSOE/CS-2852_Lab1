/*
 *CS 2852 - 011
 *Fall 2017
 *Lab 1 - Dot 2 Dot Generator
 *Name: Donal Moloney
 *Created: 9/5/2017
 */
package Moloneyda;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
*This class handles the action events of DotToDot.fxml
*/
public class DToDController {
    private File file;
    private FileChooser fileChooser = new FileChooser();
    private Picture picture = new Picture();
    private final Logger LOGGER = Logger.getLogger(Picture.class.getName());
    @FXML
    Canvas canvas;
    @FXML
    MenuItem menuItemDotsOnly;
    @FXML
    MenuItem menuItemLinesOnly;


    /*
    * This is the classes's constructor method
    * It creates a file handler object, sets the file handler level to sever, and adds the file handler to the logger
    * @throws IO Exception - can occur when declaring a new File Handler
    */
    public DToDController(){
        try {
            FileHandler fileHandler = new FileHandler("FileHandler");
            fileHandler.setLevel(Level.SEVERE);
            LOGGER.addHandler(fileHandler);
        }catch (IOException e){
            LOGGER.log(Level.SEVERE,"I/O Exception occurred while instantiating fileHandler");
            JOptionPane.showMessageDialog(null, "An error occurred while instantiating fileHandler",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     * This method allows the user to choose a file to open, then draws it by calling Picture's methods
     * This method can throw an IO exception if no file is entered
     * @param actionEvent - a mouse click
     * @throws NumberFormatException - file chosen is in the incorrect format
     * @throws InputMismatchException - file chosen is in an invalid format
     * @throws IOException - when an error occurs passing the file data to the scanner
     */
    public void openFile(ActionEvent actionEvent) throws IOException{
        file = fileChooser.showOpenDialog(null);
        try {
            if (file != null) {
                fileChooser.setTitle("Select Your Dot File");
                picture.load(file);
                picture.drawDots(canvas);
                picture.drawLines(canvas);
                menuItemDotsOnly.setDisable(false);
                menuItemLinesOnly.setDisable(false);
            }
        }catch (NumberFormatException e){
            LOGGER.log(Level.SEVERE,"The file trying to be loaded has numbers not in the correct format");
            JOptionPane.showMessageDialog(null, "The file trying to be loaded has numbers in the incorrect format",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }catch(InputMismatchException e){
            LOGGER.log(Level.SEVERE,"The file trying to be loaded is an invalid format");
            JOptionPane.showMessageDialog(null, "The file trying to be loaded is an invalid format",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }catch (IOException e){
            LOGGER.log(Level.SEVERE,"An error occurred passing the file data to a scanner");
            JOptionPane.showMessageDialog(null, "An error occurred passing the file data to a scanner",
                    "Error", JOptionPane.ERROR_MESSAGE);         }
    }

    /*
    * This method allows you to safely end the program
    * @param actionEvent - a mouse click
    * @return void - this method does not return anything
    */
    @FXML
    public void closeFile(ActionEvent actionEvent) {
        Platform.exit();
    }

    /*
    * This method draws the lines only of the file by calling the picture class's method draw lines
    * @param actionEvent - a mouse click
     */
    @FXML
    public void drawLinesOnly(ActionEvent actionEvent) {
            canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
            picture.drawLines(canvas);

    }

    /*
    *This method draws the dots only of the file by calling the picture class's method draw dots
    * @param action event- a mouse click
     */
    @FXML
    public void drawDotsOnly(ActionEvent actionEvent) {
            canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
            picture.drawDots(canvas);
    }
}
