package com.springboot.mapper;

import com.springboot.domain.LostAndFound;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 会飞的大野鸡
 * @create 2020/4/26
 * TODO:
 */

@Mapper
public interface LostAndFoundMapper {
    //=================================== 增 ======================================
    //    插入失物招领的信息
    @Insert("insert into lost_and_found(id , user_id , title , content , image , label , location , is_done , time , " +
            "is_lost , thumb_up , collect , `comment`) VALUES" +
            "(#{id} , #{userId} , #{title} , #{content} , #{image} , #{label} , #{location} , #{isDone} , #{time} , " +
            "#{isLost} , #{thumbUp} , #{collect} , #{comment})")
    public int insertLostAndFound(LostAndFound lostAndFound);
    //=================================== 增 ======================================


    //=================================== 改 ======================================
    //    更新图片信息
    @Update("update lost_and_found set image = #{image} where id = #{id}")
    public int updateImg(@Param("image") String image , @Param("id") String id);

    //    用户点赞
    @Update("update lost_and_found set thumb_up + 1 where id = #{id}")
    public int updateThumbUp(@Param("id")String id);

    //    用户收藏
    @Update("update lost_and_found set collect + 1 where id = #{id}")
    public int updateCollect(@Param("id")String id);

    //    用户评论
    @Update("update lost_and_found set comment + 1 where id = #{id}")
    public int updateComment(@Param("id")String id);

    //    更新完成情况
    @Update("update lost_and_found set is_done = 1 where id = #{id}")
    public int updateDone(@Param("id") String id);

    //    编辑文章（标题，内容，图片，标签，地址)

    //=================================== 改 ======================================


    //=================================== 查 ======================================
    @Select("select * from lost_and_found")
    List<LostAndFound> getAllLostAndFound();
    //=================================== 查 ======================================

    //=================================== 删 ======================================
    @Delete("delete from lost_and_found where id = #{id}")
    public int deleteById(@Param("id") int id);
    //=================================== 删 ======================================
}
