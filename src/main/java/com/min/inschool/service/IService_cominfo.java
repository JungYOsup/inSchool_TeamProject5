package com.min.inschool.service;

import java.util.List;

import com.min.inschool.dtos.Join_T_Dtos;
import com.min.inschool.dtos.cominfo_Dto;

public interface IService_cominfo {
	
	public boolean cominfo(cominfo_Dto dto);
	
	public List<cominfo_Dto> cominfo2();
	
	//페이지의 수를 가져온다.
	public int boardcount();
	
	public List<cominfo_Dto> cominfo2(String s_num,String e_num);
	
	public List<cominfo_Dto> RecommendBoardform(cominfo_Dto dto);
	
	public List<cominfo_Dto> getComInfo();
}
