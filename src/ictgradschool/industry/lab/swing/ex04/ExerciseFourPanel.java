package ictgradschool.industry.lab.swing.ex04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Displays an animated balloon.
 */
public class ExerciseFourPanel extends JPanel implements ActionListener, KeyListener {

    private  Balloon balloon;
    private  JButton moveButton;

    /**
     * Creates a new ExerciseFourPanel.
     */
    public ExerciseFourPanel() {
        setBackground(Color.white);

        this.balloon = new Balloon(30, 60);

        this.moveButton = new JButton("Move balloon");
        this.moveButton.addActionListener(this);
        this.add(moveButton);

        this.addKeyListener(this);

    }

    /**
     * Moves the balloon and calls repaint() to tell Swing we need to redraw ourselves.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        balloon.move();

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

        balloon.draw(g);
        
        // Sets focus outside of actionPerformed so key presses work without pressing the button
        requestFocusInWindow();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    int direction = e.getKeyCode();

    switch (direction){
        case 37:
            balloon.setDirection(Direction.Left);
            return;
        case 38:
            balloon.setDirection(Direction.Up);
            return;
        case 39:
            balloon.setDirection(Direction.Right);
            return;
        case 40:
            balloon.setDirection(Direction.Down);
            return;
    }
        System.out.println(direction);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}