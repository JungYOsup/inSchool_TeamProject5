package com.min.inschool;

import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.HashMap;


import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.min.inschool.dtos.Answer_T_Dtos;
import com.min.inschool.dtos.Funtion_T_Dtos;
import com.min.inschool.dtos.Join_T_Dtos;
import com.min.inschool.dtos.REPLY_T_Dtos;
import com.min.inschool.dtos.cominfo_Dto;
import com.min.inschool.service.IService_Ys;
import com.min.inschool.service.IService_cominfo;
import com.min.inschool.service.IYsService;
import com.min.inschool.service.Imain_service;

import javafx.scene.control.Alert;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private IService_Ys service_ys;

	@Autowired
	private Imain_service main_service;

	@Autowired
	private IYsService ysService;

	@Autowired
	private IService_cominfo cominfo_service;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	//병주1. 메인에 게시판 가져오는거 
	@RequestMapping(value = "/main.do")
	public String main(Locale locale, Model model, String errorMessage) {

		logger.info("메인화면으로 이동했고 화면에 값들을 가져옵니다");


		List<Answer_T_Dtos> listResume = main_service.mainListResume();
		List<Answer_T_Dtos> listFree = main_service.mainListFree();
		List<Answer_T_Dtos> listInter = main_service.mainListInter();
		List<Answer_T_Dtos> listQA = main_service.mainListQA();


		System.out.println(errorMessage);

		model.addAttribute("listResume",listResume);
		model.addAttribute("listFree",listFree);
		model.addAttribute("listInter",listInter);
		model.addAttribute("listQA",listQA);

		if(errorMessage !=null) {

			model.addAttribute("errorMessage","아이디 또는 비밀번호를 다시 확인하세요.<br>면접학교에 등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다");		
		}


		return "main";

	};



	@RequestMapping(value = "/search00.do")
	public String Search(Locale locale, Model model,String word,String select01,HttpServletRequest request) {

		request.getSession().setAttribute("word", word);

		request.getSession().setAttribute("select01",select01);


		if(select01.equals("searchAllinfo")) {

			List<Answer_T_Dtos> searchAll = main_service.searchAll01(word);


			model.addAttribute("lists",searchAll);

			int pageCount = main_service.pageCountAll(word);

			System.out.println(pageCount);

			model.addAttribute("pageCount",pageCount);

			request.getSession().setAttribute("pageCount",pageCount);



		}else if(select01.equals("titleOnly")) {

			List<Answer_T_Dtos> titleOnly = main_service.searchTitle01(word);

			model.addAttribute("lists", titleOnly);

			int pageCount = main_service.pageCountTitle(word);


			request.getSession().setAttribute("pageCount",pageCount);

		}


		else {

			List<Answer_T_Dtos> writer = main_service.searchWriter01(word);

			model.addAttribute("lists", writer);

			int pageCount = main_service.pageCountWriter(word);


			request.getSession().setAttribute("pageCount",pageCount);

		}


		return "search";

	}






	@RequestMapping(value = "/page.do")
	public String page(Locale locale, Model model, String sNum, String eNum,HttpServletRequest request) {

		int sNum01 = Integer.parseInt(sNum);

		int eNum01 = Integer.parseInt(eNum);

		String word = (String)request.getSession().getAttribute("word");

		String select01 = (String)request.getSession().getAttribute("select01");


		if(select01.equals("searchAllinfo")) {

			List<Answer_T_Dtos> searchAll = main_service.searchAll(word,sNum01,eNum01);

			model.addAttribute("lists",searchAll);

			request.getSession().getAttribute("pageCount");




		}else if(select01.equals("titleOnly")) {


			List<Answer_T_Dtos> titleOnly = main_service.searchTitle(word,sNum01,eNum01);

			model.addAttribute("lists",titleOnly);

			request.getSession().getAttribute("pageCount");



		}else {

			List<Answer_T_Dtos> writer = main_service.searchWriter(word,sNum01,eNum01);

			model.addAttribute("lists",writer);

			request.getSession().getAttribute("pageCount");
		}


		return "search";


	}



	//캘린더로 이동하는 메서드 (연습용)
	@RequestMapping(value = "/Calendarpractice.do")
	public String CalendarPractice(Locale locale, Model model, String a_boardname) {
		
		System.out.println("여기로 이동을 안하나요?"+a_boardname);
		
		List<cominfo_Dto> comName = cominfo_service.getComInfo();

		model.addAttribute("comName",comName);

		return "Calendar";

	}

	//캘린더로 이동하는 메서드
	@RequestMapping(value = "/Calendarform.do")
	public String Calendarform(Locale locale, Model model,String a_boardname) {
		System.out.println("여기로 이동을 안하나요?");
		
		List<cominfo_Dto> comName = cominfo_service.getComInfo();

		model.addAttribute("comName",comName);
		model.addAttribute("a_boardname", a_boardname);
		return "Calendarform";

	}


	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//영상

	//영상1. 수정화면으로 이동
	@RequestMapping(value = "/updateform.do") /*추가 폼으로 이동*/
	public String updateform(Model model,String seq) {
		logger.info("개인정보 수정 화면으로 이동");
		int sseq= Integer.parseInt(seq);
		Join_T_Dtos dto = ysService.myinform(sseq);
		model.addAttribute("udto",dto);

		if(dto.getJ_grade().equals("기업회원")) {
			return "C_updateform";
		}else if(dto.getJ_grade().equals("관리자")){
			return "";
			// 관리자 페이지가 만들어지면  return 에 입력하면 됌.
		}else if(dto.getJ_grade().equals("일반회원")) {
			return "U_updateform";
		}else if(dto.getJ_grade().equals("정회원")) {

			return "U_updateform";
		}else {
			return "Login";
		}

	} // 개인정보 , 등급에 따라서 내 정보로 가는 것을 분류 해놓음

	//영상2. 로그인페이지로 이동
	@RequestMapping(value = "/Login.do") /*추가 폼으로 이동*/
	public String Login(Locale locale) {
		logger.info("로그인 화면이동", locale);
		return "Login";
	}

	//영상3. 회원정보변경
	@RequestMapping(value = "/updateinform.do", method = RequestMethod.POST) /*추가 폼으로 이동*/
	public String updateinform(Join_T_Dtos dto,Model model) {
		logger.info("회원정보 변경");

		System.out.println(dto.getJ_pass());
		boolean isS=ysService.updateinform(dto);
		if(isS){
			// model.addAttribute("adto",isS);
			return "redirect:LoginProcess.do?j_id="+dto.getJ_id()+"&j_password="+dto.getJ_pass();
		}else {
			return "redirect:updateform.do?seq="+dto.getJ_seq();
		}//실패하면 다시 수정창으로 돌아가도록함 
	}

	@RequestMapping(value = "/kakaoLogin.do") /*추가 폼으로 이동*/
	public String Kakaologin(Model model,HttpSession session,HttpServletRequest request,String j_id,String j_name) {
		logger.info("kakao 로그인"); 

		Map<String,String> map= new HashMap<String,String>();
		map.put(j_id, j_id);
		map.put(j_name, j_name);

		System.out.println(map);


		if(j_id==null||j_name==null) {  // id 나 name 을 못받아 올 경우 팝업창.
			JOptionPane.showMessageDialog(null,"아이디나 비밀번호를 확인해주세요" );
			return "Login"; 

		}else { // id ,name 을 받아오면  ↓ 실행 후 임시 계정을 생성한다.(단 , 임시계정이 있는경우엔 select 로 DB에서 조회하여 가져온다)

			logger.info("Join_T테이블에 같은 아이디와 비밀번호 정보가 있는지를 확인합니다.");

			Join_T_Dtos dto=ysService.Kidcheck(j_id, j_name);

			logger.info("dto값이 존재합니까?"+dto);

			if(dto==null||dto.getJ_id()==null) {

				logger.info("join_T테이블에 등록이 되었습니다.");
				boolean isS	= ysService.Kregister(j_id, j_name);

				if (isS) {
					session.setAttribute("user", dto);
					System.out.println("회원가입성공");
				}   
				return "After_main";	//회원가입에 성공 
			}else {
				session.setAttribute("user", dto);
				System.out.println("등록된 임시계정 접속 성공");
				return "After_main";	
			}

		}


	}

	//로그인후 페이지
	@RequestMapping(value = "/LoginProcess.do" ) 
	public String LoginProcess(Model model,String j_id, String j_password ,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws UserPrincipalNotFoundException,IOException {
		logger.info("로그인후페이지");

		String id = j_id.toLowerCase();

		Join_T_Dtos dto = ysService.loginProcess(id, j_password);
		// 이미 id 와 pw 가 동일하다고 증명이 되어서 dto 담긴것  그러므로  dto 에 id만 찾아도 된다.
		System.out.println(dto); 

		//아이디와 비밀번호 틀릴때에 유효처리를 해야한다.

		if(dto ==null) {
			System.out.println("실패");

			return "redirect:main.do?errorMessage=0";

		}else if(dto.getJ_pass().equals(j_password)&&dto.getJ_id().equalsIgnoreCase(id)) {
			session.setAttribute("user", dto); //여기에 로그인한 회원들의 정보가 담김
			/*model.addAttribute("adto",dto);//이게 뭐지?*/

			int n =service_ys.getrecommendcount(dto);


			System.out.println("n값이 존재합니까?" + n);

			return "redirect:After_main.do?count="+n; //여기서 model로 해서 adto로 보내면 After_main.do가 adto를 못받으므로 get타입으로 보내야한다. 그러나 adto는 사용을 하지 않는다.
		}else {

			return null;
		}


	}

	//회원탈퇴
	@RequestMapping(value = "/deleteId.do") /*추가 폼으로 이동*/
	public String deleteId(int seq) {
		logger.info("회원탈퇴"); 

		System.out.println(seq);
		boolean isS=ysService.deleteId(seq);

		System.out.println(isS);

		if(isS) {
			return "Login"; 
		}else {
			return "redirect:updateform.do?seq="+seq;
		}

	}

	@RequestMapping(value = "/MyInform.do") /*추가 폼으로 이동*/
	public String myinform(int seq,Model model, Answer_T_Dtos dto) {
		logger.info("내정보"); 

		/*boolean isS=ysService.myinform(seq);*/
		Join_T_Dtos adto = ysService.myinform(seq);
		List<Answer_T_Dtos> Slists = service_ys.getsaveorlike(dto);
		List<Join_T_Dtos> Clist = service_ys.getAllrecommendList(dto);


		System.out.println("즐겨찾기"+Slists);


		if(adto==null) {
			return "index"; 
		}else {

			model.addAttribute("adto", adto);
			model.addAttribute("Slists", Slists);
			model.addAttribute("Clists",Clist);
			return "MyInform";
		}

	}

	//로그아웃
	@RequestMapping(value = "/Logout.do") /*추가 폼으로 이동*/
	public String Logout(HttpServletRequest request,Model model) {
		logger.info("로그아웃"); 

		List<Answer_T_Dtos> listResume = main_service.mainListResume();
		List<Answer_T_Dtos> listFree = main_service.mainListFree();
		List<Answer_T_Dtos> listInter = main_service.mainListInter();
		List<Answer_T_Dtos> listQA = main_service.mainListQA();


		model.addAttribute("listResume",listResume);
		model.addAttribute("listFree",listFree);
		model.addAttribute("listInter",listInter);
		model.addAttribute("listQA",listQA);

		request.getSession().invalidate();

		return "main";


	}

	@RequestMapping(value = "/After_main.do")
	public String aftermain(Locale locale, Model model, int count) {

		List<Answer_T_Dtos> listResume = main_service.mainListResume();
		List<Answer_T_Dtos> listFree = main_service.mainListFree();
		List<Answer_T_Dtos> listInter = main_service.mainListInter();
		List<Answer_T_Dtos> listQA = main_service.mainListQA();

		model.addAttribute("listResume",listResume);
		model.addAttribute("listFree",listFree);
		model.addAttribute("listInter",listInter);
		model.addAttribute("listQA",listQA);
		model.addAttribute("count", count);

		return "After_main";

	};







	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//요섭
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do")
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
	public String boardlist(Locale locale, Model model,String s_num,String e_num ,HttpSession session) {

		List<Answer_T_Dtos> lists=null;	
		int counts=0;

		logger.info("모든 게시글을 가져옵니다.");

		if(s_num==null&&e_num==null) {

			counts = service_ys.boardcount();
			lists = service_ys.getAllList();

		}else {

			logger.info("페이지의 숫자를 가져옵니다");
			counts = service_ys.boardcount();
			lists =service_ys.getAllList(s_num, e_num);
		}

		System.out.println(lists);
		model.addAttribute("lists", lists);
		model.addAttribute("counts", counts);
		session.getAttribute("user");

		return "Boardform";
	}

	//2.게시판에 글을 쓸때 보여지는 화면
	@RequestMapping(value = "/write.do")
	public String daum(Locale locale, Model model,Answer_T_Dtos dto) {

		logger.info("글쓰는 페이지로 이동합니다.");

		model.addAttribute("dto", dto);

		return "write";
	}

	//3.글써서 데이터에 입력되는 메서드
	@RequestMapping(value ="/insertboard.do")
	public String insertboard(Locale locale, Model model, Answer_T_Dtos dto) {

		logger.info("글쓰기를 합니다.");

		System.out.println(dto);

		boolean isS = service_ys.insertboard(dto);

		if(isS) {
			System.out.println("글 등록에 성공하셧습니다");

			System.out.println(dto.getA_boardname());


			return "redirect:Boardname_boardlist.do?a_boardname="+dto.getA_boardname();

		}else {
			System.out.println("글 등록에 실패하셧습니다");
			return "redirect:write.do";

		}


	}
	//4.상세보기 메서드 , 조회하는 메서드

	@RequestMapping(value ="/detailboard.do")
	public String detailboard(Locale locale, Model model, Answer_T_Dtos dto,REPLY_T_Dtos dto2, HttpSession session) {

		logger.info("상세보기를 합니다");
		System.out.println(dto);
		

		service_ys.readCount(dto.getA_seq()); //조회
				
		Answer_T_Dtos dtos =service_ys.getBoard(dto);  //상세보기

		List<REPLY_T_Dtos> lists = service_ys.selectAllcomment(dto2); //답글

		System.out.println(dtos);

		model.addAttribute("dto", dtos);
		model.addAttribute("lists",lists);
		session.getAttribute("user");
		return "V_detailboard";



	}

	//5.좋아요 메서드
	@ResponseBody
	@RequestMapping(value ="/likeboard.do")
	public Map<String, Funtion_T_Dtos> insertlike(Locale locale, Model model, Answer_T_Dtos dto) {

		logger.info("좋아요를 누릅니다");

		System.out.println("좋아요 누를때 dto는"+dto);

		Funtion_T_Dtos f_saveorlike =service_ys.selectlike(dto);

		System.out.println("f_saveorlike값이 존재하냐?"+f_saveorlike); //아무값도 없으면 null을 가져오겠지

		if(f_saveorlike==null) {

			//추가
			boolean isS = service_ys.insertlike(dto); 

			if(isS) { //추가에 성공했으면 그것을 true를 Map에 담아서 전달

				System.out.println("좋아요를 눌렀습니다");

				f_saveorlike =service_ys.selectlike(dto);

				Map<String, Funtion_T_Dtos> map = new HashMap<String, Funtion_T_Dtos>();

				map.put("f_saveorlike", f_saveorlike);

				System.out.println("생성된맵"+map);

				return map;

			}
			else {

				System.out.println("좋아요 누르기에 실패했습니다");

				return null;

			}

		}		
		else {
			boolean isS = service_ys.deletelike(dto);

			if(isS) { //삭제에 성공헀으면 그것을 false로 담아 전달

				System.out.println("삭제에 성공했습니다");

				f_saveorlike =service_ys.selectlike(dto);

				Map<String, Funtion_T_Dtos> map = new HashMap<String, Funtion_T_Dtos>();

				map.put("f_saveorlike", f_saveorlike);

				System.out.println("삭제된맵"+map);

				return map;

			}else {

				System.out.println("삭제에 실패했습니다.");

				return null;

			}

		}

	}

	//7.답글을 작성하는 메소드
	@ResponseBody
	@RequestMapping(value ="/CommentAjax.do")
	public Map<String, List<REPLY_T_Dtos>> ReplyAjax(Locale locale,REPLY_T_Dtos dto) {

		logger.info("답글 추가");

		System.out.println(dto);

		boolean isS = service_ys.commentBoardInsert(dto);

		System.out.println(isS);

		if(isS) {

			Map<String, List<REPLY_T_Dtos>> map = new HashMap<String, List<REPLY_T_Dtos>>();

			List<REPLY_T_Dtos> lists = service_ys.selectAllcomment(dto);

			map.put("lists", lists);

			return map;

		}

		return null;


	}

	//8. 즐겨찾기 하는 메소드 (나중에 ajax처리해야함)
	@RequestMapping(value ="/searchlike.do")
	public String insertsearch(Locale locale, Model model, Answer_T_Dtos dto) {

		logger.info("즐겨찾기를 누릅니다");

		System.out.println(dto);
		Funtion_T_Dtos f_saveorlike = service_ys.selectsearch(dto);


		System.out.println("f_saveorlike값이 존재하냐?"+f_saveorlike); //아무값도 없으면 null을 가져오겠지

		if(f_saveorlike==null) {

			//추가
			boolean isS = service_ys.insertsearch(dto); 

			if(isS) { //추가에 성공했으면 그것을 true를 Map에 담아서 전달

				System.out.println("즐겨찾기를를 눌렀습니다");

			}
			else {

				System.out.println("즐겨찾기 누르기에 실패했습니다");

				return null;

			}

		}		
		else {
			boolean isS = service_ys.deletesearch(dto);

			if(isS) { //삭제에 성공헀으면 그것을 false로 담아 전달

				System.out.println("삭제에 성공했습니다");


			}else {

				System.out.println("삭제에 실패했습니다.");

				return null;

			}

		}

		//Model을 통해서 Controll로 이동해서 값을 전달하면 값을 못받더라..
		return "redirect:detailboard.do?a_seq="+dto.getA_seq();

	}

	//9.자기 글을 삭제합니다. (삭제하기 위해서는 FK를 삭제한다음에 PK를 삭제해야하므로 TRANSACTION처리를 해줘야곘다
	//					 그래서 댓글 삭제 + 좋아요 또는 즐겨찾기 삭제를 한다음에 삭제를 해야한다, 그러나 댓글삭제도 필요하고 좋아요,즐겨찾기 삭제는 이미 있으므로 나중에 삭제들을 다 구현한다음에 합치기로 하자)

	//그리고 넘어오는 parameter 이름이 a_seq이므로 여기서 받는 parameter도 이름이 같게끔 a_seq로 받아줘야한다. 그렇지 않을경우 오류가 뜸
	@RequestMapping(value ="/deleteboard.do")
	public String deleteboard(Locale locale, Model model,int a_seq, Answer_T_Dtos dto) {

		logger.info("해당글을 삭제 합니다");

		System.out.println(a_seq);
		boolean isS = service_ys.deleteBoard(a_seq);

		if(isS) {
			System.out.println("해당글이 삭제가 되었습니다");
		}
		else {
			System.out.println("해당글 삭제를 실패헀습니다");
		}

		return "redirect:Boardname_boardlist.do?a_boardname="+dto.getA_boardname();

	}

	//10.댓글을 삭제합니다

	@RequestMapping(value ="/deletecomment.do")
	public String deletecomment(Locale locale, Model model, REPLY_T_Dtos dto) {

		logger.info("해당 댓글을 삭제 합니다");

		boolean isS = service_ys.Deletecomment(dto);

		if(isS) {

			System.out.println("댓글을 삭제에 성공했습니다");
		}

		return "redirect:detailboard.do?a_seq="+dto.getA_seq();

	}

	//11.답글창으로 이동합니다.
	@RequestMapping(value ="/replyboard.do")
	public String replyboard(Locale locale, Model model,Answer_T_Dtos dto) {

		logger.info("답글페이지로 이동 합니다");
		System.out.println(dto.getA_seq());

		model.addAttribute("dto", dto);
		return "replyboard";

	}

	//12.답글을 작성합니다
	@RequestMapping(value ="/insertreplyboard.do")
	public String insertreplyboard(Locale locale, Model model,Answer_T_Dtos dto) {

		logger.info("답글을 작성 합니다");

		System.out.println(dto);

		boolean isS = service_ys.replyboard(dto);

		if(isS) {
			System.out.println("답글 달기에 성공했습니다");

		}else {
			System.out.println("답글 달기에 실패했습니다");
		}


		return "redirect:V_Board.do";

	}

	//13.댓글에 댓글을 작성합니다. (댓글에 댓글다는 쿼리는 나중에 구현해보자)
	@RequestMapping(value ="/DoublecommentBoardInsert.do")
	public String DoublecommentBoardInsert(Locale locale, Model model, REPLY_T_Dtos dto) {

		logger.info("댓글에 댓글을 달았습니다.");

		boolean isS = service_ys.DoublecommentBoardInsert(dto);

		if(isS) {

			System.out.println("댓글에 댓글달기 성공");
		}

		return "redirect:detailboard.do?a_seq="+dto.getA_seq();

	}

	//14.수정폼으로 이동합니다 
	@RequestMapping(value ="/moveupdateboard.do")
	public String moveupdateboard(Locale locale, Model model, Answer_T_Dtos dto) {

		logger.info("수정폼으로 이동합니다.");

		Answer_T_Dtos dtos=service_ys.getBoard(dto);


		model.addAttribute("dtos", dtos);
		return "updateboard";

	}

	//15.수정하는 메서드
	@RequestMapping(value ="/updateboard.do" )
	public String updateboard(Locale locale, Model model, Answer_T_Dtos dto) {

		logger.info("수정폼으로 이동합니다.");

		boolean isS = service_ys.updateBoard(dto);

		if(isS) {
			System.out.println("수정이 성공하셧습니다");
		}else {
			System.out.println("수정 실패");
		}

		return "redirect:detailboard.do?a_seq="+dto.getA_seq();

	}
	//16.그 게시판에 내용을 검색하는 메서드
	//나중에 페이지가 눌렸을때 UV가 전달되게끔 해주고나서 , Answer_T_Dtos dto로 바꿔주고 지금은 UV를 받으므로 String UV로 받는다.
	@RequestMapping(value ="/searchword.do" )
	public String searchboard(Locale locale, Model model, String a_boardname,String searchword,String searchoption,String s_num,String e_num,HttpServletRequest request) {


		List<Answer_T_Dtos> lists=null;	
		int counts = 0;
		System.out.println("a_boardname가 뭡니까?"+a_boardname);


		if(searchword!=null&&a_boardname!=null){

			request.getSession().setAttribute("searchword", searchword);  //CV
			request.getSession().setAttribute("a_boardname", a_boardname); //UV
		}


		logger.info("검색창으로 이동합니다.");

		System.out.println(s_num);
		System.out.println(e_num);



		if(searchoption==null){

			if(request.getSession().getAttribute("all")=="all"){


				String searchword2 = (String)request.getSession().getAttribute("searchword");
				String a_boardname2 = (String)request.getSession().getAttribute("a_boardname");

				System.out.println(searchword2+"이다");
				System.out.println(a_boardname2+"이다");

				logger.info("페이지의 숫자를 가져옵니다!!");
				counts = service_ys.searchAllboardcount(searchword2, a_boardname2); //이거 바꾸고 
				lists =service_ys.getAllsearch(searchword2, a_boardname2,s_num,e_num);

			}else {

				String searchword2 = (String)request.getSession().getAttribute("searchword");
				String a_boardname2 = (String)request.getSession().getAttribute("a_boardname");

				logger.info("페이지의 숫자를 가져옵니다");
				counts = service_ys.searchTitleboardcount(searchword2, a_boardname2); //이거 바꾸고
				lists =service_ys.gettitlesearch(searchword2, a_boardname2,s_num,e_num);

			}

		}else if(searchoption.equals("제목+내용")){

			if(s_num==null&&e_num==null) {

				System.out.println(searchword+"라는값이 잇나요 ?"); //CV
				System.out.println(a_boardname+"값이 잇나요?"); //UV

				counts = service_ys.searchAllboardcount(searchword, a_boardname); //a_boardname을 UV가 아니고, 합치면 다른값으로 해줘야한다. 
				lists =service_ys.getAllsearch(searchword, a_boardname);

				request.getSession().setAttribute("all","all");

			}

		}else if(searchoption.equals("제목만")){

			if(s_num==null&&e_num==null) {

				counts = service_ys.searchTitleboardcount(searchword, a_boardname); //이거 바꾸고 
				lists =service_ys.gettitlesearch(searchword, a_boardname);

				request.getSession().setAttribute("title","title");

			}

		}

		model.addAttribute("counts", counts);
		model.addAttribute("lists", lists);

		return "searchboard";

	}

	//18. 해더페이지로 이동
	@RequestMapping(value ="/header.do")
	public String moveboard(Locale locale, Model model) {


		return "header";

	}

	//19. 채팅창으로 이동
	@RequestMapping(value ="/chat.do")
	public String chat(Locale locale, Model model) {


		return "chat";

	}

	//20.게시판틀로 이동
	@RequestMapping(value ="/Boardform.do")
	public String Boardform(Locale locale, Model model) {


		return "Boardform";

	}

	//21.특정게시판의 데이터를 가져온다

	@RequestMapping(value ="/Boardname_boardlist.do")
	public String Boardform(Locale locale, Model model, Answer_T_Dtos dto,String s_num,String e_num,String title,String title2) {

		List<Answer_T_Dtos> lists=null;	
		int counts=0;
		String a_boardname = dto.getA_boardname();

		System.out.println(a_boardname);

		logger.info("특정 게시글을 가져옵니다.");

		if(s_num==null&&e_num==null) {

			counts = service_ys.Boardname_boardcount(dto);
			lists = service_ys.getBoardnameAllList(dto);

		}else {

			logger.info("페이지의 숫자를 가져옵니다");

			counts = service_ys.Boardname_boardcount(dto);
			lists =service_ys.getBoardnameAllList(dto, s_num, e_num);
		}

		System.out.println(lists);

		model.addAttribute("lists", lists);
		model.addAttribute("counts", counts);
		model.addAttribute("a_boardname",a_boardname);
		model.addAttribute("title",title);
		model.addAttribute("title2", title2);
		return "Boardform";



	}

	//23. 추천 하는 메소드 (나중에 ajax처리해야함)
	@RequestMapping(value ="/recommend.do")
	public String insertrecommend(Locale locale, Model model, Answer_T_Dtos dto) {

		logger.info("추천를 누릅니다");

		System.out.println(dto);
		Funtion_T_Dtos f_recommend = service_ys.selectrecommend(dto);


		System.out.println("f_recommend값이 존재하냐?"+f_recommend); //아무값도 없으면 null을 가져오겠지

		if(f_recommend==null) {

			//추가
			boolean isS = service_ys.insertrecommend(dto); 

			if(isS) { //추가에 성공했으면 그것을 true를 Map에 담아서 전달

				System.out.println("즐겨찾기를를 눌렀습니다");

			}
			else {

				System.out.println("즐겨찾기 누르기에 실패했습니다");

				return null;

			}

		}		
		else {
			boolean isS = service_ys.deleterecommend(dto);

			if(isS) { //삭제에 성공헀으면 그것을 false로 담아 전달

				System.out.println("삭제에 성공했습니다");


			}else {

				System.out.println("삭제에 실패했습니다.");

				return null;

			}

		}

		//Model을 통해서 Controll로 이동해서 값을 전달하면 값을 못받더라..
		return "redirect:detailboard.do?a_seq="+dto.getA_seq();

	}

	//24. 사이트 소개페이지로 이동
	@RequestMapping(value ="/Showform.do")
	public String showboard(Locale locale, Model model,String a_boardname) {
		
		System.out.println(a_boardname);
		logger.info("사이트 소개페이지로 이동합니다");

		return "Showform";

	}
	


	// 이미지 첨부 팝업
	@RequestMapping(value="/imagePopup.do")
	public String imagePopup() {
		return "daumOpenEditor/image"; 
	} 

	@RequestMapping(value = "/singleUploadImageAjax.do", method = RequestMethod.POST) 
	public @ResponseBody HashMap singleUploadImageAjax(@RequestParam("Filedata") MultipartFile multipartFile, HttpSession httpSession) { 
		HashMap fileInfo = new HashMap(); // CallBack할 때 이미지 정보를 담을 Map 
		// 업로드 파일이 존재하면 

		if(multipartFile != null && !(multipartFile.getOriginalFilename().equals(""))) { 
			// 확장자 제한

			String originalName = multipartFile.getOriginalFilename(); // 실제 파일명
			String originalNameExtension = originalName.substring(originalName.lastIndexOf(".") + 1).toLowerCase(); // 실제파일 확장자 (소문자변경) 
			if( !( (originalNameExtension.equals("jpg")) || (originalNameExtension.equals("gif")) || (originalNameExtension.equals("png")) || (originalNameExtension.equals("bmp")) ) ){ 
				fileInfo.put("result", -1); // 허용 확장자가 아닐 경우 
				return fileInfo; 
			} 
			// 파일크기제한 (1MB) 
			long filesize = multipartFile.getSize(); // 파일크기 
			long limitFileSize = 1*1024*1024; // 1MB 
			if(limitFileSize < filesize){ // 제한보다 파일크기가 클 경우
				fileInfo.put("result", -2); 
				return fileInfo; 
			} 
			// 저장경로 
			String defaultPath = httpSession.getServletContext().getRealPath("/"); // 서버기본경로 (프로젝트 폴더 아님) 
			String path = defaultPath + File.separator + "upload" + File.separator + "board" + File.separator + "images" + File.separator + ""; 
			// 저장경로 처리
			File file = new File(path); 
			if(!file.exists()) { // 디렉토리 존재하지 않을경우 디렉토리 생성 
				file.mkdirs(); } 
			// 파일 저장명 처리 (20150702091941-fd8-db619e6040d5.확장자) 
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss"); 
			String today= formatter.format(new Date()); 
			String modifyName = today + "-" + UUID.randomUUID().toString().substring(20) + "." + originalNameExtension; 
			// Multipart 처리
			try { 
				// 서버에 파일 저장 (쓰기) 
				multipartFile.transferTo(new File(path + modifyName));

				// 로그 
				System.out.println("** upload 정보 **"); 
				System.out.println("** path : " + path + " **");
				System.out.println("** originalName : " + originalName + " **"); 
				System.out.println("** modifyName : " + modifyName + " **"); 
			} 
			catch (Exception e) { 
				e.printStackTrace(); 
				System.out.println("이미지파일업로드 실패 - singleUploadImageAjax"); 
			} 
			// CallBack - Map에 담기 
			String imageurl = httpSession.getServletContext().getContextPath() + "/upload/board/images/" + modifyName; // separator와는 다름! 
			fileInfo.put("imageurl", imageurl); // 상대파일경로(사이즈변환이나 변형된 파일) 
			fileInfo.put("filename", modifyName); // 파일명 
			fileInfo.put("filesize", filesize); // 파일사이즈
			fileInfo.put("imagealign", "C"); // 이미지정렬(C:center) 
			fileInfo.put("originalurl", imageurl); // 실제파일경로 
			fileInfo.put("thumburl", imageurl); // 썸네일파일경로(사이즈변환이나 변형된 파일) 
			fileInfo.put("result", 1); // -1, -2를 제외한 아무거나 싣어도 됨
			fileInfo.put("path",path);
			fileInfo.put("originalName",originalName);
		} 
		return fileInfo; // @ResponseBody 어노테이션을 사용하여 Map을 JSON형태로 반환 } 
	}

	@RequestMapping(value = "/filePopup.do") 
	public String filePopup() 
	{ 
		return "daumOpenEditor/file"; 
	} 

	// 단일 파일 업로드 Ajax 
	@RequestMapping(value = "/singleUploadFileAjax.do", method = RequestMethod.POST) 
	public @ResponseBody HashMap singleUploadFileAjax(@RequestParam("Filedata") MultipartFile multipartFile, HttpSession httpSession) 
	{ HashMap fileInfo = new HashMap(); // CallBack할 때 파일 정보를 담을 Map // 업로드 파일이 존재하면 
	if(multipartFile != null && !(multipartFile.getOriginalFilename().equals(""))) { 
		// 파일크기제한 (500MB) 
		long filesize = multipartFile.getSize(); // 파일크기
		long limitFileSize = 500*1024*1024; // 5MB 
		if(limitFileSize < filesize){ // 제한보다 파일크기가 클 경우 
			fileInfo.put("result", -1); return fileInfo; 
		} // 저장경로 
		String defaultPath = httpSession.getServletContext().getRealPath("/"); // 서버기본경로 (프로젝트 폴더 아님) 
		String path = defaultPath + File.separator + "upload" + File.separator + "board" + File.separator + "files" + File.separator + ""; 
		// 저장경로 처리 
		File file = new File(path); if(!file.exists()) { // 디렉토리 존재하지 않을경우 디렉토리 생성 
			file.mkdirs(); 
		} 
		// 파일 저장명 처리 (20150702091941-파일명) 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss"); 
		String today= formatter.format(new Date()); 
		String originalName = multipartFile.getOriginalFilename(); // 파일이름 
		String modifyName = today + "-" + originalName; // Multipart 처리 
		try { 
			// 서버에 파일 저장 (쓰기) 
			multipartFile.transferTo(new File(path + modifyName)); 
			// 로그
			System.out.println("** upload 정보 **"); 
			System.out.println("** path : " + path + " **"); 
			System.out.println("** originalName : " + originalName + " **");
			System.out.println("** modifyName : " + modifyName + " **"); 
		} catch (Exception e) { 
			e.printStackTrace(); System.out.println("파일업로드 실패 - singleUploadFileAjax");
		} 
		// mime 
		String fileMime = multipartFile.getContentType(); 
		// CallBack - Map에 담기 
		String attachurl = httpSession.getServletContext().getContextPath() + "/upload/board/files/" + modifyName; // separator와는 다름! 
		fileInfo.put("attachurl", attachurl); // 상대파일경로(사이즈변환이나 변형된 파일) 
		fileInfo.put("filemime", fileMime); // mime 
		fileInfo.put("filename", modifyName); // 파일명
		fileInfo.put("filesize", filesize); // 파일사이즈 
		fileInfo.put("result", 1); // -1을 제외한 아무거나 싣어도 됨 
	} 
	return fileInfo; // @ResponseBody 어노테이션을 사용하여 Map을 JSON형태로 반환 } 
	}





}

