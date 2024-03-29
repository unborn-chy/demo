package com.chy.handler;

import com.chy.enums.BaseErrorInterface;
import com.chy.enums.CommonEnum;
import com.chy.to.Result;
import com.chy.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 全局统一异常处理
 *
 * @author chy
 * @since 2021-03-21 20:58
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务异常
     *
     * @param
     * @return
     */
    @ExceptionHandler(BizException.class)
    public Result<BaseErrorInterface> handleBizException(BizException bizException) {
        log.warn("业务异常:{}", bizException.getError().getMessage(), bizException);
        return Result.error(bizException.getError());
    }


//    /**
//     * ValidatorUtils校验异常
//     *
//     * @param e
//     * @return
//     * @see ValidatorUtils
//     */
//    @ExceptionHandler(ValidatorException.class)
//    public Result<ExceptionCodeEnum> handleValidatorException(ValidatorException e) {
//        // 打印精确的参数错误日志，方便后端排查
//        log.warn("参数校验异常: {}", e.getMessage(), e);
//        // 一般来说，给客户端展示泛化的错误信息即可，联调时可以返回精确的信息
//        return Result.error(e.getMessage());
//    }

    /**
     * ConstraintViolationException异常（散装GET,POST 参数校验）
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<CommonEnum> handleConstraintViolationException(ConstraintViolationException e) {
        log.warn("参数错误: {}", e.getMessage(), e);
        return Result.error(CommonEnum.ERROR_PARAM, e.getMessage());
    }

    /**
     * BindException异常（GET,POST  DTO校验）
     */
    @ExceptionHandler(BindException.class)
    public Result<Map<String, String>> validationBindException(BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String message = fieldErrors.stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(" && "));
        log.error("参数错误: {}", message, e);
        return Result.error(CommonEnum.ERROR_PARAM, message);
    }

    /**
     * MethodArgumentNotValidException异常（POST DTO校验）
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Map<String, String>> validationMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String message = fieldErrors.stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(" && "));
        log.error("参数错误: {}", message, e);
        return Result.error(CommonEnum.ERROR_PARAM, message);
    }

    /**
     * 需要json传入的form post表单
     * HttpMessageNotReadableException
     */

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<Map<String, String>> validationHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("参数错误: {}", e);
        return Result.error(CommonEnum.ERROR_PARAM);
    }

    /**
     * 需要json 错误传入form-data
     * HttpMediaTypeNotSupportedException
     * @param e
     * @return
     */

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Result<Map<String, String>> validationHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        log.error("参数错误: {}", e);
        return Result.error(CommonEnum.ERROR_PARAM);
    }


    /**
     * 运行时异常 RuntimeException的子类也会被捕获
     */
//    @ExceptionHandler(RuntimeException.class)
//    public Result<BaseErrorInterface> handleRunTimeException(RuntimeException e) {
//        log.warn("运行时异常: {}", e.getMessage(), e);
//        return Result.error(CommonEnum.INTERNAL_SERVER_ERROR);
//    }

}