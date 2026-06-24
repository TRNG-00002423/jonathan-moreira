
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

CALL adjust_stock(1, -2);