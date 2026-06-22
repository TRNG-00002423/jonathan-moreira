# 1. List entities you need (tables). Include any junction or child tables required for many-to-many or one-to-many rules above.
i. customers
    customer_id
    first_name
    last_name
    email
    phone
ii. products
    sku
    name
    price
    stock
iii. orders
    order_id
    customer_id
    date
    shipping_address
    status
iv. order_lines (many-to-many between orders and products) 
    order_id
    sku
    quantity
    price_at_time_of_sale

# 2. For each table, list primary key strategy (surrogate vs natural) and important alternate keys (UNIQUE).
i. customers - surrogate
    customer_id (PK)
    email       (UNIQUE)
ii. products - surrogate
    product_id  (PK)
iii. orders  - surrogate
    order_id    (PK)
iv. order_lines - natural (composite PK)
    oder_id     (PK, FK)
    product_id  (PK, FK)
