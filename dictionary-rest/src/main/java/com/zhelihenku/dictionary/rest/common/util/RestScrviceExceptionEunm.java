package com.zhelihenku.dictionary.rest.common.util;

import com.zhelihenku.dictionary.core.exception.ServiceExceptionEnum;

public enum RestScrviceExceptionEunm implements ServiceExceptionEnum {

    // 1000-1999 用户中心错误码
    ERROR_PRARMS_NULL_MEMBERID(1101, "用户ID不能为空"),
    ERROR_PRARMS_NULL_NEWMEMBERID(1102, "新用户ID不能为空"),

    ERROR_MEMBER_EXPANSION_EXISTED(1201, "用户扩展已存在"),

    // 2000-2999 视频中心错误码
    ERROR_ONLINEVIDEO_NON_EXISTENT(2101, "在线视频不存在");

    RestScrviceExceptionEunm(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
