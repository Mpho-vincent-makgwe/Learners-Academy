package com.learnersacademy.util;

import com.learnersacademy.entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DataLoader {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Student student1 = new Student();
        student1.setName("John Doe");
        student1.setEmail("john.doe@example.com");

        Student student2 = new Student();
        student2.setName("Jane Smith");
        student2.setEmail("jane.smith@example.com");

        session.save(student1);
        session.save(student2);

        transaction.commit();
        session.close();
    }
}
