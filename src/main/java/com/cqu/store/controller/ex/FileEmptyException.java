package com.cqu.store.controller.ex;

/**
 * �ϴ����ļ�Ϊ�յ��쳣������û��ѡ���ϴ����ļ����ύ�˱�����ѡ����ļ���0�ֽڵĿ��ļ�
 */
public class FileEmptyException extends FileUploadException {
    public FileEmptyException() {
        super();
    }

    public FileEmptyException(String message) {
        super(message);
    }

    public FileEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileEmptyException(Throwable cause) {
        super(cause);
    }

    protected FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
