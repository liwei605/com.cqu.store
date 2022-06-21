package com.cqu.store.mapper;

import com.cqu.store.entity.Cart;
import com.cqu.store.vo.CartVO;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;

/** �����ﳵ���ݵĳ־ò�ӿ� */
public interface CartMapper {
    /**
     * ���빺�ﳵ����
     * @param cart ���ﳵ����
     * @return ��Ӱ�������
     */
    Integer insert(Cart cart);
    /**
     * �޸Ĺ��ﳵ��������Ʒ������
     * @param cid ���ﳵ���ݵ�id
     * @param num �µ�����
     * @param modifiedUser �޸�ִ����
     * @param modifiedTime �޸�ʱ��
     * @return ��Ӱ�������
     */
    Integer updateNumByCid(
            @Param("cid") Integer cid,
            @Param("num") Integer num,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);
    /**
     * �����û�id����Ʒid��ѯ���ﳵ�е�����
     * @param uid �û�id
     * @param pid ��Ʒid
     * @return ƥ��Ĺ��ﳵ���ݣ�������û��Ĺ��ﳵ�в�û�и���Ʒ���򷵻�null
     */
    Cart findByUidAndPid(
            @Param("uid") Integer uid,
            @Param("pid") Integer pid);

    /**
     * �����û�id��ѯ���е�cartʵ��
     * @param uid
     * @return
     */
    List<CartVO> findVOByUid(Integer uid);

    /**
     * ���ݹ��ﳵ����id��ѯ���ﳵ��������
     * @param cid ���ﳵ����id
     * @return ƥ��Ĺ��ﳵ�������飬���û��ƥ��������򷵻�null
     */
    Cart findByCid(Integer cid);

    /**
     * �������ɸ����ﳵ����id��ѯ������б�
     * @param cids ���ɸ����ﳵ����id
     * @return ƥ��Ĺ��ﳵ����������б�
     */
    List<CartVO> findVOByCids(Integer[] cids);

}