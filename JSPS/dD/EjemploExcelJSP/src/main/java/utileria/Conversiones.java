/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utileria;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alexjandrohum
 */
public class Conversiones {
    
    private static final String FORMATO_FECHA = "dd-MM";
    
    public static String format(Date date){
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(date);
        
    }
    
    public static String format(String date){
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(date);
        
    }
    
}
