/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Contracs.DivisionContract;
import Util.Constantes;
import static Util.Constantes.DOS;
import static Util.Constantes.TRES;
import static Util.Constantes.UNO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author alexjandrohum
 */
public class PanelDivision extends JPanel implements DivisionContract.ModeloDivision{

    private int valor;

    private Graphics g;
    private int divisor1;
    private int dividendo1, dividendo2;
    
    public PanelDivision(){
        
    }

    public void PanelDivisionDos(int divisor1, int dividendo1) {
        // 2 / 4
        //Enum UNO
        this.divisor1 = divisor1;
        valor = Constantes.UNO;
    }

    public PanelDivision(int divisor1, int dividendo1, int dividendo2) {
        // 2 / 43
        //Enum DOS
        valor = Constantes.DOS;
        this.divisor1 = divisor1;
        this.dividendo1 = dividendo1;
        this.dividendo2 = dividendo2;
    }

    public PanelDivision(int divisor1, int dividendo1, int dividendo2, int dividendo3) {
        // 2 / 443
        //Enum TRES
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(10, 60, 60));
        g.setColor(Color.WHITE);
        //largo - Top
        g.drawLine(50, 50, 150, 50);
        g.drawLine(50, 50, 50, 82);

        this.g = g;

        g.setFont(new Font("Tahoma", Font.BOLD, 20));
        //Cociente
        // g.drawString(Integer.toString(0), 55, 45);
        /*g.drawString(Integer.toString(1), 68, 45);
        g.drawString(Integer.toString(2), 81, 45);
        g.drawString(Integer.toString(3), 94, 45);
        g.drawString(Integer.toString(4), 107, 45);
        g.drawString(Integer.toString(5), 120, 45);
        g.drawString(Integer.toString(6), 133, 45);*/

        obtener();

    }

    private void obtener() {

        if (valor > 0) {
            switch (valor) {
                case UNO:
                    statusUno();
                    break;
                case DOS:
                    statusUno();
                    statusDos();
                    break;
                case TRES:
                    break;
            }
        }

    }

    private void statusUno() {
        //Cociente
        g.drawString(Integer.toString(0), 55, 45);
        //Dividendo
        g.setColor(new Color(51, 204, 204)); //azul
        g.drawString(Integer.toString(divisor1), 30, 76);
        //Divisor
        g.setColor(new Color(255, 255, 0)); //amarillo
        g.drawString(Integer.toString(dividendo1), 55, 76);
    }
    
    private void statusDos(){
        //Cociente
        g.setColor(new Color(255, 255, 250)); //white
        g.drawString(Integer.toString(1), 68, 45);
        //Divisor
        g.setColor(new Color(255, 255, 0)); //amarillo
        g.drawString(Integer.toString(dividendo2), 68, 76);
    }

    @Override
    public void captureDatosDivision(int[] dividendos, int[] dividendo) {
    }

}
