/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProgrammingAssignment4;

/**
 *
 * @author alexchristopher
 */

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JOptionPane;


public class PizzaCalculator_GradientButton extends JFrame {
    private final Container container;
    private final GridLayout gridLayout;
    private final JLabel title = new JLabel("Pizza Serving Calculator");
    private final JLabel inputInfo; 
    private final JLabel outputLabel;
    private final JTextField inputPizzaSize;
    private final JPanel inputPanel;
    private final JGradientButton calculateButton; 
    private final Font titleFont = new Font("Serif", Font.BOLD, 30);
    private final Font bodyFont = new Font("Serif", Font.BOLD, 15);
    private String outputString;
    private double sizeOfPizza;
    private double numbOfServings;
    
    public PizzaCalculator_GradientButton() {
        super("Pizza Servings Calculator");
        
        gridLayout = new GridLayout(4, 1);
        container = getContentPane();
        setLayout(gridLayout);
        
        // insert title
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(titleFont);
        title.setForeground(Color.RED);
        
        // initialize textfield
        inputPizzaSize = new JTextField(4);
        
        // restrict input
        
        // insert line 2
        inputPanel = new JPanel();
        inputInfo = new JLabel("Enter the size of the pizza in inches:");
        inputInfo.setFont(bodyFont);
        inputPanel.add(inputInfo);
        inputPanel.add(inputPizzaSize);
        
        // insert button
        calculateButton = new JGradientButton("Calculate");
        calculateButton.setFont(bodyFont);
        calculateButton.setOpaque(false);
        
        // create button handler
        ButtonHandler handler = new ButtonHandler();
        calculateButton.addActionListener(handler);
        
        /*calculateButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                sizeOfPizza = Double.parseDouble(inputPizzaSize.getText());
                numbOfServings = Math.pow(sizeOfPizza/8, 2);
                outputString = String.format("A %.0f inch pizza will serve %.02f people", sizeOfPizza, numbOfServings);
                outputLabel.setText(outputString);
                
                if (!outputLabel.isVisible()) {
                    outputLabel.setVisible(true);
                }
            }
        });*/
        
        // insert ouput
        outputLabel = new JLabel();
        outputLabel.setFont(bodyFont);
        outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
        outputLabel.setVisible(false); 
        
        add(title);
        add(inputPanel);
        add(calculateButton);
        add(outputLabel);
    }
    
    // inner class for button event handling
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event){
            sizeOfPizza = Double.parseDouble(inputPizzaSize.getText());
                numbOfServings = Math.pow(sizeOfPizza/8, 2);
                outputString = String.format("A %.0f inch pizza will serve %.02f people", sizeOfPizza, numbOfServings);
                outputLabel.setText(outputString);
                
                if (!outputLabel.isVisible()) {
                    outputLabel.setVisible(true);
                }
        }
    }
    
    private static class JGradientButton extends JButton {
        /*
        Code From: https://stackoverflow.com/questions/7115672/change-jbutton-gradient-color-but-only-for-one-button-not-all
        */
        
        private JGradientButton(String buttonText) {
            super(buttonText);
            setContentAreaFilled(false);
        }
        
        @Override
        protected void paintComponent(Graphics graphics) {
            final Graphics2D g2 = (Graphics2D) graphics.create();
            g2.setPaint(new GradientPaint(
                new Point(0, 0), 
                Color.BLUE, 
                new Point(0, getHeight()/3), 
                Color.WHITE));
            g2.fillRect(0, 0, getWidth(), getHeight()/3);
            g2.setPaint(new GradientPaint(
                new Point(0, getHeight()/3), 
                Color.WHITE, 
                new Point(0, getHeight()), 
                Color.BLUE));
            g2.fillRect(0, getHeight()/3, getWidth(), getHeight());
            
            
            setOpaque(false);
            //g2.dispose();
            
            super.paintComponent(graphics);
        }
        
        /*public static JGradientButton newInstance() {
            return new JGradientButton();
        }*/

        private void setBackground(Graphics2D g2) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
