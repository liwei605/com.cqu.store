package com.cqu.store.service.impl;
import com.cqu.store.entity.Cart;
import com.cqu.store.entity.Product;
import com.cqu.store.mapper.CartMapper;
import com.cqu.store.service.ICartService;
import com.cqu.store.service.IProductService;
import com.cqu.store.service.ex.AccessDeniedException;
import com.cqu.store.service.ex.CartNotFoundException;
import com.cqu.store.service.ex.InsertException;
import com.cqu.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/** ???????????????????? */
@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private IProductService productService;
    @Override
    public void addToCart(Integer uid, Integer pid, Integer amount, String username)
    {
        // ���ݲ���pid��uid��ѯ���ﳵ�е�����
        Cart result = cartMapper.findByUidAndPid(uid, pid);
        //Integer cid = result.getCid();
        Date now = new Date();
        // �жϲ�ѯ����Ƿ�Ϊnull
        if (result == null) {
            // �ǣ���ʾ���û���δ������Ʒ��ӵ����ﳵ
            // ����Cart����
            Cart cart = new Cart();
            // ��װ���ݣ�uid,pid,amount
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(amount);
            // ����productService.findById(pid)��ѯ��Ʒ���ݣ��õ���Ʒ�۸�
            Product product = productService.findById(pid);
            // ��װ���ݣ�price
            cart.setPrice(product.getPrice());
            // ��װ���ݣ�4����־
            cart.setCreatedUser(username);
            cart.setCreatedTime(now);
            cart.setModifiedUser(username);
            cart.setModifiedTime(now);
            // ����insert(cart)ִ�н����ݲ��뵽���ݱ���
            Integer rows = cartMapper.insert(cart);
            if (rows != 1) {
                throw new InsertException("������Ʒ����ʱ����δ֪��������ϵϵͳ����Ա");
            }
        } else {
            // �񣺱�ʾ���û��Ĺ��ﳵ�����и���Ʒ
            // �Ӳ�ѯ����л�ȡ���ﳵ���ݵ�id
            Integer cid = result.getCid();
            // �Ӳ�ѯ�����ȡ��ԭ�����������amount��ӣ��õ��µ�����
            Integer num = result.getNum() + amount;
            // ִ�и�������
            Integer rows = cartMapper.updateNumByCid(cid, num, username, now);
            if (rows != 1) {
                throw new InsertException("�޸���Ʒ����ʱ����δ֪��������ϵϵͳ����Ա");
            }
        }
    }



    @Override
    public List<CartVO> getVOByUid(Integer uid) {
        return cartMapper.findVOByUid(uid);
    }

    @Override
    public Integer addNum(Integer cid, Integer uid, String username) {
        // ����findByCid(cid)���ݲ���cid��ѯ���ﳵ����
        Cart result = cartMapper.findByCid(cid);
        // �жϲ�ѯ����Ƿ�Ϊnull
        if (result == null) {
            // �ǣ��׳�CartNotFoundException
            throw new CartNotFoundException("���Է��ʵĹ��ﳵ���ݲ�����");
        }
        // �жϲ�ѯ����е�uid�����uid�Ƿ�һ��
        if (!result.getUid().equals(uid)) {
            // �ǣ��׳�AccessDeniedException
            throw new AccessDeniedException("�Ƿ�����");
        }
        // ��ѡ�������Ʒ�������Ƿ���ڶ���(��������������)��С�ڶ���(�����ڼ�������)
        // ���ݲ�ѯ����е�ԭ��������1�õ��µ�����num
        Integer num = result.getNum() + 1;
        // ������ǰʱ�������ΪmodifiedTime
        Date now = new Date();
        // ����updateNumByCid(cid, num, modifiedUser, modifiedTime)ִ���޸�����
        Integer rows = cartMapper.updateNumByCid(cid, num, username, now);
        if (rows != 1) {
            throw new InsertException("�޸���Ʒ����ʱ����δ֪��������ϵϵͳ����Ա");
        }
        // �����µ�����
        return num;


    }

    @Override
    public List<CartVO> getVOByCids(Integer uid, Integer[] cids) {
        List<CartVO> list = cartMapper.findVOByCids(cids);
        Iterator<CartVO> it = list.iterator();
        while (it.hasNext()) {
            CartVO cart = it.next();
            if (!cart.getUid().equals(uid)) {
                it.remove();
            }
        }
        return list;
    }


}