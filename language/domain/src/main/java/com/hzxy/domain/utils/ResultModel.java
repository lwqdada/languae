package com.hzxy.domain.utils;
import lombok.Data;
import java.util.Map;

@Data
//返回前端数据的model
public class ResultModel {
    private int errCode; //返回码
    private String errmsg; //返回消息
    private Map<String,Object> data; //数据源
}
