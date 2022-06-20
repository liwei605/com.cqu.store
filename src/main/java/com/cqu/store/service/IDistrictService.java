package com.cqu.store.service;

import com.cqu.store.entity.District;

import java.util.List;

/**
 * ʡ�����б���ϢService��ӿ�
 * @Author supreme
 * @Date 2022/6/20 16:04
 */

public interface IDistrictService {
    /**
     * ���ݸ����Ų�ѯ��������Ϣ
     * @param parent            ������
     * @return List<District>   ��������Ϣ�б�
     */

    List<District> getByParent(String parent);
}
