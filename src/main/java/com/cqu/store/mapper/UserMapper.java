package com.cqu.store.mapper;

import com.cqu.store.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * �����û����ݲ����ĳ־ò�ӿ�
 */
public interface UserMapper {
    /**
     * �����û�����
     *
     * @param user �û�����
     * @return ��Ӱ�������
     */
    Integer insert(User user);


    /**
     * �����û�����ѯ�û�����
     * @Author supreme
     * @Date 2022/6/20 8:41
     * @param username
     * @return User
     */

    User findByUsername(String username);


    /**
     * ����uid�����û�������
     * @Author supreme
     * @Date 2022/6/20 8:42
     * @param uid           �û���id
     * @param password      ������
     * @param modifiedUser  ���ִ����
     * @param modifiedTime  ����޸�ʱ��
     * @return Integer
     */

    Integer updatePasswordByUid(
            @Param("uid") Integer uid,
            @Param("password") String password,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);
    /*
    Integer updatePasswordByUid(
            Integer uid,
            String password,
            String modifiedUser,
            Date modifiedTime); */

    /**
     * �����û�id��ѯ�û�����
     *
     * @param uid �û�id
     * @return ƥ����û����ݣ����û��ƥ����û����ݣ��򷵻�null
     */
    User findByUid(Integer uid);


    /**
     * ����uid�����û�����
     * @Author supreme
     * @Date 2022/6/20 8:44
     * @param user
     * @return Integer ��Ӱ�������
     */

    Integer updateInfoByUid(User user);

    /**
     * ����uid�����û�ͷ��
     * @Author supreme
     * @Date 2022/6/20 8:46
     * @param uid           �û�uid
     * @param avatar        ��ͷ��·��
     * @param modifiedUser  �޸���
     * @param modifiedTime  �޸�ʱ��
     * @return Integer
     */

    Integer updateAvatarByUid(
            @Param("uid") Integer uid,
            @Param("avatar") String avatar,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);
}
