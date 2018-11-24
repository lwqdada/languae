package com.hzxy.domain.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Category implements Serializable{
    private  Long id;
    private Long  parentId;
    private String name;
    private Long sortOrder;
    private Long status;
    private  Boolean isParent;
    private Date created;
    private Date updated;

}
