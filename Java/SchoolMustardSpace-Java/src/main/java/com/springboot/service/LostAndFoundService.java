package com.springboot.service;

import com.springboot.domain.LostAndFound;

import java.util.List;

/**
 * @author 会飞的大野鸡
 * @create 2020/4/26
 * TODO:
 */

public interface LostAndFoundService {
    String insertLostAndFound(LostAndFound lostAndFound);

    String updateSome(int choice , String id);

    String deleteById(String id);

    List<LostAndFound> selectAll();

    LostAndFound selectByReason(int choice , String id , int userId);
}
