/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.LoginDAO;
import br.edu.ifsul.modelo.AcessoUsuario;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author bringha
 */
@ManagedBean(name = "controleLogin")
@SessionScoped
public class ControleLogin implements Serializable{
    
    @EJB
    private LoginDAO<Pessoa> dao;    
    private Pessoa usuarioLogado;
    private String usuario;
    private String senha;
    
    public ControleLogin() {
    }
    
    public String principal(){
        return "/index?faces-redirect=true";
    }

    public String paginaLogin(){
        return "/publico/login?faces-redirect=true";
    }
    
    public String efetuarLogin(){
        // testa se o login e senha existem
        if(dao.login(usuario, senha)){
            // recupera o usuario pelo nome
            usuarioLogado = dao.localizaUsuarioPorNome(usuario);
            // acesso a requisição para recuperar o endereço remoto do login
            FacesContext context = FacesContext.getCurrentInstance();
            javax.servlet.http.HttpServletRequest request =
                    (javax.servlet.http.HttpServletRequest) context.getExternalContext().getRequest();
            // criação de um novo acesso com o endereço remoto do login
            AcessoUsuario acesso = new AcessoUsuario();
            acesso.setDataHora(Calendar.getInstance());
            usuarioLogado.adicionarAcesso(acesso);
            try {
                // salvo o usuario e seu acesso
                dao.merge(usuarioLogado);
            } catch (Exception e){
                Util.mensagemErro("Erro ao salvar acesso do usuário");
            }
            Util.mensagemInformacao("Login efetuado com sucesso");
            return "/restrito/interna";
        } else {
            Util.mensagemErro("Usuário ou senha inválidos");
            return "/publico/login";
        }
    }
    
    public String efetuarLogOut(){
        usuarioLogado = null;
        Util.mensagemInformacao("LogOut efetuado com sucesso!");
        return "/index";
    }

    public LoginDAO<Pessoa> getDao() {
        return dao;
    }

    public void setDao(LoginDAO<Pessoa> dao) {
        this.dao = dao;
    }

    public Pessoa getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Pessoa usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
