package com.example.project_sop.repository;

import com.example.project_sop.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query(value = "{username:'?0'}")
    public User findUserByUsername(String username);

    @Query(value = "{_id:?0}")
    public User findUserByID(String _id);
}
