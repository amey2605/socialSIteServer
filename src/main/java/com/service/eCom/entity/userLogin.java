package com.service.eCom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class userLogin {

    private String email;
    private String password;
}
