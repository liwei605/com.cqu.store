package com.cqu.store.service.impl;

import com.cqu.store.entity.Favorite;
import com.cqu.store.mapper.FavoriteMapper;
import com.cqu.store.service.IFavoriteService;
import com.cqu.store.service.ex.AccessDeniedException;
import com.cqu.store.service.ex.DeleteException;
import com.cqu.store.service.ex.FavoriteNotFoundException;
import com.cqu.store.service.ex.InsertException;
import com.cqu.store.vo.FavoriteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class FavoriteServiceImpl implements IFavoriteService {
    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public  void insertFavorite(Integer uid,Integer pid,String username)
    {
        Integer rows=0;
        Date date=new Date();
        //��ѯ�Ƿ��ղ��Ѵ���
        Favorite result=favoriteMapper.findByUidAndPid(uid,pid);
        //����������ӵ��ղؼ�
        if(result==null)
        {
            result=new Favorite();
            result.setPid(pid);
            result.setUid(uid);
            result.setCreatedTime(date);
            result.setModifiedTime(date);
            result.setCreatedUser(username);
            result.setModifiedUser(username);
            rows=favoriteMapper.insertFavorite(result);
            if (rows!=1)
            {
                throw new InsertException("�ղ�ʧ��");
            }
        }else {
            //�Ѿ����ڲ���Ҫ���ղ�
            throw new InsertException("���ղ�");
        }

    }

    @Override
    public  List<FavoriteVO> findByUid(Integer uid)
    {
        return favoriteMapper.findByUid(uid);
    }

    @Override
    public  void deleteFavorite(Integer fid,Integer uid)
    {
        Integer rows=0;
        Date date=new Date();
        //��ѯ�Ƿ��ղ��Ѵ���
        Favorite result=favoriteMapper.findByFid(fid);
        if (result==null)
        {
            throw  new FavoriteNotFoundException("��δ�ղظ���Ʒ��ȡ���ղ�ʧ��");
        }
        else
        {
            if(uid.equals(result.getUid())==false)
            {
                throw  new AccessDeniedException("�Ƿ�����");
            }
            rows=favoriteMapper.deleteFavorite(fid);
            if(rows!=1)
            {
                throw  new DeleteException("ȡ���ղ�ʧ�ܣ�����ϵ����Ա");
            }
        }
    }




}
