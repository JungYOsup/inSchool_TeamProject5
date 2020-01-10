package com.min.inschool.daos;

import java.util.List;

import com.min.inschool.dtos.Answer_T_Dtos;
import com.min.inschool.dtos.Funtion_T_Dtos;
import com.min.inschool.dtos.Join_T_Dtos;
import com.min.inschool.dtos.REPLY_T_Dtos;

public interface IDao_Ys {

	//1. 모든 데이터를 가져온다. (SELECT)
	public List<Answer_T_Dtos> getAllList();

	//2. 페이지에 해당되는 데이터를 가져온다.
	public List<Answer_T_Dtos> getAllList(String s_num,String e_num);

	//2. 게시판에 글쓰는 메서드(메인및 상세보기) (INSERT)
	public boolean insertboard(Answer_T_Dtos dto);

	//3. 게시판에 글 조회수를 나타내는 메서드 (메인, 상세보기) (UPDATE)
	public boolean readCount(int seq);

	//4. 답글달기 메서드 (상세보기) (INSERT,UPDATE-트랜젝션처리)
	public boolean replyboard(Answer_T_Dtos dto);

	public int replyBoardUpdate(Answer_T_Dtos dto);
	public int replyBoardInsert(Answer_T_Dtos dto);

	//5. 댓글다는 메서드(상세보기) (INSERT)
	public boolean commentBoardInsert(REPLY_T_Dtos dto);

	//6. 댓글을 가져오는 메서드 (SELECT)
	public List<REPLY_T_Dtos> selectAllcomment(REPLY_T_Dtos dto);

	//7. 댓글에 댓글달기 (INSERT)
	public boolean DoublecommentBoardInsert(REPLY_T_Dtos dto); 

	//8. 게시판을 수정하는 메서드(상세보기, 내것을 클릭했을때) (UPDATE)
	public boolean updateBoard(Answer_T_Dtos dto);

	//10. 글 상세보는 메서드 (SELECT)
	public Answer_T_Dtos getBoard(Answer_T_Dtos dto);

	//11. 댓글의 수를 조회하는 메서드(SELECT)
	public boolean commentreadCount(int seq);


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

	//22. 해당게시글의 페이지수를 가져오는 메서드
	public int boardcount();

	//23. 제목+내용을 검색한는 메서드
	public List<Answer_T_Dtos> getAllsearch(String searchword,String a_boardname); 

	//24. 제목만 검색하는 메서드
	public List<Answer_T_Dtos> gettitlesearch(String searchword,String a_boardname); 

	//25. 검색한 페이지수를 가져오는 메서드(제목+타이틀)
	public int searchAllboardcount(String searchword,String a_boardname);

	//26. 검색한 페이지수를 가져오는 메서드(제목)
	public int searchTitleboardcount(String searchword,String a_boardname);

	//27. 검색한 특정페이지의 데이터를 가져옴
	public List<Answer_T_Dtos> getAllsearch(String searchword,String a_boardname,String s_num,String e_num);

	//28. 검색한 특정페이지의 데이터를 가져옴
	public List<Answer_T_Dtos> gettitlesearch(String searchword,String a_boardname,String s_num,String e_num);


	//29. 특정게시판의 데이터를 10개 가져온다
	public List<Answer_T_Dtos> getBoardnameAllList(Answer_T_Dtos dto);

	//30. 특정게시판의 페이지의 해당되는 데이터를 가져온다.
	public List<Answer_T_Dtos> getBoardnameAllList(Answer_T_Dtos dto,String s_num,String e_num);

	//31. 특정게시판의 페이지를 가져온다 
	public int Boardname_boardcount(Answer_T_Dtos dto);

	//32.내가 선택한 즐겨찾기를 가져오는 메서드
	public List<Answer_T_Dtos> getsaveorlike(Answer_T_Dtos dto);

	//33.기업이 게시글을 추천하는메서드
	public boolean insertrecommend(Answer_T_Dtos dto);

	//34. 기업이 게시글을 추천하는것을 가져오는 메서드(SELECT)
	public Funtion_T_Dtos selectrecommend(Answer_T_Dtos dto);

	//35. 기업이 게시글을 추천한것을 삭제하는 메서드(DELETE)
	public boolean deleterecommend(Answer_T_Dtos dto);

	//36. 추천받은 모든 기업을 가져온다. (SELECT)
	public List<Join_T_Dtos> getAllrecommendList(Answer_T_Dtos dto);
	
	//37.추천받은 모든 기업의 수를 가져온다
	public int getrecommendcount(Join_T_Dtos dto);
}
