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

	@Scheduled(fixedRate = 5000)
	@CaptureTransaction
	@CaptureSpan
	public void doTask() {
		log.info("in doTask");
		task();
	}

	@CaptureSpan
	public void task() {
		log.info("In task {}", dateFormat.format(new Date()));
	}
}
