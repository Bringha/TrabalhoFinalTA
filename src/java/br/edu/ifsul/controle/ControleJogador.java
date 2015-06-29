/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.JogadorDAO;
import br.edu.ifsul.dao.TimesDAO;
import br.edu.ifsul.modelo.Jogador;
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
@ManagedBean(name = "controleJogador")
@ViewScoped
public class ControleJogador implements Serializable{
    @EJB
    private JogadorDAO<Jogador> dao;
    private Jogador objeto;
    
    @EJB
    private TimesDAO<Times> daoTime;

    public ControleJogador() {
    }

    public JogadorDAO<Jogador> getDao() {
        return dao;
    }

    public void setDao(JogadorDAO<Jogador> dao) {
        this.dao = dao;
    }

    public Jogador getObjeto() {
        return objeto;
    }

    public void setObjeto(Jogador objeto) {
        this.objeto = objeto;
    }

    public String listar(){
        return "/restrito/jogador/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Jogador();
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

    public TimesDAO<Times> getDaoTime() {
        return daoTime;
    }

    public void setDaoTime(TimesDAO<Times> daoTime) {
        this.daoTime = daoTime;
    }

}
