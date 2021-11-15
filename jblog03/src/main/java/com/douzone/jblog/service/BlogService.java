package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.vo.BlogVO;
import com.douzone.jblog.vo.UserVO;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	public Boolean saveImage(BlogVO vo) {
		return blogRepository.insert(vo);
	}
	/*
	 * public UserVO getId(String id) { return blogRepository.getId(id); }
	 */
	
}
