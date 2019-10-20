/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IntrebareDao;
import db.Intrebari;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author chiri
 */
public class IntrebariService {
     private EntityManagerFactory emf;
    
    private IntrebariService(){
        emf = Persistence.createEntityManagerFactory("EvaluatorTesteGrilaPU");
    }
    
    private static final class SingletonHolder{
        private static final IntrebariService SINGLETON = new IntrebariService();
    }
    
    public static IntrebariService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public Intrebari getIntrebare(String intrebare_text){
        EntityManager em = emf.createEntityManager();
        
        try{
            IntrebareDao intrebareDao = new IntrebareDao(em);
            
            Intrebari intrebare = intrebareDao.findIntrebareByText(intrebare_text);
            if(intrebare != null){
                return intrebare;
            }
        }finally{
            if(em != null){
                em.close();
            }
        }
        return null;
    }
    
    public List<String> getIntrebariByClasa(String clasa){
        EntityManager em = emf.createEntityManager();
        try{
            IntrebareDao intrebareDao = new IntrebareDao(em);
            
            List<Intrebari> intrebari = intrebareDao.findIntrebareByClasa(clasa);
            List<String> categorii = new ArrayList<String>();
            for(Intrebari intrebare : intrebari){
                if(!categorii.contains(intrebare.getCapitol()))
                    categorii.add(intrebare.getCapitol());
            }
            if(!intrebari.isEmpty())
                return categorii;
        }finally{
            if(em != null)
                em.close();
        }
        return null;
    }
      public List<Intrebari> getIntrebariByCapitol(String capitol){
        EntityManager em = emf.createEntityManager();
        try{
            IntrebareDao intrebareDao = new IntrebareDao(em);
            
            List<Intrebari> intrebari = intrebareDao.findIntrebareByCapitol(capitol);
            if(!intrebari.isEmpty())
                return intrebari;
        }finally{
            if(em != null)
                em.close();
        }
        return null;
    }
    public boolean adaugareIntrebare(String textIntrebare, String clasa, String capitol){
        EntityManager em = emf.createEntityManager();
        
        try{
            IntrebareDao intrebareDao = new IntrebareDao(em);
            Intrebari intrebare = intrebareDao.findIntrebareByText(textIntrebare);
            
            if(intrebare == null){
                em.getTransaction().begin();
                intrebare = new Intrebari();
                intrebare.setTextIntrebare(textIntrebare);
                intrebare.setClasa(clasa);
                intrebare.setCapitol(capitol);
                intrebareDao.adaugaIntrebare(intrebare);
                em.getTransaction().commit();
                return true;
            }
        }finally{
            if(em != null)
                em.close();
        }
        return false;
    }
}
