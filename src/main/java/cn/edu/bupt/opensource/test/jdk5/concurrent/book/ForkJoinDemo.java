package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * <p>Title: ForkJoinDemo</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 17:31</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class ForkJoinDemo extends RecursiveTask<Long>{

    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if(canCompute) {
            for(long i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 分成100小任务
            long step = (start + end) / 100;
            ArrayList<ForkJoinDemo> subTasks = new ArrayList<>();
            long pos = start;
            for(int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                if(lastOne > end) {
                    lastOne = end;
                }
                ForkJoinDemo subTask = new ForkJoinDemo(pos, lastOne);
                pos += step+1;
                subTasks.add(subTask);
                subTask.fork();
            }
            for(ForkJoinDemo t : subTasks) {
                sum += t.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(0, 200000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        System.out.println("sum = " + result.get());
    }

}
