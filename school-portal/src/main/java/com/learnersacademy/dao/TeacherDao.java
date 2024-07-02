package com.learnersacademy.dao;

import com.learnersacademy.model.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.learnersacademy.util.HibernateUtil;
import java.util.List;

public class TeacherDao {
	public void saveTeacher(Teacher teacher) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(teacher);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Teacher> getTeachers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Teacher", Teacher.class).list();
        }
    }
}
