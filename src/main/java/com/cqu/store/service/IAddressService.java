package com.cqu.store.service;

import com.cqu.store.entity.Address;

/**
 *  �ջ���ַҵ���ӿ�
 * @Author supreme
 * @Date 2022/6/20 11:11
 */

public interface IAddressService {

    /**
     * �����ջ��ַҵ��
     * @param uid       �û�uid
     * @param username  �ջ�������
     * @param address   ����ĵ�ַ
     */
    void addNewAddress(Integer uid, String username, Address address);
}
