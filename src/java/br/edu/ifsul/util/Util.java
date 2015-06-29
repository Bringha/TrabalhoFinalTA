/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author bringha
 */
public class Util {
    public static void mensagemInformacao(String texto){
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, "");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
    
    public static void mensagemErro(String texto){
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, texto, "");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
}
