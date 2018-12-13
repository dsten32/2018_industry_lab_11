package ictgradschool.industry.lab.swing.ex04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ArrayList;

/**
 * Displays an animated balloon.
 */
public class ExerciseFourPanel extends JPanel implements ActionListener, KeyListener {
public static List<Balloon> balloons;
//    private  Balloon balloon;
    private  JButton moveButton;
    private Timer timer;


    /**
     * Creates a new ExerciseFourPanel.
     */
    public ExerciseFourPanel() {
        setBackground(Color.white);

        this.balloons= new ArrayList<>();

        int numBalloons = (int)(Math.random()*1)+3;
        System.out.println(numBalloons);

        for (int i = 0; i < numBalloons; i++) {
            balloons.add(new Balloon((int)(Math.random()*500),(int)(Math.random()*500)));
        }
        System.out.println(balloons.size());
        repaint();

//        this.balloon = new Balloon(30, 60);


        this.moveButton = new JButton("Move balloon");
        this.moveButton.addActionListener(this);
        this.add(moveButton);

        this.addKeyListener(this);

        this.timer = new Timer(100, this);



    }

    /**
     * Moves the balloon and calls repaint() to tell Swing we need to redraw ourselves.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        for (Balloon balloon:balloons
        ) {
                balloon.move();
        }


        // Sets focus to the panel itself, rather than the JButton. This way, the panel can continue to generate key
        // events even after we've clicked the button.
        requestFocusInWindow();

        repaint();
    }

    /**
     * Draws any balloons we have inside this panel.
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Balloon balloon:balloons
             ) {
//            balloon.col2();
//            balloon.collision();
            balloon.draw(g);
        }

        
        // Sets focus outside of actionPerformed so key presses work without pressing the button
        requestFocusInWindow();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.timer.start();

//    int direction  ;
//        System.out.println(last);

        switch (e.getKeyCode()){
            case 37:
                for (Balloon balloon:balloons
                ) {
                    balloon.setDirection(Direction.Left);
                }
                return;
            case 38:
                for (Balloon balloon:balloons
                ) {
                    balloon.setDirection(Direction.Up);
                }
                return;
            case 39:
                for (Balloon balloon:balloons
                ) {
                    balloon.setDirection(Direction.Right);
                }
                return;
            case 40:
                for (Balloon balloon:balloons
                ) {
                    balloon.setDirection(Direction.Down);
                }
                return;
            case 83:
                for (Balloon balloon:balloons
                ) {
                    if(balloon.getLastDirection()!=Direction.None){
                        balloon.setDirection(Direction.None);
                    } else {
                        balloon.setDirection(Direction.Left);
                    }

                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}