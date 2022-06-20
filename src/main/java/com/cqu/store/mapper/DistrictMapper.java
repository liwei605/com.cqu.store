package com.cqu.store.mapper;

import com.cqu.store.entity.District;

import java.util.List;


/**
 *  ʡ�����б��ѯ�ӿ�
 * @Author supreme
 * @Date 2022/6/20 15:50
 */

public interface DistrictMapper {
    /**
     *  ���ݸ�code ��ѯ������Ϣ
     * @param parent            ������
     * @return List<District>   ĳ�������µ�ȫ�������б�
     */

    List<District> findByParent(String parent);
}
