import threading
import time

shared_variable = 1

def print_odd():
    global shared_variable
    while shared_variable <= 40:
        if shared_variable % 2 != 0:
            print("Thread 1: ", shared_variable)
            shared_variable += 1

def print_even():
    global shared_variable
    while shared_variable <= 40:
        if shared_variable % 2 == 0:
            print("Thread 2: ", shared_variable)
            shared_variable += 1

if __name__ == "__main__":
    start_time = time.perf_counter_ns()
    t1 = threading.Thread(target=print_odd)
    t2 = threading.Thread(target=print_even)

    t1.start()
    t2.start()

    t1.join()
    t2.join()

    print("Runtime: ", time.perf_counter_ns() - start_time)