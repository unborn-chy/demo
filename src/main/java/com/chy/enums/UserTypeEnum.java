package com.chy.enums;

import com.chy.exception.BizException;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户类型
 * @author chy
 * @since 2021-03-22 13:38
 */
public enum UserTypeEnum {

    /**
     *
     */
    ADMIN(1,"管理员"),
    READER(2,"读者"),
    ;
    private Integer code;
    private String message;

    private UserTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
   private static  Map<Integer,UserTypeEnum> CACHE_USER = new HashMap<>();

    /**
     * 吧map存入Map中
     */
    static {
        UserTypeEnum[] values = UserTypeEnum.values();
        for (UserTypeEnum value : values) {
            CACHE_USER.put(value.getCode(),value);
        }
    }
    /**
     * 根据code在Map中找到对应的类型
     */
    public static void getUserTypeEnumByCode(Integer code){

        UserTypeEnum userTypeEnum = CACHE_USER.get(code);
        if(userTypeEnum==null){
            throw new BizException(UserErrorEnum.USER_TYPE_ERROR);
        }
    }
}
