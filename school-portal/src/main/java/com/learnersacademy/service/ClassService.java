package com.learnersacademy.service;

import java.util.List;

import com.learnersacademy.dao.ClassDao;
import com.learnersacademy.model.Class;

public class ClassService {
    private ClassDao classDAO = new ClassDao();

    public void addClass(Class clazz) {
        classDAO.saveClass(clazz);
    }

    public List<Class> getAllClasses() {
        return classDAO.getAllClasses();
    }
}
