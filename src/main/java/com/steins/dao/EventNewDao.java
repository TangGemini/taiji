package com.steins.dao;

import com.steins.entity.Event;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: tyq
 */

@Repository
public interface EventNewDao {
    /**
     * 新建四级项目信息
     *
     * @param event
     * @return
     */
    int insertEvent(Event event);

    /**
     * 删除四级项目信息
     *
     * @param event
     * @return
     */
    int deleteEvent(Event event);

    /**
     * 列出区域列表
     *
     * @return areaList
     */
    List<Event> queryEvent();

    /**
     * 修改四级项目信息
     *
     * @param event
     * @return
     */
    int updateEvent(Event event);

}
