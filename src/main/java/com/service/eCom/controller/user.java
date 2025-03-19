package com.service.eCom.controller;

import com.service.eCom.entity.productType;
import com.service.eCom.entity.userLogin;
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

@RestController
@RequestMapping("/user")
@Component
@CrossOrigin(origins = {"http://localhost:4200", "https://socialsiteserver-1.onrender.com"})
public class user {

    @Autowired
    private userService usersService;

    @GetMapping
    public List<userSignIn> getAllUsers(){
        return usersService.getAllProducts();
    }

    @PostMapping()
    public void addUser(@RequestBody userSignIn user){
        usersService.addProduct(user);
    }
    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody userLogin creds) {
        userSignIn user=usersService.findUserByEmail(creds.getEmail());

        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.UNAUTHORIZED);
        }

        if(user.getPassword().equals(creds.getPassword())){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }
}
