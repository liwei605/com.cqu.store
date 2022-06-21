package com.cqu.store.service.impl;

import com.cqu.store.entity.Address;
import com.cqu.store.mapper.AddressMapper;
import com.cqu.store.service.IAddressService;
import com.cqu.store.service.ex.AddressCountLimitException;
import com.cqu.store.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * �ջ���ַʵ����
 * @Author supreme
 * @Date 2022/6/20 11:16
 */
@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Value("${user.address.max-count}")
    private Integer maxCount;

    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        //1���ж��Ƿ�ﵽ��ַ��������
        Integer count = addressMapper.countByUid(uid);

        if(count>=maxCount){
            throw  new AddressCountLimitException("�ջ��ַ������������");
        }

        //2����ȫ���ݡ���װ����
        address.setUid(uid);
        Integer isDefault = count==0?1:0;
        address.setIsDefault(isDefault);

        address.setCreatedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedUser(username);
        address.setModifiedTime(new Date());



        //3�������ջ���ַ
        Integer rows = addressMapper.insert(address);
        if(rows!=1){
            throw new InsertException("�����û��ջ���ַʱ����δ֪�쳣");
        }
    }
}
