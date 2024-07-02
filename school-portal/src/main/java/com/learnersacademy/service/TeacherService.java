package com.learnersacademy.service;


import java.util.List;

import com.learnersacademy.dao.TeacherDao;
import com.learnersacademy.model.Teacher;

public class TeacherService {
	private TeacherDao teacherDAO = new TeacherDao();

    public void addTeacher(Teacher teacher) {
        teacherDAO.saveTeacher(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherDAO.getAllTeachers();
    }
}
