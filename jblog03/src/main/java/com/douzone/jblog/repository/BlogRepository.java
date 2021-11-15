package com.douzone.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.BlogVO;

@Repository
public class BlogRepository {
	
	@Autowired
	private SqlSession sqlSession;

	public Boolean insert(BlogVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
