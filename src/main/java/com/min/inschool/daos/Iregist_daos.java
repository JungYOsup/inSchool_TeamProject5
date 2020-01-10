package com.min.inschool.daos;

import com.min.inschool.dtos.Join_T_Dtos;

public interface Iregist_daos {
	//일반회원 회원가입
	public boolean Uresist(Join_T_Dtos dto);
	//기업회원 회원가입
	public boolean Cresist(Join_T_Dtos dto);
	//id중복검사
	public int chkDupId(Join_T_Dtos dto);
	
	
}
