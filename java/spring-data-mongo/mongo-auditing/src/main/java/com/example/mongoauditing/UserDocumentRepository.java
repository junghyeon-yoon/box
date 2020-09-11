package com.example.mongoauditing;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDocumentRepository extends MongoRepository<UserDocument, String> {

}
