/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author alexjandrohum
 */
public class VerificarPalabra {

    public static Palabras[] arreglos = {new Palabras(1, "Also", "Ademas", true), new Palabras(2, "Some", "Alguno", true), new Palabras(3, "Way", "Camino", false)};
    public static int longitudArreglo = arreglos.length + 1;
    public static int valores = (int) (Math.random() * longitudArreglo);
    public static int contador = 0;

    public static int verificar() {

        while (contador <= longitudArreglo) {
            if (arreglos[valores].leido) {
                valores = (int) (Math.random() * longitudArreglo);
                contador++;
            }
        }
        return valores;
    }

    public static void main(String... args) {
        int i = 0;
        while (i < arreglos.length) {
            System.out.println(verificar());
            i++;
        }

    }

}
