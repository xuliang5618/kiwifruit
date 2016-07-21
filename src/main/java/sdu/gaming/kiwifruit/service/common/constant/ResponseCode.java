package sdu.gaming.kiwifruit.service.common.constant;

/**
 * 错误码定义
 * 100000-199999
 *
 * @author xuliang
 */
public interface ResponseCode {
    /**
     * 成功
     */
    int SUCCESSFUL = 0;
    /**
     * 未知异常
     */
    int UNKNOWN_ERROR = 1000000;
    /**
     * 参数为空
     */
    int PARAMETER_NULL = 1000001;
    /**
     * 参数校验失败
     */
    int PARAMETER_ERROR = 1000002;


    /**
     * 帐号相关
     * 100100-100199
     */
    public interface Account {
        /**
         * 帐号类型不存在
         */
        int ACCOUNT_TYPE_NOT_EXIST = 100100;
        /**
         * 帐号不存在
         */
        int ACCOUNT_NOT_EXIST = 100101;
        /**
         * 帐号已经存在
         */
        int ACCOUNT_EXIST = 100102;
    }
}
