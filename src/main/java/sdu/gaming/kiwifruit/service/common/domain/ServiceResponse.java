package sdu.gaming.kiwifruit.service.common.domain;

import sdu.gaming.kiwifruit.service.common.exception.KiwifruitException;

import java.io.Serializable;

/**
 * service层响应类
 * 接口定义为ServiceResult+throw Exception 或者 ServiceResponse格式
 *
 * @author xuliang
 */
public abstract class ServiceResponse  implements Serializable {
    /**
     * constructor
     */
    public ServiceResponse() {
        this.responseCode = 0;
        this.responseMessage = "success";
    }

    /**
     * constructor
     */
    public ServiceResponse(KiwifruitException e) {
        this.setResponseCode(e.getErrorCode());
        this.setResponseMessage(e.getErrorMsg());
    }

    /**
     * 返回消息
     */
    private String responseMessage;

    /**
     * 返回码
     */
    private int responseCode;

    public void setErrorResponse(KiwifruitException e) {
        this.setResponseCode(e.getErrorCode());
        this.setResponseMessage(e.getErrorMsg());
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
