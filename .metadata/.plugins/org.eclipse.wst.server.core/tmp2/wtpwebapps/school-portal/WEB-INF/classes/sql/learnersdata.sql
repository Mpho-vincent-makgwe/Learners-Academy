-- Create the database
CREATE DATABASE IF NOT EXISTS learnersacademy;
USE learnersacademy;

-- Drop existing tables if they exist
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS teachers;
DROP TABLE IF EXISTS classes;
DROP TABLE IF EXISTS subjects;
DROP TABLE IF EXISTS class_subject;
DROP TABLE IF EXISTS teacher_class;
DROP TABLE IF EXISTS admins;

-- Create the 'classes' table
CREATE TABLE classes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- Create the 'subjects' table
CREATE TABLE subjects (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- Create the 'students' table
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    class_id INT,
    FOREIGN KEY (class_id) REFERENCES classes(id)
);

-- Create the 'teachers' table
CREATE TABLE teachers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Create a junction table 'class_subject' to establish many-to-many relationship between classes and subjects
CREATE TABLE class_subject (
    class_id INT,
    subject_id INT,
    PRIMARY KEY (class_id, subject_id),
    FOREIGN KEY (class_id) REFERENCES classes(id),
    FOREIGN KEY (subject_id) REFERENCES subjects(id)
);

-- Create a junction table 'teacher_class' to establish many-to-many relationship between teachers and classes
CREATE TABLE teacher_class (
    teacher_id INT,
    class_id INT,
    PRIMARY KEY (teacher_id, class_id),
    FOREIGN KEY (teacher_id) REFERENCES teachers(id),
    FOREIGN KEY (class_id) REFERENCES classes(id)
);

-- Create the 'admin' table
CREATE TABLE admins (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- Insert dummy data into 'classes' table
INSERT INTO classes (name) VALUES ('Class 1');
INSERT INTO classes (name) VALUES ('Class 2');
INSERT INTO classes (name) VALUES ('Class 3');
INSERT INTO classes (name) VALUES ('Class 4');

-- Insert dummy data into 'subjects' table
INSERT INTO subjects (name) VALUES ('Math');
INSERT INTO subjects (name) VALUES ('Science');
INSERT INTO subjects (name) VALUES ('History');
INSERT INTO subjects (name) VALUES ('Geography');
INSERT INTO subjects (name) VALUES ('English');
INSERT INTO subjects (name) VALUES ('Art');

-- Insert dummy data into 'students' table
INSERT INTO students (name, class_id) VALUES ('John Doe', 1);
INSERT INTO students (name, class_id) VALUES ('Jane Smith', 2);
INSERT INTO students (name, class_id) VALUES ('Michael Johnson', 3);
INSERT INTO students (name, class_id) VALUES ('Emily Davis', 1);
INSERT INTO students (name, class_id) VALUES ('David Brown', 4);
INSERT INTO students (name, class_id) VALUES ('Sarah Wilson', 2);

-- Insert dummy data into 'teachers' table
INSERT INTO teachers (name) VALUES ('Mr. Anderson');
INSERT INTO teachers (name) VALUES ('Ms. Baker');
INSERT INTO teachers (name) VALUES ('Dr. Clark');
INSERT INTO teachers (name) VALUES ('Prof. Davis');

-- Insert dummy data into 'class_subject' table
INSERT INTO class_subject (class_id, subject_id) VALUES (1, 1);
INSERT INTO class_subject (class_id, subject_id) VALUES (1, 2);
INSERT INTO class_subject (class_id, subject_id) VALUES (2, 2);
INSERT INTO class_subject (class_id, subject_id) VALUES (2, 3);
INSERT INTO class_subject (class_id, subject_id) VALUES (3, 3);
INSERT INTO class_subject (class_id, subject_id) VALUES (3, 4);
INSERT INTO class_subject (class_id, subject_id) VALUES (4, 4);
INSERT INTO class_subject (class_id, subject_id) VALUES (4, 5);

-- Insert dummy data into 'teacher_class' table
INSERT INTO teacher_class (teacher_id, class_id) VALUES (1, 1);
INSERT INTO teacher_class (teacher_id, class_id) VALUES (1, 2);
INSERT INTO teacher_class (teacher_id, class_id) VALUES (2, 2);
INSERT INTO teacher_class (teacher_id, class_id) VALUES (2, 3);
INSERT INTO teacher_class (teacher_id, class_id) VALUES (3, 3);
INSERT INTO teacher_class (teacher_id, class_id) VALUES (3, 4);
INSERT INTO teacher_class (teacher_id, class_id) VALUES (4, 4);

-- Insert dummy data into 'admin' table
INSERT INTO admins (username, password, email) VALUES ('admin1', 'password1', 'admin1@example.com');
INSERT INTO admins (username, password, email) VALUES ('admin2', 'password2', 'admin2@example.com');
INSERT INTO admins (username, password, email) VALUES ('admin3', 'password3', 'admin3@example.com');
INSERT INTO admins (username, password, email) VALUES ('mpho', '1234', 'mpho@gmail.com');
