package com.min.inschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.inschool.daos.Iregist_daos;
import com.min.inschool.dtos.Join_T_Dtos;
@Service
public class Service_Regist implements IService_Regist{

	@Autowired
	private Iregist_daos regist_daos;
	
	@Override
	public boolean Uresist(Join_T_Dtos dto) {
		return regist_daos.Uresist(dto);
	}

	@Override
	public boolean Cresist(Join_T_Dtos dto) {
		return regist_daos.Cresist(dto);
	}

	@Override
	public int chkDupId(Join_T_Dtos dto) {
		return regist_daos.chkDupId(dto);
	}
}
