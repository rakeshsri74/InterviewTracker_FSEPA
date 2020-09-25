package com.iiht.interviewtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.interviewtracker.dto.UserDTO;
import com.iiht.interviewtracker.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
    private UserService userService;
	
	@PostMapping(value = "/addUser")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userdto) {
		return null;
	}
	
	@GetMapping(value = "/viewAllUsers")
	public ResponseEntity<List<UserDTO>> viewAllUsers() {
		return null;
	}
	
	@PostMapping(value = "/updateUser")
	public  ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userdto){
		return null;
	}
	
	@DeleteMapping(value = "/deleteUser/{userId}")
	public  ResponseEntity<UserDTO> deleteUser(@PathVariable("userId") String userId){
		return null;
	}	



}
