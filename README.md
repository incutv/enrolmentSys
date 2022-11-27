# enrolmentSys
CREATE TABLE `notice` (
  `seq` int NOT NULL AUTO_INCREMENT COMMENT '순번',
  `subject` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '제목',
  `contents` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '내용',
  `req_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '작성일',
  `start_date` date NOT NULL DEFAULT (curdate()) COMMENT '시작일',
  `end_date` date NOT NULL DEFAULT (curdate()) COMMENT '종료일',
  `views` int NOT NULL DEFAULT '0' COMMENT '조회수',
  `writer` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '작성자',
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=476 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `notice_reply` (
  `reply_seq` int NOT NULL AUTO_INCREMENT,
  `notice_seq` int NOT NULL,
  `parent_id` int DEFAULT NULL,
  `depth` int DEFAULT NULL,
  `reply_content` text,
  `reply_writer` varchar(100) NOT NULL,
  `reply_password` varchar(300) NOT NULL,
  `reply_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`reply_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `sugang` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lectureId` int DEFAULT NULL,
  `studentId` int DEFAULT NULL,
  `year` int DEFAULT NULL,
  `semester` int DEFAULT NULL,
  `credit` int DEFAULT NULL,
  `cancel` tinyint DEFAULT NULL,
  `grade` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Sugang_Student_idx` (`studentId`),
  KEY `FK_Sugang_Lecture_idx` (`lectureId`),
  CONSTRAINT `FK_Sugang_Lecture` FOREIGN KEY (`lectureId`) REFERENCES `lecture` (`id`),
  CONSTRAINT `FK_Sugang_Student` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=501 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `studentNo` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `departmentId` int DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `sex` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(100) NOT NULL COMMENT 'sha256',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_Student_Department_idx` (`departmentId`),
  CONSTRAINT `FK_Student_Department` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `shortName` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `lecture` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `professorId` int DEFAULT NULL,
  `year` int DEFAULT NULL,
  `semester` int DEFAULT NULL,
  `room` varchar(45) DEFAULT NULL,
  `credit` int DEFAULT NULL COMMENT '학점',
  `entry` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Lecture_Professor_idx` (`professorId`),
  CONSTRAINT `FK_Lecture_Professor` FOREIGN KEY (`professorId`) REFERENCES `professor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


#기능 구현
* 강의신청시스템
	* 공지사항
		* 리스트 
		* 작성페이지 
		* 페이징 처리 
		* 수정페이지 
		* 댓글 작성 (x)
		* 게시 기간 처리 
		* 캐싱 처리 
			* ehcache
			
	* 수강신청
		* 수강신청리스트 
		    * 수강 취소
		* 수강신청내역 
		* 수강신청페이지 
			* 동시성 처리 < synchronized >
			* validation check
				* 최대 학점(20점) 넘기면 신청 방지
				* 강의 당 자리 수 체크
				* 중복신청 체크
				
	* 로그인 
		* student 테이블 활용 < 학번으로 로그인 > 
		* 로그인 < HttpSession >
		* 로그아웃
		* 회원가입 
			* 비밀번호암호화 < Spring security >
		* 아이디/비밀번호 찾기 
		* 비밀번호 변경 후 6개월지나면 변경권유 (x)
		
- 기술스택
    - spring boot2.x , java11 , mysql , mybatis , ehcache , redis