/*
 *CS 2852 - 011
 *Fall 2017
 *Lab 1 - Dot 2 Dot Generator
 *Name: Donal Moloney
 *Created: 9/5/2017
 */
package Moloneyda;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
*This class has methods that draw manipulate the .dot file
*/
public class Picture{
    public ArrayList<Dot> dotsList = new ArrayList<Dot>();
    private double dotXPosition;
    private double dotYPosition;
    private static final int dotOffSetFactor = 5;


    /*
    *This method loads a .dot file
    *@param file - the file the user chose to load
    *@throws IOException - if an error occurs setting the file's data into the scanner
    *@ returns void - this method does not return anything
    */
    protected void load(File file) throws IOException {
            Scanner fileData = new Scanner(new FileReader(file));
            String aLine;
            Scanner maniputableLine;
            while (fileData.hasNextLine()) {
                aLine = fileData.nextLine();
                maniputableLine = new Scanner(aLine);
                double xCordinate = 0.0;
                String xString = maniputableLine.next();
                if (xString.contains(",")) {
                    xString = xString.replace(",", "");
                    xCordinate = Double.parseDouble(xString);
                }
                double yCoordinate = maniputableLine.nextDouble();
                Dot newDots = new Dot(xCordinate, yCoordinate);
                dotsList.add(newDots);
            }
            fileData.close();
    }

    /*
    *This method draws the dots of the image
    * @param canvas - where the dots are drawn upon
    * @returns void - this method does not return anything
    */
    protected void drawDots(Canvas canvas){
        canvas.getGraphicsContext2D().setFill(Color.AQUA);
        for(int i = 0; i<dotsList.size(); i++) {
            dotXPosition = dotsList.get(i).getHorizontalPosition()*600 - dotOffSetFactor;
            dotYPosition = (1 - dotsList.get(i).getVerticalPoisttion())*600 - dotOffSetFactor;
            canvas.getGraphicsContext2D().fillOval(dotXPosition,dotYPosition,10,10);
        }
    }

    /*
    * This method draws the lines of lines of the image
    * @param canvas - where the dots are drawn upon
    * @returns void - this method does not return anything
    */
    protected void drawLines(Canvas canvas){
        double beginXLocation = dotsList.get(0).getHorizontalPosition()*600;
        double beginYLocation =(1- dotsList.get(0).getVerticalPoisttion())*600;
        canvas.getGraphicsContext2D().setLineWidth(2.0);
        canvas.getGraphicsContext2D().beginPath();
        canvas.getGraphicsContext2D().moveTo(beginXLocation,beginYLocation);
        for(int i = 1; i<dotsList.size(); i++) {
            double xPos =  dotsList.get(i).getHorizontalPosition()*600;
            double yPos =(1 - dotsList.get(i).getVerticalPoisttion())*600;
            canvas.getGraphicsContext2D().lineTo(xPos,yPos);
        }
        canvas.getGraphicsContext2D().lineTo(beginXLocation,beginYLocation);
        canvas.getGraphicsContext2D().closePath();
        canvas.getGraphicsContext2D().stroke();
    }
}

