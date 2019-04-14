package com.steins.web.admin;

import com.steins.entity.Event;
import com.steins.service.EventNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: tyq
 */

@Controller
@RequestMapping("/eventnew")
public class EventNewController {
    @Autowired
    private EventNewService eventNewService;

    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Map<String,Object> add(@RequestParam("first") String first,
                                  @RequestParam("second") String second,
                                  @RequestParam("third") String third,
                                  @RequestParam("name") String name){
        Event event = new Event();
        event.setFirstLevel(first);
        event.setSecondLevel(second);
        event.setThirdLevel(third);
        event.setEventName(name);

        eventNewService.addEvent(event);

        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",true);
        return modelMap;
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> delete(@RequestParam("del") String del,
                                     @RequestParam("level") int level){
        Event event = new Event();

        switch (level){
            case 1 :
                event.setFirstLevel(del);
                break;
            case 2 :
                event.setSecondLevel(del);
                break;
            case 3 :
                event.setThirdLevel(del);
                break;
            case 4 :
                event.setEventName(del);
                break;
            default:
                Map<String,Object> modelMap = new HashMap<String, Object>();
                modelMap.put("fail",false);
                return modelMap;
        }

        eventNewService.deleteEvent(event);

        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",true);
        return modelMap;
    }

    @ResponseBody
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public Map<String,Object> query(){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<Event> list = new ArrayList<Event>();
        try{
            list = eventNewService.getEventList();
            modelMap.put("rows",list);
            modelMap.put("sucess",true);
            modelMap.put("total",list.size());

        }catch (Exception ex){
            ex.printStackTrace();
            modelMap.put("errMsg", ex.toString());
        }
        return modelMap;
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map<String,Object> update(@RequestParam("upb") String upb,
                                     @RequestParam("upa") String upa,
                                     @RequestParam("level") int level){
        Event event = new Event();
        event.setTransport(upa);
        switch (level){
            case 1 :
                event.setFirstLevel(upb);
                break;
            case 2 :
                event.setSecondLevel(upb);
                break;
            case 3 :
                event.setThirdLevel(upb);
                break;
            case 4 :
                event.setEventName(upb);
                break;
            default:
                Map<String,Object> modelMap = new HashMap<String, Object>();
                modelMap.put("fail",false);
                return modelMap;
        }

        eventNewService.updateEvent(event);

        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",true);
        return modelMap;
    }

}
