package com.kodcu;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class MessageArchiver {

    @PersistenceContext
    EntityManager entityManager;

    public void save(String message) {
        try {
            entityManager.merge(new Message(message));
        } catch (Exception ex) {
            System.out.println(" -- Database error " + ex);
        }

    }


    @Override
    public String toString() {
        return "MessageArchiver{}";
    }
}
