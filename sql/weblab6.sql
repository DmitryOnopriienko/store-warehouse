DROP DATABASE IF EXISTS weblab6;

CREATE DATABASE weblab6;

USE weblab6;

DROP TABLE IF EXISTS waybill_has_products;
DROP TABLE IF EXISTS waybill;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL,
    surname VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    price DECIMAL(9,2) NOT NULL
);

CREATE TABLE waybill (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE waybill_has_products (
    waybill_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT UNSIGNED NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (waybill_id) REFERENCES waybill(id)
);

INSERT INTO customer (`name`, surname, email)
VALUES ('Serhiy', 'Igorev', 'sergigo@gmail.com'),
       ('Alex', 'Johnson', 'alex.johnson@yahoo.com');

INSERT INTO product (name, price)
VALUES ('M4', 600.00),
       ('Granade', 250.00),
       ('Armor', 500.00);

INSERT INTO waybill (customer_id)
VALUES (1), (1), (2);

INSERT INTO waybill_has_products
VALUES (1, 1, 3),
       (1, 2, 5),
       (1, 3, 10);