package com.cqu.store.service.impl;

import com.cqu.store.entity.District;
import com.cqu.store.mapper.DistrictMapper;
import com.cqu.store.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DistrictService �ӿ�ʵ����
 * @Author supreme
 * @Date 2022/6/20 16:08
 */


@Service
public class DistrictServiceImpl implements IDistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getByParent(String parent) {
        List<District> list = districtMapper.findByParent(parent);
        for(District d:list){
            d.setId(null);
            d.setParent(null); //���⴫����Ч���ݣ���Ϊnull����ʡ��������ʾЧ��
        }
        return list;
    }
}
