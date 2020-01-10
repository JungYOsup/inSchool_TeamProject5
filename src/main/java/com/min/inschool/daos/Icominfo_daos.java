package com.min.inschool.daos;

import java.util.List;

import com.min.inschool.dtos.cominfo_Dto;

public interface Icominfo_daos {
	
	public boolean cominfo(cominfo_Dto dto);
	
	//10개의 정보를 가져온다.
	public List<cominfo_Dto> cominfo2();
	
	//페이지의 수를 가져온다.
	public int boardcount();
		
	//페이지에 해당되는 정보를 가져온다.
	public List<cominfo_Dto> cominfo2(String s_num,String e_num);
	
	//추천받은 기업의 데이터를 가져온다. 
	public List<cominfo_Dto> RecommendBoardform(cominfo_Dto dto);
		
	public List<cominfo_Dto> getComInfo();
	
	
}
