package com.springboot.service.impl;

import com.springboot.domain.LostAndFound;
import com.springboot.mapper.LostAndFoundMapper;
import com.springboot.service.LostAndFoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 会飞的大野鸡
 * @create 2020/4/26
 * TODO:
 */

@Service
public class LostAndFoundServiceImpl implements LostAndFoundService {
    @Autowired
    private LostAndFoundMapper lostAndFoundMapper;

    public String insertLostAndFound(LostAndFound lostAndFound){
       return lostAndFoundMapper.insertLostAndFound(lostAndFound) == 1 ? "succeed" : "fail";
    }

    public String updateSome(int choice , String uuid){
        if (choice == 1){
            return lostAndFoundMapper.updateDone(uuid) == 1 ? "succeed" : "fail";
        }
        if (choice == 2){
            return lostAndFoundMapper.updateThumbUp(uuid) == 1 ? "succeed" : "fail";
        }
        if (choice == 3){
            return lostAndFoundMapper.updateCollect(uuid) == 1 ? "succeed" : "fail";
        }
        if (choice == 4){
            return lostAndFoundMapper.updateComment(uuid) == 1 ? "succeed" : "fail";
        }
        return null;
    }

}
