CREATE DATABASE taylorsInsurance;

USE taylorsInsurance;

CREATE TABLE driver (
    driverID int auto_increment not null,
    firstName VARCHAR (15) NOT NULL,
    lastName VARCHAR (30) NOT NULL,
    age INT NOT NULL,
    numberOfAccidents INT,
    address VARCHAR (100) NOT NULL,
    PRIMARY KEY (driverID)
);

SELECT * FROM driver;