package com.douzone.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.exception.UserRepositoryException;
//import com.douzone.jblog.exception.UserRepositoryException;
import com.douzone.jblog.vo.UserVO;

@Repository
public class UserRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public boolean insert(UserVO vo) {
		int count = sqlSession.insert("user.insert", vo);
		return count == 1;
	}

	public boolean update(UserVO vo) {
		int count = sqlSession.update("user.update", vo);
		return count == 1;
	}
	
	public UserVO getId(String id) {
		return sqlSession.selectOne("user.getId", id);
	}
	
	public UserVO getIdAndPassword(String id, String password) throws UserRepositoryException {
		Map<String, String> map = new HashMap<>();
		map.put("i", id);
		map.put("p", password);
		
		return sqlSession.selectOne("user.getIdAndPassword", map);
	}
	
}
