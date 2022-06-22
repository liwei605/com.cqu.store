package com.cqu.store.service;

import com.cqu.store.entity.Favorite;
import com.cqu.store.vo.FavoriteVO;

import java.util.List;

public interface IFavoriteService {

    /**
     * �����Ʒ���ղؼ�
     * @param uid
     * @param pid
     * @param username
     * @return
     */
    void insertFavorite(Integer uid,Integer pid,String username);

    /**
     * ��ѯĳ�û��ղؼ���Ϣ
     * @param uid
     * @return
     */
    List<FavoriteVO> findByUid(Integer uid);

    /**
     * ȡ���ղ�
     * @param fid
     * @return
     */
    void deleteFavorite(Integer fid,Integer uid);


}
