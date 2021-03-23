package com.chy.enums;

/**
 * 用户错误信息
 */
public enum UserErrorEnum implements BaseErrorInterface{
    /**
     *
     */
    USER_TYPE_ERROR(1000, "用户类型有误");
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误描述
     */
    private String message;

    UserErrorEnum(Integer code, String message) {
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
