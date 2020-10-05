/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import objects.Arroz;
import objects.Carne;
import objects.Patata;
import objects.Product;
import storage.Database;
import views.View;

/**
 *
 * @author alexjandrohum
 */
public class Register {

    private static Database database;

    public Register() {
        database = new Database();
    }

    //inicia el proceso de la registradora
    public  void register() {
        
        
        int option;
        do{
            View.showHeaderPrincipal();
            View.showMenuPrincipal();
            View.showGetOption();
            option = View.getOption();
            
            switch(option){
                case 1:
                    buy();
                    break;
                case 2:
                    sale();
                    break;
                case 3:
                    showStock();
                    break;
                case 4:
                    showPurchases();
                    break;
                case 5:
                    showSales();
                    break;
                case 6:
                    View.showSaludo();
                    System.exit(0);
                    break;
                default:
                    View.showInvalidOption();
            }
            
        }while(option >= 1 || option <= 6);
        
    }
    
    //Se encargará de mostrar el menú de compras 
    // y obtener la opción deseada por el usuario
    private void buy(){
        View.showBuyHeader();
        
        int option;
        do{
            View.showGetOption();
            option = View.getOption();
            if (option >= 1 && option <= 3){
                buyProducts(option);
            }else if(option == 4){
                View.showGetBack("Compras");
                return;
            }else{
                View.showInvalidOption();
            }
            
        }while(option < 1 || option > 6);
    }

    
    private void buyProducts(int option){
        Product product = null;
        switch(option){
            case 1:
                product = new Patata("Sabanera");
                break;
            case 2:
                product = new Arroz("Una marca");
                break;
            case 3:
                product = new Carne("Lomo fino");
                break;
            default:
                View.showInvalidOption();
        }
        View.showgetAmount();
        int amount = View.getAmount();
        View.showGetPrice();
        double price = View.getPrice();
        product.setAmount(amount);
        product.setPrice(price);
        database.comprar(product);
    }
    
    private void showStock(){
        View.showStockHeader();
        View.showItemStocks(database.getAll());
        View.showAnyKey();
        View.getOption();
    }
    
    private static void sale(){
        View.showSaleHeader();
        
        int option;
        do{
            View.showGetOption();
            option = View.getOption();
            if (option >= 1 && option <= 3){
                saleProducts(option);
            }else if(option == 4){
                View.showGetBack("Ventas");
                return;
            }else{
                View.showInvalidOption();
            }
            
        }while(option < 1 || option > 6);
    }
    
    private static void saleProducts(int option){
        Product product = null;
        
        if(option < 1 || option > 3){
            View.showInvalidOption();
            return;
        }
        
        product = database.getByIndex(option -1);      
        View.showgetAmount();
        int amount = View.getAmount();
        if(product.getAmount() < amount){
            View.showInvalidAmount();
            return;
        }
      
        product.setAmount(amount);
        database.venta(product);
    }
    
    private static void showPurchases(){
        List<Product> listado = database.getPurchases();
        View.showByListHeader();
        View.showPurchases(listado);
    }
    
    private static void showSales(){
        List<Product> listado = database.getSales();
        View.showSalesListHeader();
        View.showSales(listado);
    }
}
