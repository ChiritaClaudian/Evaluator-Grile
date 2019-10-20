/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TestDao;
import db.Teste;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author chiri
 */
public class TesteService {
    private EntityManagerFactory emf;
    
    private TesteService(){
        emf = Persistence.createEntityManagerFactory("EvaluatorTesteGrilaPU");
    }
    
    private static final class SingletonHolder{
        private static final TesteService SINGLETON = new TesteService();
    }
    
    public static TesteService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public boolean adaugaTest(String nume, String prenume, String clasa, String capitol, int nota){
        EntityManager em = emf.createEntityManager();
        TestDao testDao = new TestDao(em);
        Teste test;
        try{
            em.getTransaction().begin();
            test = new Teste();
            test.setCapitol(capitol);
            test.setClasa(clasa);
            test.setNota(nota);
            test.setNume(nume);
            test.setPrenume(prenume);
            testDao.adaugaTest(test);
            em.getTransaction().commit();
        }finally{
            if(em != null)
                em.close();
        }
        return false;
    }
    public List<Teste> getTesteByClasa(String clasa){
        EntityManager em = emf.createEntityManager();
        try{
            TestDao testDao = new TestDao(em);
            
            List<Teste> teste = testDao.findTesteByClasa(clasa);
            
            if(!teste.isEmpty())
                return teste;
        }finally{
            if(em != null)
                em.close();
        }
        return null;
    }
}
