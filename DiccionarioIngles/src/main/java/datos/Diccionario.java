/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.Scanner;

/**
 *
 * @author alexjandrohum
 */
public class Diccionario {

    public static Scanner sc = new Scanner(System.in);

    public static int valores = (int) (Math.random() * 3);
    public static Palabras[] arreglos = {new Palabras(1, "Also", "Ademas", false), new Palabras(2, "Some", "Alguno", false), new Palabras(3, "Way", "Camino", false)};

    public static void main(String[] args) {
        runProgram();
    }

    public static void runProgram() {
        valores = (int) (Math.random() * 3);
        getMenu();

        System.out.print("Ingresa una opcion: ");
        validarOpcion(getOpcion());

    }

    public static void getMenu() {
        System.out.println("## MENU DE OPCIONES ##");
        System.out.println("1.- Ver palabra");
        System.out.println("2.- Salir");

    }

    public static int getOpcion() {
        int opcion = sc.nextInt();
        return opcion;
    }

    public static String getSign() {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Significado: ");
        String re = sc2.nextLine();
        return re;
    }

    public static void getOperacion() {
        System.out.println("Palabra: " + arreglos[valores].nombre);
        if ((arreglos[valores].significado).equals(getSign())) {
            System.out.println("Palabra correcta");
            runProgram();
        } else {
            System.out.println("Palabra incorrecta");
            runProgram();
        }
    }

    public static void validarOpcion(int opcion) {
        if (opcion == 1) {
            getOperacion();
        }
    }

}
