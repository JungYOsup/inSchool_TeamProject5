package com.min.inschool.daos;

import java.util.List;

import com.min.inschool.dtos.Answer_T_Dtos;
import com.min.inschool.dtos.Funtion_T_Dtos;
import com.min.inschool.dtos.REPLY_T_Dtos;

public interface IDao_Ys {
	
	//1. 모든 데이터를 가져온다. (SELECT)
	public List<Answer_T_Dtos> getAllList();
	
	//2. 게시판에 글쓰는 메서드(메인및 상세보기) (INSERT)
	public boolean insertboard(Answer_T_Dtos dto);
	
	//3. 게시판에 글 조회수를 나타내는 메서드 (메인, 상세보기) (UPDATE)
	public boolean readCount(int seq);
	
	//4. 답글달기 메서드 (상세보기) (INSERT,UPDATE-트랜젝션처리)
	public boolean replyboard(Answer_T_Dtos dto);
	
	public int replyBoardUpdate(int seq);
	public int replyBaordInsert(Answer_T_Dtos dto);
		
	//5. 댓글다는 메서드(상세보기) (INSERT)
	public boolean commentBoardInsert(REPLY_T_Dtos dto);
	
	//6. 댓글을 가져오는 메서드 (SELECT)
	public List<REPLY_T_Dtos> selectAllcomment(REPLY_T_Dtos dto);
		
	//7. 댓글에 댓글달기 (INSERT)
	public int DoublecommentBoardInsert(Answer_T_Dtos dto); 
	
		
	//8. 게시판을 수정하는 메서드(상세보기, 내것을 클릭했을때) (UPDATE)
	public boolean updateBoard(Answer_T_Dtos dto);
		
	//10. 글 상세보는 메서드 (SELECT)
	public Answer_T_Dtos getBoard(Answer_T_Dtos dto);
	
	//11. 댓글의 수를 조회하는 메서드(SELECT)
	public boolean commentreadCount(int seq);
	
	//12. ajax처리 
	public Answer_T_Dtos getBoardAjax(int seq);
	
	//13. 좋아요를 누르는 메서드(UPDATE)
	public boolean insertlike(Answer_T_Dtos dto);
		
	//14. 좋아요를 가져오는 메서드(SELECT)
	public Funtion_T_Dtos selectlike(Answer_T_Dtos dto);
	
	//15. 좋아요를 삭제하는 메서드(DELETE)
	public boolean deletelike(Answer_T_Dtos dto);
	
	//16. 즐겨찾기 하는 메서드(INSERT)
	public boolean insertsearch(Answer_T_Dtos dto);
	
	//17. 즐겨찾기를 가져오는 메서드(SELECT)
	public Funtion_T_Dtos selectsearch(Answer_T_Dtos dto);
	
	//18. 즐겨찾기를 삭제하는 메서드(DELETE)
	public boolean deletesearch(Answer_T_Dtos dto);
	
	//19. 댓글을 삭제하는 메서드
	public boolean Deletecomment(REPLY_T_Dtos dto);
	
	//9. 게시판을 삭제하는 메서드 (내것을 클릭했을때) (DELETE)
	public int deleteBoard(int a_seq);
	
	//20. 해당게시글의 댓글을 모두 삭제하는 메서드
	public int deleteAllcomment(int a_seq);
	
	//21. 해당게시글의 기능을 모두 삭제하는 메서드
	public int deleteAllfunction(int a_seq);
	
	
	
	

}
