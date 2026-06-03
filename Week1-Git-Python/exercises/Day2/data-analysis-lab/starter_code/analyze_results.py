import pandas as pd
df = pd.read_csv("test_data.csv")

print(len(df))
print(df.columns)
print(df.dtypes)
print(df.head())