package net.skhu.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.skhu.dto.Sugang;
import net.skhu.service.SugangServiceImpl;


public class EnrolmentTest {

	public void testEnrolment() throws InterruptedException {
		int numberOfThreads = 100;
		ExecutorService service = Executors.newFixedThreadPool(10);
		CountDownLatch latch = new CountDownLatch(numberOfThreads);

		SugangServiceImpl sugangService = new SugangServiceImpl(null);
		Sugang sugang = new Sugang();

		for(int i =0; i < numberOfThreads; i++) {

			service.execute(() -> {

				sugang.setLectureId(1);

				sugangService.insertSugang(sugang);

			});
		}

		latch.await();
		assertEquals(sugangService.countSugang(1), 30);
	}



}
