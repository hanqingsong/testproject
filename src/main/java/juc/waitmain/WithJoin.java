package juc.waitmain;

import java.util.Random;

public class WithJoin {
 
    public WithJoin() {
    }
 
    public static void main(String[] args) throws InterruptedException {
        ChildThead t1 = new ChildThead(0);
        ChildThead t2 = new ChildThead(1);
        ChildThead t3 = new ChildThead(2);
        ChildThead t4 = new ChildThead(3);
 
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();


 
        System.out.println("Main finished");
    }
 
    static class ChildThead extends Thread {
 
        private int id = -1;
 
        public ChildThead(int id) {
            this.id = id;
        }
 
        public void run() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt(5000)));
                System.out.println(String
                        .format("Child Thread %d finished", id));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
 
}