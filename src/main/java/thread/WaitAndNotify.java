package thread;

/**
 *
 * wait 和 notify使用
 * 使用wait和notify的时候一定要配合synchronized关键字去使用
 * @author hanqingsong
 * @version 1.0
 * @date 2020-12-24 16:46
 */
public class WaitAndNotify {
    private static Object lock = new Object();

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    for (int i = 0; i < 100; i++) {
                        System.out.println("Thread A " + i);
                        lock.notify();
                        lock.wait();
                    }
                    lock.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    for (int i = 0; i < 100; i++) {
                        System.out.println("Thread B " + i);
                        lock.notify();
                        lock.wait();
                    }
                    lock.notify();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new WaitAndNotify.ThreadA()).start();
        Thread.sleep(10);
        new Thread(new WaitAndNotify.ThreadB()).start();
    }
}
