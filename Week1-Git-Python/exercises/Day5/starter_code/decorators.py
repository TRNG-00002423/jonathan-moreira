import time
from functools import wraps

def timer(func):
    """Decorator that measures and prints execution time.

    Output format: "⏱️ {func_name} completed in {seconds:.4f}s"
    """
    @wraps(func)
    def wrapper(*args, **kwargs):
        start_time = time.time()
        result = func(*args, **kwargs)
        finish_time = time.time()
        seconds = finish_time - start_time
        func_name = func.__name__
        print(f"⏱️ {func_name} completed in {seconds:.4f}s")
        return result
    
    return wrapper

@timer
def slow_operation():
    time.sleep(0.5)
    return "done"

result = slow_operation()
# Should print: ⏱️ slow_operation completed in 0.50XXs
assert result == "done"
assert slow_operation.__name__ == "slow_operation"  # @wraps preserves metadata


def retry(max_attempts=3, delay=0.5, exceptions=(Exception,)):
    """Parameterized decorator that retries on failure.

    Args:
        max_attempts: Maximum number of tries
        delay: Seconds between retries
        exceptions: Tuple of exception types to catch

    Prints progress: "⚠️ Attempt {n}/{max}: {error}. Retrying in {delay}s..."
    On final failure: "💥 {func_name} failed after {max} attempts"
    """
    def result(func):
        @wraps(func)
        def wrapper(*args, **kwargs):
            for i in range(1, max_attempts + 1):
                try:
                    func_name = func.__name__
                    test_result = func(*args, **kwargs)
                    return test_result
                except exceptions as e:
                    if i < max_attempts:
                        print(f"⚠️ Attempt {i}/{max_attempts}: {e}. Retrying in {delay}s...")
                        time.sleep(delay)
                    else:
                        print(f"💥 {func_name} failed after {max_attempts} attempts")
                        raise e
        return wrapper
    
    return result

attempt_count = 0

@retry(max_attempts=3, delay=0.1)
def flaky_function():
    global attempt_count
    attempt_count += 1
    if attempt_count < 3:
        raise ConnectionError("Server unavailable")
    return "success"

result = flaky_function()
assert result == "success"