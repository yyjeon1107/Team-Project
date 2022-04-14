CREATE DATABASE mcdb DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_general_ci;

CREATE USER 'multicampus'@'%' IDENTIFIED BY 'multicampus1234'; 

CREATE TABLE user(
    id VARCHAR(128) PRIMARY KEY,
    password VARCHAR(128),
    name VARCHAR(128),
    email VARCHAR(128),
    address VARCHAR(128),
    INDEX (id)
);

CREATE TABLE product(
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    userId VARCHAR(128),
    name VARCHAR(128),
    info VARCHAR(128),
    INDEX (name),
    FOREIGN KEY ( userId ) REFERENCES user(id)
);