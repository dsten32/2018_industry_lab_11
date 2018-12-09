package ictgradschool.industry.lab.swing.ex01;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * A simple GUI app that does BMI calculations.
 */
public class ExerciseOnePanel extends JPanel implements ActionListener {

    // TODOne Declare JTextFields and JButtons as instance variables here.
    private JButton calculateBMIButton,calculateHealthyWeight;
    private JTextField heightInM,weightInKg,BMI,maxHealthyWeight,err;
    double vHeight,vWeight;

    /**
     * Creates a new ExerciseOnePanel.
     */
    public ExerciseOnePanel() {
        setBackground(Color.white);

        // TODOne Construct JTextFields and JButtons.
        // HINT: Declare them as instance variables so that other methods in this class (e.g. actionPerformed) can
        // also access them.
        heightInM = new JTextField((10));

        weightInKg = new JTextField((10));

        calculateBMIButton = new JButton("Calculate BMI");

        BMI = new JTextField((10));

        calculateHealthyWeight = new JButton("Calculate Healthy Weight");

        maxHealthyWeight = new JTextField((10));

        err = new JTextField(50){
          @Override public void setBorder(Border border){

          }
        };

        // TODOne Declare and construct JLabels
        // Note: These ones don't need to be accessed anywhere else so it makes sense just to declare them here as
        // local variables, rather than instance variables.
        JLabel height = new JLabel("Height in metres:");
        JLabel weight = new JLabel("Weight in kilograms:");

        JLabel BMILabel = new JLabel("Your Body Mass Index is:");

        JLabel maxHealthy = new JLabel("Maximum Healthy Weight for your Height is:");

        // TODOne Add JLabels, JTextFields and JButtons to window.
        // Note: The default layout manager, FlowLayout, will be fine (but feel free to experiment with others if you want!!)


        this.add(height);
        this.add(heightInM);

        this.add(weight);
        this.add(weightInKg);

        this.add(calculateBMIButton);

        this.add(BMILabel);
        this.add(BMI);

        this.add(calculateHealthyWeight);

        this.add(maxHealthy);
        this.add(maxHealthyWeight);


        this.add(err);


        // TODOne Add Action Listeners for the JButtons
        calculateBMIButton.addActionListener(this);
        calculateHealthyWeight.addActionListener(this);


    }


    /**
     * When a button is clicked, this method should detect which button was clicked, and display either the BMI or the
     * maximum healthy weight, depending on which JButton was pressed.
     */
    public void actionPerformed(ActionEvent event) {

        // TODOne Implement this method.
        // Hint #1: event.getSource() will return the button which was pressed.
        // Hint #2: JTextField's getText() method will get the value in the text box, as a String.
        // Hint #3: JTextField's setText() method will allow you to pass it a String, which will be diaplayed in the text box.
        if(event.getSource()==calculateBMIButton){

            try {
            vHeight= Double.parseDouble(heightInM.getText());
            vWeight = Double.parseDouble(weightInKg.getText());

            String yourBMI = String.valueOf(roundTo2DecimalPlaces(vWeight / (Math.pow(vHeight,2))));
                BMI.setText(yourBMI);
            } catch (NumberFormatException e) {
                err.setText("You haven't filled the height and weight, or you didn't use numbers");
            }




        }


        if(event.getSource()==calculateHealthyWeight) {
            try {
                vHeight = Double.parseDouble(heightInM.getText());
                vWeight = Double.parseDouble(weightInKg.getText());

                String maxWeight = String.valueOf(roundTo2DecimalPlaces(24.9 * (Math.pow(vHeight, 2))));

                maxHealthyWeight.setText(maxWeight);
            } catch (NumberFormatException e) {
                err.setText("You haven't filled the height and weight, or you didn't use numbers");
            }
        }

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

}