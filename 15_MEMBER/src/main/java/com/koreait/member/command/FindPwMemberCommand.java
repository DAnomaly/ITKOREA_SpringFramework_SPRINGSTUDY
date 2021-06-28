package com.koreait.member.command;

import java.io.UnsupportedEncodingException;

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

import com.koreait.member.dao.MemberDAO;

@Component
public class FindPwMemberCommand{

	@Autowired
	private JavaMailSender mailSender;

	public String execute(SqlSession sqlSession, Model model) {
		StringBuilder resMessage = new StringBuilder();
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		int count = dao.findPw(id, email);
		if( count != 1 ) {
			// 회원 찾기 실패
			resMessage.append("<script>\n");
			resMessage.append("alert('아이디와 이메일이 동일한 회원을 찾지 못하였습니다.');\n");
			resMessage.append("history.back();\n");
			resMessage.append("</script>");
			return resMessage.toString();
		}
		String key = SecurityUtils.createKey(12);
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("key", key);
		String url = "http://localhost:9090/member/changePwPage.do?k=" + key;
		sendEmail(email, url);
		resMessage.append("<script>\n");
		resMessage.append("alert('비밀번호 변경 이메일을 전송했습니다.');\n");
		resMessage.append("location.href='/member/';\n");
		resMessage.append("</script>");
		
		return resMessage.toString();
	}
	
	private void sendEmail(String email, String url) {

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			mimeMessage.setHeader("Content-Type", "text/plain; charset=UTF-8");
			mimeMessage.setFrom(new InternetAddress("forspringlec@gmail.com","관리자")); // 보내는 사람
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email)); // 받는 사람
			mimeMessage.setSubject("비밀번호 찾기 메일 입니다.");
			mimeMessage.setText("비밀번호를 변경하시려면 아래 링크에 접속하세요.\n"
						+ url);
			
			// 이메일 보내기
			mailSender.send(mimeMessage);
		} catch (MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
}
