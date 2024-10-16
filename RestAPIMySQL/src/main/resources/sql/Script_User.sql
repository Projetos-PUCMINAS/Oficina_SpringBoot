CREATE DATABASE `bd-user`
CHARACTER SET utf8mb4
COLLATE utf8mb4_general_ci;

CREATE TABLE User(
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 username VARCHAR(255) NOT NULL,
 email VARCHAR(255) NOT NULL,
 password VARCHAR(255) NOT NULL
);


INSERT INTO User(nome, email)
VALUES
('Marcos Alberto','marcosferreira@gmail.com','mar'),
('Jamilly Nicole','jamillynicole@gmail.com','jam'),
('Bernardo Alvim','bernardoalvim@gmail.com','ber');

SELECT * FROM User;

