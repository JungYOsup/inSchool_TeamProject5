package com.min.inschool;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
	//4.상세보기 메서드
	
	@RequestMapping(value ="/detailboard.do")
	public String detailboard(Locale locale, Model model, int seq) {
		
		logger.info("상세보기를 합니다");
		System.out.println(seq);
		
		
		Answer_T_Dtos dto =service_ys.getBoard(seq);
		
		System.out.println(dto);
				
		model.addAttribute("dto", dto);
		
		return "V_detailboard";
		
	
		
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
