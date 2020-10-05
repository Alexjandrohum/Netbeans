/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.helper;

import beans.model.Colonia;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author alexjandrohum
 */
@RequestScoped
@Named
public class ColoniaHelper {
    
    public List<Colonia> getColonias(){
        List<Colonia> colonias = new ArrayList<>();
        
        int coloniaID = 1;
        colonias.add(new Colonia(coloniaID++, "Napoles", 3810));
        colonias.add(new Colonia(coloniaID++, "Polanco", 11530));
        colonias.add(new Colonia(coloniaID++, "Del valle centro", 3100));
        
        return colonias;
    }
    
    public int getColoniaByName(String nombreColonia){
        int coloniaId = 0;
        List<Colonia> colonias = this.getColonias();
        for(Colonia colonia : colonias){
            if(colonia.getNombreColonia().equals(nombreColonia)){
                coloniaId = colonia.getColoniaID();
                break;
            }
        }
        return coloniaId;
    }
    
    public int getColoniaByZipPostal(int postal){
        int codigoId = 0;
        List<Colonia> colonias = this.getColonias();
        for(Colonia colonia : colonias){
            if(colonia.getCodigoPostal() == postal){
                codigoId = colonia.getCodigoPostal();
                break;
            }
        }
        return codigoId;
    }
    
    public List<SelectItem> getSelectItems(){
        List<SelectItem> selectItems = new ArrayList<>();
        List<Colonia> colonias = this.getColonias();
        for(Colonia colonia : colonias){
            SelectItem selectItem  = new SelectItem(colonia.getColoniaID(), colonia.getNombreColonia());
            selectItems.add(selectItem);
        } 
        return selectItems;
    }
}
