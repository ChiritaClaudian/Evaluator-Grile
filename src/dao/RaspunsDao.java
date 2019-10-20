/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Intrebari;
import db.Raspunsuri;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author chiri
 */
public class RaspunsDao {
    private EntityManager em;
    
    public RaspunsDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaRaspuns(Raspunsuri raspuns){
        em.persist(raspuns);
    }
    
    public List<Raspunsuri> findRaspunsByIdIntrebare(int idIntrebare){
        Query q = em.createNamedQuery("Raspunsuri.findByIdIntrebare");
        q.setParameter("idIntrebare", idIntrebare);
        
        List<Raspunsuri> raspunsuri = q.getResultList();
        
        if(raspunsuri.isEmpty())
            return null;
        else 
            return raspunsuri;
    }
    
    public Raspunsuri findRaspunsByTextRaspuns(String textRaspuns){
        Query q = em.createNamedQuery("Raspunsuri.findByTextRaspuns");
        q.setParameter("textRaspuns", textRaspuns);
        
        List<Raspunsuri> raspunsuri = q.getResultList();
        if(raspunsuri.isEmpty())
            return null;
        else
            return raspunsuri.get(0);
    }
}
