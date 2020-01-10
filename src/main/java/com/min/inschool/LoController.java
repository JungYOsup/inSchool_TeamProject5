package com.min.inschool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.inschool.dtos.Join_T_Dtos;
import com.min.inschool.dtos.cominfo_Dto;
import com.min.inschool.service.IService_Regist;
import com.min.inschool.service.IService_cominfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoController{
	
	private static final Logger logger = LoggerFactory.getLogger(LoController.class);
	private Join_T_Dtos dto=new Join_T_Dtos();
	
	@Autowired
	private IService_Regist Service_Regist;
	@Autowired
	private IService_cominfo Service_cominfo;
//	회원가입메인화면연결
	@RequestMapping(value = "/registmain.do")
	public String main(Locale locale, Model model) {
		logger.info("회원가입 선택창입니다.", locale);
		return "registmain";
	}
	
	
//	일반회원으로 가입할 껀지 기업회원으로 가입할껀지 선택창 
	@RequestMapping(value = "/regist.do", method = RequestMethod.POST)
	public String regist(String id, Model model) {
		logger.info("회원가입창 넘어가기전입니다.");
		System.out.println(id);
		if (id.equals("일반회원")) {
			System.out.println("일반회원 가입폼으로 이동~~");
			model.addAttribute("id", id);
			return "";
		} else{
			System.out.println("기업회원 가입폼으로 이동~~");
			model.addAttribute("id", id);
			return "";
		}
	
	}	
	
//	일반회원가입
	@RequestMapping(value = "/Uregist.do", method = RequestMethod.POST)
	public String Uregist(Join_T_Dtos dto) {
		logger.info("유저 회원으로 가입합니다");
		System.out.println(dto);
		boolean isS=Service_Regist.Uresist(dto);
		if (isS) {
			System.out.println(isS);
			return "redirect:main.do";
		} else {
			return "Uregist";
		}
	}
//	기업회원가입
	@RequestMapping(value = "/Cregist.do", method = RequestMethod.POST)
	public String Cregist(Join_T_Dtos dto) {
		logger.info("기업 회원으로 ");
		boolean isS=Service_Regist.Cresist(dto);
		if (isS) {
			return "redirect:main.do";
		} else {
			return "Cregist";
		}
	}
	@RequestMapping(value = "/chkDupId.do", method = RequestMethod.POST)
	public void checkId(HttpServletRequest req, HttpServletResponse res, ModelMap model) throws Exception {
		PrintWriter out = res.getWriter();
		System.out.println(out);
		try {
			//넘어온 ID를 받는 곳
			String paramId=(req.getParameter("j_id")==null)?"":String.valueOf(req.getParameter("j_id"));
			dto.setJ_id(paramId.trim());
			System.out.println(dto.getJ_id());
			int chkPoint=Service_Regist.chkDupId(dto);
			System.out.println(chkPoint);
			System.out.println(dto);
			out.print(chkPoint);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			out.print("1");
			}
	}
	//인증창
	@RequestMapping(value = "/ins.do", method = RequestMethod.POST)
	public String ins(Locale locale) {
		logger.info("인증창");
		return "ins";	
	}
	//인증변수 
	@RequestMapping(value="/emailAuth.do" , produces="text/plain;charset=utf-8",method = RequestMethod.POST)
	@org.springframework.web.bind.annotation.ResponseBody
	public String emailAuth(javax.servlet.http.HttpServletRequest request) {
	    String email = request.getParameter("email");
	    String authNum = "";
	    System.out.println(email);
	    authNum = randomNum();
	    //가입승인에 사용될 인증키 난수 발생    
	    String str = authNum;
	    System.out.println(str);
	    return str;
	}
	@RequestMapping(method = RequestMethod.POST)
	private String randomNum() {
	    StringBuffer buffer = new StringBuffer();
	        
	    for( int i = 0 ; i <= 6 ; i++) {
	        int n = (int)(Math.random()*10);
	        buffer.append(n);
	    }
	        
	    return buffer.toString();
	}
	
	@RequestMapping(value = "/jobAjax.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> jobAjax(Locale locale,HttpServletRequest request,String co_name[]) {
		logger.info("Welcome home! The client locale is {}.", locale);
		String urlPath="http://api.saramin.co.kr/job-search?keywords=%EC%9B%B9%EA%B0%9C%EB%B0%9C%EC%9E%90&fields=posting-date+expiration-date&sort=ud&start=1&count=110";
		String p="";
//		System.out.println(p);
		try {
			//특정 사이트를 url을 이용하여 객체 생성
			URL url=new URL(urlPath);
			
			//IO 스트림을 이용하여 파일 읽어 들이기 
			InputStreamReader in=new InputStreamReader(url.openStream());
			BufferedReader br=new BufferedReader(in);
			String s="";
//			System.out.println(s);	
			//읽어들인 결과 문자열로 저장하기
		
			while((s=br.readLine())!=null){
				p+=s+"\n";
			}
			p=p.replaceAll("[<][!]\\[CDATA\\[|\\]\\][>]", "");
					
//			System.out.println(p);
		}catch (Exception e) {
			e.printStackTrace();
		}
			Map<String, String>map=new HashMap<>();
			
			map.put("p", p);
		return map;
	}
	//내정보확인
	@RequestMapping(value = "/myinfo.do", method = RequestMethod.GET)
	public String myinfo(Locale locale, Model model) {
		logger.info("내정보확인창 입니다.", locale);
		return "jobget";
	}
	//xml자료 보내기
	@RequestMapping(value = "/cominfo.do", method = RequestMethod.POST)
	@Transactional
	public String cominfo(Locale locale, Model model, cominfo_Dto dto, HttpServletRequest request) {
		logger.info("정보날리기", locale);

		String[] co_name=request.getParameterValues("co_name");
		String[] co_title=request.getParameterValues("co_title");
		String[] co_podate=request.getParameterValues("co_podate");
		String[] co_exdate=request.getParameterValues("co_exdate");
		String[] co_location=request.getParameterValues("co_location");
		String[] co_jobtype=request.getParameterValues("co_jobtype");
		String[] co_jobcategory=request.getParameterValues("co_jobcategory");
		String[] co_exlevel=request.getParameterValues("co_exlevel");
		String[] co_relevel=request.getParameterValues("co_relevel");
		String[] co_salary=request.getParameterValues("co_salary");
		String[] co_id=request.getParameterValues("co_id");
		String[] co_url=request.getParameterValues("co_url");
		
		
		
		for (int i = 0; i < co_name.length; i++) {
		dto.setCo_name(co_name[i]);
		dto.setCo_title(co_title[i]);
		dto.setCo_podate(co_podate[i]);
		dto.setCo_exdate(co_exdate[i]);
		dto.setCo_location(co_location[i]);
		dto.setCo_jobtype(co_jobtype[i]);
		dto.setCo_jobcategory(co_jobcategory[i]);
		dto.setCo_exlevel(co_exlevel[i]);
		dto.setCo_relevel(co_relevel[i]);
		dto.setCo_salary(co_salary[i]);
		dto.setCo_id(co_id[i]);
		dto.setCo_url(co_url[i]);
		
		/*System.out.println("정보가 있습니까?" +dto);*/
		
		boolean isS=Service_cominfo.cominfo(dto);
		System.out.println(isS);
		}
		return "jobget";
	}
	
			
	//21.특정게시판의 데이터를 가져온다

		@RequestMapping(value ="/comjob.do")
		public String Boardform(Locale locale, Model model,String s_num,String e_num,String a_boardname) {
			
			logger.info("기업정보를 가져옵니다.");
			List<cominfo_Dto> lists=null;
			int counts=0;

			logger.info("특정 게시글을 가져옵니다.");

			if(s_num==null&&e_num==null) {

				counts =Service_cominfo.boardcount(); //페이지 수를 가져온다.
				lists=Service_cominfo.cominfo2(); //10개페이지를 가져온다.

			}else {

				logger.info("페이지의 숫자를 가져옵니다");
				counts =Service_cominfo.boardcount(); //페이지 수를 가져온다.
				lists=Service_cominfo.cominfo2(s_num,e_num);
			}

			System.out.println(lists);
			model.addAttribute("lists", lists);
			model.addAttribute("counts", counts);
			model.addAttribute("a_boardname", a_boardname);
			return "ComBoardform";



		}
	//추천받은 기업의 데이터를 가져온다.
		
		@RequestMapping(value ="/recommendcomjob.do")
		public String RecommendBoardform(Locale locale, Model model,String a_boardname,cominfo_Dto dto) {
			
			logger.info("추천받은기업정보를 가져옵니다.");
			
			System.out.println(dto);
			
			List<cominfo_Dto> lists =Service_cominfo.RecommendBoardform(dto);
			
			System.out.println(lists+"이존재하나요?");

			model.addAttribute("counts",0);
			model.addAttribute("lists", lists);
			model.addAttribute("a_boardname", a_boardname);
			return "ComBoardform";



		}
	
		//인증창
		@RequestMapping(value = "/jobget.do", method = RequestMethod.GET)
		public String jobget(Locale locale) {
			logger.info("인증창");
			return "jobget";	
		}
	
}


