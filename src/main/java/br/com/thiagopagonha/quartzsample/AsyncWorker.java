package br.com.thiagopagonha.quartzsample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncWorker {

	private static final Logger LOG = LoggerFactory.getLogger(AsyncWorker.class);
	
    @Async
    public void work(int i) {
        String threadName = Thread.currentThread().getName();
        LOG.info("   " + threadName + " beginning work on " + i);
        try {
            Thread.sleep(5000); // simulates work
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        LOG.info("   " + threadName + " completed work on " + i);
    }
}