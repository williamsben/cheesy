CREATE USER 'ben'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'ben'@'%' WITH GRANT OPTION;

CREATE DATABASE cheesy;
USE cheesy;

CREATE TABLE cheeses (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(20), taste VARCHAR(20), PRIMARY KEY(id));

INSERT INTO cheeses (name,taste) VALUES("Gouda", "Good");
INSERT INTO cheeses (name,taste) VALUES("Cheddar", "Delicious");
INSERT INTO cheeses (name,taste) VALUES("Bleu", "Horrible");
