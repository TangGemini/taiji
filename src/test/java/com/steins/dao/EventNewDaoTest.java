package com.steins.dao;

import com.steins.BaseTest;
import com.steins.entity.Event;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tyq
 */

public class EventNewDaoTest extends BaseTest {
    @Autowired
    private EventNewDao eventNewDao;

    @Test
    public void insertEvent() throws Exception {
       for (int i = 0;i<20;i++){
           Event event = new Event();
           event.setFirstLevel("武术"+i);
           event.setSecondLevel("太极拳"+i);
           event.setThirdLevel("器械"+i);
           event.setEventName("杨氏太极拳"+i);
           int num = eventNewDao.insertEvent(event);
       }
       System.out.println("数据生成完毕");
    }

    @Test
    public void deleteEvent() throws Exception{
        Event event = new Event();
        event.setEventName("杨氏太极拳1");

        eventNewDao.deleteEvent(event);
        System.out.println("删除成功");
    }

    @Test
    public void queryEvent() throws Exception{
        eventNewDao.queryEvent();
        List<Event> list = new ArrayList<Event>();
        for (Event event:list){
            System.out.println(event);
        }
    }

    @Test
    public void updateEvent() throws Exception{
        Event event = new Event();
        event.setFirstLevel("武术");
        event.setTransport("哈哈");

        eventNewDao.updateEvent(event);
        System.out.println("更新成功");
    }

}