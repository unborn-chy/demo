package com.chy.demo.exception;

import com.chy.demo.enums.BaseErrorInfoInterface;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 自定义异常
 * @author chy
 * @since 2021-02-22 16:54
 */
@Getter
@Setter
@NoArgsConstructor
public class GlobalException extends RuntimeException{
    private Integer code;

    public GlobalException(String message){
        super(message);
    }

    public GlobalException(BaseErrorInfoInterface errorInfoInterface) {
        super(errorInfoInterface.getMessage());
        this.code = errorInfoInterface.getCode();
    }
}
