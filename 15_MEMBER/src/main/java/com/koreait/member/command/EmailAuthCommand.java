package com.koreait.member.command;

import java.io.UnsupportedEncodingException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class EmailAuthCommand {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailAuthCommand.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	public String execute(Model model) {

		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		String email = request.getParameter("email"); // 인증번호를 받는 사람 이메일
		String key = getKey();
		
		// MimeMessage 클래스
		// 이메일을 작성하는 클래스
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			mimeMessage.setHeader("Content-Type", "text/plain; charset=UTF-8");
			mimeMessage.setFrom(new InternetAddress("parksh980112@gmail.com","관리자")); // 보내는 사람
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email)); // 받는 사람
			mimeMessage.setSubject("인증 요청 메일입니다.");
			mimeMessage.setText("인증번호는 '" + key + "'입니다.");
			
			// 이메일 보내기
			mailSender.send(mimeMessage);
		} catch (MessagingException | UnsupportedEncodingException e) {
			LOGGER.warn("이메일 생성중 오류가 발생했습니다.");
			e.printStackTrace();
			return "";
		}
		
		return key;
	}

	private String getKey() {
		StringBuilder key = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			if(Math.random() > 0.4) {
				key.append((char)(Math.random() * ('Z' - 'A') + 'A'));
			} else {
				key.append((char)(Math.random() * ('9' - '0') + '0'));
			}
		}
		return key.toString();
	}
}
