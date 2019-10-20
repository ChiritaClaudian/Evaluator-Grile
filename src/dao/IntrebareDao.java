/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Intrebari;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author chiri
 */
public class IntrebareDao {
    private EntityManager em;
    
    public IntrebareDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaIntrebare(Intrebari intrebare){
        em.persist(intrebare);
    }
    
    public Intrebari findIntrebareByText(String text_intrebare){
        Query q = em.createNamedQuery("Intrebari.findByText");
        q.setParameter("textIntrebare", text_intrebare);
        
        List<Intrebari> intrebari = q.getResultList();
        
        if(intrebari.isEmpty())
            return null;
        else 
            return intrebari.get(0);
    }
    
    public List<Intrebari> findIntrebareByCapitol(String capitol){
        Query q = em.createNamedQuery("Intrebari.findByCapitol");
        q.setParameter("capitol", capitol);
        
        List<Intrebari> intrebari = q.getResultList();
        
        if(intrebari.isEmpty())
            return null;
        else
            return intrebari;
    }
    
    public List<Intrebari> findIntrebareByClasa(String clasa){
        Query q = em.createNamedQuery("Intrebari.findByClasa");
        q.setParameter("clasa", clasa);
        
        List<Intrebari> intrebari = q.getResultList();
         if(intrebari.isEmpty())
            return null;
        else
            return intrebari;
    }
}
