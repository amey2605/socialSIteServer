package com.service.eCom.service;


import com.service.eCom.entity.productType;
import com.service.eCom.entity.userSignIn;
import com.service.eCom.mongoRepo.userEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class userService {

    @Autowired
    private userEntry userRepo;

    public List<userSignIn> getAllProducts(){
        return userRepo.findAll();
    }

    public Optional<userSignIn> getProductById(ObjectId id){
        return userRepo.findById(String.valueOf(id));
    }

    public boolean addProduct(userSignIn product){
        userRepo.save(product);
        return true;
    }
    public boolean addProductById(userSignIn product,ObjectId id){
        return true;
    }

    public userSignIn findUserByEmail(String email){

        return userRepo.findByEmail(email);
    }
    public void deletePostById(ObjectId id){
        userRepo.deleteById(id);
        System.out.print("deleted post");
    }
}
