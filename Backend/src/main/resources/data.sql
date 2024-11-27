-- Disable foreign key checks for initial table creation

DROP DATABASE IF EXISTS `ESD_ACEDMIADB`;

-- Create a new database
CREATE DATABASE `ESD_ACEDMIADB` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

-- Select the newly created database
USE `ESD_ACEDMIADB`;

-- Create departments table
CREATE TABLE departments (
                             department_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             name VARCHAR(100) NOT NULL,
                             capacity INT
);

-- Create employees table
CREATE TABLE employees (
                           employee_id INT AUTO_INCREMENT PRIMARY KEY,
                           first_name VARCHAR(50) NOT NULL,
                           last_name VARCHAR(50) NOT NULL,
                           email VARCHAR(100) UNIQUE NOT NULL,
                           password VARCHAR(100) NOT NULL,
                           title VARCHAR(100),
                           photograph_path VARCHAR(255),
                           department_id BIGINT
);

-- Create specialisation table
CREATE TABLE specialization (
                                specialization_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                code VARCHAR(10) UNIQUE NOT NULL,
                                name VARCHAR(100) NOT NULL,
                                description TEXT,
                                year INT,
                                credits_required INT
);
-- Adjust the starting AUTO_INCREMENT value
ALTER TABLE specialization AUTO_INCREMENT = 1001;

-- Create courses table
CREATE TABLE courses (
                         course_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         course_code VARCHAR(10) UNIQUE NOT NULL,
                         name VARCHAR(100) NOT NULL,
                         description TEXT,
                         year INT,
                         term VARCHAR(20),
                         faculty VARCHAR(100),
                         credits INT,
                         capacity INT
);

-- Create specialization_course table
CREATE TABLE specialization_course (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       specialization_id BIGINT NOT NULL,
                                       course_id BIGINT NOT NULL,
                                       FOREIGN KEY (specialization_id) REFERENCES specialization(specialization_id) ON DELETE CASCADE,
                                       FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

-- Insert data into departments table
INSERT INTO departments (name, capacity) VALUES
                                             ('Admin Department', 50),
                                             ('Academic Department', 100),
                                             ('IT Department', 30);

-- Insert data into employees table
INSERT INTO employees (first_name, last_name, email, title, photograph_path, department_id, password) VALUES
                                                                                                          ('John', 'Doe', 'john.doe@university.com', 'Admin Officer', '/photos/john.jpg', 1, '$2a$10$N9y1fZNzyLaVazDw6djprO/WhFKWp8tIKzvIRP7NTgYEPvDyp.CQ6'),
                                                                                                          ('Jane', 'Smith', 'jane.smith@university.com', 'Department Head', '/photos/jane.jpg', 1, '$2a$10$N9y1fZNzyLaVazDw6djprO/WhFKWp8tIKzvIRP7NTgYEPvDyp.CQ6'),
                                                                                                          ('Mike', 'Johnson', 'mike.johnson@university.com', 'Admin Assistant', '/photos/mike.jpg', 1, '$2a$10$N9y1fZNzyLaVazDw6djprO/WhFKWp8tIKzvIRP7NTgYEPvDyp.CQ6');

-- Insert data into specialisation table
INSERT INTO specialization (code, name, description, year, credits_required) VALUES
                                                                                 ('TS', 'Theory & Systems', 'Focuses on theoretical computer science and systems design', 2024, 20),
                                                                                 ('DS', 'Data Science', 'Covers machine learning, data analytics, and statistical methods', 2024, 20),
                                                                                 ('SE', 'Software Engineering', 'Software development methodologies and engineering practices', 2024, 20),
                                                                                 ('AI', 'Artificial Intelligence', 'Study of intelligent systems and cognitive computing', 2024, 20);

-- Insert data into courses table
INSERT INTO courses (course_code, name, description, year, term, faculty, credits, capacity) VALUES
                                                                                                 ('CS501', 'Advanced Algorithms', 'Study of complex algorithms and their applications', 2024, 'Fall', 'Dr. Smith', 4, 60),
                                                                                                 ('CS502', 'Machine Learning', 'Introduction to machine learning concepts and applications', 2024, 'Fall', 'Dr. Johnson', 4, 50),
                                                                                                 ('CS503', 'Software Architecture', 'Enterprise software design patterns and practices', 2024, 'Spring', 'Dr. Davis', 4, 55),
                                                                                                 ('CS504', 'AI Fundamentals', 'Basic concepts of artificial intelligence', 2024, 'Spring', 'Dr. Wilson', 4, 45);

-- Insert data into specialisation_course table
INSERT INTO specialization_course (specialization_id, course_id) VALUES
                                                                     (1001, 1), -- Theory & Systems - Advanced Algorithms
                                                                     (1002, 2), -- Data Science - Machine Learning
                                                                     (1003, 3), -- Software Engineering - Software Architecture
                                                                     (1004, 4); -- AI - AI Fundamentals

-- Enable foreign key checks (if needed)
-- SET FOREIGN_KEY_CHECKS = 1;
