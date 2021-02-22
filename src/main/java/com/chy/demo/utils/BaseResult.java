package com.chy.demo.utils;

import com.chy.demo.enums.BaseErrorInfoInterface;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 返回数据格式
 *
 * @author chy
 * @since 2021-02-22 16:29
 */

@Getter
@Setter
@NoArgsConstructor
public class BaseResult<T> {
    //返回代码
    private Integer code;

    //返回消息
    private String message;

    //返回对象
    private T data;


    private BaseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private BaseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功
     */
    public static <T> BaseResult<T> success(Integer code, String message,T data) {
        return new BaseResult<T>(code, message,data );
    }

    public static <T> BaseResult<T> success(BaseErrorInfoInterface base,T data) {
        return new BaseResult<T>(base.getCode(), base.getMessage(),data );
    }


    /**
     * 失败
     */
    public static <T> BaseResult<T> error(Integer code, String message) {
        return new BaseResult<T>(code, message);
    }

}
