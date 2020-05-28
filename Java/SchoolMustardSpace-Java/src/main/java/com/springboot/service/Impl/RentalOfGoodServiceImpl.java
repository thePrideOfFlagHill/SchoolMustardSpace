package com.springboot.service.Impl;

import com.springboot.constant.Constant;
import com.springboot.domain.RentalOfGood;
import com.springboot.mapper.RentalOfGoodMapper;
import com.springboot.service.RentalOfGoodService;
import com.springboot.utils.datetool.DateResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 会飞的大野鸡
 * @create 2020/4/26
 * @description:物品租赁impl层
 * TODO:
 */

@Service
public class RentalOfGoodServiceImpl implements RentalOfGoodService {
    @Autowired
    private RentalOfGoodMapper rentalOfGoodMapper;

    public String insertRentalOfGood(RentalOfGood rentalOfGood){
        return rentalOfGoodMapper.insertInfo(rentalOfGood) == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
    }

    public String insertTime(int c , String id){
        String time = new DateResult().getCurrentTime();
        if (c == 1)
            return rentalOfGoodMapper.insertStartTime(time , id) == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
        if (c == 2)
            return rentalOfGoodMapper.insertEndTime(time , id) == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
        return null;
    }

    public String updateSome(int choice , String id){
        if (choice == 1){
            return rentalOfGoodMapper.updateDone(id) == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
        }
        if (choice == 2){
            return rentalOfGoodMapper.updateThumbUp(id) == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
        }
        if (choice == 3){
            return rentalOfGoodMapper.updateCollect(id) == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
        }
        if (choice == 4){
            return rentalOfGoodMapper.updateComment(id) == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
        }
        return null;
    }

    public String deleteById(String id){
        return rentalOfGoodMapper.deleteById(id) == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
    }

    public List<RentalOfGood> selectList(int choice , int userId){
        if (choice == 1) {
            return rentalOfGoodMapper.getAllRental();
        }else
            return rentalOfGoodMapper.getRentalByUserId(userId);

    }

    public RentalOfGood selectOne(String id){
        return rentalOfGoodMapper.getRentalById(id);
    }

    public List<RentalOfGood> selectLike(int choice , String text){

        if (choice == 1)
            return rentalOfGoodMapper.getLikeTitle(text);

        if (choice == 2)
            return rentalOfGoodMapper.getLikeContent(text);

        if (choice == 3)
            return rentalOfGoodMapper.getLikeLabel(text);

        return null;
    }

    @Override
    public int updateImg(@Param("image") String image, @Param("id") String id){

        int temp = this.rentalOfGoodMapper.updateImg(image,id);

        return temp;
    }
}
