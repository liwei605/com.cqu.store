package com.cqu.store.mapper;

import com.cqu.store.entity.History;
import com.cqu.store.vo.HistoryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HistoryMapper {

    /**
     * �����û������¼id
     * @param uid
     * @return
     */
    List<HistoryVO> findByUid(Integer uid);

    /**
     * ���������¼
     * @param history
     * @return
     */
    Integer insertHistory(History history);


    /**
     * ɾ�������¼
     * @param hid
     * @return
     */
    Integer deleteHistory(Integer hid);

    /**
     * ���������¼
     * @param uid
     * @param pid
     * @return
     */
    List<History> findByUidAndPid(@Param("uid") Integer uid, @Param("pid")Integer pid);

    /**
     * ���������¼
     * @param hid
     * @return
     */
    History findByHid(@Param("hid")Integer hid);


}
