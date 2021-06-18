package com.koreait.contact02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="contact", produces="text/html; charset=UTF-8")
@ResponseBody
public class ContactAlertController {

	@RequestMapping("success")
	public String success() {
		StringBuilder sb = new StringBuilder();
		sb.append("<script> ");
		sb.append("alert('작업이 성공적으로 수행되었습니다.'); ");
		sb.append("location.href='list.do'; ");
		sb.append("</script> ");
		return sb.toString();
	}
	
	@RequestMapping("error")
	public String error() {
		StringBuilder sb = new StringBuilder();
		sb.append("<script> ");
		sb.append("alert('오류가 발생했습니다.'); ");
		sb.append("history.back(); ");
		sb.append("</script> ");
		return sb.toString();
	}
	
	@RequestMapping("updateSuccess")
	public String updateSuccess(long no) {
		StringBuilder sb = new StringBuilder();
		sb.append("<script> ");
		sb.append("alert('작업이 성공적으로 수행되었습니다.'); ");
		sb.append("location.href='view.do?no=").append(no).append("'; ");
		sb.append("</script> ");
		return sb.toString();
	}
	
}
