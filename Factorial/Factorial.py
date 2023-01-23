import time
from decimal import Decimal

def factorial(n):
    result = Decimal(1)
    for i in range(1, n+1):
        result *= Decimal(i)
    return result

# Example usage


if __name__ == "__main__":
    start_time = time.perf_counter_ns()
    print(factorial(30000))
    print("Runtime: ", time.perf_counter_ns() - start_time)