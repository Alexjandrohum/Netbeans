/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author alexjandrohum
 */
@Stateless
@WebService(endpointInterface="beans.ServicioSumarWs")
public class SumaServicioImpl implements ServicioSumarWs{

    @Override
    public int sumar(int a, int b) {
        return a + b;
    }
    
}
