/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Jogo;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author bringha
 */
@Stateful
public class JogoDAO<T> extends GenericDAO<T> implements Serializable{
    
    public JogoDAO() {
        super();
        super.setPersistentClass(Jogo.class);
        //inicializar as ordenações possíveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("arbitro", "Árbitro", "like"));
        super.getListOrder().add(
                new Order("auxiliar_um", "Primeiro Auxilar", "like"));
        super.getListOrder().add(
                new Order("auxiliar_dois", "Segundo Auxilar", "like"));
        super.getListOrder().add(
                new Order("estadio", "Estádio", "like"));
        super.getListOrder().add(
                new Order("campeonato.nome", "Campeonato", "like"));
        super.getListOrder().add(
                new Order("datahora", "Data e Hora", "like"));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializando o filtro 
        super.setFilter("");
        // inicializando o conversor da ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }   
}
