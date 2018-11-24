package com.hzxy.domain.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AreaContent {
    private long id;
    private long categoryId;
    private String yanyu;
    private String geyao;
    private String gushi;
    private String jinji;
    private String qiyu;
    private String dancantuce;
    private String content;
    private String pic;
    private Date created;
    private Date updated;
}