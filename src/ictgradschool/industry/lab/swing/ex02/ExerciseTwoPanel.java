package ictgradschool.industry.lab.swing.ex02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple JPanel that allows users to add or subtract numbers.
 *
 * TODO Complete this class. No hints this time :)
 */
public class ExerciseTwoPanel extends JPanel implements ActionListener {
    private JButton add,subtract;
    private JTextField firstNumber, secondNumber, result;
    private double vFirst,vSecond,vResult;
    /**
     * Creates a new ExerciseFivePanel.
     */
    public ExerciseTwoPanel() {
        setBackground(Color.white);

        add = new JButton("Add");
        subtract = new JButton("Subtract");

        firstNumber = new JTextField(10);
        secondNumber = new JTextField(10);
        result = new JTextField(21);

        JLabel resultLabel = new JLabel("Result:");

        this.add(firstNumber);
        this.add(secondNumber);
        this.add(add);
        this.add(subtract);
        this.add(resultLabel);
        this.add(result);

        add.addActionListener(this);
        subtract.addActionListener(this);

    }

    /**
     * A library method that rounds a double to 2dp
     *
     * @param amount to round as a double
     * @return the amount rounded to 2dp
     */
    private double roundTo2DecimalPlaces(double amount) {
        return ((double) Math.round(amount * 100)) / 100;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==add){
            vFirst=Double.parseDouble(firstNumber.getText());
            vFirst=Double.parseDouble(secondNumber.getText());

            vResult=vFirst+vSecond;

            result.setText(String.valueOf(vResult));
        }

        if(e.getSource()==subtract){
            vFirst=Double.parseDouble(firstNumber.getText());
            vFirst=Double.parseDouble(secondNumber.getText());

            vResult=vFirst-vSecond;

            result.setText(String.valueOf(vResult));

        }

    }
}