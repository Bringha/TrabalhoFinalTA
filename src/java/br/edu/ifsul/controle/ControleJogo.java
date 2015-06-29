/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CampeonatoDAO;
import br.edu.ifsul.dao.JogoDAO;
import br.edu.ifsul.modelo.Campeonato;
import br.edu.ifsul.modelo.Jogo;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author bringha
 */
@ManagedBean(name = "controleJogo")
@ViewScoped
public class ControleJogo implements Serializable{
    @EJB
    private JogoDAO<Jogo> dao;
    private Jogo objeto;

    @EJB
    private CampeonatoDAO<Campeonato> daoCampeonato;
    
    public ControleJogo() {
    }

    public JogoDAO<Jogo> getDao() {
        return dao;
    }

    public void setDao(JogoDAO<Jogo> dao) {
        this.dao = dao;
    }

    public Jogo getObjeto() {
        return objeto;
    }

    public void setObjeto(Jogo objeto) {
        this.objeto = objeto;
    }

    public String listar(){
        return "/restrito/jogo/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Jogo();
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

    public CampeonatoDAO<Campeonato> getDaoCampeonato() {
        return daoCampeonato;
    }

    public void setDaoCampeonato(CampeonatoDAO<Campeonato> daoCampeonato) {
        this.daoCampeonato = daoCampeonato;
    }

}
