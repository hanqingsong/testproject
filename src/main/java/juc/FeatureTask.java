package juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2019-08-27 16:25
 */
@Slf4j
public class FeatureTask {
    /**
     * FutureTask get请求阻塞并行任务
     *
     * @param args args
     * @return void
     * @author hanqingsong
     * @date 2019-08-27
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3));

        Task1 task1 = new Task1();
        Future future = threadPoolExecutor.submit(task1);
        // Object String1 = future.get();


        Task2 task2 = new Task2();
        Future future1 = threadPoolExecutor.submit(task2);
        // Object String2 = future1.get();


        Task3 Task3 = new Task3();
        Future future2 = threadPoolExecutor.submit(Task3);
        // Object String3 = future2.get();

        Object String1 = future.get();
        Object String2 = future1.get();
        Object String3 = future2.get();

        log.info("输出结果={}",String1);
        log.info("输出结果={}",String2);
        log.info("输出结果={}",String3);

    }




    public static class Task2 implements Callable {
        @Override
        public Object call() throws Exception {
            log.info("Task2 休眠开始");
            Thread.sleep(10000);
            log.info("Task2 休眠结束");
            return "Task2";
        }
    }

    public static class Task3 implements Callable {
        @Override
        public Object call() throws Exception {
            log.info("Task3 休眠开始");
            Thread.sleep(5000);
            log.info("Task3 休眠结束");
            return "Task3";
        }
    }
}
