package com.min.inschool.service;

import com.min.inschool.dtos.Join_T_Dtos;

public interface IService_Regist {
	public	boolean Uresist(Join_T_Dtos dtos);

	public	boolean Cresist(Join_T_Dtos dtos);

	public int chkDupId(Join_T_Dtos dto);

}
