package juc.waitmain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WithExecutor {
 
    public static void main(String[] args) throws InterruptedException {
 
        ExecutorService pool = Executors.newFixedThreadPool(3);
 
        List<Callable<Void>> list = new ArrayList<Callable<Void>>();
        for (int i = 0; i < 3; i++) {
            list.add(new ChildThead(i));
        }
 
        try {
            pool.invokeAll(list);
        } finally {
            pool.shutdown();
        }
 
        System.out.println("Main finished");
    }
 
    static class ChildThead implements Callable<Void> {
 
        private int id = -1;
 
        public ChildThead(int id) {
            this.id = id;
        }
 
        @Override
        public Void call() throws Exception {
            try {
                Thread.sleep(Math.abs(new Random().nextInt(5000)));
                System.out.println(String
                        .format("Child Thread %d finished", id));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}