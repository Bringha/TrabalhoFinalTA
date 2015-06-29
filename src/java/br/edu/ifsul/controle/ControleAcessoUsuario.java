/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AcessoUsuarioDAO;
import br.edu.ifsul.modelo.AcessoUsuario;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author bringha
 */
@ManagedBean(name = "controleAcessoUsuario")
@ViewScoped
public class ControleAcessoUsuario implements Serializable{
    @EJB
    private AcessoUsuarioDAO<AcessoUsuario> dao;
    private AcessoUsuario objeto;

    public ControleAcessoUsuario() {
    }

    public AcessoUsuarioDAO<AcessoUsuario> getDao() {
        return dao;
    }

    public void setDao(AcessoUsuarioDAO<AcessoUsuario> dao) {
        this.dao = dao;
    }

    public AcessoUsuario getObjeto() {
        return objeto;
    }

    public void setObjeto(AcessoUsuario objeto) {
        this.objeto = objeto;
    }
    
    public String listar(){
        return "/restrito/acessos/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new AcessoUsuario();
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
