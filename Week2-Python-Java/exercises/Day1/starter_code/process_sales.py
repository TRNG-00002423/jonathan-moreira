"""
Week 2 Exercise — CSV processing with context managers.

TODO:
1. Read starter_code/data/sales.csv using csv.DictReader and with open(...).
2. Compute rows count, grand total (sum of units * unit_price), average line revenue.
3. Find SKU with max line revenue (tie: first in file).
4. Write output/summary.txt using with open(..., "w", encoding="utf-8").
"""

from __future__ import annotations
import csv

def main() -> None:
    with open("./data/sales.csv",mode="r", encoding="utf-8") as file:
        reader = csv.DictReader(file)
        row_count = 0
        grand_total = 0.0
        avg_line_revenue = 0.0
        max_item_sku = ""
        max_line_revenue = 0.0


        for row in reader:
            try:
                row["units"] = int(row["units"])
                row["unit_price"] = float(row["unit_price"])
                row_count += 1
            except ValueError as e:
                print({e})

            line_revenue = row["units"] * row["unit_price"]
            grand_total += line_revenue
            

            if line_revenue > max_line_revenue:
                max_item_sku = row["sku"]
                max_line_revenue = line_revenue

        
        avg_line_revenue = grand_total / row_count

    with open("./output/summary.txt",mode="w", encoding="utf-8") as file:
        file.write(f"Number of items {row_count}\n")
        file.write(f"Total Price: ${grand_total}\n")
        file.write(f"Average line revenue: ${avg_line_revenue:.2f}\n")
        file.write(f"Max line revenue: {max_item_sku}: ${max_line_revenue}\n")

if __name__ == "__main__":
    main()