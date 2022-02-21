CREATE SEQUENCE  IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE product (
  id INTEGER NOT NULL,
   product_name VARCHAR(255),
   quantity INTEGER,
   price DOUBLE PRECISION,
   CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE store (
  id INTEGER NOT NULL,
   store_name VARCHAR(255),
   CONSTRAINT pk_store PRIMARY KEY (id)
);

CREATE TABLE store_products (
  products_id INTEGER NOT NULL,
   store_id INTEGER NOT NULL,
   CONSTRAINT pk_store_products PRIMARY KEY (products_id, store_id)
);

ALTER TABLE store_products ADD CONSTRAINT fk_stopro_on_product_entity FOREIGN KEY (products_id) REFERENCES product (id);

ALTER TABLE store_products ADD CONSTRAINT fk_stopro_on_store_entity FOREIGN KEY (store_id) REFERENCES store (id);

INSERT INTO store (id, store_name) VALUES(1,'Worten');
INSERT INTO store (id, store_name) VALUES(2,'Radio Popular');
INSERT INTO store (id, store_name) VALUES(3,'FNAC');

INSERT INTO product (id, product_name, price, quantity) VALUES(1, 'Iphone 12','999.00',100);
INSERT INTO product (id, product_name, price, quantity) VALUES(2, 'Iphone 13','1200.00',500);
INSERT INTO product (id, product_name, price, quantity) VALUES(3, 'Macbook pro','1399.99',10);
INSERT INTO product (id, product_name, price, quantity) VALUES(4, 'Macbook air','1000.99',15);

INSERT INTO store_products (products_id, store_id) VALUES (1,1);
INSERT INTO store_products (products_id, store_id) VALUES (2,1);
INSERT INTO store_products (products_id, store_id) VALUES (3,1);
INSERT INTO store_products (products_id, store_id) VALUES (1,2);
INSERT INTO store_products (products_id, store_id) VALUES (2,2);

COMMIT;