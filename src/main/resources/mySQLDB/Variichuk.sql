USE onlineShop;
INSERT countries(idcountry, countryName)
VALUES(1, 'USA');
INSERT countries(idcountry, countryName)
VALUES(2, 'UK');

INSERT cities(idcity, cityName, cityPostalCode, idcountry)
VALUES(1, 'London', '001', 2);
INSERT cities(idcity, cityName, cityPostalCode, idcountry)
VALUES(2, 'Birmingham', '002',2);
INSERT cities(idcity, cityName, cityPostalCode, idcountry)
VALUES(3, 'New York', '003',1);
INSERT cities(idcity, cityName, cityPostalCode, idcountry)
VALUES(4, 'Los Angeles', '004',1);

INSERT manufacturers(idmanufacturer, manufacturerName, manufacturerContact)
VALUES(1, 'Best cosmetics', 'bestcosmetics@gmail.com');
INSERT manufacturers(idmanufacturer, manufacturerName, manufacturerContact)
VALUES(2, 'Apple', 'apple@gmail.com');
INSERT manufacturers(idmanufacturer, manufacturerName, manufacturerContact)
VALUES(3, 'Hair style', 'hairstyle@gmail.com');
INSERT manufacturers(idmanufacturer, manufacturerName, manufacturerContact)
VALUES(4, 'Sumsung', 'samsungs@gmail.com');

INSERT addresses(idaddresse, addresseName, addressePostalCode, idcity)
VALUES(1, 'Red str', '001', 1);
INSERT addresses(idaddresse, addresseName, addressePostalCode, idcity)
VALUES(2, 'Green str', '002', 2);
INSERT addresses(idaddresse, addresseName, addressePostalCode, idcity)
VALUES(3, 'Blue  str', '003', 1);
INSERT addresses(idaddresse, addresseName, addressePostalCode, idcity)
VALUES(4, 'Orange str', '004', 2);

INSERT discounts(iddiscount, discountSize)
VALUES(1, 10);
INSERT discounts(iddiscount, discountSize)
VALUES(2, 20);
INSERT discounts(iddiscount, discountSize)
VALUES(3, 30);
INSERT discounts(iddiscount, discountSize)
VALUES(0, 0);

INSERT employees(idemployee, employeeName, employeeSurname, employeeContact, employeeSalary)
VALUES(1, 'Ivan', 'Kovalenko', 'kovalenko@gmail.com',  36300);
INSERT employees(idemployee, employeeName, employeeSurname, employeeContact, employeeSalary)
VALUES(2, 'Igor', 'Bug', 'bug@gmail.com',  40300);

INSERT productCategories(idproductCategorie, productCategorieName)
VALUES(1, 'Makeup');
INSERT productCategories(idproductCategorie, productCategorieName)
VALUES(2, 'Hair');
INSERT productCategories(idproductCategorie, productCategorieName)
VALUES(3, 'Technique');

INSERT products(idproduct, productName, productDescription, idproductCategorie, productPrice, idmanufacturer, iddiscount)
VALUES(1, 'Lipstick', 'Lipstick color oo1', 1, 30, 1, 0);
INSERT products(idproduct, productName, productDescription, idproductCategorie, productPrice, idmanufacturer, iddiscount)
VALUES(2, 'Lipstick', 'Lipstick color oo2', 1, 35, 1, 0);
INSERT products(idproduct, productName, productDescription, idproductCategorie, productPrice, idmanufacturer, iddiscount)
VALUES(3, 'Lipstick', 'Lipstick color oo3', 1, 35, 1, 2);
INSERT products(idproduct, productName, productDescription, idproductCategorie, productPrice, idmanufacturer, iddiscount)
VALUES(4, 'Shadows', 'Shadows color oo1', 1, 50, 1, 0);
INSERT products(idproduct, productName, productDescription, idproductCategorie, productPrice, idmanufacturer, iddiscount)
VALUES(5, 'Shadows', 'Shadows color oo2', 1, 50, 1, 1);
INSERT products(idproduct, productName, productDescription, idproductCategorie, productPrice, idmanufacturer, iddiscount)
VALUES(6, 'Iphone 13', '128GB GREEN', 3, 1000, 2, 0);
INSERT products(idproduct, productName, productDescription, idproductCategorie, productPrice, idmanufacturer, iddiscount)
VALUES(7, 'Iphone 13', '128GB WHITE', 3, 1000, 2, 0);
INSERT products(idproduct, productName, productDescription, idproductCategorie, productPrice, idmanufacturer, iddiscount)
VALUES(8, 'Iphone 13', '128GB ROSE', 3, 1000, 2, 1);

INSERT customersCategories(idcustomersCategory, customersCategoryType, customersCategoryDiscount)
VALUES (1, 'Not a regular customer', false);
INSERT customersCategories(idcustomersCategory, customersCategoryType, customersCategoryDiscount)
VALUES (2, 'Regular customer', true);

