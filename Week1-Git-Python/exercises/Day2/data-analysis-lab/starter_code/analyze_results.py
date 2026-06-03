import pandas as pd
df = pd.read_csv("test_data.csv")

# Print basic info:
print(len(df))
print(df.columns)
print(df.dtypes)
print(df.head())

# Calculate aggregate metrics:
pass_rate = (df["status"] == "pass").mean() * 100

avg_ms = df["duration_ms"].mean()
avg_sec = avg_ms / 1000

slowest = df.loc[df["duration_ms"].idxmax()]


fastest = df.loc[df["duration_ms"].idxmin()]


# Group by module
df["passed"] = df["status"] == "pass"
module_pass_rate = df.groupby("module")["passed"].mean() * 100
module_avg_duration = df.groupby("module")["passed"].mean()
module_test_count = df.groupby("module")["test_name"].count()


# Filter and display
failed_tests = df[df["status"] == "fail"][["test_name", "module", "duration_ms"]]
slow_tests = df[df["duration_ms"] > 1500][["test_name", "duration_ms"]]
slow_tests = df[df["duration_ms"] > 1500][["test_name", "duration_ms"]]
auth_tests = df[df["module"] == "auth"][["test_name", "module"]]


# Add a computed column
df["duration_sec"] = df["duration_ms"] / 1000

# Sort and Export
df_sorted = df.sort_values("duration_ms", ascending = False)

print(f"Test results Analysis")
print(f"{'Total Tests:':<15}   {len(df)}")
print(f"{'Pass Rate:':<15}   {pass_rate}%")
print(f"{'Average duration':<15}  {avg_ms:,.0f}ms ({avg_sec:.2f})")
print(f"{'Slowest:':<15}   {slowest['test_name']} ({slowest['duration_ms']:,.0f}ms)")
print(f"{'Fastest:':<15}   {fastest['test_name']} ({fastest['duration_ms']:,.0f}ms)")
"""
    print(f"Module Pass Rate: \n{module_pass_rate}")
    print(f"Module Avg Duration: \n{module_avg_duration}")
    print(f"Module Test Count: \n{module_test_count}")
    print(f"Failed Tests: \n{failed_tests}")
    print(f"Slow Tests: \n{slow_tests}")
    print(f"Auth Tests: \n{auth_tests}")
    print(f"Fastest: \n{fastest}")
    
    
    print(f"Average duration in sec: {avg_sec:.2f}sec")
    
"""
