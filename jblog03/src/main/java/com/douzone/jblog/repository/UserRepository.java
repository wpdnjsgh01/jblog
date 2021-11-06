package com.douzone.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
}
