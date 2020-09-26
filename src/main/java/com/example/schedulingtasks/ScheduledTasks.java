package com.example.schedulingtasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import co.elastic.apm.api.*;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 1000)
	@CaptureTransaction
	@CaptureSpan
	public void doTask() {
		Transaction transaction = ElasticApm.currentTransaction();
		transaction.setName("Schedule-txn");
		ElasticApm.currentSpan().setName("Schedule-span");
		transaction.addLabel("label1", dateFormat.format(new Date()));
		log.info("In doTask {}", dateFormat.format(new Date()));
		taskDetail();
	}

	@CaptureSpan
	public void taskDetail() {
		log.info("In taskDetail {}", dateFormat.format(new Date()));
		Span span = ElasticApm.currentSpan();
		span.setName("task-detail-span");
		span.addLabel("TASK-DETAIL-SPAN-LABEL", "task-span-label-value");
	}
}
