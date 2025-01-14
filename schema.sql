create database Lms;
use Lms;
CREATE TABLE admins (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE assignmenttable (
    assignment_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    course_name VARCHAR(100) NOT NULL,
    assignment TEXT NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_date DATE NOT NULL
);

CREATE TABLE enrollments (
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    enrolled_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE users_courses (
    user_id INT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    course_1 VARCHAR(255),
    course_2 VARCHAR(255),
    course_3 VARCHAR(255),
    course_4 VARCHAR(255),
    course_5 VARCHAR(255)
);

CREATE TABLE courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,  -- Auto-incrementing primary key
    course_name VARCHAR(100) NOT NULL,         -- Course name (required field)
    description TEXT,                          -- Course description (optional)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- Timestamp of record creation
);


CREATE TABLE submissions (
    submission_id INT AUTO_INCREMENT PRIMARY KEY,  -- Auto-incrementing primary key
    assignment_id INT NOT NULL,                    -- Foreign key or reference to an assignment (required)
    user_id INT NOT NULL,                          -- Foreign key or reference to a user (required)
    user_name VARCHAR(255) NOT NULL,               -- User's name (required)
    url VARCHAR(255),                              -- URL for submission (optional)
    submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Timestamp of submission (default: current time)
    
    -- You can also add foreign keys if necessary:
    -- FOREIGN KEY (assignment_id) REFERENCES assignments(assignment_id),
    -- FOREIGN KEY (user_id) REFERENCES users(user_id)
);


CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,          -- Auto-incrementing primary key
    name VARCHAR(255) NOT NULL,                  -- User's name (required)
    email VARCHAR(255) NOT NULL UNIQUE,          -- User's email (required and unique)
    password VARCHAR(255) NOT NULL,              -- User's password (required)
    profile_details TEXT                        -- User's profile details (optional)
);

