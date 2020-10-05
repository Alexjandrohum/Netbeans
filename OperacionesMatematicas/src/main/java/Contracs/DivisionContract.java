/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contracs;

/**
 *
 * @author alexjandrohum
 */
public interface DivisionContract {

    /**
     * View
     */
    interface ViewDivision {

        //void getDatos(int[] datos);
        void getStatus(boolean enabled);

        void getDatos(int[] dividendo, int[] divisor);


    }

    /**
     * Presenter
     */
    interface PresenterDivision {

        void getDatos(int[] dividendo, int[] divisor);
        void sendDatos(int[] dividendo, int[] divisor);
        
    }

    /**
     * Modelo
     */
    interface ModeloDivision {

        void captureDatosDivision(int[] dividendos, int[] dividendo);
    }

}
