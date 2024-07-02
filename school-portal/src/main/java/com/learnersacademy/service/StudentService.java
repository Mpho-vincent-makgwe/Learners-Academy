package com.learnersacademy.service;

import java.util.List;

import com.learnersacademy.dao.StudentDao;
import com.learnersacademy.model.Student;

public class StudentService {
	private StudentDao studentDAO = new StudentDao();

    public void addStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
