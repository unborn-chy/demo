package com.chy.demo.enums;


public enum UserEnum implements BaseErrorInfoInterface {
    // 数据操作错误定义
    USER_IS_NULL(10001, "用户名或者密码错误");

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误描述
     */
    private String message;

    UserEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
