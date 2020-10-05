/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.util.ArrayList;
import java.util.List;
import objects.Arroz;
import objects.Carne;
import objects.Patata;
import objects.Product;

/**
 *
 * @author alexjandrohum
 */
public class Database {
    
    private Product[] products;
    private List<Product> ourchases;
    private List<Product> sales;
    
    public Database(){
        products = new Product[3];
        Product patata = new Patata("Sabanera");
        Product arroz = new Arroz("Una marca");
        Product carne = new Carne("Lomo fino");
        
        products[0] = patata;
        products[1] = arroz;
        products[2] = carne;
        
        ourchases = new ArrayList<>();
        sales = new ArrayList<>();
    }
    
    public Product getByIndex(int i){
        
        if(i < 0 || i > 2){
            System.out.println("Indice no válido");
            return null;
        }
        
        Product resultado = null;
        
        try{
            resultado =  products[i].clone();
        }catch(CloneNotSupportedException e){
            System.out.println(e);
        }
        
        return resultado;
        
    }
    
    public Product[] getAll(){
        
        Product[] result = new Product[3];
        try{
            
            result[0] = products[0].clone();
            result[1] = products[1].clone();
            result[2] = products[2].clone();
            
        }catch(CloneNotSupportedException e){
            System.out.println(e);
        }
        return products;
    }
    
    public void comprar(Product producto){
        Product temp;
        switch(producto.getClass().getSimpleName()){
            case "Patata":
                temp = products[0];
                break;
            case "Arroz":
                temp = products[1];
                break;
            case "Carne":
                temp = products[2];
                break;
            default:
                System.out.println("No válido");
                return;
        }
        
        temp.setAmount(temp.getAmount() + producto.getAmount());
        temp.setPrice(producto.getPrice());
        ourchases.add(producto);
    }
    
    public void venta(Product producto){
        Product temp;
        switch(producto.getClass().getSimpleName()){
            case "Patata":
                temp = products[0];
                break;
            case "Arroz":
                temp = products[1];
                break;
            case "Carne":
                temp = products[2];
                break;
            default:
                System.out.println("No válido");
                return;
        }
        
        temp.setAmount(temp.getAmount() - producto.getAmount());
        producto.setPrice(temp.getPrice() * 1.25);
        sales.add(producto);
    }
    
    public List<Product> getPurchases(){
        return ourchases;
    }
    
    public List<Product> getSales(){
        return sales;
    }
}
