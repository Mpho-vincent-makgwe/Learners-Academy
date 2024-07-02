package com.learnersacademy.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.learnersacademy.entities.Student;
import com.learnersacademy.util.HibernateUtil;

public class StudentDao {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void saveStudent(com.learnersacademy.model.Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
