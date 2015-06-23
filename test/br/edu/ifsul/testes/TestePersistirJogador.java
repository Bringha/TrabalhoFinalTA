/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Jogador;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bringha
 */
public class TestePersistirJogador {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirJogador() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TrabalhoFinalTAPULocal");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void test(){
        boolean exception = false;
        try{
            Jogador obj = new Jogador();
            obj.setNome("Felipe Bastos");
            obj.setAtivo(true);
            obj.setNascimento(Calendar.getInstance());
            obj.setNroPartidas(30);
            obj.setNroGols(1);
            obj.setCartoesAmarelos(7);
            obj.setCartoesVermelhos(3);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
