package ictgradschool.industry.lab.swing.ex04;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * A class representing a Balloon
 */
//added extends Rectangle to get setSize method. possibly needed for collision detection.
public class Balloon extends Rectangle{

    // Top left hand corner of Face
    private int x;
    private int y;
    private int size;
    private int speed;
    private Direction last;
    
    // This variable stores the current direction of the face
    private Direction direction;
    private Color balloonColor;

    /**
     * Creates a new balloon.
     *
     * @param left the left coordinate
     * @param top the top coordinate
     */
    public Balloon(int left, int top) {
        
        int red = (int)(Math.random()*256);
        int green = (int)(Math.random()*256);
        int blue = (int)(Math.random()*256);
        balloonColor = new Color(red, green, blue);
        size = (int)(Math.random() * 10 + 5);
        speed = (int)(Math.random() * 30 + 5);
        // Initially, the direction is to the right
        direction = Direction.Right;
        x = left;
        y = top;
//        adding setSize.
        super.setSize(8*size,9*size);
    }

    public Point getPosition(){
        Point position= new Point();
        position.x=this.x;
        position.y=this.y;
        return position;
    }

    /**
     * Changes the direction
     *
     * @param direction the new direction
     */
    public void setDirection(Direction direction) {
        if(direction!=Direction.None){
            this.last=this.direction;
            System.out.println(last);
        }

        this.direction = direction;
    }
//attempting collision detection.
    public void collision(){
        for (Balloon balloon:ExerciseFourPanel.balloons
        ) {
            if (this.intersects(balloon)){
                System.out.println("collided");
                randomiseDirection();

            }
        }
    }

    public void col2(){
        for (Balloon balloon:ExerciseFourPanel.balloons
        ) {
            if(this.contains(balloon.getPosition())){
                System.out.println("col2");
            }
        }
    }

    private void randomiseDirection(){
        int newDirection = (int)(Math.random()*4);
        switch (newDirection){
            case 0: setDirection(Direction.Left);
            return;
            case 1: setDirection(Direction.Right);
            return;
            case 2: setDirection(Direction.Up);
            return;
            case 3: setDirection(Direction.Down);
        }
    }


    public Direction getLastDirection(){
        return this.last;
    }

    /**
     * Moves the balloon in the current direction
     */
    public void move() {
        if (direction == Direction.Right) {
            x = x + speed;
        }

        if (direction == Direction.Left) {
            x = x - speed;
        }

        if (direction == Direction.Up) {
            y = y - speed;
        }

        if (direction == Direction.Down) {
            y = y + speed;
        }
        // TODOne Complete the code for the other directions
        
    }

    /**
     * Draws the balloon
     *
     * @param g the Graphics object with which to do the drawing
     */
    public void draw(Graphics g) {
        
        g.setColor(balloonColor);
        g.fillOval(x, y, 8 * size, 9 * size);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 8 * size, 9 * size);
        g.setColor(Color.BLUE);
        g.fillOval(x + 2*size, y + 2*size, size, size);
        g.fillOval(x + 5*size, y + 2*size, size, size);
        g.setColor(Color.WHITE);
        g.fillOval(x + 2*size, y + 5*size,4*size, 2*size);
        g.setColor(Color.BLACK);
        g.drawLine(x + 4*size, y + 9*size, x + 4*size, y + 30*size);
        
    }

    /**
     * Determines if a point is within the 'face' part of the balloon
     * 
     * @param p a Point object containing the coordinates to test
     * @return true if Point lies within the Rectangle bounding the face, otherwise false
     */
    public boolean contains(Point p) {
        Rectangle rect = new Rectangle(x, y, 8 * size, 9 * size);
        return rect.contains(p);
    }
}

