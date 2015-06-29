/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pessoa;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.persistence.Query;

/**
 *
 * @author bringha
 */
@Stateful
public class LoginDAO<T> extends GenericDAO<Pessoa> implements Serializable{
    
    public LoginDAO(){
        super();
        super.setPersistentClass(Pessoa.class);
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("nome", "Nome", "like"));
        super.getListOrder().add(
                new Order("apelido", "Apelido", "like"));
        super.setCurrentOrder(super.getListOrder().get(1));
        super.setFilter("");
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }
    
    @Override
    public Pessoa getObjectById(Integer id) throws Exception{
       Pessoa obj = super.getEm().find(Pessoa.class, id);
       obj.getAcessos().size();
        return obj;
    }
    
    public boolean login(String usuario, String senha) {
        Query query = super.getEm().createQuery(
                "from Pessoa where upper(apelido) = :usuario and "
                + " upper(senha) = :senha and ativo = true");
        query.setParameter("usuario", usuario.toUpperCase());
        query.setParameter("senha", senha.toUpperCase());
        if (!query.getResultList().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    public Pessoa localizaUsuarioPorNome(String usuario){
        Query query = super.getEm().createQuery(
                "from Pessoa where upper(apelido) = :usuario");
        query.setParameter("usuario", usuario.toUpperCase());
        Pessoa obj = (Pessoa) query.getSingleResult();
        obj.getAcessos().size();
        return obj;
    }
}
