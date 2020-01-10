package com.min.inschool.daos;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.inschool.dtos.Join_T_Dtos;

@Repository
public class regist_daos implements Iregist_daos{
	
	@Autowired
	private SqlSessionTemplate SqlSession;
	private String namespace="com.min.inschool.";
	
	@Override
	public boolean Uresist(Join_T_Dtos dto) {
		int count=0;
		count=SqlSession.insert(namespace+"Uregist",dto);
		return count>0?true:false;
	}

	@Override
	public boolean Cresist(Join_T_Dtos dto) {
		int count=0;
		count=SqlSession.insert(namespace+"Cregist",dto);
		return count>0?true:false;
	}

	@Override
	public int chkDupId(Join_T_Dtos dto) {

		return SqlSession.selectOne(namespace+"chkDupId",dto);
	}

}
