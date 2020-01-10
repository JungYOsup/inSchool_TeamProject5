package com.min.inschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.inschool.daos.Icominfo_daos;
import com.min.inschool.dtos.cominfo_Dto;

@Service
public class Service_cominfo implements IService_cominfo{

	@Autowired
	private Icominfo_daos cominfo_daos;
	
	@Override
	public boolean cominfo(cominfo_Dto dto) {
		return cominfo_daos.cominfo(dto);
	}

	@Override
	public List<cominfo_Dto> cominfo2() {
		return cominfo_daos.cominfo2();
	}

	@Override
	public int boardcount() {
		return cominfo_daos.boardcount();
	}

	@Override
	public List<cominfo_Dto> cominfo2(String s_num, String e_num) {
		return cominfo_daos.cominfo2(s_num, e_num);
	}

	@Override
	public List<cominfo_Dto> RecommendBoardform(cominfo_Dto dto) {
		return cominfo_daos.RecommendBoardform(dto);
	}

	@Override
	public List<cominfo_Dto> getComInfo() {
		// TODO Auto-generated method stub
		return cominfo_daos.getComInfo();
	}
	
	
	
}
