package com.min.inschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.inschool.daos.IYsDao;
import com.min.inschool.dtos.Join_T_Dtos;

@Service
public class YsService implements IYsService{

	@Autowired
	private IYsDao ysDaoImp; 
	
	@Override  
	public Join_T_Dtos myinform(int seq) {
		return ysDaoImp.myinform(seq);
	}// 내정보확인

	@Override
	public boolean updateinform(Join_T_Dtos dto) {
		return ysDaoImp.updateinform(dto);
	}// 내정보 수정하기

	@Override
	public Join_T_Dtos loginProcess(String id, String password) {
		return ysDaoImp.loginProcess(id, password);
	}//로그인시 DB에서 정보확인 후 로그인 하는 기능

	@Override
	public boolean deleteId(int seq) {
		return ysDaoImp.deleteId(seq);
	}// 회원탈퇴시 기능 

	@Override
	public boolean Kregister(String j_id, String j_name) {
		return ysDaoImp.Kregister(j_id, j_name);
	}

	@Override
	public Join_T_Dtos Kidcheck(String j_id, String j_name) {
		return ysDaoImp.Kidcheck(j_id, j_name);
	}

	

	

	
	
}
