package com.company.project.core;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
    public static Result genParmeterErrorResult() {
        return new Result()
                .setCode(ResultCode.PARAMETER_ERROR)
                .setMessage("参数错误,请检查参数");
    }
    
    public static Result genServerResult(String message) {
        return new Result()
                .setCode(ResultCode.INTERNAL_SERVER_ERROR)
                .setMessage(message);
    }
}
