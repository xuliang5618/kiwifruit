package sdu.gaming.kiwifruit.service.common.exception;

import sdu.gaming.kiwifruit.service.common.constant.ResponseCode;

// 不建议在此处重新定义ErrCode，会导致不好管理，推荐使用ErrConstant
//此处使用ErrConstant中的errorCode。
//@Deprecated注释影响原有代码
public enum KiwifruitErrorType {
    UNKNOWN_ERROR(ResponseCode.UNKNOWN_ERROR,"未知异常"),
    PARAMETER_NULL(ResponseCode.PARAMETER_NULL, "请求参数为空"),
    PARAMETER_ERROR(ResponseCode.PARAMETER_ERROR, "请求参数异常"),
    ACCOUNT_TYPE_NOT_EXIST(ResponseCode.Account.ACCOUNT_TYPE_NOT_EXIST, "帐号类型不存在"),
    ACCOUNT_NOT_EXIST(ResponseCode.Account.ACCOUNT_NOT_EXIST, "帐号不存在"),
    ACCOUNT_EXIST(ResponseCode.Account.ACCOUNT_EXIST, "帐号已存在");

    private int errorCode;
    private String errorMsg;

    private KiwifruitErrorType(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrCode() {
        return errorCode;
    }

    public String getErrMsg() {
        return errorMsg;
    }

}
