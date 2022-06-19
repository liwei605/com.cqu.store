package com.cqu.store.mapper;

import com.cqu.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest


public class UserMapperTests {


    //��������ȼ����������ô��޷��Զ�װ����»��߱���
    @Autowired
    private UserMapper userMapper;

    //�û��������
    @Test
    public void insert_user()
    {
        User user =new User();
        user.setUsername("tim");
        user.setPassword("123");
        Integer flag =userMapper.insert(user);
        System.out.println(flag);
    }

    //�û���ѯ����ͨ��ID����
    @Test
    public void select_user()
    {
        User user =userMapper.findByUid(2);
        System.out.println(user);
    }

    @Test
    //ͨ���û�ID��������
    public void updatePasswordByUid()
    {
        userMapper.updatePasswordByUid(1,"654321","admin change",new Date());
    }
    @Test
    //ͨ���û�ID��ѯ�û�
    public void findByUid()
    {
        User user=  userMapper.findByUid(1);
        System.out.println(user);
    }

    @Test
    //ͨ���û�ID��ѯ�û�
    public void updateInfoByid()
    {
        User user=new User();
        user.setUid(10);
        user.setGender(1);
        user.setPhone("17843939721");
        user.setEmail("2499280864@qq.com");

        userMapper.updateInfoByUid(user);

    }

    @Test
    public void updateAvatarByUid()
    {
        //ͷ����Ϣ
        userMapper.updateAvatarByUid(10,"/index/user.png","liwie1",new Date());
    }

}
