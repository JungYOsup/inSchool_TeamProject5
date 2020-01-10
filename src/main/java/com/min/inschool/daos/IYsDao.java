package com.min.inschool.daos;


import com.min.inschool.dtos.Join_T_Dtos;


public interface IYsDao {
	
		public Join_T_Dtos myinform(int seq); 
		// ↑ 내 정보 확인
		public boolean updateinform(Join_T_Dtos dto);
		// ↑ 내 정보 수정
//	    public Join_T_Dtos loginProcess(String id,String password);
		public Join_T_Dtos loginProcess(String id, String password);
		// ↑로그인시 DB에 있는지 확인 하는 기능
		public boolean deleteId(int seq);
		// ↑회원 탈퇴 기능
		public boolean Kregister(String j_id,String j_name);
		// ↑ kakao 임시 로그인
		public Join_T_Dtos Kidcheck(String j_id,String j_name); 
		// ↑ 임시 계정   있는지 확인 및 가져오기
		
}
