package com.cqu.store.mapper;

import com.cqu.store.entity.Favorite;
import com.cqu.store.vo.FavoriteVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//�ղؼ�
public interface FavoriteMapper {

    /**
     * ͨ���û�id ���ҹ��ﳵ����
     * @param uid
     * @return
     */
    List<FavoriteVO>  findByUid(Integer uid);

    /**
     * �����ղ�����
     * @param favorite
     * @return
     */
    Integer insertFavorite(Favorite favorite);

    /**
     * ȡ���ղ�
     * @param fid
     * @return
     */
    Integer deleteFavorite(Integer fid);

    /**
     * ����uid��pid�����ղؼ�ʵ��
     * @return
     */
    Favorite findByUidAndPid(@Param("uid") Integer uid,@Param("pid")Integer pid);

    /**
     * �����ղؼ���Ų���
     * @param fid
     * @return
     */
    Favorite findByFid(@Param("fid")Integer fid);
}
