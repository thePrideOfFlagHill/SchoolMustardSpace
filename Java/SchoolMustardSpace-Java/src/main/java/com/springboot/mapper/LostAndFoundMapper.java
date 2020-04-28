package com.springboot.mapper;

import com.springboot.domain.LostAndFound;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 会飞的大野鸡
 * @create 2020/4/26
 * TODO:
 */

@Mapper
public interface LostAndFoundMapper {
    //=================================== 插入信息 ======================================
    //    插入失物招领的信息
    @Insert("insert into lost_and_found(id , user_id , title , content , image , label , location , is_done , time , " +
            "is_lost , thumb_up , collect , `comment`) VALUES" +
            "(#{id} , #{userId} , #{title} , #{content} , #{image} , #{label} , #{location} , #{isDone} , #{time} , " +
            "#{isLost} , #{thumbUp} , #{collect} , #{comment})")
    public void insertLostAndFound(LostAndFound lostAndFound);

    //     插入失物招领的图片信息
    @Insert("insert into lost_and_found(image) values (#{image}) where id = #{id}")
    public void insertImg(@Param("image") String image , @Param("id") String id);
    //=================================== 插入信息 ======================================


    //=================================== 更新信息 ======================================
    //    更新点赞数
    //    更新收藏数
    //    更新评论数
    //    更新完成情况
    //    编辑文章（标题，内容，图片，标签，地址)
    //=================================== 更新信息 ======================================


    //=================================== 搜集信息 ======================================
    //=================================== 搜集信息 ======================================

    //=================================== 删除信息 ======================================
    //=================================== 删除信息 ======================================
}
