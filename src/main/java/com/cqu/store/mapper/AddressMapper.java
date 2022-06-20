package com.cqu.store.mapper;

import com.cqu.store.entity.Address;

/**
 *  �ջ��ַ�־ò�ӿ�
 * @Author supreme
 * @Date 2022/6/20 10:21
 */

public interface AddressMapper  {
    /**
     * �����û��ó��ջ���ַ����
     * @param address   �ջ��ַ����
     * @return Integer  ��Ӱ�������
     */
    Integer insert(Address address);

    /**
     * �����û�idͳ���ջ���ַ����
     * @param uid       �û�uid
     * @return Integer  �ջ���ַ����
     */

    Integer countByUid(Integer uid);
}
