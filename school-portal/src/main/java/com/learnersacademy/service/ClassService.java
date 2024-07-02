package com.learnersacademy.service;

import com.learnersacademy.dao.ClassDao;
import com.learnersacademy.model.Class;
import java.util.List;

public class ClassService {
    private ClassDao classDAO = new ClassDao();

    public void addClass(Class clazz) {
        classDAO.saveClass(clazz);
    }

    public List<Class> getAllClasses() {
        return classDAO.getClasses();
    }
}
