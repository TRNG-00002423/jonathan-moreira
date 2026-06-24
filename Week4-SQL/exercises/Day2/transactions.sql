-- Section A — Happy path
SELECT * FROM product;
BEGIN;

INSERT INTO order_header (customer_id, status)
SELECT customer_id, 'PAID' FROM customer WHERE email = 'alpha@example.com';

INSERT INTO order_line (order_id, line_no, product_id, qty, unit_price)
SELECT oh.order_id, 1, p.product_id, 4, p.unit_price
FROM order_header oh
JOIN customer c ON c.customer_id = oh.customer_id
JOIN product p ON p.sku = 'BASE-A'
WHERE c.email = 'alpha@example.com'
ORDER BY oh.order_id DESC LIMIT 1;

UPDATE product p
SET stock_qty = stock_qty - ol.qty
FROM order_line ol
WHERE p.product_id = ol.product_id
  AND ol.order_id = 1
  AND p.stock_qty >= ol.qty;

COMMIT;
SELECT * FROM product;


-- Section B — Rollback on rule violation
SELECT * FROM product;
BEGIN;

INSERT INTO order_header (customer_id, status)
SELECT customer_id, 'PAID' FROM customer WHERE email = 'alpha@example.com';

INSERT INTO order_line (order_id, line_no, product_id, qty, unit_price)
SELECT oh.order_id, 1, p.product_id, 1000, p.unit_price
FROM order_header oh
JOIN customer c ON c.customer_id = oh.customer_id
JOIN product p ON p.sku = 'BASE-A'
WHERE c.email = 'alpha@example.com'
ORDER BY oh.order_id DESC LIMIT 1;

UPDATE product p
SET stock_qty = p.stock_qty - ol.qty
FROM order_line ol
WHERE p.product_id = ol.product_id
  AND ol.order_id =
      (SELECT MAX(order_id) FROM order_header)
  AND p.stock_qty >= ol.qty;

-- Check whether update succeeded
SELECT stock_qty
FROM product
WHERE sku = 'BASE-A';

ROLLBACK;

-- Order should not exist
SELECT *
FROM order_header
ORDER BY order_id DESC;

-- Order line should not exist
SELECT *
FROM order_line
ORDER BY order_id DESC;

-- Stock should be unchanged
SELECT sku, stock_qty
FROM product
WHERE sku = 'BASE-A';

-- Section C — Savepoint
BEGIN;

SAVEPOINT after_header;
INSERT INTO order_header (customer_id, status)
SELECT customer_id, 'PAID' FROM customer WHERE email = 'alpha@example.com';

SAVEPOINT after_lines;
INSERT INTO order_line (order_id, line_no, product_id, qty, unit_price)
SELECT oh.order_id, 1, p.product_id, 1000, p.unit_price
FROM order_header oh
JOIN customer c ON c.customer_id = oh.customer_id
JOIN product p ON p.sku = 'BASE-A'
WHERE c.email = 'alpha@example.com'
ORDER BY oh.order_id DESC LIMIT 1;

ROLLBACK TO SAVEPOINT after_lines;
INSERT INTO order_line (order_id, line_no, product_id, qty, unit_price)
SELECT oh.order_id, 1, p.product_id, 3, p.unit_price
FROM order_header oh
JOIN customer c ON c.customer_id = oh.customer_id
JOIN product p ON p.sku = 'BASE-A'
WHERE c.email = 'alpha@example.com'
ORDER BY oh.order_id DESC LIMIT 1;

COMMIT;