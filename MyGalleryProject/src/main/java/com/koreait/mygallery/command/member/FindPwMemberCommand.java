package com.koreait.mygallery.command.member;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.dao.MemberDAO;
import com.koreait.mygallery.dto.Member;
import com.koreait.mygallery.util.SecurityUtils;

@Component
public class FindPwMemberCommand implements MemberCommand{

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		Member member = (Member)model.asMap().get("member");
		
		Member findMember = dao.findMember(member);
		model.addAttribute("findMember", findMember);
		if(findMember == null)
			return null;

		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		HttpSession session = request.getSession();
		String key = SecurityUtils.createKey(8);
		session.setAttribute("key", key);
		
		sendEmail(member.getEmail(), key);
		return null;
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
