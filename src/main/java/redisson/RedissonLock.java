package redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2021/4/18 8:02 下午
 */
public class RedissonLock {
    private static final String LOCK_KEY = "REDLOCK_KEY";
    public static   RedissonClient redissonClient ;
    static {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379")
                .setDatabase(0);
        redissonClient = Redisson.create(config);
    }
    public RedissonLock() {

    }

    public  RedissonClient getRedissonClient() {
        return redissonClient;
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        List<Callable<Void>> list = new ArrayList<Callable<Void>>();
        for (int i = 0; i < 3; i++) {
            list.add(new ChildThead(i));
        }
        System.out.println(list.size());
        try {
            pool.invokeAll(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
            System.out.println(String.format("Child Thread %d start", id));
            RedissonClient redissonClient = new RedissonLock().getRedissonClient();
            RLock rLock = redissonClient.getLock(RedissonLock.LOCK_KEY);
            System.out.println(id + " 获取锁开始");
            rLock.lock();
            System.out.println(id + " 获取锁结束");

            try {
                Thread.sleep(6000);
                System.out.println(String.format("Child Thread %d finished", id));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                rLock.unlock();
            }
            return null;
        }
    }



}
