package com.min.inschool.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.inschool.dtos.Answer_T_Dtos;
import com.min.inschool.dtos.Funtion_T_Dtos;
import com.min.inschool.dtos.REPLY_T_Dtos;

@Repository
public class Dao_YS implements IDao_Ys{

   @Autowired
   private SqlSessionTemplate SqlSession;

   private String namespace ="com.hk.ansboard.";



   //1. 모든 데이터를 가져온다. (SELECT)
   @Override
   public List<Answer_T_Dtos> getAllList() {

      return SqlSession.selectList(namespace+"boardlist");

   }
   
   //2. 페이지에 해당되는 데이터를 가져온다.
   public List<Answer_T_Dtos> getAllList(String s_num,String e_num) {

      Map<String, String> map = new HashMap<>();
      
      map.put("s_num", s_num);
      map.put("e_num", e_num);
      
      return SqlSession.selectList(namespace+"boardlistpage",map);

   }
   
   
   
   
   //2. 게시판에 글쓰는 메서드(메인및 상세보기) (INSERT)
   @Override
   public boolean insertboard(Answer_T_Dtos dto) {

      int count =0;
      count = SqlSession.insert(namespace+"insertboard", dto);

      return count>0?true:false;
   }
   //3. 게시판에 글 조회수를 나타내는 메서드 (메인, 상세보기) (UPDATE)
   @Override
   public boolean readCount(int seq) {

      int count =0;
      count = SqlSession.update(namespace+"updatecount", seq);

      return count>0?true:false;
   }
   
   //4. 답글달기 메서드 (상세보기) (INSERT,UPDATE-트랜젝션처리) 
   @Override
   public boolean replyboard(Answer_T_Dtos dto) {
      
      return false;
   }

   @Override
   public int replyBoardUpdate(Answer_T_Dtos dto) {
      return SqlSession.update(namespace+"replyBoardUpdate", dto);
   }

   @Override
   public int replyBoardInsert(Answer_T_Dtos dto) {
      
      return SqlSession.insert(namespace+"replyBoardInsert", dto);
   }

   //5. 댓글다는 메서드(상세보기) (INSERT)
   @Override
   public boolean commentBoardInsert(REPLY_T_Dtos dto) {

      System.out.println("DaO가 받는 dto는"+dto);
      int count =0;
      count = SqlSession.insert(namespace+"insertcomment",dto);

      return count>0?true:false;


   }
   //6. 댓글을 가져오는 메서드 (SELECT)
   @Override
   public List<REPLY_T_Dtos> selectAllcomment(REPLY_T_Dtos dto) {

      return SqlSession.selectList(namespace+"commentlist",dto);
   }

   //*7. 댓글에 댓글달기 (INSERT)
   @Override
   public boolean DoublecommentBoardInsert(REPLY_T_Dtos dto) {
      int count =0;
      count = SqlSession.insert(namespace+"DoublecommentBoardInsert", dto);
      
      return count>0?true:false;
   }


   //7. 게시판을 수정하는 메서드(상세보기, 내것을 클릭했을때) (UPDATE)
   @Override
   public boolean updateBoard(Answer_T_Dtos dto) {
      int count =0;
      count = SqlSession.update(namespace+"updataboard", dto);
      
      
      return count>0?true:false;
   }

   //9. 글 상세보는 메서드 (SELECT)
   @Override
   public Answer_T_Dtos getBoard(Answer_T_Dtos dto) {
      return SqlSession.selectOne(namespace+"detailboard", dto);
   }

   //10. 댓글의 수를 가져오는 메서드(SELECT)
   @Override
   public boolean commentreadCount(int seq) {
      // TODO Auto-generated method stub
      return false;
   }

   //12. 좋아요를 누르는 메서드(UPDATE)
   @Override
   public boolean insertlike(Answer_T_Dtos dto) {

      int count =0;

      System.out.println(dto);

      count =  SqlSession.insert(namespace+"insertlike", dto);

      System.out.println(count);

      return count>0?true:false;

   }

   //14. 좋아요를 누른사람을 가져오는 메서드(SELECT)
   @Override
   public Funtion_T_Dtos selectlike(Answer_T_Dtos dto) {

      return SqlSession.selectOne(namespace+"selectlike", dto);
   }

