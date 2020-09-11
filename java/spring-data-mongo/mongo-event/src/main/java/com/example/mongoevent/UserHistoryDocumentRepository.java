package com.example.mongoevent;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHistoryDocumentRepository extends MongoRepository<UserHistoryDocument, String> {

}
