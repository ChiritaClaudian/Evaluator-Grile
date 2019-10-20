/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author chiri
 */
public class UserDao {
    private EntityManager em;
    
    public UserDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaUser(User user){
        em.persist(user);
    }
    
    public User findUserByEmail(String email){
        Query q = em.createNamedQuery("User.findByEmail");
        q.setParameter("email", email);
        
        List<User> users = q.getResultList();
        
        if(users.isEmpty())
            return null;
        else 
            return users.get(0);
    }
}
