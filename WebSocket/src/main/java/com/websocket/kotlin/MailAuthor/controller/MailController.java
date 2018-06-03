package com.websocket.kotlin.MailAuthor.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websocket.kotlin.MailAuthor.model.service.MailService;
import com.websocket.kotlin.User.model.service.UserService;
@Controller
public class MailController {
	private UserService userService;
	@Autowired
	private MailService mailService;
	
	
	@RequestMapping(value = "/showSession")
	public void test(HttpSession session) {
		System.out.println(session.getAttribute("joinCode"));
	}
 
	
	@RequestMapping(value = "/sendMail/auth", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public boolean sendMailAuth(HttpSession session, @RequestParam String email) {
		System.out.println("test" + email);
		int ran = new Random().nextInt(10000) + 10000; //10000 ~ 9999
		String joinCode = String.valueOf(ran);
		session.setAttribute("joinCode", joinCode);
		
		String subject = "회원가입 인증 코드 발급 안내 입니다.";
		StringBuilder sb = new StringBuilder();
		sb.append("귀하의 인증 코드는 " + joinCode + " 입니다. ");
		System.out.println(sb);
		System.out.println(mailService.send(subject, sb.toString(), "kotlinken@gmail.com", email, null));
		return mailService.send(subject, sb.toString(), "kotlinken@gmail.com", email, null);
		
		
	}
	
	
	
}
