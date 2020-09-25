package com.iiht.interviewtracker.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.iiht.interviewtracker.model.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

}
