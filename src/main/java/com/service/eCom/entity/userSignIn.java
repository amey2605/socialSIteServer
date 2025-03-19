package com.service.eCom.entity;

import com.service.eCom.controller.product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class userSignIn {


    @Id
    private ObjectId id;
    private String name;

    @Indexed(unique = true)
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String rePassword;
    @DBRef
    private List<productType> productList=new ArrayList<>();
}
