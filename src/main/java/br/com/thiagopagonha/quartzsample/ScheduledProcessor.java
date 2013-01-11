package br.com.thiagopagonha.quartzsample;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledProcessor  {

	private static final Logger LOG = LoggerFactory.getLogger(ScheduledProcessor.class);
	
    private final AtomicInteger counter = new AtomicInteger();

    @Autowired
    public ScheduledProcessor(AsyncWorker worker) {
    	this.worker = worker;
    }
    
    private AsyncWorker worker;

    @Scheduled(fixedDelay = 30000)
    public void process() {
        LOG.info("processing next 10 at " + new Date());
        for (int i = 0; i < 10; i++) {
            worker.work(counter.incrementAndGet());
        }
    }
}