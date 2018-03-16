package com.min.inschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.inschool.daos.IDao_Ys;
import com.min.inschool.dtos.Answer_T_Dtos;

@Service
public class Service_Ys implements IService_Ys {
	
	@Autowired
	private IDao_Ys YSDao;
	
	@Override
	public List<Answer_T_Dtos> getAllList() {
		
		return YSDao.getAllList();
	}

	@Override
	public boolean insertboard(Answer_T_Dtos dto) {
		
		return YSDao.insertboard(dto);
	}

	@Override
	public boolean readCount(int seq) {
		return YSDao.readCount(seq);
	}

	@Override
	public boolean replyboard(Answer_T_Dtos dto) {
		return false;
	}

	@Override
	public int commentBoardInsert(Answer_T_Dtos dto) {
		return 0;
	}

	@Override
	public int DoublecommentBoardInsert(Answer_T_Dtos dto) {
		return 0;
	}

	@Override
	public boolean updateBoard(Answer_T_Dtos dto) {
		return YSDao.updateBoard(dto);
	}

	@Override
	public boolean deleteBoard(int seq) {
		return YSDao.deleteBoard(seq);
	}

	@Override
	public Answer_T_Dtos getBarod(int seq) {
		return YSDao.getBarod(seq);
	}

	@Override
	public boolean commentreadCount(int seq) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Answer_T_Dtos getBoardAjax(int seq) {
		return null;
	}

	


}
