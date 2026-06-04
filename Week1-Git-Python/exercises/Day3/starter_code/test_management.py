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
    def __init__(self, test_case, duration_ms, error_message = None):
        self.test_name = test_case.name
        self.status = "pass" if test_case.run() else "fail"
        self.duration_ms = duration_ms
        self.error_message = error_message



    def summary(self):
        """Return a one-line summary like: '✅ test_login (120ms)'"""
        if self.status == "pass":
            return f"✅ {self.test_name} ({self.duration_ms}ms)"
        else:
            return f"❌ {self.test_name} ({self.duration_ms}ms)"