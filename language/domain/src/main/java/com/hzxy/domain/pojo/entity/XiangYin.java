package com.hzxy.domain.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class XiangYin {
    private Long id;
    private String name;
    private String type;
    private String record;
    private String video;
    private Date created;
    private Date updated;

}