   //15. 좋아요를 삭제하는 메서드(DELETE)
   @Override
   public boolean deletelike(Answer_T_Dtos dto) {

      int count =0;

      count = SqlSession.delete(namespace+"deletelike", dto);

      return count>0?true:false;
   }

   //13. 즐겨찾기 하는 메서드(INSERT)
   @Override
   public boolean insertsearch(Answer_T_Dtos dto) {
      int count =0;

      count = SqlSession.insert(namespace+"insertsearch", dto);

      return count>0?true:false;
   }
   //14. 즐겨찾기를 가져오는 메서드
   @Override
   public Funtion_T_Dtos selectsearch(Answer_T_Dtos dto) {

      return SqlSession.selectOne(namespace+"selectsearch",dto);
   }

   //15. 즐겨찾기를 삭제하는 메서드
   @Override
   public boolean deletesearch(Answer_T_Dtos dto) {
      int count =0;

      count = SqlSession.delete(namespace+"deletesearch", dto);

      return count>0?true:false;
   }

   //16.댓글을 삭제하는 메서드
   @Override
   public boolean Deletecomment(REPLY_T_Dtos dto) {
      int count =0;

      count = SqlSession.delete(namespace+"deletecomment", dto);

      return count>0?true:false;
   }
   
   //17.해당게시글을 삭제하는 메서드(TRANSACTION처리를 SERVICE에서 해줘야함)
   
   @Override
   public int deleteBoard(int a_seq) {
      return SqlSession.delete(namespace+"deleteboard", a_seq);
   }
   @Override
   public int deleteAllcomment(int a_seq) {
      return SqlSession.delete(namespace+"deleteAllcomment", a_seq);
   }
   @Override
   public int deleteAllfunction(int a_seq) {
      return SqlSession.delete(namespace+"deleteAllfunction", a_seq);
   }
   
   //18.해당게시글의 페이지 수를 결정짓는 메서드
   @Override
   public int boardcount() {
                  
      return SqlSession.selectOne(namespace+"boardcount");
   }
   
   //23. 제목+내용을 검색하는 메서드
   @Override
   public List<Answer_T_Dtos> getAllsearch(String searchword, String a_boardname) {
      
      Map<String, String> map = new HashMap<String, String>();
      
      map.put("searchword", searchword);
      map.put("a_boardname",a_boardname);
      
      return SqlSession.selectList(namespace+"searchAll" , map);
   }
   //24. 제목만 검색하는 쿼리
   @Override
   public List<Answer_T_Dtos> gettitlesearch(String searchword, String a_boardname) {
      
      Map<String, String> map = new HashMap<String, String>();
      
      map.put("searchword", searchword);
      map.put("a_boardname",a_boardname);
      
      return SqlSession.selectList(namespace+"searchtitle" ,map);
   }
   
   //25. 검색한 페이지수를 가져오는 메서드(제목+타이틀)
   @Override
   public int searchAllboardcount(String searchword, String a_boardname) {
      
      Map<String, String> map = new HashMap<String, String>();
      
      map.put("searchword", searchword);
      map.put("a_boardname",a_boardname);
      
      
      return SqlSession.selectOne(namespace+"searchAllboardcount",map);
   }
   
   //26. 검색한 페이지수를 가져오는 메서드(제목)
   @Override
   public int searchTitleboardcount(String searchword, String a_boardname) {
      
      Map<String, String> map = new HashMap<String, String>();
      
      map.put("searchword", searchword);
      map.put("a_boardname",a_boardname);
      
      return SqlSession.selectOne(namespace+"searchTitleboardcount",map);
   }

   @Override
   public List<Answer_T_Dtos> getAllsearch(String searchword, String a_boardname, String s_num, String e_num) {
      Map<String, String> map = new HashMap<String, String>();

      map.put("searchword", searchword);
      map.put("a_boardname",a_boardname);
      map.put("s_num", s_num);
      map.put("e_num", e_num);
      
      
      return SqlSession.selectList(namespace+"searchAllpage", map);
   }

   @Override
   public List<Answer_T_Dtos> gettitlesearch(String searchword, String a_boardname, String s_num, String e_num) {
      Map<String, String> map = new HashMap<String, String>();

      map.put("searchword", searchword);
      map.put("a_boardname",a_boardname);
      map.put("s_num", s_num);
      map.put("e_num", e_num);
      
      return SqlSession.selectList(namespace+"searchtitlepage", map);
   }

   

   
   












}