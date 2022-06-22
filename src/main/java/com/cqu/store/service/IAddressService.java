package com.cqu.store.service;

import com.cqu.store.entity.Address;

import java.util.List;

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

    /**
     * �����û�uid��ȡ�ջ���ַ��Ϣ
     * @param uid               �û�uid
     * @return List<Address>    �ջ���ַ��Ϣ�б�
     */
    List<Address> getByUid(Integer uid);

    /**
     * �޸�ĳ���û�ĳ���ջ���ַΪĬ�ϵ�ַ
     * @param aid       �ջ���ַid
     * @param uid       �û�uid
     * @param username  �޸���
     */
    void setDefault(Integer aid,Integer uid,String username);

    /**
     *  ɾ���û�ѡ�е��ջ���ַ
     * @param aid       �ջ���ַaid
     * @param uid       �û�uid
     * @param username  �û���
     */
    void deleteAddress(Integer aid, Integer uid, String username);

    /**
     * �����ջ���ַ���ݵ�id����ѯ�ջ���ַ����
     * @param aid �ջ���ַid
     * @param uid �������û�id
     * @return ƥ����ջ���ַ����
     */
    Address getByAid(Integer aid, Integer uid);
}
