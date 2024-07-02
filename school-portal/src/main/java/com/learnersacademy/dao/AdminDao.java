package com.learnersacademy.dao;

import com.learnersacademy.model.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.learnersacademy.util.HibernateUtil;
import java.util.List;

public class AdminDao {
    public void saveAdmin(Admin admin) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(admin);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Admin> getAdmins() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Admin", Admin.class).list();
        }
    }
}
