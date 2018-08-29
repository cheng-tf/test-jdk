package cn.edu.bupt.opensource.test.jdk4.nio.timeserver.false_aio;/**
 * Created by boya on 2018/7/9.
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: TimeServerHandlerExecutorPool</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-07-09 13:40</p>
 *
 * @author ChengTengfei
 * @version 1.0
 */
public class TimeServerHandlerExecutorPool {

    private ExecutorService executorService;

    public TimeServerHandlerExecutorPool(int maxPoolSize, int queueSize) {
        executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                maxPoolSize, 120L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable task) {
        executorService.execute(task);
    }


}
