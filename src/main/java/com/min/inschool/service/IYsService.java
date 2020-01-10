package com.min.inschool.service;

import com.min.inschool.dtos.Join_T_Dtos;

public interface IYsService {
	public Join_T_Dtos myinform(int seq); 
	// ↑ 내 정보 확인
	public boolean updateinform(Join_T_Dtos dto);
	// ↑ 내 정보 수정
	public Join_T_Dtos loginProcess(String id,String password);
	// 로그인 접속시 DB에 정보 확인 
	public boolean deleteId(int seq);
	// ↑ 회원탈퇴
    public boolean Kregister(String j_id,String j_name);
    // ↑ 카카오 임시로그인
    public Join_T_Dtos Kidcheck(String j_id,String j_name); 
    // ↑ 카카오 아이디체크
    
}
