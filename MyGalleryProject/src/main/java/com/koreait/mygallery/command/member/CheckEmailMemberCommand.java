package com.koreait.mygallery.command.member;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.dao.MemberDAO;
import com.koreait.mygallery.dto.Member;
import com.koreait.mygallery.util.SecurityUtils;

/**
 * 이메일 중복 여부를 판단하고<br>
 * 인증코드를 이메일에 전송하는 커맨드
 * 
 * @author 박세환
 */
@Component
public class CheckEmailMemberCommand implements MemberCommand {

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		Member member = (Member)model.asMap().get("member");
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		int result = dao.checkEmail(member);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", result == 0);
		if((boolean)resultMap.get("result")) {
			String key = SecurityUtils.createKey(6);
			resultMap.put("key", key);
			sendEmail(member.getEmail(), key);
		}
		return resultMap;
	}

	/**
	 * 이메일 전송
	 * 
	 * @param email 이메일주소
	 * @param key 키
	 */
	private void sendEmail(String email, String key) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			mimeMessage.setHeader("Content-Type", "text/plain; charset=UTF-8");
			mimeMessage.setFrom(new InternetAddress("forspringlec@gmail.com","관리자")); // 보내는 사람
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email)); // 받는 사람
			mimeMessage.setSubject("인증 요청 메일입니다.");
			mimeMessage.setText("인증번호는 '" + key + "'입니다.");
			
			mailSender.send(mimeMessage);
		} catch (MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
