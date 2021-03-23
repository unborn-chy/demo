package com.chy.exception;

import com.chy.enums.BaseErrorInterface;
import lombok.Getter;

/**
 * 业务异常
 * biz是business的缩写
 * @author chy
 * @since 2021-03-21 20:34
 */
@Getter
public class BizException extends RuntimeException {


    private BaseErrorInterface error;

    /**
     * 构造器，有时我们需要将第三方异常转为自定义异常抛出，但又不想丢失原来的异常信息，此时可以传入cause
     *
     * @param error
     * @param cause
     */
    public BizException(BaseErrorInterface error, Throwable cause) {
        super(cause);
        this.error = error;
    }

    /**
     * 构造器，只传入错误枚举
     *
     * @param error
     */
    public BizException(BaseErrorInterface error) {
        this.error = error;
    }

}