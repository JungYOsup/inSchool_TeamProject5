package com.min.inschool.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.inschool.dtos.Answer_T_Dtos;


@Repository
public class main_dao implements Imain_dao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace="com.inschool.main.";
	
	@Override
	public List<Answer_T_Dtos> mainListResume() {
		return sqlSession.selectList(namespace+"mainlistResume");
	}
	@Override
	public List<Answer_T_Dtos> mainListInter() {
		return sqlSession.selectList(namespace+"mainlistInter");
	}
	@Override
	public List<Answer_T_Dtos> mainListFree() {
		return sqlSession.selectList(namespace+"mainlistFree");
	}
	@Override
	public List<Answer_T_Dtos> mainListQA() {
		return sqlSession.selectList(namespace+"mainlistQA");
	}
	
	@Override
	public List<Answer_T_Dtos> searchAll(String word) {		
	return sqlSession.selectList(namespace+"searchAll",word);
	}
	
	@Override
	public List<Answer_T_Dtos> searchTitle(String word) {
		
		return sqlSession.selectList(namespace+"searchTitle",word);
	}
	@Override
	public List<Answer_T_Dtos> searchWriter(String word) {
		return sqlSession.selectList(namespace+"searchWriter",word);
	}
	@Override
	public int pageCount(int count) {

		return sqlSession.selectOne(namespace+"pageCount", count);
	}
	
	
	
	

	
	
}
