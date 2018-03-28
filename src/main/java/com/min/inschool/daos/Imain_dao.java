package com.min.inschool.daos;

import java.util.List;

import com.min.inschool.dtos.Answer_T_Dtos;

public interface Imain_dao {

	public List<Answer_T_Dtos> mainListResume();
	public List<Answer_T_Dtos> mainListInter();
	public List<Answer_T_Dtos> mainListFree();
	public List<Answer_T_Dtos> mainListQA();
	
	public List<Answer_T_Dtos> searchAll(String word);

	public List<Answer_T_Dtos> searchTitle(String word);
	
	public List<Answer_T_Dtos> searchWriter(String word);

	public int pageCount(int count);

}