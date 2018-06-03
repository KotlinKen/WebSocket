package com.websocket.kotlin;

import java.io.ObjectInputStream.GetField;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websocket.kotlin.Commad.model.Command;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		System.out.println(session.getId());
		/*System.out.println(session.getAttributeNames().nextElement());*/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "form";
	}
	@RequestMapping(value = "/t", method = RequestMethod.GET)
	public String forms() {
		return "command";
	}
	
	@RequestMapping(value = "/command", method = RequestMethod.POST)
	public void none(@ModelAttribute Command command, BindingResult result) {
		System.out.println(result);
		System.out.println(command);
		
		if(result.hasErrors()) {
			System.out.println("에러라구요");
		}else {
			System.out.println("에러아니라구요 ");
			
			System.out.println(command);
			System.out.println(command.getId());
			System.out.println(command.getName());
			System.out.println(command.getPass());
		}
		
		
	}
	
}
