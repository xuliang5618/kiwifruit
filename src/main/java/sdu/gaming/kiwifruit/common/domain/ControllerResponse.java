package sdu.gaming.kiwifruit.common.domain;

import com.alibaba.fastjson.JSONObject;
import sdu.gaming.kiwifruit.service.common.domain.ServiceResponse;

/**
 * ControllerResponse
 *
 * @author xuliang
 */
public class ControllerResponse {
    private String errCode = "0", msg = "";

    private Object data = new JSONObject();

    public ControllerResponse setResponse(ServiceResponse serviceResponse) {
        this.errCode = serviceResponse.getResponseCode() + "";
        this.data = serviceResponse;
        this.msg = serviceResponse.getResponseMessage();
        return this;
    }

    public ControllerResponse setErrCode(String errCode) {
        this.errCode = errCode;
        return this;
    }

    public ControllerResponse setErrCode(long errCode) {
        this.errCode = errCode + "";
        return this;
    }


    public ControllerResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ControllerResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public JSONObject toJSONObject() {

        JSONObject resultValue = new JSONObject();
        resultValue.put("errCode", this.errCode);
        resultValue.put("msg", this.msg);
        if (this.data == null) {
            this.data = "";
        }
        resultValue.put("data", this.data);

        return resultValue;
    }

}
