package com.chy.utils;

import com.chy.enums.BaseErrorInterface;
import com.chy.enums.CommonEnum;
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
public class Result<T> {
    //返回代码
    private Integer code;

    //返回消息
    private String message;

    //返回对象
    private T data;


    private Result(Integer code, String message) {
        this.code = code;
        this.message = message;
        data= null;
    }

    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 不带数据成功返回
     */
    public static <T> Result<T> success() {
        return success(null);
    }
    /**
     * 带数据成功返回
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(CommonEnum.SUCCESS.getCode(), CommonEnum.SUCCESS.getMessage(),data);
    }

    /**
     * 重载消息的成功返回
     */
    public static <T> Result<T> success(String message,T data) {
        return new Result<T>(CommonEnum.SUCCESS.getCode(), message,data);
    }

    /**
     * 通用错误返回，传入指定的错误枚举
     *
     * @param error
     * @return
     */
    public static <T> Result<T> error(BaseErrorInterface error) {
        return new Result<T>(error.getCode(), error.getMessage());
    }

    /**
     * 通用错误返回，传入指定的错误枚举，但支持覆盖message
     */
    public static <T> Result<T> error(BaseErrorInterface error, String message) {
        return new Result<T>(error.getCode(), message);
    }

    /**
     * 通用错误返回，只传入message
     *
     * @param message
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(String message) {
        return new Result<T>(CommonEnum.INTERNAL_SERVER_ERROR.getCode(), message);
    }

    /**
     * 直接返回系统错误
     * @param <T>
     * @return
     */
    public static <T> Result<T> error() {
        return error(CommonEnum.INTERNAL_SERVER_ERROR);
    }
}
