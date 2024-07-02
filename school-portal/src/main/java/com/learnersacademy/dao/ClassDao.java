package com.learnersacademy.dao;

import com.learnersacademy.model.SchoolClass;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.learnersacademy.util.HibernateUtil;
import java.util.List;

public class ClassDao {
    public void saveClass(SchoolClass clazz) {
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

    public List<SchoolClass> getClasses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Class", SchoolClass.class).list();
        }
    }
}
