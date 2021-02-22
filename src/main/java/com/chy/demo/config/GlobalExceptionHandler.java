package com.chy.demo.config;

import com.chy.demo.exception.GlobalException;
import com.chy.demo.utils.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chy
 * @since 2021-02-22 17:22
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 捕获 自定义的DemoException
     */
    @ExceptionHandler(GlobalException.class)
    public BaseResult<Object> globalExceptionHandler(GlobalException e) {
        log.error("GlobalException：{}", e.getMessage());
        return BaseResult.error(e.getCode(), e.getMessage());
    }

    /**
     * jsr303 参数校验异常
     */
    @ExceptionHandler(BindException.class)
    public BaseResult<Object> validExceptionHandler(BindException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        if(fieldError!=null){
            log.error("参数校验异常:{}({})", fieldError.getDefaultMessage(), fieldError.getField());
            // 将错误的参数的详细信息封装到统一的返回实体
            return BaseResult.error(-1, fieldError.getDefaultMessage());
        }
        return null;

    }

}
