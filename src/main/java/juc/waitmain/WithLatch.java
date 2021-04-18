package juc.waitmain;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class WithLatch {
 
    public WithLatch() {
    }
 
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new ChildThead(i, latch).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main finished");
    }
     
    static class ChildThead extends Thread {
 
        private int id = -1;
        private CountDownLatch latch = null;
 
        public ChildThead(int id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }
 
        @Override
        public void run() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt(5000)));
                System.out.println(String
                        .format("Child Thread %d finished", id));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
    }
}