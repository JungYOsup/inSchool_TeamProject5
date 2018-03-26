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
import com.min.inschool.service.Imain_service;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private Imain_service main_service;


	@RequestMapping(value = "/main.do")
	public String main(Locale locale, Model model) {

		List<Answer_T_Dtos> listResume = main_service.mainListResume();
		List<Answer_T_Dtos> listFree = main_service.mainListFree();
		List<Answer_T_Dtos> listInter = main_service.mainListInter();
		List<Answer_T_Dtos> listQA = main_service.mainListQA();

		model.addAttribute("listResume",listResume);
		model.addAttribute("listFree",listFree);
		model.addAttribute("listInter",listInter);
		model.addAttribute("listQA",listQA);

		return "main";

	};


	@RequestMapping(value = "/search01.do")
	public String Search(Locale locale, Model model,String word, String select01) {

		if(select01.equals("searchAllinfo")) {

			List<Answer_T_Dtos> allinfo = main_service.searchAll(word);

			model.addAttribute("lists",allinfo);	


		}else if(select01.equals("titleOnly")) {

			List<Answer_T_Dtos> titleOnly = main_service.searchTitle(word);

			model.addAttribute("lists",titleOnly);	

		}else {

			List<Answer_T_Dtos> writer = main_service.searchWriter(word);

			model.addAttribute("lists",writer);	

		}



		return "search";


	}



}