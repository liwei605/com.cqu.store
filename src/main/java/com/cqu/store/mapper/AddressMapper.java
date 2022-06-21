package com.cqu.store.mapper;

import com.cqu.store.entity.Address;
import com.cqu.store.entity.District;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

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


    /**
     * �����û�uid��ѯ�ջ���ַ����
     * @param uid               �û�uid
     * @return List<District>   �ջ���ַ����
     */
    List<Address> findByUid(Integer uid);

    /**
     * ����aid��ѯ�ջ���ַ����
     * @param aid           �ջ���ַaid
     * @return Address      �ջ���ַ���ݣ���û�ҵ��򷵻�null
     */
    Address findByAid(Integer aid);

    /**
     *  �����û���uidֵ���޸��û��ջ���ַ����Ϊ��Ĭ��
     * @param uid           �û�uid
     * @return Integer      ��Ӱ�������
     */
    Integer updateNoneDefault(Integer uid);


    /**
     * ����aid����Ĭ�ϵ�ַ
     * @param aid           �ջ���ַaid
     * @param modifiedUser  �޸���
     * @param modifiedTime  �޸�ʱ��
     * @return Integer
     */

    Integer updateDefaultByAid(
            @Param("aid") Integer aid,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime
    );

    /**
     *  ����aidɾ���ջ���ַ
     * @param aid       �ջ���ַaid
     * @return Integer  ��Ӱ�������
     */
    Integer deleteByAid(Integer aid);

    /**
     * �����û�uid��ѯ��ǰ�û����һ���޸ĵ��ջ���ַ
     * @param uid       �û�uid
     * @return Address  ����޸ĵ��ջ���ַ
     */
    Address findLastModified(Integer uid);
}
