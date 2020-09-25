package com.iiht.interviewtracker.service;

import static com.iiht.interviewtracker.utils.UserUtilities.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.interviewtracker.dto.UserDTO;
import com.iiht.interviewtracker.model.User;
import com.iiht.interviewtracker.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;
	
	@Override
	public UserDTO saveUser(UserDTO userDTO) {
		return null;
	}

	@Override
	public List<UserDTO> findAll() {
		return null;
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO) {
		return null;
	}

	@Override
	public UserDTO delete(String userId) {
		return null;
	}

}
