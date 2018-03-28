package com.min.inschool.daos;

import java.util.List;

import com.min.inschool.dtos.Answer_T_Dtos;

public interface Imain_dao {

	public List<Answer_T_Dtos> mainListResume();
	public List<Answer_T_Dtos> mainListInter();
	public List<Answer_T_Dtos> mainListFree();
	public List<Answer_T_Dtos> mainListQA();
	
	public List<Answer_T_Dtos> searchAll01(String word);

	public List<Answer_T_Dtos> searchTitle01(String word);
	
	public List<Answer_T_Dtos> searchWriter01(String word);

	
	public List<Answer_T_Dtos> searchAll(String word,int sNum,int eNum);

	public List<Answer_T_Dtos> searchTitle(String word,int sNum,int eNum);
	
	public List<Answer_T_Dtos> searchWriter(String word,int sNum,int eNum);

	public int pageCountAll(String word);
	
	public int pageCountTitle(String word);
	
	public int pageCountWriter(String word);
}