package net.skhu.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.skhu.mapper.master.SugangMasterMapper;
import net.skhu.service.SugangService;

@SpringBootTest
public class EnrolmentTest {

	@Autowired
	SugangService sugangService;

	@Autowired
	SugangMasterMapper sugangMapper;

	@Test
	public void testEnrolment() throws InterruptedException {
		int numberOfThreads = 100;
		ExecutorService service = Executors.newFixedThreadPool(10);
		CountDownLatch latch = new CountDownLatch(numberOfThreads);

		for(int i =0; i < numberOfThreads; i++) {

			service.execute(() -> {
//				ReqSugang sugang = ReqSugang.builder()
//						.lectureId(1)
//						.studentId(1)
//						.year(2022)
//						.semester(2)
//						.build();
//
//				sugangService.insertSugang(sugang);
				latch.countDown();

			});
		}

		latch.await();
		assertEquals(32, sugangMapper.countSugangInt(2022, 2, 1));
	}




}
