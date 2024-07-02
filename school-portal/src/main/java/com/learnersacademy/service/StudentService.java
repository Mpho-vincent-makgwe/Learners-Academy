package com.learnersacademy.service;

import com.learnersacademy.dao.StudentDao;
import com.learnersacademy.model.Student;

import java.util.List;

public class StudentService {
	private StudentDao studentDAO = new StudentDao();

    public void addStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    public List<com.learnersacademy.entities.Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
