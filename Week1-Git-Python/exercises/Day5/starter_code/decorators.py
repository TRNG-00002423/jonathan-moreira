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


def log_calls(func):
    """Decorator that logs function calls with arguments and return value.

    Output:
        "📞 Calling func_name(arg1, arg2, key=val)"
        "✅ func_name → return_value"
    """
    @wraps(func)
    def wrapper(*args, **kwargs):
        func_name = func.__name__
        func_args = ", ".join([str(arg) for arg in args] + [f"{k}={v}" for k,v in kwargs.items()])
        print(f"📞 Calling {func_name}({func_args})")
        func_result = func(*args, **kwargs)
        print(f"✅ {func_name} → {func_result}")

        return func_result
    
    return wrapper

@log_calls
def sum(a, b):
    return a + b

from unittest.mock import patch
import io

with patch('sys.stdout', new_callable=io.StringIO) as mock_stdout:
    result = sum(1, 2)
    output = mock_stdout.getvalue()

result = sum(1,2)
assert result == 3
assert "📞 Calling sum(1, 2)" in output
assert "✅ sum → 3" in output
