package com.hzxy.language.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Category implements Serializable{
    private  Long id;
    private Long  parentId;
    private String name;
    private Long sortOrder;
    private Long status;
    private  Boolean isParent;
    private List<AreaContent> areaContents;
    private Date created;
    private Date updated;

}
