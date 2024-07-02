package com.learnersacademy.service;

import com.learnersacademy.model.SchoolClass;
import com.learnersacademy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ClassService {
    public List<SchoolClass> getAllClasses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from SchoolClass", SchoolClass.class).list();
        }
    }

    public void addSchoolClass(SchoolClass classObj) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(classObj);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
