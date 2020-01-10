package com.min.inschool.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.inschool.dtos.cominfo_Dto;

@Repository
public class cominfo_daos implements Icominfo_daos{
	@Autowired
	private SqlSessionTemplate SqlSession;
	private String namespace="com.min.inschool.";

	@Override
	public boolean cominfo(cominfo_Dto dto) {
		int count=0;
		count=SqlSession.insert(namespace+"cominfo",dto);
		return count>0?true:false;
	}

	//데이터 10개 가져온다.
	@Override
	public List<cominfo_Dto> cominfo2() {
		return SqlSession.selectList(namespace+"cominfo2");
	}

	//페이지 수를 가져온다
	@Override
	public int boardcount() {
		return SqlSession.selectOne(namespace+"cominfopage");
	}

	//페이지에 해당되는 데이터를 가져온다.
	@Override
	public List<cominfo_Dto> cominfo2(String s_num, String e_num) {

		Map<String, String> map = new HashMap<String,String>();

		map.put("s_num", s_num);
		map.put("e_num", e_num);

		return SqlSession.selectList(namespace+"cominfo3",map);


	}

	@Override
	public List<cominfo_Dto> RecommendBoardform(cominfo_Dto dto) {


		return SqlSession.selectList(namespace+"recommendBoardform", dto);
	}


	@Override
	public List<cominfo_Dto> getComInfo() {

		return SqlSession.selectList(namespace+"getComInfo");


	}
}
