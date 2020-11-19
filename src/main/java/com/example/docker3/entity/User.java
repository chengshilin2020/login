package com.example.docker3.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author csl
 */
@Data
public class User implements Serializable {
    private String id;
    private String username;
    private String password;
}
