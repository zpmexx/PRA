package classes.one;

import example.HelloWorld;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class Executor2 {

    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HelloWorld.class);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            sleep(1000);
            logger.info("pierwszy");
            return null;
        });
        executor.submit(() -> {
            sleep(1000);
            logger.info("drugi");
            return null;
        });
        executor.submit(() -> {
            sleep(1000);
            logger.info("trzeci");
            return null;
        });

        logger.info(executor.getPoolSize());
        logger.info(executor.getQueue().size());

        sleep(1000);

        logger.info(executor.getPoolSize());
        logger.info(executor.getQueue().size());

        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();
        // Wait until all threads are finish
        try {
            executor.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished all threads");
    }
}
