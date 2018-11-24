package com.hzxy.language.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Long id;


    private String username;


    private String password;


    private String email;

    private String phone;
    private Date created;
    private Date updated;
}