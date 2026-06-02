total_test_cases = int(input("What is the total number of test cases?: "))
passed_tests = int(input("What is the tolta number of passed tests?: "))
total_execution_time_in_seconds = float(input("What is the total execution time in seconds?: "))


failed_tests = total_test_cases - passed_tests
pass_rate = passed_tests / total_test_cases
fail_rate = failed_tests / total_test_cases
average_time_per_test = total_execution_time_in_seconds / total_test_cases
print(f"\nTotal tests: {total_test_cases} \nTotal tests passed {passed_tests} \nTotal tests failed: {failed_tests} \nPass rate: {pass_rate * 100:.1f}% \nFail Rate: {fail_rate * 100:.1f}% \nAvg time per test: {average_time_per_test:.2f}s")

if (pass_rate >= 0.95):
    print("✅ RELEASE APPROVED")
elif (pass_rate >= 0.80):
    print("⚠️ CONDITIONAL RELEASE — review failures")
else:
    print("❌ RELEASE BLOCKED — too many failures")