CREATE DATABASE IF NOT EXISTS JEEPRJ DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE JEEPRJ;

CREATE TABLE IF NOT EXISTS user(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
login varchar(30),
password varchar(30),
name varchar(30) NOT NULL,
firstName varchar(30) NOT NULL,
homePhone int(10) NOT NULL,
mobilePhone int(10) NOT NULL,
workPhone int(10) NOT NULL,
address varchar(30) NOT NULL,
postalCode int(5) NOT NULL,
city varchar(30) NOT NULL,
email varchar(30) NOT NULL
);

INSERT INTO user (login, password, name, firstName, homePhone, mobilePhone, workPhone, address, postalCode, city, email) VALUES 
('admin', 'admin', 'Bourne', 'Jason', 0145362734, 0645362734, 0745361734, '165 rue Agent Secret Perdu', 92700, 'Colombes', 'jbourne@yahoo.fr'),
(null, null, 'Jones', 'Indiana', 0145362787, 0645362787, 0745361787, '10 rue des Aventuriers', 92270, 'Bois-Colombes', 'ijones@gmail.com'),
( null,  null, 'Lanister', 'Cersei', 0145362794, 0645362794, 0745361794, '5 bvd des Reines', 21000, 'Dijon', 'clanister@mail.co.uk');
('empl', 'empl', 'Stark', 'Arya', 0145362766, 0745362766, 0745361767, '6 rue Sans-Norm', 75016, 'Paris', 'astark@nord.com');