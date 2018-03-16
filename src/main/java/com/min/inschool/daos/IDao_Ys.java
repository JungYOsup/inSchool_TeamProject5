package com.min.inschool.daos;

import java.util.List;

import com.min.inschool.dtos.Answer_T_Dtos;

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
	public int commentBoardInsert(Answer_T_Dtos dto);
	
	//6. 댓글에 댓글달기 (INSERT)
	public int DoublecommentBoardInsert(Answer_T_Dtos dto); 
	
	//7. 게시판을 수정하는 메서드(상세보기, 내것을 클릭했을때) (UPDATE)
	public boolean updateBoard(Answer_T_Dtos dto);
	//8. 게시판을 삭제하는 메서드 (내것을 클릭했을때) (DELETE)
	public boolean deleteBoard(int seq);
	
	//9. 글 상세보는 메서드 (SELECT)
	public Answer_T_Dtos getBoard(int seq);
	
	//10. 댓글의 수를 조회하는 메서드(SELECT)
	public boolean commentreadCount(int seq);
	
	//11. ajax처리 
	public Answer_T_Dtos getBoardAjax(int seq);
	
	

}
