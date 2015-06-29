/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Jogador;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author bringha
 */
@Stateful
public class JogadorDAO<T> extends GenericDAO<T> implements Serializable{
    
    public JogadorDAO() {
        super();
        super.setPersistentClass(Jogador.class);
        //inicializar as ordenações possíveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("nome", "Nome", "like"));
        super.getListOrder().add(
                new Order("time.nome", "Time", "like"));
        super.getListOrder().add(
                new Order("ativo", "Ativo", "like"));
        super.getListOrder().add(
                new Order("nro_partidas", "Partidas", "like"));
        super.getListOrder().add(
                new Order("gols", "Gols", "like"));
        super.getListOrder().add(
                new Order("amarelos", "Amarelos", "like"));
        super.getListOrder().add(
                new Order("vermelhos", "Vermelhos", "like"));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializando o filtro 
        super.setFilter("");
        // inicializando o conversor da ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }   
}
