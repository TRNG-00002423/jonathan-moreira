import pandas as pd
df = pd.read_csv("test_data.csv")

# Print basic info:
print(len(df))
print(df.columns)
print(df.dtypes)
print(df.head())

# Calculate aggregate metrics:
pass_rate = (df["status"] == "pass").mean() * 100
print(f"Pass rate: {pass_rate}")

avg_ms = df["duration_ms"].mean()
avg_sec = avg_ms / 1000
print(f"Average duration in ms: {avg_ms:.2f}ms")
print(f"Average duration in sec: {avg_sec:.2f}sec")

slowest = df.loc[df["duration_ms"].idxmax()]
print(f"Slowest: \n{slowest}")

fastest = df.loc[df["duration_ms"].idxmin()]
print(f"Fastest: \n{fastest}")

# Group by module
df["passed"] = df["status"] == "pass"
module_pass_rate = df.groupby("module")["passed"].mean() * 100
module_avg_duration = df.groupby("module")["passed"].mean()
module_test_count = df.groupby("module")["test_name"].count()
print(f"Module Pass Rate: \n{module_pass_rate}")
print(f"Module Avg Duration: \n{module_avg_duration}")
print(f"Module Test Count: \n{module_test_count}")

# Filter and display
failed_tests = df[df["status"] == "fail"][["test_name", "module", "duration_ms"]]
slow_tests = df[df["duration_ms"] > 1500][["test_name", "duration_ms"]]
slow_tests = df[df["duration_ms"] > 1500][["test_name", "duration_ms"]]
auth_tests = df[df["module"] == "auth"][["test_name", "module"]]
print(f"Failed Tests: \n{failed_tests}")
print(f"Slow Tests: \n{slow_tests}")
print(f"Auth Tests: \n{auth_tests}")
