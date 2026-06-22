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
    sku
iii. orders  - surrogate
    order_id    (PK)
iv. order_lines - natural (composite PK)
    oder_id     (PK, FK)
    product_id  (PK, FK)

# 4. Write 5–8 bullet “design decisions”
* Surrogate keys for customers, products, orders because the advantage of a surrogate key is that it's stable — it never needs to change regardless of what happens to the real-world data (e.g. change in email from a customer)
* Natural Key for order_lines because the identity of a line item is naturally defined by which order + which product
* Shipping address as a string in orders because storing it on orders preserves the shipping history per order compared to storing it in the costumers table
* Order lines table stores a price_at_time_of_sale even though products have a price attribute because prices might change over time
* A composite key for Order lines table because you'd have duplicate order_id values which violates the uniqueness constraint