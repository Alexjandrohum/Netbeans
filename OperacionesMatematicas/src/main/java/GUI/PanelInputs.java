/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Contracs.DivisionContract;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import static java.awt.TextArea.SCROLLBARS_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author alexjandrohum
 */
public class PanelInputs implements DivisionContract.ViewDivision{

    static JTextField campoDivisores;
    static JTextField campoDividendos;
    JTextField Cociente;
    JTextField Residuo;

    public JPanel inputs() {
        JPanel panel1 = new JPanel();

        //oyenteDividir evento = new oyenteDividir();
        JLabel etiquetaDividendo = new JLabel("Escribe el Dividendo");
        JLabel etiquetaDivisor = new JLabel("Escribe el Divisor");
        JLabel etiquetaCociente = new JLabel(" El Cociente es: ");
        JLabel etiquetaResiduo = new JLabel(" El Residuo es: ");

        JButton dividir = new JButton("Dividir");
        dividir.setMnemonic(KeyEvent.VK_V);

        campoDividendos = new JTextField("0", 7);
        campoDivisores = new JTextField("0", 7);
        Cociente = new JTextField("", 7);
        Cociente.setEditable(false);
        Residuo = new JTextField("", 7);
        Residuo.setEditable(false);

        panel1.add(etiquetaDividendo);
        panel1.add(campoDividendos);
        panel1.add(etiquetaDivisor);
        panel1.add(campoDivisores);
        panel1.add(dividir);
        panel1.add(etiquetaCociente);
        panel1.add(Cociente);
        panel1.add(etiquetaResiduo);
        panel1.add(Residuo);
        panel1.setLayout(new GridLayout(1, 9));
        //add(panel1);
        //pack();
        campoDivisores.setText("0");

        dividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (campoDivisores.getText().equals("0")) {
                    //Principal.getStatus(false);
                } else {
                    //Principal.getStatus(true);
                }
            }
        });
        return (panel1);
    }

    public JPanel crearPanelbotonesFinal() {
        JPanel panel4 = new JPanel();
        //
        JButton explicacion = new JButton("Explicaci\u00f3n");
        //oyeExplica Tevento = new oyeExplica();
        explicacion.setMnemonic(KeyEvent.VK_E);
        panel4.add(explicacion);
        //explicacion.addActionListener(Tevento);

        JButton situacionesD = new JButton("Situaciones Did\u00e1cticas");
        situacionesD.setMnemonic(KeyEvent.VK_D);
        //OyenteSituacionesD evento2 = new OyenteSituacionesD();
        //situacionesD.addActionListener(evento2);
        panel4.add(situacionesD);

        JButton borrar = new JButton("Borrar");
        borrar.setMnemonic(KeyEvent.VK_B);
        // OyenteBorrarDatos evento3 = new OyenteBorrarDatos();
        //borrar.addActionListener(evento3);
        panel4.add(borrar);

        JButton salir = new JButton("Salir");
        salir.setMnemonic(KeyEvent.VK_S);
        panel4.add(salir);

        salir.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        }
        );

        panel4.setLayout(new GridLayout(1, 4));

        return (panel4);
    }

    public JPanel crearPanelexplicaySD() {
        JPanel panel3 = new JPanel();
        boolean isSelected = false;
        TextArea areaExplica = new TextArea("Explicaci\u00f3n", 75, 95, SCROLLBARS_BOTH);
        //areaExplica.setPreferredSize(new Dimension(1100, 68));  //tenia 638
        areaExplica.setFont(new Font("TRUETYPE_FONT", Font.PLAIN, 16));

        areaExplica.setBackground(isSelected ? new Color(204, 255, 255) : new Color(10, 60, 60));
        areaExplica.setForeground(isSelected ? new Color(10, 60, 60) : new Color(204, 255, 255));
        //MASTERING JAVA, busqueda "color", primera opción: Foreground
        panel3.add(areaExplica);
        //setVisible(true);

        TextArea areaSituacionesD = new TextArea("Situaciones Didacticas (SD) y Conflictos Cognitivos (CC)", 75, 95, SCROLLBARS_BOTH);
        //areaSituacionesD.setPreferredSize(new Dimension(1100, 68));
        areaSituacionesD.setFont(new Font("TRUETYPE_FONT", Font.PLAIN, 16));
        areaSituacionesD.setBackground(isSelected ? new Color(204, 255, 154) : new Color(10, 60, 60));
        areaSituacionesD.setForeground(isSelected ? new Color(10, 60, 60) : new Color(204, 255, 154));
        panel3.add(areaSituacionesD);
        //setVisible(true);
        panel3.setLayout(new GridLayout(2, 1));
        //add(panel3);
        //setVisible(true);
        //pack();
        return (panel3);

    }

    public static String getDividendo() {
        return campoDividendos.getText();
    }

    public static String getDivisor() {
        return campoDivisores.getText();
    }

    @Override
    public void getStatus(boolean enabled) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getDatos(int[] dividendo, int[] divisor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
