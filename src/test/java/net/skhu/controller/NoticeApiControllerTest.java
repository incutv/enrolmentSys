package net.skhu.controller;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import net.skhu.dto.Notice;
import net.skhu.mapper.NoticeMapper;

class NoticeApiControllerTest {

	private final NoticeMapper noticeMapper;

	public NoticeApiControllerTest(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}

	@Test
	void testList() {
		List<Notice> notices = noticeMapper.findAll();

		fail("Not yet implemented");
	}

}
