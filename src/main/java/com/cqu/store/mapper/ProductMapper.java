package com.cqu.store.mapper;
import com.cqu.store.entity.Product;

import java.util.List;

/** ������Ʒ���ݵĳ־ò�ӿ� */
public interface ProductMapper {
    /**
     * ��ѯ������Ʒ��ǰ����
     * @return ������Ʒǰ�����ļ���
     */
    List<Product> findHotList();

    /**
     * ������Ʒid��ѯ��Ʒ����
     * @param id ��Ʒid
     * @return ƥ�����Ʒ���飬���û��ƥ��������򷵻�null
     */
    Product findById(Integer id);
}
