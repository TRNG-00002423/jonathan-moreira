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