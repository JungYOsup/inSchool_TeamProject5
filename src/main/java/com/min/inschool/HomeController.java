package com.min.inschool;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.inschool.dtos.Answer_T_Dtos;
import com.min.inschool.service.IService_Ys;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private IService_Ys service_ys;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//1.게시판의 모든 정보를 가지고 온다. 
	@RequestMapping(value = "/V_Board.do")
	public String boardlist(Locale locale, Model model) {
		logger.info("모든 게시글을 가져옵니다.");
		
		
		List<Answer_T_Dtos> lists = service_ys.getAllList();
		
		
		System.out.println(lists);
		
		
		model.addAttribute("lists", lists);
			
		return "V_Board";
	}
	
	//2.게시판에 글을 쓸때 보여지는 화면
	@RequestMapping(value = "/insertform.do")
	public String insertboard(Locale locale, Model model) {
		logger.info("글쓰기 페이지로 이동합니다.");
		
			
		return "V_Board";
	}
	
	
	
}