INSERT customers(idcustomer, customerName, customerSurname, customerCard, customerPhoneNumber, idCustomerCategory)
VALUES (1, 'Anna', 'Ivanova', '5678908767895432', '+380997896578', 1);
INSERT customers(idcustomer,  customerName, customerSurname,  customerCard, customerPhoneNumber, idCustomerCategory)
VALUES(2, 'Ivanna', 'Kovalenco', '5678908767895433', '+380997896578', 2);

INSERT users(iduser, username, email, password, idcustomer)
VALUES(1, 'aNnA', 'annaivanova@gmail.com', '1234567890', 1);
INSERT users(iduser, username, email, password, idcustomer)
VALUES(2, 'iVV', 'ivv@gmail.com', '1234567891', 2);

INSERT shoppingOrders(idshoppingOrder, shoppingOrderDate, shoppingOrderTotalPrice, iduser)
VALUES(2, '2022-08-23', 780, 2);
INSERT shoppingOrders(idshoppingOrder, shoppingOrderDate, shoppingOrderTotalPrice, iduser)
VALUES(1, '2022-08-22', 1050, 1);
INSERT shoppingOrders(idshoppingOrder, shoppingOrderDate, shoppingOrderTotalPrice, iduser)
VALUES(3, '2022-08-24', 800 , 2);
INSERT shoppingOrders(idshoppingOrder, shoppingOrderDate, shoppingOrderTotalPrice, iduser)
VALUES(4, '2022-08-25', 150 , 2);

INSERT deliveries(iddelivery, idaddresse, iduser, deliveryDateTime, idemployee)
VALUES(4, 2, 1, '2022-09-01 14:45:00', 1);
INSERT deliveries(iddelivery, idaddresse, iduser, deliveryDateTime, idemployee)
VALUES(1, 1, 1, '2022-08-23 13:00:00', 1);
INSERT deliveries(iddelivery, idaddresse, iduser, deliveryDateTime, idemployee)
VALUES(2, 1, 2, '2022-08-28 13:00:00', 1);
INSERT deliveries(iddelivery, idaddresse, iduser, deliveryDateTime, idemployee)
VALUES(3, 1, 2, '2022-08-29 13:00:00', 1);

INSERT productorders(idproductOrder, idproduct, idshoppingOrder)
VALUES(1, 2, 1);
INSERT productorders(idproductOrder, idproduct, idshoppingOrder)
VALUES(2, 4, 3);
INSERT productorders(idproductOrder, idproduct, idshoppingOrder)
VALUES(3, 6, 1);
INSERT productorders(idproductOrder, idproduct, idshoppingOrder)
VALUES(4, 9, 2);

INSERT payments(idpayment, idcustomer, paymentDateTime, paymentStatus)
VALUES (1, 1, '22-08-20 11:00:00', true),
(2, 2, '22-08-21 11:00:00', true);

SET SQL_SAFE_UPDATES = 0;
UPDATE products
SET productPrice = productPrice + 100
WHERE productName = 'Iphone 13';

UPDATE users
SET userName = 'ANNA'
WHERE iduser= 1;

UPDATE shoppingOrders 
SET shoppingOrderTotalPrice = shoppingOrderTotalPrice - 65
WHERE shoppingOrderTotalPrice < 1000 AND shoppingOrderTotalPrice > 100 OR iduser = 2;

UPDATE cities
SET cityPostalCode = '1234'
WHERE cityName = 'London';

UPDATE employees
SET enployeeSalary = enployeeSalary * 1.1
WHERE enployeeSalary < 40000;

DELETE FROM manufacturers
WHERE manufacturerName = 'Samsung';

DELETE FROM payments;

DELETE FROM productOrders
WHERE idshoppingOrder = 2;
DELETE FROM shoppingOrders 
WHERE shoppingOrderTotalPrice BETWEEN 400 and 900;

DELETE FROM cities
WHERE cityName = 'Los Angeles';

SELECT * FROM products 
WHERE productPrice BETWEEN 50 AND 1100;

SELECT COUNT(*) FROM users;

SELECT productName, COUNT(*) FROM products 
GROUP BY productName;

SELECT productName, productPrice FROM products 
ORDER BY productPrice;

SELECT productName, productPrice FROM products 
ORDER BY productPrice DESC;

SELECT * FROM products
WHERE productPrice > 100 OR productPrice < 35;

SELECT * FROM products
WHERE productPrice IN (30,50);

SELECT shoppingOrders.shoppingOrderDate, customers.customerSurname
FROM shoppingOrders
JOIN users ON users.iduser = shoppingOrders.iduser
JOIN customers ON users.idcustomer = customers.idcustomer;

SELECT products.productName, products.productPrice, discounts.discountSize
FROM products
JOIN discounts ON discounts.iddiscount = products.iddiscount;

SELECT manufacturers.manufacturerName, products.productName, products.productPrice
FROM manufacturers
JOIN products ON products.idmanufacturer = manufacturers.idmanufacturer;
