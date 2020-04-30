package com.springboot.service;

import com.springboot.domain.LostAndFound;
import com.springboot.domain.RentalOfGood;

import java.util.List;

/**
 * @author 会飞的大野鸡
 * @create 2020/4/26
 * @description:物品租赁service层
 * TODO:
 */

public interface RentalOfGoodService {
    String insertRentalOfGood(RentalOfGood rentalOfGood);

    String updateSome(int choice , String id);

    String deleteById(String id);

    List<RentalOfGood> selectList(int choice , int userId);

    RentalOfGood selectOne(String id);

    List<RentalOfGood> selectLike(int choice , String text);
}
