package com.min.inschool;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

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
import com.min.inschool.dtos.REPLY_T_Dtos;
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
	public String boardlist(Locale locale, Model model) {


		logger.info("모든 게시글을 가져옵니다.");

		List<Answer_T_Dtos> lists = service_ys.getAllList();
		System.out.println(lists);
		model.addAttribute("lists", lists);

		return "V_Board";
	}

	//2.게시판에 글을 쓸때 보여지는 화면
	@RequestMapping(value = "/daum.do")
	public String daum(Locale locale, Model model) {

		logger.info("글쓰는 페이지로 이동합니다.");

		return "daum";
	}

	//3.글써서 데이터에 입력되는 메서드
	@RequestMapping(value ="/insertboard.do")
	public String insertboard(Locale locale, Model model, Answer_T_Dtos dto) {

		logger.info("글쓰기를 합니다.");

		System.out.println(dto);

		boolean isS = service_ys.insertboard(dto);

		if(isS) {
			System.out.println("글 등록에 성공하셧습니다");
			return "redirect:V_Board.do";

		}else {
			System.out.println("글 등록에 실패하셧습니다");
			return "redirect:daum.do";

		}


	}
	//4.상세보기 메서드 , 조회하는 메서드

	@RequestMapping(value ="/detailboard.do")
	public String detailboard(Locale locale, Model model, Answer_T_Dtos dto,REPLY_T_Dtos dto2) {

		logger.info("상세보기를 합니다");
		System.out.println(dto);


		service_ys.readCount(dto.getA_seq()); //조회

		Answer_T_Dtos dtos =service_ys.getBoard(dto);  //상세보기

		List<REPLY_T_Dtos> lists = service_ys.selectAllcomment(dto2); //답글

		System.out.println(dtos);

		model.addAttribute("dto", dtos);
		model.addAttribute("lists",lists);

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

	//7.댓글을 작성하는 메소드
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
	public String deleteboard(Locale locale, Model model,int a_seq) {

		logger.info("해당글을 삭제 합니다");
		
		System.out.println(a_seq);
		boolean isS = service_ys.deleteBoard(a_seq);

		if(isS) {
			System.out.println("해당글이 삭제가 되었습니다");
		}
		else {
			System.out.println("해당글 삭제를 실패헀습니다");
		}

		return "redirect:V_Board.do";

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
