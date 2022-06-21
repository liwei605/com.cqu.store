package com.cqu.store.controller;

import com.cqu.store.service.ICartService;
import com.cqu.store.util.JsonResult;
import com.cqu.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("carts")
public class CartController extends BaseController {
    @Autowired
    private ICartService cartService;
    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession
            session) {
        // ��Session�л�ȡuid��username
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        // ����ҵ�����ִ����ӵ����ﳵ
        cartService.addToCart(uid, pid, amount, username);
        // ���سɹ�
        return new JsonResult<Void>(OK);
    }

    @GetMapping({"", "/"})
    public JsonResult<List<CartVO>> getVOByUid(HttpSession session) {
        // ��Session�л�ȡuid
        Integer uid = getuidFromSession(session);
        // ����ҵ�����ִ�в�ѯ����
        List<CartVO> data = cartService.getVOByUid(uid);
        // ���سɹ�������
        return new JsonResult<List<CartVO>>(OK, data);
    }

    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid") Integer cid, HttpSession
            session) {
        // ��Session�л�ȡuid��username
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        // ����ҵ�����ִ����������
        Integer data = cartService.addNum(cid, uid, username);
        // ���سɹ�
        return new JsonResult<Integer>(OK, data);
    }

    @GetMapping("list")
    public JsonResult<List<CartVO>> getVOByCids(Integer[] cids, HttpSession session) {
        // ��Session�л�ȡuid
        Integer uid = getuidFromSession(session);
        // ����ҵ�����ִ�в�ѯ����
        List<CartVO> data = cartService.getVOByCids(uid, cids);
        // ���سɹ�������
        return new JsonResult<>(OK, data);
    }
}

