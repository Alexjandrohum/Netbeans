/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclientews;

import clientews.servicio.ServicioSumarWs;
import clientews.servicio.SumaServicioImplService;

/**
 *
 * @author alexjandrohum
 */
public class TestServicioSumaWs {
    
    public static void main(String[] args) {
        ServicioSumarWs servicioSumar = new SumaServicioImplService().getSumaServicioImplPort();
        
        System.out.println("Ejecutando servicios sumar ws");
        int a = 6;
        int b = 3;
        
        int resultado = servicioSumar.sumar(a, b);
        System.out.println("Resultado de la suma: "+resultado);
        System.out.println("Fin de servicio");
    }
    
}
