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
    # TODO: Implement __init__, run(), and a class method

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


test1 = TestCase("test_login","test the login", "high", ["smoke","regression"])
print(f"{test1.name}")
print(f"{test1.tags}")
print(f"{TestCase.is_valid_name(test1.name)}")

test2 = TestCase.from_dict({"name": "test_logout", "description": "test_logout" , "priority" : "high", "tags" : ["smoke"]})
print(f"{test2.name}")
print(f"{test2.tags}")
