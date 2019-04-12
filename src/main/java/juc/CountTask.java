package juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by hanqingsong on 18/12/20.
 * fork/join
 * @author hanqingsong
 * @date 18/12/20
 */
public class CountTask extends RecursiveTask<Integer>{
    private int start;
    private int end;
    // 阀值
    private static final int THRESHOLD = 2;
    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        int sum =0;
        // 判断任务是否足够小
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum+=i;
            }
        }else {
            // 如果任务大于阀值，分裂两个子任务计算
            int middle=(start+end)/2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            // 执行子任务
            leftTask.fork();
            rightTask.fork();
            // 等等任务执行完，并得到其结果

            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();
            // 合并子任务
            sum=leftResult+rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1, 3);
        ForkJoinTask<Integer> submit = forkJoinPool.submit(countTask);
        try {
            Integer sum = submit.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
