package com.learnersacademy.dao;

import com.learnersacademy.model.Class;
import com.learnersacademy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClassDao {
    public void saveClass(Class clazz) {
        Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                    transaction = session.beginTransaction();
                    session.save(clazz);
                    transaction.commit();
                } catch (Exception e) {
                    if (transaction != null) {
                        transaction.rollback();
                    }
                    e.printStackTrace();
                }
            }

            public List<Class> getAllClasses() {
                try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                    return session.createQuery("from Class", Class.class).list();
                }
            }
        }
