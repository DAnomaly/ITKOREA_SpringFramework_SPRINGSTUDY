package com.koreait.contact03.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.contact03.dao.ContactDAO;

public class DeleteContactCommand implements ContactCommand {

	@Override
	public void execute(Model model, SqlSession session) {
		long no = (Long)model.asMap().get("no");
		ContactDAO dao = session.getMapper(ContactDAO.class);
		int result = dao.deleteContact(no);
		
		HttpServletResponse response = (HttpServletResponse)model.asMap().get("response");
		response.setContentType("text/html; charset=UTF-8"); 
		try {
			PrintWriter out = response.getWriter();
			if(result > 0) {
				out.println("<script>");
				out.println("alert('회원 정보가 성공적으로 삭제되었습니다.');");
				out.println("location.href='list.do';");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('삭제 도중 오류가 발생했습니다.');");
				out.println("histroy.back();");
				out.println("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
