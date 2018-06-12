CREATE TABLE IF NOT EXISTS PRODUCT
(
  IDT_PRODUCT  NUMBER(10,0)  NOT NULL,
  COD_PRODUCT  VARCHAR2(60)  NOT NULL,
  DES_PRODUCT  VARCHAR2(60)  NOT NULL,
  PRICE_PRODUCT NUMBER(8,2)  NOT NULL
);

CREATE TABLE IF NOT EXISTS SALES
(
  IDT_SALES NUMBER(10,0)  NOT NULL,
  SALES_DISCOUNT  NUMBER(8,2)  NOT NULL,
  SALES_DATE  DATE  NOT NULL
);

CREATE TABLE IF NOT EXISTS SALES_PRODUCT
(
  IDT_PRODUCT  NUMBER(10,0)  NOT NULL,
  IDT_SALES  NUMBER(10,0)  NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS SQ_PRODUCT_IDT START WITH 1;
CREATE SEQUENCE IF NOT EXISTS SQ_SALES_IDT START WITH 1;