package com.service.eCom.controller;

import com.service.eCom.entity.productType;
import com.service.eCom.entity.userSignIn;
import com.service.eCom.service.productService;
import com.service.eCom.service.userService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@Component
@CrossOrigin(origins = {"http://localhost:4200", "https://socialsiteserver-1.onrender.com"})

public class product {

    @Autowired
    private productService productsservice;

    @Autowired
    private userService userService;



    @GetMapping("{email}")
    public ResponseEntity<?> getAllProductsOfUser(@PathVariable String email){
            userSignIn user = userService.findUserByEmail(email);
            List<productType> all= user.getProductList();
            if(!all.isEmpty() && all!=null){
                return new ResponseEntity<>(all, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }
    @GetMapping("allUsers")
    public ResponseEntity<?> getALlPostsOfAllUsers(){
        List<productType> allPosts=productsservice.getUserProducts();
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @DeleteMapping("/{email}/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
        ObjectId objectid=new ObjectId(String.valueOf(id));

        productsservice.deletePostById(objectid);
        return new ResponseEntity<>("Product deleted", HttpStatus.OK);

    }

//    @GetMapping("{id}")
//    public Optional<productType> getProduct(@PathVariable ObjectId id){
//        return productsservice.getProductById(id);
//    }




    @PostMapping("{email}")
    public void addProducttoUser(@RequestBody productType product, @PathVariable String email){

        userSignIn user=userService.findUserByEmail(email);
        productsservice.addProduct(product,email);

    }


//    @PostMapping("{id}")
//    public void addProductById(@RequestBody productType product,@PathVariable ObjectId id){
//
//    }
}
