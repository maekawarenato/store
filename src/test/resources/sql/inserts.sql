INSERT INTO PRODUCT (IDT_PRODUCT, COD_PRODUCT, DES_PRODUCT, PRICE_PRODUCT) VALUES
(1, '7891425364', 'Produto 1', 50.20),
(2, '7891425365', 'Produto 2', 10.50);


INSERT INTO SALES (IDT_SALES, SALES_DISCOUNT, SALES_DATE) VALUES
(1, 0.00, '2005-08-06');

INSERT INTO SALES_PRODUCT (IDT_SALES_PRODUCT, IDT_PRODUCT, IDT_SALES, AMOUNT) VALUES
(1, 1, 1, 1),
(2, 2, 1, 2);
