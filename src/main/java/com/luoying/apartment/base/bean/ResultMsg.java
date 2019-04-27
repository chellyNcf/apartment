package com.luoying.apartment.base.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultMsg {

    ResultMsg(){

    }

    private Integer code;

    private String msg;

    private Integer count;

    private Object data;

}
