/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IntrebareDao;
import dao.RaspunsDao;
import db.Intrebari;
import db.Raspunsuri;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author chiri
 */
public class RaspunsuriService {
     private EntityManagerFactory emf;
    
    private RaspunsuriService(){
        emf = Persistence.createEntityManagerFactory("EvaluatorTesteGrilaPU");
    }
    
    private static final class SingletonHolder{
        private static final RaspunsuriService SINGLETON = new RaspunsuriService();
    }
    
    public static RaspunsuriService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public List<Raspunsuri> getRaspunsuri(int idIntrebare){
        EntityManager em = emf.createEntityManager();
        
        try{
            RaspunsDao raspunsDao = new RaspunsDao(em);
            
            List<Raspunsuri> raspunsuri = raspunsDao.findRaspunsByIdIntrebare(idIntrebare);
            if(raspunsuri != null){
                return raspunsuri;
            }
        }finally{
            if(em != null){
                em.close();
            }
        }
        return null;
    }
    
    public boolean adaugareRaspuns(int idIntrebare, String textRaspuns, int isCorrect){
        EntityManager em = emf.createEntityManager();
        
        try{
            RaspunsDao raspunsDao = new RaspunsDao(em);
            Raspunsuri raspuns = raspunsDao.findRaspunsByTextRaspuns(textRaspuns);
            
            if(raspuns == null){
                em.getTransaction().begin();
                raspuns = new Raspunsuri();
                raspuns.setTextRaspuns(textRaspuns);
                raspuns.setIdIntrebare(idIntrebare);
                raspuns.setIsCorrect(isCorrect);
                raspunsDao.adaugaRaspuns(raspuns);
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
