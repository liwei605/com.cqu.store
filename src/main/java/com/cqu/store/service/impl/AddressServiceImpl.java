package com.cqu.store.service.impl;

import com.cqu.store.entity.Address;
import com.cqu.store.mapper.AddressMapper;
import com.cqu.store.service.IAddressService;
import com.cqu.store.service.IDistrictService;
import com.cqu.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * �ջ���ַʵ����
 * @Author supreme
 * @Date 2022/6/20 11:16
 */
@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressMapper addressMapper;

    //������û��ջ���ַ��ҵ���������DistrictService�ӿ�
    @Autowired
    private IDistrictService districtService;

    @Value("${user.address.max-count}")
    private Integer maxCount;

    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        //1���ж��Ƿ�ﵽ��ַ��������
        Integer count = addressMapper.countByUid(uid);

        if(count>=maxCount){
            throw  new AddressCountLimitException("�ջ��ַ������������");
        }
        //2����ȫʡ�����������
        String provinceName =  districtService.getNameByCode(address.getProvinceCode());
        String cityName = districtService.getNameByCode(address.getCityCode());
        String areaName = districtService.getNameByCode(address.getAreaCode());
        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);

        //3����ȫ���ݡ���װ����
        address.setUid(uid);
        Integer isDefault = count==0?1:0;
        address.setIsDefault(isDefault);
        address.setCreatedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedUser(username);
        address.setModifiedTime(new Date());

        //4�������ջ���ַ
        Integer rows = addressMapper.insert(address);
        if(rows!=1){
            throw new InsertException("�����û��ջ���ַʱ����δ֪�쳣");
        }
    }

    @Override
    public List<Address> getByUid(Integer uid) {
        List<Address> list = addressMapper.findByUid(uid);
        for(Address address:list){
//            address.setAid(null);
//            address.setUid(null);
            address.setProvinceCode(null);
            address.setCityCode(null);
            address.setAreaCode(null);
            address.setZip(null);
            address.setTel(null);
            address.setCreatedTime(null);
            address.setCreatedUser(null);
            address.setIsDefault(null);
            address.setModifiedTime(null);
            address.setModifiedUser(null);
        }
        return list;
    }

    @Override
    public void setDefault(Integer aid, Integer uid, String username) {
        Address address = addressMapper.findByAid(aid);
        if(address==null){
            throw new AddressNotFoundException("�ջ���ַ������");
        }
        //��⵱ǰ��ȡ�����ջ���ַ���ݹ���
        if(!address.getUid().equals(uid)){
            throw new AccessDeniedException("�Ƿ����ݷ���");
        }
        //�Ƚ������ջ���ַ����Ϊ��Ĭ��
        Integer rows = addressMapper.updateNoneDefault(uid);
        if(rows<1){
            throw new UpdateException("����Ĭ�ϵ�ַ�����쳣");
        }
        //���û�ѡ�еĵ�ַ����ΪĬ���ջ���ַ
        rows = addressMapper.updateDefaultByAid(aid,username,new Date());
        if(rows!=1){
            throw new UpdateException("����Ĭ�ϵ�ַ�����쳣");
        }
    }

    @Override
    public void deleteAddress(Integer aid, Integer uid, String username) {
        Address result = addressMapper.findByAid(aid);
        if(result==null){
            throw new AddressNotFoundException("�ջ���ַ������");
        }
        //��⵱ǰ��ȡ�����ջ���ַ���ݹ���
        if(!result.getUid().equals(uid)){
            throw new AccessDeniedException("�Ƿ����ݷ���");
        }

        Integer isDefault = result.getIsDefault();

        //����aidɾ���ջ���ַ
        Integer rows = addressMapper.deleteByAid(aid);
        if(rows!=1){
            throw new DeleteException("ɾ�����ݲ���δ֪���쳣");
        }

        Integer count = addressMapper.countByUid(uid);
        if(count==0 || isDefault==0){
            return;
        }

        Address address = addressMapper.findLastModified(uid);
        rows= addressMapper.updateDefaultByAid(address.getAid(),username,new Date());
        if(rows!=1){
            throw new UpdateException("��������ʱ�����쳣");
        }
    }
    @Override
    public Address getByAid(Integer aid, Integer uid) {
        // �����ջ���ַ����id����ѯ�ջ���ַ����
        Address address = addressMapper.findByAid(aid);
        if (address == null) {
            throw new AddressNotFoundException("���Է��ʵ��ջ���ַ���ݲ�����");
        }
        if (!address.getUid().equals(uid)) {
            throw new AccessDeniedException("�Ƿ�����");
        }
        address.setProvinceCode(null);
        address.setCityCode(null);
        address.setAreaCode(null);
        address.setCreatedUser(null);
        address.setCreatedTime(null);
        address.setModifiedUser(null);
        address.setModifiedTime(null);
        return address;
    }
}
