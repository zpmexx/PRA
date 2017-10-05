package classes.one;

import example.HelloWorld;

public class RunnableForExecutors implements Runnable {

    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HelloWorld.class);

    private final long countUntil;

    RunnableForExecutors(long countUntil) {
            this.countUntil = countUntil;
        }

    @Override
    public void run() {
        long sum = 0;
        for (long i = 1; i < countUntil; i++) {
            sum += i;
        }
        logger.info(sum);
    }

}
