class TestCase:
    """Represents a single test case.

    Class Attributes:
        total_created (int): Count of all TestCase objects ever created

    Instance Attributes:
        name (str): Test name (e.g., "test_login_valid")
        description (str): What this test verifies
        priority (str): "high", "medium", or "low" (default: "medium")
        tags (list): Labels like ["smoke", "regression"]
    """

    total_created = 0

    def __init__(self, name, description, tags, priority = "medium"):
        self.name = name
        self.description = description
        self.tags = tags
        self.priority = priority
        TestCase.total_created += 1
    
    
    def run(self):
        """Simulate running the test. Return True for pass, False for fail.
        For now, use: return "fail" not in self.name
        """
        return "fail" not in self.name

    @classmethod
    def from_dict(cls, data):
        """Create a TestCase from a dictionary.
        Example: TestCase.from_dict({"name": "test_login", "priority": "high"})
        """
        return cls(data["name"], data["description"], data.get("tags" , []), data.get("priority" , "medium"))

    @staticmethod
    def is_valid_name(name):
        """Check if name starts with 'test_' and has no spaces."""
        return name.startswith("test_") and " " not in name


class TestResult:
    """The outcome of running a single test.

    Instance Attributes:
        test_name (str): Which test was run
        status (str): "pass" or "fail"
        duration_ms (float): How long it took
        error_message (str or None): Error details if failed
    """
    def __init__(self, test_name, status, duration_ms, error_message = None):
        self.test_name = test_name
        self.status = status
        self.duration_ms = duration_ms
        self.error_message = error_message



    def summary(self):
        """Return a one-line summary like: '✅ test_login (120ms)'"""
        if self.status == "pass":
            return f"✅ {self.test_name:<19} ({self.duration_ms}ms)"
        else:
            return f"❌ {self.test_name:<19} ({self.duration_ms}ms)"


class TestSuite:
    """A collection of test cases.

    Instance Attributes:
        name (str): Suite name
        tests (list): List of TestCase objects
    Methods:
        add_test(test): Add a TestCase
        remove_test(name): Remove by name
        get_by_priority(priority): Return tests matching the priority
        count(): Return number of tests
    """
    def __init__(self, name, tests = None):
        self.name = name
        self.tests = tests if tests is not None else []

    def add_test(self,test_case):
        self.tests.append(test_case)

    def remove_test(self, test_name):
        for test in self.tests:
            if test.name == test_name:
                self.tests.remove(test)
    
    def get_by_priority(self, priority):
        tests_priority = []
        for test in self.tests:
            if test.priority == priority:
                tests_priority.append(test)
        
        return tests_priority
    
    def count(self):
        return len(self.tests)


class TestRunner:
    """Executes a TestSuite and collects results.

    Methods:
        run(suite): Run all tests in a suite, return list of TestResult
        summary(results): Print a formatted summary
    """
    def run(self, suite):
        """Run each test in the suite and return a list of TestResults."""
        import time
        import random
        results = []
        for test in suite.tests:
            start = time.time()
            passed = test.run()
            duration = (time.time() - start) * 1000
            # Simulate varying duration
            duration += random.uniform(50, 500)
            result = TestResult(
                test.name,
                "pass" if passed else "fail",
                round(duration, 1),
                None if passed else f"{test.name} assertion failed"
            )
            results.append(result)
        return results
    
    def summary(self, results):
        print(f"\n===== Tests Summary =====")
        for result in results:
            print(result.summary())

def main():
    test_case_1 = TestCase("test_login", "tests login working", ["smoke"], "medium")
    test_case_2 = TestCase("test_login_fail", "tests login fails when submitting empty login", ["regression"], "high")
    test_case_3 = TestCase("test_payment", "tests payment working", ["regression"], "high")
    test_case_4 = TestCase.from_dict({"name"        : "test_payment_fail", 
                                      "description" : "tests payment fails"})
    test_case_5 = TestCase("test_withdraw", "tests withdraw working", ["regression"], "low")
    test_case_6 = TestCase.from_dict({"name"        : "test_withdraw_fail", 
                                      "description" :"tests withdraw fails"})
    
    test_suite = TestSuite("test")
    test_suite.add_test(test_case_1)
    test_suite.add_test(test_case_2)
    test_suite.add_test(test_case_3)
    test_suite.add_test(test_case_4)
    test_suite.add_test(test_case_5)
    test_suite.add_test(test_case_6)

    high_priority = test_suite.get_by_priority("high")
    print(f"===== High Priority Tests =====")
    for test in high_priority:
        print(test.name)

    test_runner = TestRunner()
    test_results = test_runner.run(test_suite)
    test_runner.summary(test_results)

main()