package net.skhu.controller;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import net.skhu.dto.Criteria;
import net.skhu.dto.Notice;
import net.skhu.mapper.NoticeMapper;

class NoticeApiControllerTest {

	private final NoticeMapper noticeMapper;

	public NoticeApiControllerTest(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}

	@Test
	void testList() {
		Criteria cri = new Criteria();
		List<Notice> notices = noticeMapper.findAll(cri);

		fail("Not yet implemented");
	}

}
