package com.springboot.service.Impl;

import com.springboot.domain.LostAndFound;
import com.springboot.mapper.LostAndFoundMapper;
import com.springboot.service.LostAndFoundService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 会飞的大野鸡
 * @create 2020/4/26
 * @description:失物招领impl层
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

    public String deleteById(String id){
        return lostAndFoundMapper.deleteById(id) == 1 ? "succeed" : "fail";
    }

    public List<LostAndFound> selectList(int choice , int userId){
        if (choice == 1) {
            return lostAndFoundMapper.getAllLostAndFound();
        }else
            return lostAndFoundMapper.getLostAndFoundByUserId(userId);

    }

    public LostAndFound selectOne(String id){
        return lostAndFoundMapper.getLostAndFoundById(id);
    }

    public List<LostAndFound> selectLike(int choice , String text){

        if (choice == 1)
            return lostAndFoundMapper.getLikeTitle(text);

        if (choice == 2)
            return lostAndFoundMapper.getLikeContent(text);

        if (choice == 3)
            return lostAndFoundMapper.getLikeLabel(text);

        return null;
    }

    @Override
    public int updateImg(@Param("image") String image, @Param("id") String id){

        int temp = this.lostAndFoundMapper.updateImg(image,id);

        return temp;
    }
}
