package com.steins.service;

import com.steins.entity.Event;

import java.util.List;

/**
 * @Author: tyq
 */

public interface EventNewService {
    /**
     * 新建四级项目信息
     *
     * @param event
     * @return
     */
    void addEvent(Event event);

    /**
     * 删除四级项目信息
     *
     * @param event
     * @return
     */
    void deleteEvent(Event event);

    /**
     * 获取区域列表，优先从缓存获取
     *
     * @return
     */
    List<Event> getEventList();

    /**
     * 更新四级项目信息
     *
     * @param event
     * @return
     */
    void updateEvent(Event event);
}
