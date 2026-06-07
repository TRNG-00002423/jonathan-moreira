"""
Legacy Test Runner — Uses print() everywhere.
YOUR TASK: Replace ALL print() calls with appropriate logging calls.

Import and use setup_logging() from logging_config.py.
"""

import time
import random
import logging_config

logger = logging_config.setup_logging()

def run_test(test_name):
    """Run a single test (simulated)."""
    logger.debug(f"Running test: {test_name}")
    duration = random.uniform(0.1, 2.0)
    time.sleep(0.01)

    if random.random() < 0.2:
        logger.error(f"{test_name} failed! Duration: {duration:.2f}s")
        return False

    logger.debug(f"{test_name} passed ({duration:.2f}s)")
    return True


def run_suite(suite_name, test_names):
    """Run a suite of tests."""
    # print(f"\n{'='*50}")
    logger.info(f"Starting suite: {suite_name}")
    logger.info(f"Tests to run: {len(test_names)}")
    # print(f"{'='*50}\n")

    results = {"passed": 0, "failed": 0}

    for i, test in enumerate(test_names, 1):
        if run_test(test):
            results["passed"] += 1
        else:
            results["failed"] += 1

    total = results["passed"] + results["failed"]
    rate = results["passed"] / total * 100

    # print(f"\n{'='*50}")
    logger.info(f"Results: {results['passed']}/{total} passed ({rate:.1f}%)")

    if rate < 80:
        logger.warning(f"Pass rate below 80%!")
    if rate < 50:
        logger.critical(f"More than half the tests failed!")

    return results


def main():
    logger.info("QA Test Framework v1.0")
    logger.info("Initializing...")

    random.seed(42)

    suites = {
        "Smoke Tests": ["test_login", "test_homepage", "test_search"],
        "Regression": ["test_checkout", "test_payment", "test_profile",
                       "test_settings", "test_logout"],
        "Performance": ["test_load_page", "test_api_response"],
    }

    all_results = {"passed": 0, "failed": 0}

    for suite_name, tests in suites.items():
        try:
            result = run_suite(suite_name, tests)
            all_results["passed"] += result["passed"]
            all_results["failed"] += result["failed"]
        except Exception as e:
            logger.error(f"Suite {suite_name} crashed: {e}", exc_info=True)

    total = all_results["passed"] + all_results["failed"]
    logger.info(f"\nFinal: {all_results['passed']}/{total} overall")


if __name__ == "__main__":
    main()