package sdu.gaming.kiwifruit.service.common.constant;

/**
 * 常量类
 *
 * @author xuliang
 */
public interface Constant {
    /**
     * 用户相关
     */
    public interface User {
        /**
         * 账户类型
         */
        public interface AccountType {
            /**
             * 未知类型，查询时使用，会查询全部
             * 即都有可能
             */
            int UNKNOWN = 0;
            /**
             * 帐号number
             */
            int ACCOUNT_NUM = 1;
            /**
             * 自定义帐号
             */
            int ACCOUNT_NAME = 2;
            /**
             * 手机帐号
             */
            int PHONE = 3;
            /**
             * 邮箱帐号
             */
            int EMAIL = 4;
        }

    }
}
