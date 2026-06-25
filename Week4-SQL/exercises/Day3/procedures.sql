
-- A PROCEDURE is better about centralizing the business rule and reducing the risk of bugs due to scattering it.
CREATE OR REPLACE PROCEDURE adjust_stock(p_sku TEXT, p_delta INT)
LANGUAGE plpgsql
AS $$
	DECLARE p_current_stock INT;
	BEGIN
		SELECT stock_qty INTO p_current_stock FROM product WHERE sku = p_sku;

		IF p_current_stock - p_delta < 0 THEN
			RAISE EXCEPTION 'Not enough in stock';
		ELSE
			UPDATE product
			SET stock_qty = stock_qty + p_delta
			WHERE sku = p_sku;
		END IF;
			
	END;
		
$$;

--  Functions that return values are convenient and concise in PostgreSQL.
--  Some database systems emphasize stored procedures with OUT/INOUT parameters,
--  so Procedure A may be more portable across different RDBMS implementations.

CREATE OR REPLACE FUNCTION fetch_order_total(p_order_id INTEGER)
RETURNS NUMERIC(12,2)
LANGUAGE plpgsql
AS $$
DECLARE
    v_total NUMERIC(12,2);
BEGIN
    SELECT COALESCE(SUM(qty * unit_price), 0)
    INTO v_total
    FROM order_line
    WHERE order_id = p_order_id;

    RETURN v_total;
END;
$$;

CALL adjust_stock(1, -2);
SELECT fetch_order_total(1);