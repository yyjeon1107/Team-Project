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