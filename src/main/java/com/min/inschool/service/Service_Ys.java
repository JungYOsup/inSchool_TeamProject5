package com.min.inschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.inschool.daos.IDao_Ys;
import com.min.inschool.dtos.Answer_T_Dtos;
import com.min.inschool.dtos.Funtion_T_Dtos;
import com.min.inschool.dtos.REPLY_T_Dtos;

@Service
public class Service_Ys implements IService_Ys {
	
	@Autowired
	private IDao_Ys YSDao;
	
	@Override
	public List<Answer_T_Dtos> getAllList() {
		
		return YSDao.getAllList();
	}
	
	@Override
	public List<Answer_T_Dtos> getAllList(String s_num,String e_num) {
		
		return YSDao.getAllList(s_num, e_num);
	}

	@Override
	public boolean insertboard(Answer_T_Dtos dto) {
		
		return YSDao.insertboard(dto);
	}

	@Override
	public boolean readCount(int seq) {
		return YSDao.readCount(seq);
	}

	@Transactional
	@Override
	public boolean replyboard(Answer_T_Dtos dto) {
		int count =0;
		
		YSDao.replyBoardUpdate(dto);
		count = YSDao.replyBoardInsert(dto);
		
		return count>0?true:false;
	}

	@Override
	public boolean commentBoardInsert(REPLY_T_Dtos dto) {
		return YSDao.commentBoardInsert(dto);
	}

	@Override
	public List<REPLY_T_Dtos> selectAllcomment(REPLY_T_Dtos dto) {
		return YSDao.selectAllcomment(dto);
	}
	
	@Override
	public boolean DoublecommentBoardInsert(REPLY_T_Dtos dto) {
		return YSDao.DoublecommentBoardInsert(dto);
	}

	@Override
	public boolean updateBoard(Answer_T_Dtos dto) {
		return YSDao.updateBoard(dto);
	}

	

	@Override
	public Answer_T_Dtos getBoard(Answer_T_Dtos dto) {
		return YSDao.getBoard(dto);
	}

	@Override
	public boolean commentreadCount(int seq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertlike(Answer_T_Dtos dto) {
		
		return YSDao.insertlike(dto);
	}


	@Override
	public Funtion_T_Dtos selectlike(Answer_T_Dtos dto) {
		// TODO Auto-generated method stub
		return YSDao.selectlike(dto);
	}
	
	@Override
	public boolean deletelike(Answer_T_Dtos dto) {
		return YSDao.deletelike(dto);
	}
	
	@Override
	public boolean insertsearch(Answer_T_Dtos dto) {
		return YSDao.insertsearch(dto);
	}

	@Override
	public Funtion_T_Dtos selectsearch(Answer_T_Dtos dto) {
		
		return YSDao.selectsearch(dto);
	}

	@Override
	public boolean deletesearch(Answer_T_Dtos dto) {
		
		return YSDao.deletesearch(dto);
	}

	@Override
	public boolean Deletecomment(REPLY_T_Dtos dto) {
		
		return YSDao.Deletecomment(dto);
	}
	
	@Transactional
	@Override
	public boolean deleteBoard(int a_seq) {
		int count =0;
		
		YSDao.deleteAllfunction(a_seq);
		
		YSDao.deleteAllcomment(a_seq);
		
		count = YSDao.deleteBoard(a_seq);
		
		return count>0?true:false;
	}
	
	@Override
	public int boardcount() {
		return YSDao.boardcount();
	}

	@Override
	public List<Answer_T_Dtos> getAllsearch(String searchword, String a_boardname) {
		// TODO Auto-generated method stub
		return YSDao.getAllsearch(searchword, a_boardname);
	}

	@Override
	public List<Answer_T_Dtos> gettitlesearch(String searchword, String a_boardname) {
		// TODO Auto-generated method stub
		return YSDao.gettitlesearch(searchword, a_boardname);
		
	}

	@Override
	public int searchAllboardcount(String searchword, String a_boardname) {
		// TODO Auto-generated method stub
		return YSDao.searchAllboardcount(searchword, a_boardname);
	}

	@Override
	public int searchTitleboardcount(String searchword, String a_boardname) {
		// TODO Auto-generated method stub
		return YSDao.searchAllboardcount(searchword, a_boardname);
	}

	@Override
	public List<Answer_T_Dtos> getAllsearch(String searchword, String a_boardname, String s_num, String e_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer_T_Dtos> gettitlesearch(String searchword, String a_boardname, String s_num, String e_num) {
		// TODO Auto-generated method stub
		return null;
	}
	

	


	


}
