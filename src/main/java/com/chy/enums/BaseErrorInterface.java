package com.chy.enums;

/**
 * 错误枚举的接口
 */
public interface BaseErrorInterface {
    /** 错误码*/
    Integer getCode();

    /** 错误描述*/
    String getMessage();
}
