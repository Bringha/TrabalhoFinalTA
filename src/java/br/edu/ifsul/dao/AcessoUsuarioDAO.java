/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.AcessoUsuario;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author bringha
 */
@Stateful
public class AcessoUsuarioDAO<T> extends GenericDAO<T> implements Serializable{
    
    public AcessoUsuarioDAO() {
        super();
        super.setPersistentClass(AcessoUsuario.class);
        //inicializar as ordenações possíveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("datahora", "Data e Hora", "="));
        super.getListOrder().add(
                new Order("pessoa.nome", "Pessoa", "like"));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializando o filtro 
        super.setFilter("");
        // inicializando o conversor da ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }
}
