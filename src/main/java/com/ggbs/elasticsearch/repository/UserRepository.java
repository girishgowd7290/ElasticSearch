package com.ggbs.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.ggbs.elasticsearch.model.User;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String>{

	User findByFirstName(String firstName);

}
