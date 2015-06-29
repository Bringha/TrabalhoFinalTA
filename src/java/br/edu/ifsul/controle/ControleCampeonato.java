/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CampeonatoDAO;
import br.edu.ifsul.dao.UsuarioDAO;
import br.edu.ifsul.modelo.Campeonato;
import br.edu.ifsul.modelo.Usuario;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author bringha
 */
@ManagedBean(name = "controleCampeonato")
@ViewScoped
public class ControleCampeonato implements Serializable{
    @EJB
    private CampeonatoDAO<Campeonato> dao;
    private Campeonato objeto;
    
    @EJB
    private UsuarioDAO<Usuario> daoUsuario;

    public ControleCampeonato() {
    }

    public CampeonatoDAO<Campeonato> getDao() {
        return dao;
    }

    public void setDao(CampeonatoDAO<Campeonato> dao) {
        this.dao = dao;
    }

    public Campeonato getObjeto() {
        return objeto;
    }

    public void setObjeto(Campeonato objeto) {
        this.objeto = objeto;
    }

    public String listar(){
        return "/restrito/campeonato/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Campeonato();
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

    public UsuarioDAO<Usuario> getDaoUsuario() {
        return daoUsuario;
    }

    public void setDaoUsuario(UsuarioDAO<Usuario> daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

}
