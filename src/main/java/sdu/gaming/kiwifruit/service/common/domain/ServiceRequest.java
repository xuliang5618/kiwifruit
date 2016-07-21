package sdu.gaming.kiwifruit.service.common.domain;

import sdu.gaming.kiwifruit.service.common.exception.KiwifruitException;

import java.io.Serializable;

/**
 * service层请求类
 * 请求类定义尽量用单独字段，不包含实体类
 *
 * @author xuliang
 */
public abstract class ServiceRequest  implements Serializable {
    abstract protected void validate() throws KiwifruitException;
}
