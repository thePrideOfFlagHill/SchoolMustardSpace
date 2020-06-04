package com.springboot.mapper;

import com.springboot.domain.RentalOfGood;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 会飞的大野鸡
 * @create 2020/4/26
 * @description:物品租赁dao层
 * TODO:
 */

@Mapper
public interface RentalOfGoodMapper {
    //=================================== 增 ======================================
    @Insert("INSERT into rental_of_goods(id , user_id , title , content , image , label , location , is_done , " +
            "unit_price , start_time , end_time , new_degree , thumb_up , collect , `comment`) VALUES" +
            "(#{id} , #{userId} , #{title} , #{content} , #{image} , #{label} , #{location} , #{isDone} , " +
            "#{unitPrice} , #{startTime} , #{endTime} , #{newDegree} , #{thumbUp} , #{collect} , #{comment})")
    public int insertInfo(RentalOfGood rentalOfGood);
    //=================================== 增 ======================================



    //=================================== 删 ======================================
    @Delete("delete from rental_of_goods where id = #{id}")
    public int deleteById(@Param("id") String id);
    //=================================== 删 ======================================



    //=================================== 改 ======================================
    //    更新图片信息
    @Update("update rental_of_goods set image = #{image} where id = #{id}")
    public int updateImg(@Param("image") String image, @Param("id") String id);
    //    用户点赞
    @Update("update rental_of_goods set thumb_up = thumb_up + 1 where id = #{id}")
    public int updateThumbUp(@Param("id") String id);

    //    用户收藏
    @Update("update rental_of_goods set collect = collect + 1 where id = #{id}")
    public int updateCollect(@Param("id") String id);

    //    用户评论
    @Update("update rental_of_goods set comment = comment + 1 where id = #{id}")
    public int updateComment(@Param("id") String id);

    //    更新完成情况
    @Update("update rental_of_goods set is_done = 1 where id = #{id}")
    public int updateDone(@Param("id") String id);

    @Update("update rental_of_goods set start_time = #{startTime} where id = #{id}")
    public int insertStartTime(@Param("startTime") String time, @Param("id") String id);

    @Insert("update rental_of_goods set end_time = #{endTime} where id = #{id}")
    public int insertEndTime(@Param("endTime") String time, @Param("id") String id);
    //=================================== 改 ======================================



    //=================================== 查 ======================================


    @Select("select * from rental_of_goods order by start_time desc")
    @Results(value = {
            @Result(column = "user_id" , property = "userId"),
            @Result(column = "is_done" , property = "isDone"),
            @Result(column = "unit_price" , property = "unitPrice"),
            @Result(column = "start_time" , property = "startTime"),
            @Result(column = "end_time" , property = "endTime"),
            @Result(column = "new_degree" , property = "newDegree"),
            @Result(column = "thumb_up" , property = "thumbUp"),
    })
    List<RentalOfGood> getAllRental();

    @Select("select * from rental_of_goods where id = #{id}")
    @Results(value = {
            @Result(column = "user_id" , property = "userId"),
            @Result(column = "is_done" , property = "isDone"),
            @Result(column = "unit_price" , property = "unitPrice"),
            @Result(column = "start_time" , property = "startTime"),
            @Result(column = "end_time" , property = "endTime"),
            @Result(column = "new_degree" , property = "newDegree"),
            @Result(column = "thumb_up" , property = "thumbUp"),
    })
    RentalOfGood getRentalById(@Param("id") String id);

    @Select("select * from rental_of_goods where user_id = #{userId} order by start_time desc")
    @Results(value = {
            @Result(column = "user_id" , property = "userId"),
            @Result(column = "is_done" , property = "isDone"),
            @Result(column = "unit_price" , property = "unitPrice"),
            @Result(column = "start_time" , property = "startTime"),
            @Result(column = "end_time" , property = "endTime"),
            @Result(column = "new_degree" , property = "newDegree"),
            @Result(column = "thumb_up" , property = "thumbUp"),
    })
    List<RentalOfGood> getRentalByUserId(@Param("userId") int userId);

    @Select("select * from rental_of_goods where content like concat('%' , #{text} , '%') order by start_time desc")
    @Results(value = {
            @Result(column = "user_id" , property = "userId"),
            @Result(column = "is_done" , property = "isDone"),
            @Result(column = "unit_price" , property = "unitPrice"),
            @Result(column = "start_time" , property = "startTime"),
            @Result(column = "end_time" , property = "endTime"),
            @Result(column = "new_degree" , property = "newDegree"),
            @Result(column = "thumb_up" , property = "thumbUp"),
    })
    List<RentalOfGood> getLikeContent(@Param("text") String text);

    @Select("select * from rental_of_goods where title like concat('%' , #{text} , '%') order by start_time desc")
    @Results(value = {
            @Result(column = "user_id" , property = "userId"),
            @Result(column = "is_done" , property = "isDone"),
            @Result(column = "unit_price" , property = "unitPrice"),
            @Result(column = "start_time" , property = "startTime"),
            @Result(column = "end_time" , property = "endTime"),
            @Result(column = "new_degree" , property = "newDegree"),
            @Result(column = "thumb_up" , property = "thumbUp"),
    })
    List<RentalOfGood> getLikeTitle(@Param("text") String text);

    @Select("select * from rental_of_goods where label like concat('%' , #{text} , '%') order by start_time desc")
    @Results(value = {
            @Result(column = "user_id" , property = "userId"),
            @Result(column = "is_done" , property = "isDone"),
            @Result(column = "unit_price" , property = "unitPrice"),
            @Result(column = "start_time" , property = "startTime"),
            @Result(column = "end_time" , property = "endTime"),
            @Result(column = "new_degree" , property = "newDegree"),
            @Result(column = "thumb_up" , property = "thumbUp"),
    })
    List<RentalOfGood> getLikeLabel(@Param("text") String text);
    //=================================== 查 ======================================
}
