/*
 *CS 2852 - 011
 *Fall 2017
 *Lab 1 - Dot 2 Dot Generator
 *Name: Donal Moloney
 *Created: 9/5/2017
 */
package Moloneyda;

/*
 * This class creates a Dot
 * This class extends Picture
 */
public class Dot extends Picture{
    private double xCoordinate;
    private double yCoordinate;

    /*
    * This is the Dot constructor and it passes the x, y coordinates of the new dot to its set methods
    * @param yCoordinate - the height of the dot as a double
    * @param yCoordinate - The dots vertical position from the origin
    */
    public Dot(double xCoordinate, double yCoordinate){
        setHorizontalPosition(xCoordinate);
        setVerticalPoistion(yCoordinate);
    }

    /*
    * This class sets the horizontal position of a dot
    * @param xCoordinate - The dots horizontal position from the origin
    */
    public void setHorizontalPosition(double xCoordinate){this.xCoordinate = xCoordinate;}

    /*
    * This class sets the vertical position of a dot
    * @param yCoordinate - The dots vertical position from the origin
    */
    public void setVerticalPoistion(double yCoordinate){this.yCoordinate = yCoordinate;}

    /*
    * This class gets returns the horizontal position of a dot
    * @returns this.xCoordinate- the Dots instance of its x coordinate
    */
    public double getHorizontalPosition(){
        return this.xCoordinate;
    }

    /*
    * This class gets returns the vertical position of a dot
    * @returns this.yCoordinate- the Dots instance of its y coordinate
    */
    public double getVerticalPoisttion(){
        return this.yCoordinate;
    }
}
