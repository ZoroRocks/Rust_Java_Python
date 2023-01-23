use std::time::SystemTime;
extern crate num;
use num::{BigInt, One};

fn factorial(n: u64) -> BigInt {
    let mut result = BigInt::one();
    for i in 2..=n {
        result = result * BigInt::from(i);
    }
    result
}
fn main() {
    let t_init = SystemTime::now();
    let num = 30000;
    let result = factorial(num);
    println!("The factorial of {} is {}", num, result);
   println!("{}", t_init.elapsed().unwrap().as_nanos());
}