package net.skhu.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import net.skhu.mapper.NoticeMapper;

@SpringBootTest
class NoticeControllerTest {

	@Autowired
	NoticeMapper noticeMapper;

//	public NoticeControllerTest(NoticeMapper noticeMapper) {
//		this.noticeMapper = noticeMapper;
//	}

//	@AfterEach
//	public void afterEach() {
//
//	}

	@Test
	@Transactional
	void 글쓰기() {
//		//given
//		ResNotice notice = new ResNotice();
//		notice.setDate(new Date());
//		notice.setStart_date(new Date());
//		notice.setEnd_date(new Date());
//		notice.setViews(0);
//		notice.setContents("내용");
//		notice.setSubject("제목");
//		notice.setWriter("작성자");
//
//		//when
//		noticeMapper.insertNotice(notice);
//
//		//then
//		ResNotice result = noticeMapper.findOne(notice.getSeq());
//		//Assertions.assertThat(notice).isEqualTo(result);
//		Assertions.assertThat(notice.getSeq()).isEqualTo(result.getSeq());
	}

}
