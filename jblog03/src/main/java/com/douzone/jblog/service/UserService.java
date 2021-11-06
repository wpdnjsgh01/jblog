package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.UserRepository;
import com.douzone.jblog.vo.UserVO;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public void join(UserVO vo) {
		userRepository.insert(vo);
	}

	public UserVO getUser(String email, String password) {
		return null;
	}
	
	public UserVO getId(String id) {
		return userRepository.getId(id);
	}


}
