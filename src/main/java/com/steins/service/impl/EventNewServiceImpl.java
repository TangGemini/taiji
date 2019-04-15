package com.steins.service.impl;

import com.steins.dao.EventNewDao;
import com.steins.entity.Event;
import com.steins.service.EventNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: tyq
 */

@Service
public class EventNewServiceImpl implements EventNewService {
    @Autowired
    private EventNewDao eventNewDao;

    @Override
    public void addEvent(Event event){
        eventNewDao.insertEvent(event);
    }

    @Override
    public void deleteEvent(Event event){
        eventNewDao.deleteEvent(event);
    }

    @Override
    public List<Event> getEventList(){
        List<Event> eventList = null;
        eventList = eventNewDao.queryEvent();
        return eventList;
    }

    @Override
    public void updateEvent(Event event){
        eventNewDao.updateEvent(event);
    }
}
