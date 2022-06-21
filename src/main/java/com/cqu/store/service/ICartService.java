package com.cqu.store.service;

import com.cqu.store.vo.CartVO;

import java.util.List;

/** ������Ʒ���ݵ�ҵ���ӿ� */
public interface ICartService {
    /**
     * ����Ʒ��ӵ����ﳵ
     *
     * @param uid      ��ǰ��¼�û���id
     * @param pid      ��Ʒ��id
     * @param amount   ���ӵ�����
     * @param username ��ǰ��¼���û���
     */
    void addToCart(Integer uid, Integer pid, Integer amount, String username);

    /**
     * ��ʾ���ﳵ
     * @param uid
     * @return
     */
    List<CartVO> getVOByUid(Integer uid);

    /**
     * �����ﳵ��ĳ��Ʒ��������1
     * @param cid ���ﳵ������id
     * @param uid ��ǰ��¼���û���id
     * @param username ��ǰ��¼���û���
     * @return ���ӳɹ����µ�����
     */
    Integer addNum(Integer cid, Integer uid, String username);

    /**
     * �������ɸ����ﳵ����id��ѯ������б�
     * @param uid ��ǰ��¼���û���id
     * @param cids ���ɸ����ﳵ����id
     * @return ƥ��Ĺ��ﳵ����������б�
     */
    List<CartVO> getVOByCids(Integer uid, Integer[] cids);

}