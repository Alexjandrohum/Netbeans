/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Contracs.DivisionContract;
import GUI.PanelDivision;
import GUI.PanelInputs;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author alexjandrohum
 */
public class Principal extends JFrame implements DivisionContract.ViewDivision {

    PanelInputs inputs = new PanelInputs();
    private PanelDivision panelDivision;

    public Principal() {

        add(inputs.inputs(), BorderLayout.NORTH);
        add(inputs.crearPanelbotonesFinal(), BorderLayout.SOUTH);
        add(inputs.crearPanelexplicaySD(), BorderLayout.EAST);
        add(new PanelDivision());
    }

    public static void main(String... args) {
        Principal frame = new Principal();
        frame.setTitle("Divisi\u00f3n de N\u00fameros Enteros");
        frame.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(frame); //centra el frame
        frame.setVisible(true);

    }

    @Override
    public void getDatos(int[] dividendo, int[] divisor) {

    }

    @Override
    public void getStatus(boolean enabled) {
        if (enabled) {
            JOptionPane.showMessageDialog(null, "Dividendo: " + PanelInputs.getDividendo() + " Divisor : " + PanelInputs.getDivisor());
        } else {
            JOptionPane.showMessageDialog(null, "Vacio");
        }
    }
}
