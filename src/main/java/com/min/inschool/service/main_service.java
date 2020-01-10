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
	public List<Answer_T_Dtos> searchAll(String word, int sNum, int eNum) {
		return main_dao.searchAll(word,sNum,eNum);
	}

	@Override
	public List<Answer_T_Dtos> searchTitle(String word, int sNum, int eNum) {
		return main_dao.searchTitle(word,sNum,eNum);
	}

	@Override
	public List<Answer_T_Dtos> searchWriter(String word, int sNum, int eNum) {
		return main_dao.searchWriter(word,sNum,eNum);
	}

	

	@Override
	public List<Answer_T_Dtos> searchAll01(String word) {
		return main_dao.searchAll01(word);
	}

	@Override
	public List<Answer_T_Dtos> searchTitle01(String word) {
		return main_dao.searchTitle01(word);
	}

	@Override
	public List<Answer_T_Dtos> searchWriter01(String word) {
		return main_dao.searchWriter01(word);
	}

	@Override
	public int pageCountAll(String word) {
		return main_dao.pageCountAll(word);
	}

	@Override
	public int pageCountTitle(String word) {
		return main_dao.pageCountTitle(word);
	}

	@Override
	public int pageCountWriter(String word) {
		return main_dao.pageCountWriter(word);
	}

	
}
