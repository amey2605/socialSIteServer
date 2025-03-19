package com.service.eCom.mongoRepo;

import com.service.eCom.entity.productType;
import com.service.eCom.entity.userSignIn;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface userProducts extends MongoRepository<productType, String> {
    void deleteById(ObjectId id);
}
