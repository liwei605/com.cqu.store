package com.cqu.store.service.impl;

import com.cqu.store.entity.History;
import com.cqu.store.mapper.HistoryMapper;
import com.cqu.store.service.IHistoryService;
import com.cqu.store.service.ex.AccessDeniedException;
import com.cqu.store.service.ex.DeleteException;
import com.cqu.store.service.ex.HistoryNotFound;
import com.cqu.store.service.ex.InsertException;
import com.cqu.store.vo.HistoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HistoryServiceImpl implements IHistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public void insertHistory(Integer uid,Integer pid,String username)
    {
        Integer rows=0;
        Date date=new Date();
        History result=new History();
        result.setPid(pid);
        result.setUid(uid);
        result.setCreatedTime(date);
        result.setModifiedTime(date);
        result.setCreatedUser(username);
        result.setModifiedUser(username);
        rows=historyMapper.insertHistory(result);
        if (rows!=1)
        {
            throw new InsertException("����㼣��¼ʧ��");
        }
    }

    @Override
    public List<HistoryVO> findByUid(Integer uid) {
        return historyMapper.findByUid(uid);
    }

    @Override
    public void deleteHistory(Integer hid, Integer uid) {
        Integer rows=0;
        Date date=new Date();
        //��ѯ�Ƿ��ղ��Ѵ���
        History result=historyMapper.findByHid(hid);
        if (result==null)
        {
            throw  new HistoryNotFound("δ�ҵ��������¼");
        }
        else
        {
            if(uid.equals(result.getUid())==false)
            {
                throw  new AccessDeniedException("�Ƿ�����");
            }
            rows=historyMapper.deleteHistory(hid);
            if(rows!=1)
            {
                throw  new DeleteException("ɾ�������¼ʧ�ܣ�����ϵ����Ա");
            }
        }
    }

    @Override
    public void deleteAllHistory(Integer uid) {
        List<HistoryVO> list=historyMapper.findByUid(uid);
        Integer hid=0;
        Integer rows=0;
        for(int i=0;i<list.size();i++)
        {
            hid=list.get(i).getHid();
            rows=historyMapper.deleteHistory(hid);
            if(rows!=1)
            {
                throw  new DeleteException("ɾ�������¼ʧ�ܣ�����ϵ����Ա");
            }
        }
    }
}
