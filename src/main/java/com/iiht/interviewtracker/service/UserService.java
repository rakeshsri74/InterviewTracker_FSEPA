package com.iiht.interviewtracker.service;

import java.util.List;

import com.iiht.interviewtracker.dto.UserDTO;

public interface UserService {

	public UserDTO saveUser(UserDTO userDTO);
	List<UserDTO> findAll();
	public UserDTO updateUser(UserDTO userDTO);
	public UserDTO delete(String userId);
}
