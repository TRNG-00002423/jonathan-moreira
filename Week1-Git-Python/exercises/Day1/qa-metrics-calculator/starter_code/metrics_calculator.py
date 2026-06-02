total_test_cases = int(input("What is the total number of test cases?: "))
passed_tests = int(input("What is the tolta number of passed tests?: "))
total_execution_time_in_seconds = float(input("What is the total execution time in seconds?: "))


failed_tests = total_test_cases - passed_tests
pass_rate = passed_tests / total_test_cases
fail_rate = failed_tests / total_test_cases
average_time_per_test = total_execution_time_in_seconds / total_test_cases
print(f"Total tests failed: {failed_tests}, Pass rate: {pass_rate * 100:.1f} %, Fail Rate: {fail_rate * 100:.1f}%, Avg time per test: {average_time_per_test:.2f}")