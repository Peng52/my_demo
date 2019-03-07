package com.jack.shiro;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author : peng
 * @Description :
 * @Date : 2019-02-26 11:03
 */
@Getter
@Setter
public class PushUser implements Serializable {

    private static final long serialVersionUID = 4492116936989175773L;


    private Long userId;


    private Integer appType;


    private Integer sex;

    private Long count;
}
