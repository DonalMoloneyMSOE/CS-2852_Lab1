# CS-2852_Lab1

Objectives

    Demonstrate competency in many prerequisite areas including:
        Graphical User Interfaces with JavaFX
        Text file input
        Handle exceptions in a robust and meaningful fashion

Resources

    Instructions for Installing OpenJDK 11 and JavaFX 11
    Creating .jar video
    Sample .dot files:
        circle.dot
        balloon100.dot
        magician.dot
    GraphicFileGenerator.jar

Overview

In this assignment you will begin developing a dot-to-dot generator program. The subsequent two laboratory assignments will build on this one, allowing you to improve your initial submission based on feedback from your instructor and expand the program’s functionality.
Assignment

You must create a program that will read a picture from a .dot file and graphically display the picture stored in the file.
User Interface
Figure 1: User Interface

Your program must have two menus each with two menu items:

    File
        Open — Loads a .dot file and displays the dots in the file and connects neighboring dots with lines.
        Close — Exits the program (use Platform.exit()).
    Draw
        Lines Only — Redraws the loaded picture drawing only lines (no dots).
        Dots Only — Redraws the loaded picture drawing only dots (no lines).

The Draw menu items should only be active when a picture has been loaded.

You may use FXML but are not required to do so.
Details
CheckStyles

Be sure to install the Checkstyles plugin and MSOE custom configuration before completing the assignment.
Class Structure

All of your classes should be placed in a package whose name matches your MSOE username.

You must implement two classes:

    Dot — Represents a dot in the picture.
    Picture — Holds a list of Dots that describe a picture.

The Picture class must implement the following methods:

    void load(Path path) — Loads all of the dots from a .dot file.
    void drawDots(Canvas canvas) — Draws each dot in the picture onto the canvas.
    void drawLines(Canvas canvas) — Draws lines between all neighboring dots in the picture on the canvas.

.dot File Format

Your program must be able to read dot files that contain a list of dots. The file is formatted such that each dot is on a separate line. A dot consists of a horizontal and vertical component separated by a comma. Each component is a floating point value between zero and one. For example, square.dot looks like this:

    0.1, 0.1
    0.1,0.9
    0.9,0.9
    0.9, 0.1

Here are a few sample .dot files: circle.dot, balloon100.dot, and magician.dot.

If you’d like to make your own graphic files, you can use the GraphicFileGenerator.jar. The program begins with a file chooser dialog that can be used to select a background image (which you can then trace). Hit cancel if you’d rather just have a black background. To draw, press and hold the mouse down. When you’re done, release the mouse. You’ll then need to save the points to a file (use the menu).
Drawing Dots

A dot can be drawn on a Canvas by first obtaining the GraphicsContext and then calling the fillOval() method. Be sure to set an appropriate fill color and center the dot over its coordinate location.
Drawing Lines

Lines should be drawn between all neighboring dots, including a line from the last dot back to the first dot. The lines can be drawn on a Canvas by first obtaining the GraphicsContext and then creating a path. To do this:

    Call beginPath()
    Move to the location of the first dot by calling moveTo()
    Draw a line to the next dot by calling lineTo()
    Repeat the previous step for all dots
    Call closePath()
    Call stroke() to draw the path

Exception Handling

There are a number of situations that could cause your program to throw an exception. For example, if the file is not found, cannot be opened, or contains incorrectly formatted data, it is likely that an exception will be thrown. In these cases, the program should display an useful message in an Alert.
Just For Fun

Ambitious students may wish to:

    Try replacing lineTo() with quadraticCurveTo() or bezierCurveTo().
    Add number annotations next to each dot.
    Create a print to PDF option.

Lab Deliverables

    See your professor’s instructions for details on submission guidelines and due dates.

        Dr. Taylor’s students: See below
        All other students should refer to Blackboard

    If you have any questions, consult your instructor.

Acknowledgment

This laboratory assignment was developed by Dr. Chris Taylor.
