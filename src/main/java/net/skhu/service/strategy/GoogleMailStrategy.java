package net.skhu.service.strategy;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.Message;

@Slf4j
public class GoogleMailStrategy implements MailStrategy{
	private final JavaMailSender javaMailSender;

	public GoogleMailStrategy(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public boolean sign(String email, String name) {
		log.info("메일 발송 시작");

		String from = "수강신청서비스 <daonmom1204@gmail.com> ";
		String to = email;
		String subject = name + "님 " + Message.STUDENT_SIGN_SUJECT.getMessage();
		String content = name + "님 " + Message.STUDENT_SIGN_CONTENT.getMessage();

		try {
			MimeMessage mail = javaMailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");

			mailHelper.setFrom(from);
            // 빈에 아이디 설정한 것은 단순히 smtp 인증을 받기 위해 사용 따라서 보내는이(setFrom())반드시 필요
            // 보내는이와 메일주소를 수신하는이가 볼때 모두 표기 되게 원하신다면 아래의 코드를 사용하시면 됩니다.
            //mailHelper.setFrom("보내는이 이름 <보내는이 아이디@도메인주소>");
			mailHelper.setTo(to);
			mailHelper.setSubject(subject);
			mailHelper.setText(content, true);
			javaMailSender.send(mail);
			log.info("메일 발송 완료");
			return true;
		} catch(Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}


		return false;

	}

	@Override
	public boolean withraw(String email, String name) {
		log.info("메일 발송 시작");

		String from = "수강신청서비스 <daonmom1204@gmail.com> ";
		String to = email;
		String subject = name + "님 " + Message.STUDENT_WITHRAW.getMessage();
		String content = name + "님 " + Message.STUDENT_WITHRAW.getMessage();

		try {
			MimeMessage mail = javaMailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");

			mailHelper.setFrom(from);
            // 빈에 아이디 설정한 것은 단순히 smtp 인증을 받기 위해 사용 따라서 보내는이(setFrom())반드시 필요
            // 보내는이와 메일주소를 수신하는이가 볼때 모두 표기 되게 원하신다면 아래의 코드를 사용하시면 됩니다.
            //mailHelper.setFrom("보내는이 이름 <보내는이 아이디@도메인주소>");
			mailHelper.setTo(to);
			mailHelper.setSubject(subject);
			mailHelper.setText(content, true);
			javaMailSender.send(mail);
			log.info("메일 발송 완료");
			return true;
		} catch(Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}


		return false;
	}







}
