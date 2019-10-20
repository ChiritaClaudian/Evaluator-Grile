/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import db.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author chiri
 */
public class LoginService {
    private EntityManagerFactory emf;
    
    private LoginService(){
        emf = Persistence.createEntityManagerFactory("EvaluatorTesteGrilaPU");
    }
    
    private static final class SingletonHolder{
        private static final LoginService SINGLETON = new LoginService();
    }
    
    public static LoginService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public User login(String email, String password){
        EntityManager em = emf.createEntityManager();
        
        try{
            UserDao userDao = new UserDao(em);
            
            User user = userDao.findUserByEmail(email);
            if(user != null){
                if(user.getPassword().equals(password))
                    return user;
            }
        }finally{
            if(em != null){
                em.close();
            }
        }
        return null;
    }
    
    public boolean register(String nume, String prenume, String email,String clasa, String password){
        EntityManager em = emf.createEntityManager();
        
        try{
            UserDao userDao = new UserDao(em);
            User user = userDao.findUserByEmail(email);
            
            if(user == null){
                em.getTransaction().begin();
                user = new User();
                user.setNume(nume);
                user.setPrenume(prenume);
                user.setEmail(email);
                user.setUsername(clasa);
                user.setPassword(password);
                userDao.adaugaUser(user);
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
