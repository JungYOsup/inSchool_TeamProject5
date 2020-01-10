package com.min.inschool.daos;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.inschool.dtos.Answer_T_Dtos;
import com.min.inschool.dtos.Join_T_Dtos;

@Repository
public class YsDao implements IYsDao {

    @Autowired
	 private SqlSessionTemplate sqlSession;
     private String namespace="com.min.inschool.";
  	
	
	@Override
	public Join_T_Dtos myinform(int seq) {
		// if 절로    유저정보 가져오게하는 mapper 쿼리랑  , 기업정보 가져오게하는 쿼리를 나눠서 갖고 오게 해야함.
		return sqlSession.selectOne(namespace+"myinform",seq);
	}
	// 내정보확인하기
	
	@Override
	public boolean updateinform(Join_T_Dtos dto) {
		int count = 0;
		count = sqlSession.update(namespace+"updateinform",dto);
		return count>0?true:false;
	} 
	// 내정보 수정하기 

	@Override
	public Join_T_Dtos loginProcess(String j_id, String j_password) {
		 
		Map<String, String> map = new HashMap<String,String>();
		map.put("id", j_id);
		map.put("password", j_password);
		//sqlSession.select(statement, handler);
	
		 return sqlSession.selectOne(namespace+"loginProcess",map);
	}
	// 로그인 

	@Override
	public boolean deleteId(int seq) {
	    int	count= 0;
		 count = sqlSession.update(namespace+"deleteID",seq);
		  return count>0?true:false;
	}

	@Override
	public boolean Kregister(String j_id,String j_name) {
			int count = 0;
			Map<String, String> map = new HashMap<String,String>();
			map.put("j_id", j_id);
			map.put("j_name", j_name);
			
			count = sqlSession.insert(namespace+"Kregister",map);
		return count>0?true:false;
	}

	@Override
	public Join_T_Dtos Kidcheck(String j_id, String j_name) {
				Map<String, String> map = new HashMap<String,String>();
				map.put("j_id", j_id);
				map.put("j_name", j_name);
				return sqlSession.selectOne(namespace+"Kidcheck",map);
	}
	
//	@Override
//	public static usernot

	

}
