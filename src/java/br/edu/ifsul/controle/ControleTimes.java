/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.TimesDAO;
import br.edu.ifsul.modelo.Times;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author bringha
 */
@ManagedBean(name = "controleTime")
@ViewScoped
public class ControleTimes implements Serializable{
    @EJB
    private TimesDAO<Times> dao;
    private Times objeto;

    public ControleTimes() {
    }

    public TimesDAO<Times> getDao() {
        return dao;
    }

    public void setDao(TimesDAO<Times> dao) {
        this.dao = dao;
    }

    public Times getObjeto() {
        return objeto;
    }

    public void setObjeto(Times objeto) {
        this.objeto = objeto;
    }

    public String listar(){
        return "/restrito/time/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Times();
    }
    
    public void salvar(){
        try{
            if(objeto.getId() == null){
                dao.persist(objeto);
            }else{
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        }catch(Exception e){
            Util.mensagemErro("Erro ao persistir o objeto: " + e.getMessage());
        }
    }
    
    public void editar(Integer id){
        try{
            objeto = dao.getObjectById(id);
        }catch(Exception e){
            Util.mensagemErro("Erro ao recuperar o objeto: " + e.getMessage());
        }
    }
    
    public void remover(Integer id){
        try{
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
        }catch(Exception e){
            Util.mensagemErro("Erro ao remover o objeto: " + e.getMessage());
        }
    }

}
