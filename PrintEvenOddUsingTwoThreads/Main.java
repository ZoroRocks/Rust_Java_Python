
class EvenOdd {
    private int n;
    private boolean noOdd;

    public EvenOdd(int n) {
        this.n = n;
        noOdd = false;
    }

    public synchronized void even() {
        for(int i=1;i<=n;i=i+2){
                while(noOdd){
                   try {
                        wait();
                    }
                    catch (
                        InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                noOdd = true;
                System.out.println(i);
                notifyAll();
        }
    }

    public synchronized void odd() {
        for(int i=2;i<=n;i=i+2){
                while(noOdd==false){
                    try {
                        wait();
                    }
                    catch (
                        InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                noOdd = false;
                System.out.println(i);
                notifyAll();
        }
    }
}


public class Main {
    public static void main(String[] args)  throws InterruptedException{
        long tInit = System.nanoTime();
        EvenOdd evenOdd = new EvenOdd(40);
        Thread thread1 = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    evenOdd.odd();
                                }
                            });
        Thread thread2 = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    evenOdd.even();
                                }
                            });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(System.nanoTime() - tInit);
    }
}
