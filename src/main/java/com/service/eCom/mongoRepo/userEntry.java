package com.service.eCom.mongoRepo;

import com.service.eCom.entity.productType;
import com.service.eCom.entity.userSignIn;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface userEntry extends MongoRepository<userSignIn, String> {
    userSignIn findByEmail(String email);

    Optional<productType> findById(ObjectId id);
    void deleteById(ObjectId id);
}
