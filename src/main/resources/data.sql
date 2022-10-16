DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id int NOT NULL PRIMARY KEY,
    username varchar(255) NOT NULL,
    password varchar(255),
    role varchar2(50) not null,
    attempt int DEFAULT 0,
    last_updated_date datetime 
);

--student
DROP TABLE IF EXISTS student;

CREATE TABLE student (
    student_id int NOT NULL PRIMARY KEY,
    first_name varchar2(50),
    last_name varchar2(50),
    group_id int
);

INSERT INTO student  VALUES (1111, 'Ankit','Kumar' ,1);
INSERT INTO student  VALUES (1112, 'Ankit','Mishra' ,2);
INSERT INTO student  VALUES (1113, 'Ram','Kumar' ,1);
INSERT INTO student  VALUES (1114, 'Wazi','Kumar' ,2);

--group 
DROP TABLE IF EXISTS groups;

CREATE TABLE groups (
    group_id int NOT NULL PRIMARY KEY,
    name varchar2(50)
);

INSERT INTO groups  VALUES (1, 'grp1');
INSERT INTO groups  VALUES (2, 'grp2');


--marks
DROP TABLE IF EXISTS marks;

CREATE TABLE marks (
    mark_id int NOT NULL PRIMARY KEY,
    student_id int ,
    subject_id int,
    date date,
    marks int
);

INSERT INTO marks  VALUES (11111,1111, 11, sysdate,75);
INSERT INTO marks  VALUES (11112,1111, 12, sysdate,95);

--subject 
DROP TABLE IF EXISTS subject;

CREATE TABLE subject (
    subject_id int NOT NULL PRIMARY KEY,
    title varchar2(50)
);

INSERT INTO subject  VALUES ( 11, 'Physics');
INSERT INTO subject  VALUES ( 12, 'Chemistry');
INSERT INTO subject  VALUES ( 13, 'Maths');
INSERT INTO subject  VALUES ( 14, 'English');

--subject_teacher
DROP TABLE IF EXISTS subject_teacher;

CREATE TABLE subject_teacher (
    subject_id int NOT NULL ,
    teacher_id int ,
    group_id int
);

INSERT INTO subject_teacher  VALUES ( 11, 999999,1);
INSERT INTO subject_teacher  VALUES ( 12, 888888,2);
INSERT INTO subject_teacher  VALUES ( 13, 999998,1);
INSERT INTO subject_teacher  VALUES ( 14, 888889,2);
