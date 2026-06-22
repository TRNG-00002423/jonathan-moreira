BEGIN;

DROP TABLE IF EXISTS order_lines CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS customers CASCADE;

CREATE TABLE customers (
    customer_id   INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_name    VARCHAR(200) NOT NULL,
    last_name     VARCHAR(200) NOT NULL,
    email         VARCHAR(255) NOT NULL UNIQUE,
    phone         VARCHAR(32)
);

CREATE TABLE orders (
    order_id            INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    customer_id         INTEGER NOT NULL REFERENCES customers (customer_id) ON DELETE RESTRICT,
    date                TIMESTAMP NOT NULL,
    shipping_address    VARCHAR(100) NOT NULL,
    status              VARCHAR(20) NOT NULL
);

CREATE TABLE products (
    product_id    INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    sku           VARCHAR(32) NOT NULL UNIQUE,
    product_name  VARCHAR(200) NOT NULL,
    unit_price    DECIMAL(12, 2) NOT NULL CHECK (unit_price >= 0),
    stock_qty     INTEGER NOT NULL DEFAULT 0 CHECK (stock_qty >= 0)
);

CREATE TABLE order_lines (
    order_id      INTEGER NOT NULL REFERENCES orders (order_id) ON DELETE CASCADE,
    product_id    INTEGER NOT NULL REFERENCES products (product_id) ON DELETE RESTRICT,
    quantity      INTEGER NOT NULL CHECK (quantity > 0),
    unit_price    DECIMAL(12, 2) NOT NULL CHECK (unit_price >= 0),
    PRIMARY KEY (order_id, product_id)
);

COMMIT;

INSERT INTO customers(first_name, last_name, email, phone) VALUES('Alice', 'Johnson', 'alice@email.com', '555-0101'),
    ('Bob', 'Smith', 'bob@email.com', '555-0102');

INSERT INTO products (sku, product_name, unit_price, stock_qty)
VALUES 
    ('XF-839-L2', 'Laptop Pro', 999.99, 50),
    ('9B-W2X-04', 'Wireless Mouse', 29.99, 200),
    ('TR-448-P9', 'Standing Desk', 299.99, 30);

INSERT INTO orders (customer_id, date, shipping_address, status)
VALUES 
    (1,'2024-03-15 10:30:00', '456 xyz', 'shipped'),
    (2,'2024-03-16 12:00:00', '123 abc', 'pending');


INSERT INTO order_lines (order_id, product_id, quantity, unit_price)
VALUES 
    (1, 1, 1, 799.99),  -- 1 Laptop Pro
    (2, 2, 2, 19.99),  -- 1 Wireless Mouse
    (2, 3, 1, 289.99);   -- 1 Standing Desk

UPDATE products SET unit_price = 899.99 WHERE product_id = 1;

SELECT unit_price FROM products WHERE product_id = 1;
SELECT unit_price FROM order_lines WHERE order_id = 1 AND product_id = 1;

UPDATE orders SET status = 'cancelled' WHERE status = 'pending' AND order_id = 2;
SELECT * FROM orders;