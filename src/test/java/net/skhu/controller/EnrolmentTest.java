package net.skhu.controller;

public class EnrolmentTest {

//	public void testEnrolment() throws InterruptedException {
//		int numberOfThreads = 100;
//		ExecutorService service = Executors.newFixedThreadPool(10);
//		CountDownLatch latch = new CountDownLatch(numberOfThreads);
//
//		ReqSugang sugang = new ReqSugang();
//
//		for(int i =0; i < numberOfThreads; i++) {
//
//			service.execute(() -> {
//
//				sugang.setLectureId(1);
//				sugang.setStudentId(1);
//				sugang.setYear(2022);
//				sugang.setSemester(2);
//				sugang.setCredit(3);
//				insertSugang(sugang);
//
//			});
//		}
//
//		latch.await();
//		assertEquals(SugangMapper.countSugang(1), 100);
//	}
//
//
//	public synchronized int insertSugang(ReqSugang sugang) {
//		if ( countSugang(sugang.getLectureId()).equals("OK")) {
//			return SugangMapper.insertSugang(sugang);
//		}
//		else {
//			throw new NullPointerException(Message.SUGANG_FULL.getMessage());
//		}
//	}
//
//	public String countSugang(int lectureId) {
//		return SugangMapper.countSugang(lectureId);
//	}


}
