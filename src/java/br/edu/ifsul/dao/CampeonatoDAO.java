/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Campeonato;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author bringha
 */
@Stateful
public class CampeonatoDAO<T> extends GenericDAO<T> implements Serializable{
    
    public CampeonatoDAO() {
        super();
        super.setPersistentClass(Campeonato.class);
        //inicializar as ordenações possíveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("nome", "Nome", "like"));
        super.getListOrder().add(
                new Order("artilheiro.nome", "Goleador", "like"));
        super.getListOrder().add(
                new Order("campeao.nome", "Campeão", "like"));
        super.getListOrder().add(
                new Order("vice.nome", "Vice-Campeão", "like"));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializando o filtro 
        super.setFilter("");
        // inicializando o conversor da ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }   
}
