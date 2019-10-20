/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Teste;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author chiri
 */
public class TestDao {
    private EntityManager em;
    public TestDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaTest(Teste test){
        em.persist(test);
    }
    
    public List<Teste> findTesteByClasa(String clasa){
        Query q = em.createNamedQuery("Teste.findByClasa");
        q.setParameter("clasa", clasa);
        
        List<Teste> teste = q.getResultList();
        
        if(teste.isEmpty())
            return null;
        else
            return teste;
    }
}
