use std::sync::{Arc, Mutex};
use std::thread;
use std::time::SystemTime;

fn main() {
    let t_init = SystemTime::now();
    let shared_variable = Arc::new(Mutex::new(1));
    let shared_variable_clone = shared_variable.clone();
    let handle1 = thread::spawn(move || {
        loop {
            let mut shared_variable = shared_variable_clone.lock().unwrap();
            if *shared_variable > 40 {
                break;
            }
            if *shared_variable % 2 == 1 {
                println!("Thread 1: {}", *shared_variable);
                *shared_variable += 1;
            }
        }
    });

    let handle2 = thread::spawn(move || {
        loop {
            let mut shared_variable = shared_variable.lock().unwrap();
            if *shared_variable > 40 {
                break;
            }
            if *shared_variable % 2 == 0 {
                println!("Thread 2: {}", *shared_variable);
                *shared_variable += 1;
            }
        }
    });

    handle1.join().unwrap();
    handle2.join().unwrap();
    println!("{}", t_init.elapsed().unwrap().as_nanos());
}
