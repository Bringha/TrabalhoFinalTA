/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author bringha
 */
@Stateful
public class UsuarioDAO<T> extends GenericDAO<T> implements Serializable{
    
    public UsuarioDAO() {
        super();
        super.setPersistentClass(Usuario.class);
        //inicializar as ordenações possíveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("nome", "Nome", "like"));
        super.getListOrder().add(
                new Order("apelido", "Apelido", "like"));
        super.getListOrder().add(
                new Order("ativo", "Ativo", "like"));
        super.getListOrder().add(
                new Order("administrador", "Administrador", "like"));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializando o filtro 
        super.setFilter("");
        // inicializando o conversor da ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }   
}
