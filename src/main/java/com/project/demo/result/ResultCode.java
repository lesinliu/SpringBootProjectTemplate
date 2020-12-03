package com.project.demo.result;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESS(200,"Success"),//成功
    FAIL(400,"Failure"),//失败
    UNAUTHORIZED(401,"Unauthorized"),//未认证（签名错误）
    NOT_FOUND(404,"Not Found");//接口不存在
    private final int code;
    private final String tips;

    ResultCode(int code,String tips) {
        this.code = code;
        this.tips = tips;
    }

    public int code() {
        return code;
    }
    public String tips() {
        return tips;
    }
}

