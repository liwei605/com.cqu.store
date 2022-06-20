package com.cqu.store.service.ex;

/**
 *  ��ʾ�ջ���ַ������������쳣��20����
 * @Author supreme
 * @Date 2022/6/20 11:08
 */


public class AddressCountLimitException extends ServiceException {
    public AddressCountLimitException() {
        super();
    }

    public AddressCountLimitException(String message) {
        super(message);
    }

    public AddressCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressCountLimitException(Throwable cause) {
        super(cause);
    }

    protected AddressCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
