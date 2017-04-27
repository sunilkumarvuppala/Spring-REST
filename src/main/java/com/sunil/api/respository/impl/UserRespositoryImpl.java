package com.sunil.api.respository.impl;

import com.sunil.api.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.sunil.api.respository.UserRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class UserRespositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
        return query.getResultList();
    }

    @Override
    public User findEmail(String email) {
        TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
        query.setParameter("pEmail", email);
        List<User> users = query.getResultList();
        if (!(users.isEmpty())) {
            return users.get(0);
        } else {
            return null;
        }
    }

    @Override
    public User findOne(String id) {
        return em.find(User.class, id);
    }

    @Override
    public User create(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public User update(User user) {
        return em.merge(user);
    }

    @Override
    public void delete(User user) {
        em.remove(user);
    }

}
