CREATE database onlinestore;

SHOW databases;

USE onlinestore;

status;

CREATE TABLE customers(
     customer_id INT PRIMARY KEY auto_increment,
     first_name VARCHAR(50) NOT NULL,
     last_name VARCHAR(50) NOT NULL,
     ADDress VARCHAR(60),
     email VARCHAR(60) NOT NULL UNIQUE,
     gENDer VARCHAR(10) NOT NULL);
	 
CREATE TABLE phonebook(
     customer_id INT NOT NULL,
     pnone_number VARCHAR(20) NOT NULL,
     FOREIGN KEY(customer_id) REFERENCES customers(customer_id));

CREATE TABLE categories(
     category_id INT PRIMARY KEY auto_increment,
     name VARCHAR(50) NOT NULL UNIQUE);

CREATE TABLE products(
     product_id INT PRIMARY KEY auto_increment,
     category_id INT,
     name VARCHAR(50) NOT NULL,
     price FLOAT NOT NULL CHECK(price >= 0),
     discount INT CHECK(discount >= 0),
     unit VARCHAR(20) NOT NULL,
     stock INT CHECK(stock >= 0));

CREATE TABLE ORDERs(
     ORDER_id INT PRIMARY KEY auto_increment,
     customer_id INT NOT NULL,
     ORDER_DATE DATE,
     status_id INT NOT NULL,
     FOREIGN KEY(customer_id) REFERENCES customers(customer_id));

CREATE TABLE ORDER_status(
     status_id INT PRIMARY KEY auto_increment,
     name VARCHAR(20) NOT NULL);

CREATE TABLE carts(
     customer_id INT NOT NULL,
     product_id INT NOT NULL,
     PRIMARY KEY(customer_id,product_id),
     quantity FLOAT NOT NULL CHECK(quantity >= 0),
     FOREIGN KEY(customer_id) REFERENCES customers(customer_id),
     FOREIGN KEY(product_id) REFERENCES products(product_id));

CREATE TABLE transactions(
     transaction_id INT PRIMARY KEY auto_increment,
     ORDER_id INT NOT NULL,
     transaction_DATE DATE NOT NULL,
     amount FLOAT NOT NULL CHECK(amount >= 0),
     FOREIGN KEY(ORDER_id) REFERENCES ORDERs(ORDER_id));

SHOW TABLEs;

CREATE TABLE ORDERs_products(
     ORDER_id INT NOT NULL,
     product_id INT NOT NULL,
     quantity FLOAT NOT NULL,
     PRIMARY KEY(ORDER_id, product_id),
     FOREIGN KEY(ORDER_id) REFERENCES ORDERs(ORDER_id),
     FOREIGN KEY(product_id) REFERENCES products(product_id));

SHOW full TABLEs;

ALTER TABLE ORDERs
     ADD constraINT fk_ORDER_status FOREIGN KEY(status_id) REFERENCES ORDER_status(status_id);

SHOW CREATE TABLE ORDERs;

INSERT INTO categories(name)
     VALUES ('Clothings'), ('Food and Beverage'), ('Consumer Electronics'), ('Cosmetics'), ('Home Appliances'), ('Stationary');

UPDATE categories
     SET name = 'Stationery' WHERE category_id = 6;

SELECT * FROM categories ORDER BY category_id ASC;

INSERT INTO products(category_id, name, price, discount, unit, stock)
     VALUES
     (1, 'Jacket', 4000, 0, 'pc' , 30),
     (1, 'TroUSErs', 2500, 0, 'pair', 35),
     (1, 'T-shirt', 1500, 0, 'pc', 40),
     (2, 'Noodles', 20, 0, 'pc', 200),
     (2, 'Fruit Juice', 150, 0, 'ltr', 200),
     (2, 'Onion', 200, 0 , 'kg' , 300),
     (3, 'Mobile Phone', 25000, 2, 'pc', 50),
     (3, 'Camera' , 35000, 3, 'pc', 20),
     (3, 'Laptop', 70000, 2, 'pc',15),
     (4, 'Perfume', 2000, 0, 'pc' , 60),
     (4, 'Shampoo', 750, 0, 'pc' , 100),
     (4, 'Mosturizer', 500, 0, 'pc', 100),
     (5, 'Microwave Oven', 45000, 1, 'pc', 25),
     (5, 'Rice Cooker', 7500, 0, 'pc', 25),
     (5, 'Electric pot', 2000, 0, 'pc', 25);

SELECT * FROM products;

INSERT INTO ORDER_status(name)
     VALUES ('received'),('in_progress'),('cancelled'),('completed');

SELECT * FROM ORDER_status;

INSERT INTO customers(first_name, last_name, ADDress, email, gENDer)
     VALUES
     ('Ram', 'Limbu', 'Mangalbazar, Patan', 'ram_limbu@gmail.com', 'M'),
     ('Naren', 'Shrestha', 'New Baneshwor, Kathmandu', 'naren_stha@gmail.com', 'M'),
     ('Sneha', 'Gurung', 'Lazimpat, Kathmandu', 'sneha_grg123@gmail.com', 'F'),
     ('Bikram', 'Baral', 'Thimi, Bhaktapur', 'bikram_baral@yahoo.com', 'M'),
     ('Aashma', 'Thapa', 'Swomambhu, Kathmandu', 'aashma_thapa@hotmail.com', 'F');

SELECT * FROM customers;

UPDATE customers
     SET ADDress = 'Swoyambhu, Kathmandu' WHERE customer_id = 5;

delimiter //
CREATE PROCEDURE ADDtocart(customer_id INT, product_id INT, quantity INT)
     BEGIN
     INSERT INTO carts(customer_id, product_id, quantity) VALUES (customer_id, product_id, quantity);
     END //

delimiter ;
CALL ADDtocart(1,1,1);

SELECT * FROM carts;

CALL ADDtocart(1,5,2);

SELECT * FROM carts;

CALL ADDtocart(2,4,3);

SELECT * FROM carts;