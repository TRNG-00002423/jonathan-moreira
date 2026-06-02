tests = [
    ("test_login", 1200, "✅PASS"),
    ("test_search", 850, "✅PASS"),
    ("test_checkout", 2300, "❌FAIL"),
    ("test_profile", 450, "✅PASS"),
    ("test_logout", 180, "✅PASS"),
]

print(f"Test Name           Duration            Status")
for name, duration, status in tests:
    print(f"{name:<16} {duration:>10,} ms {status:>16}")