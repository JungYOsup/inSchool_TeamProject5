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
	public List<Answer_T_Dtos> searchAll(String word, int sNum, int eNum) {		
	
		Map<String, Object> map = new HashMap<String,Object>();
		
		map.put("word", word);
		map.put("sNum", sNum);
		map.put("eNum", eNum);
		
		return sqlSession.selectList(namespace+"searchAll",map);
	}
	
	@Override
	public List<Answer_T_Dtos> searchTitle(String word, int sNum, int eNum) {
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("word", word);
		map.put("sNum", sNum);
		map.put("eNum", eNum);
		
		return sqlSession.selectList(namespace+"searchTitle",map);
	}
	
	@Override
	public List<Answer_T_Dtos> searchWriter(String word, int sNum, int eNum) {
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("word", word);
		map.put("sNum", sNum);
		map.put("eNum", eNum);
		
		return sqlSession.selectList(namespace+"searchWriter",map);
	}
	
	@Override
	public List<Answer_T_Dtos> searchAll01(String word) {
		return sqlSession.selectList(namespace+"searchAll01",word);
	}
	@Override
	public List<Answer_T_Dtos> searchTitle01(String word) {
		return sqlSession.selectList(namespace+"searchTitle01",word);
	}
	@Override
	public List<Answer_T_Dtos> searchWriter01(String word) {
		return sqlSession.selectList(namespace+"searchWriter01",word);
	}
	
	@Override
	public int pageCountAll(String word) {
		return sqlSession.selectOne(namespace+"pageCountAll",word);
	}
	@Override
	public int pageCountTitle(String word) {
		return sqlSession.selectOne(namespace+"pageCountTitle",word);
				
	}
	@Override
	public int pageCountWriter(String word) {
		return sqlSession.selectOne(namespace+"pageCountWriter",word);
	}
	
	
	
	

	
	
}
