package com.cpy.onsiteinform.config;

import com.cpy.onsiteinform.exception.RRException;
import com.cpy.onsiteinform.framework.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Carl
 * @Description
 * @date 2019-10-13 20:38
 * @Param
 * @return
 **/
@ControllerAdvice
public class GlobalDefultExceptionHandler extends BaseController {

    private static Logger Log = LoggerFactory.getLogger(GlobalDefultExceptionHandler.class);

    //声明要捕获的异常
    @ExceptionHandler(RRException.class)
    @ResponseBody
    public ApiResponse defultExcepitonHandler(RRException e) {
        Log.info(e.getMessage(), e);
        return wrapApiResponse(ApiStatusCode.SERVICE_BIZ_EXCEPTION, null, e.getMessage(), e.getMsg());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResponse handleException(Exception e) {
        Log.error("系统错误", e);
        return wrapApiResponse(ApiStatusCode.SYSTEM_ERROR, null, "系统错误");
    }

    @ResponseBody
    @ExceptionHandler(ParamValidateException.class)
    public ApiResponse handleParamValidateException(ParamValidateException e) {
        String msg = String.format("参数校验错误: %s, %s", e.getParam(), e.getMsg());
        Log.error(msg, e);
        return wrapApiResponse(ApiStatusCode.INVALID_PARAM, null, msg);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                sb.append("[").append(fieldError.getField()).append(fieldError.getDefaultMessage()).append("] ");
            } else if (error instanceof ObjectError) {
                sb.append("[").append(error.getObjectName()).append(error.getDefaultMessage()).append("] ");
            }
        }
        String msg = String.format("参数校验错误: %s", sb.toString());
        Log.error(msg, e);
//        return wrapApiResponse(ApiStatusCode.INVALID_PARAM, null, msg);
        return wrapApiResponse(ApiStatusCode.INVALID_PARAM, null, msg);
    }

    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ApiResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        Log.error("参数解析错误", e);
        return wrapApiResponse(ApiStatusCode.PARAM_ERROR, null, "参数解析错误");
    }

    @ResponseBody
    @ExceptionHandler(WebApiException.class)
    public ApiResponse handleWebApiException(WebApiException e) {
        Log.error("系统错误", e);
        if (e.getMessage() == null) {
            return wrapApiResponse(ApiStatusCode.SYSTEM_ERROR, null, "系统错误");
        } else {
            return wrapApiResponse(ApiStatusCode.SYSTEM_ERROR, null, e.getMessage());
        }
    }
}
	
