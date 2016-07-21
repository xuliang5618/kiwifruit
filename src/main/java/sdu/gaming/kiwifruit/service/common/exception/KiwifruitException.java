package sdu.gaming.kiwifruit.service.common.exception;

/**
 * 异常定义
 *
 * @author xuliang
 */
public class KiwifruitException extends RuntimeException {


    private int errorCode;
    private String errorMsg;

    protected KiwifruitException() {
    }

    protected KiwifruitException(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public static KiwifruitException createInstance(KiwifruitErrorType type) {
        return new KiwifruitException(type.getErrCode(), type.getErrMsg());
    }
    public static KiwifruitException createInstance(int errorCode, String errorMsg) {
        return new KiwifruitException(errorCode, errorMsg);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
