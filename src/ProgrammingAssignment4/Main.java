/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProgrammingAssignment4;

/**
 *
 * @author alexchristopher
 */

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        PizzaCalculator pizza = new PizzaCalculator();
        pizza.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pizza.setSize(350, 300);
        pizza.setVisible(true);
    }
}
