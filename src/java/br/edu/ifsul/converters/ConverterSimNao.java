/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.converters;

import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bringha
 */
@FacesConverter(value = "converterSimNao")
public class ConverterSimNao implements Serializable, Converter{
    
    @PersistenceContext(unitName = "TrabalhoFinalTAPU")
    EntityManager em;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try{
            if(string.equals("Sim")){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Boolean obj = (Boolean) o;
        if(obj){
            return "Sim";
        }else{
            return "Não";
        }
    }
}
