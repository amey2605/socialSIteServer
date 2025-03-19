package com.service.eCom.service;

import com.service.eCom.entity.productType;
import com.service.eCom.entity.userSignIn;
import com.service.eCom.mongoRepo.userProducts;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class productService {


    @Autowired
    private userProducts productRepo;

    @Autowired
    private userService useService;

    public List<productType> getUserProducts(){

        return productRepo.findAll();
    }


    public Optional<productType> getProductById(ObjectId id){
        return productRepo.findById(String.valueOf(id));
    }

    public boolean addProduct(productType product,String email){

            userSignIn user= useService.findUserByEmail(email);
            productType saved=productRepo.save(product);

            user.getProductList().add(saved);
            useService.addProduct(user);
            return true;
    }
    public boolean addProductById(productType product,ObjectId id){
        return true;
    }

    public void deletePostById(ObjectId id){
        productRepo.deleteById(id);
    }



}
