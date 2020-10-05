/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author alexjandrohum
 */
public abstract class Product implements Cloneable{
    
    private String name;
    private int amount;
    private double price;
    
    public Product(){
        
    }
    
    public Product(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if(amount < 0){
            System.out.println("No puede asignar una cantidad negativa");
            return;
        }
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price <= 0){
            System.out.println("EL precio debe de ser mayor a 0");
            return;
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name+ "- "+this.amount+ " "+this.price;
    }
    
    public Product clone() throws CloneNotSupportedException{
        return (Product)super.clone();
        
    }
}
