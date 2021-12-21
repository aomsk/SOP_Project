package com.example.project_sop.repository;

import com.example.project_sop.pojo.Hold;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HoldRepository extends MongoRepository<Hold, String> {

    @Query(value = "{username:'?0'}")
    public Hold findHoldBookByUsername(String username);

    @Query(value = "{title:'?0'}")
    public Hold findHoldBookByTitle(String title);

    @Query(value = "{_id: ?0}")
    public Hold findHoldBookByID(String _id);

}
