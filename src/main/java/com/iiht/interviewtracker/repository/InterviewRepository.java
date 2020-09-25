package com.iiht.interviewtracker.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.iiht.interviewtracker.model.Interview;

@Repository
public interface InterviewRepository extends MongoRepository<Interview,String> {
}
