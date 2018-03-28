package com.min.inschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.inschool.daos.Imain_dao;
import com.min.inschool.dtos.Answer_T_Dtos;

@Service

public class main_service implements Imain_service{

@Autowired
private Imain_dao main_dao;


	@Override
	public List<Answer_T_Dtos> mainListResume() {
		return main_dao.mainListResume();
	}

	@Override
	public List<Answer_T_Dtos> mainListInter() {
		return main_dao.mainListInter();
	}

	@Override
	public List<Answer_T_Dtos> mainListFree() {
		return main_dao.mainListFree();
	}

	@Override
	public List<Answer_T_Dtos> mainListQA() {
		return main_dao.mainListQA();
	}

	@Override
	public List<Answer_T_Dtos> searchAll(String word) {
		return main_dao.searchAll(word);
	}

	@Override
	public List<Answer_T_Dtos> searchTitle(String word) {
		return main_dao.searchTitle(word);
	}

	@Override
	public List<Answer_T_Dtos> searchWriter(String word) {
		return main_dao.searchWriter(word);
	}

	@Override
	public int pageCount(int count) {
		return main_dao.pageCount(count);
	
	}

	
}
