/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.List;
import java.util.Scanner;
import objects.Product;

/**
 *
 * @author alexjandrohum
 */
public class View {

    public static void showHeaderPrincipal() {
        System.out.println("*****************************************");
        System.out.println("* BIENVENIDO A LA CAJA REGISTRADORA *");
        System.out.println("*****************************************");
    }

    public static void showMenuPrincipal() {
        System.out.println("1. Comprar");
        System.out.println("2. Vender");
        System.out.println("3. Inventario");
        System.out.println("4. Compras");
        System.out.println("5. Ventas");
        System.out.println("6. Salir");

    }

    public static void showGetOption() {
        System.out.print("Digite la opción: ");
    }

    public static void showgetAmount() {
        System.out.print("Digite la cantidad: ");
    }

    public static void showGetPrice() {
        System.out.print("Digite el precio: ");
    }

    public static int getOption() {
        Scanner teclado = new Scanner(System.in);

        return teclado.nextInt();
    }

    public static int getAmount() {
        Scanner teclado = new Scanner(System.in);

        return teclado.nextInt();
    }

    public static double getPrice() {
        Scanner teclado = new Scanner(System.in);

        return teclado.nextDouble();
    }

    public static void showBuyHeader() {
        System.out.println("*****************************************");
        System.out.println("*          MENÚ DE COMPRAS              *");
        System.out.println("*****************************************");
        showItemsMenu();
    }

    public static void showSaleHeader() {
        System.out.println("*****************************************");
        System.out.println("*          MENÚ DE VENTAS               *");
        System.out.println("*****************************************");
        showItemsMenu();
    }

    public static void showItemsHeader() {
        System.out.println("==========================================");
        System.out.println("* PRODUCTO  | Cantidad | Vr Unitario | Vr Total *");
        System.out.println("==========================================");
    }

    public static void showStockHeader() {
        System.out.println("*****************************************");
        System.out.println("*          INVENTARIO                   *");
        System.out.println("*****************************************");
        showItemsHeader();
    }

    public static void showByListHeader() {
        System.out.println("*****************************************");
        System.out.println("*          COMPRAS                   *");
        System.out.println("*****************************************");
        showItemsHeader();
    }

    public static void showSalesListHeader() {
        System.out.println("*****************************************");
        System.out.println("*          VENTAS                   *");
        System.out.println("*****************************************");
        showItemsHeader();
    }

    public static void showItemsMenu() {
        System.out.println("1. Patatas");
        System.out.println("2. Arroz");
        System.out.println("3. Carne");
        System.out.println("3. Volver");
    }

    public static void showSaludo() {
        System.out.println("Gracias por usar nuestra APP");
    }

    public static void showInvalidOption() {
        System.out.println("Opción no válida");
    }

    public static void showGetBack(String name) {
        System.out.println("Saliendo del módulo " + name);
    }

    public static void showAnyKey() {
        System.out.println("Digite cualquier número para continuar");
    }

    public static void showItemStocks(Product[] products) {
        for (Product v : products) {
            System.out.println("\t\t* " + v.getName() + "\t| " + v.getAmount() + "\t\t| " + v.getPrice() + "\t\t\t| " + v.getAmount() * v.getPrice() + "\t\t*");
        }
    }

    public static void showInvalidAmount() {
        System.out.println("La cantidad no es válida");
    }

    public static void showPurchases(List<Product> listado) {
        for (Product v : listado) {
            System.out.println("\t\t* " + v.getName() + "\t| " + v.getAmount() + "\t\t| " + v.getPrice() + "\t\t\t| " + v.getAmount() * v.getPrice() + "\t\t*");

        }

    }

    public static void showSales(List<Product> listado) {
        for (Product v : listado) {
            System.out.println("\t\t* " + v.getName() + "\t| " + v.getAmount() + "\t\t| " + v.getPrice() + "\t\t\t| " + v.getAmount() * v.getPrice() * 1.25 + "\t\t*");
        }
    }
}
