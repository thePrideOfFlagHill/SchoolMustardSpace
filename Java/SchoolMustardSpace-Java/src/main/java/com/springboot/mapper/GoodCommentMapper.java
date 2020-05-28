package com.springboot.mapper;

import com.springboot.domain.Comment;
//import com.springboot.domain.GoodComment;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * GoodCommentMapper
 * TODO
 * @description GoodCommentMapper
 * @author 221701412_theTuring 会飞的大野鸡
 * @version v 1.0.0
 * @since 2020.5.1
 */
@Mapper
public interface GoodCommentMapper {

    //查询全部
    @Select("select * from rental_of_goods_comment")
    List<Comment> getAllGoodComment();

    //根据条目id查询具体任务评论
    @Select("SELECT * FROM rental_of_goods_comment WHERE id =#{id}")
    Comment queryGoodCommentById(String id);

    //按上传者的owner_id查询具体任务评论
    @Select("SELECT * FROM rental_of_goods_comment WHERE user_id =#{user_id}")
    List<Comment> queryGoodCommentByUserId(String user_id);

    //按任务表的table_id查询具体任务评论
    @Select("SELECT * FROM rental_of_goods_comment WHERE table_id =#{table_id}")
    List<Comment> queryGoodCommentByTableId(String table_id);

    //发布插入任务评论
    @Insert("INSERT INTO rental_of_goods_comment (id, user_id, content, publish_time, table_id, thumb_up, comment) "
            + "VALUES (#{id}, #{user_id}, #{content}, #{publish_time}, #{table_id}, #{thumb_up}, #{comment})")
    int insertGoodComment(Comment goodComment);

    //更新任务评论内容
    @Update("UPDATE rental_of_goods_comment SET `content`=#{content} WHERE id=#{id}")
    int updateGoodCommentContent(@Param("content") String content, @Param("id") String id);

    //更新任务 点赞数+1
    @Update("UPDATE rental_of_goods_comment SET thumb_up = thumb_up + 1 WHERE id=#{id}")
    int updateGoodCommentThumb(String id);

    //更新任务 评论数+1
    @Update("UPDATE rental_of_goods_comment SET comment = comment + 1 WHERE id=#{id}")
    int updateGoodCommentComment(String id);

    //删除任务
    @Delete("delete from rental_of_goods_comment where id = #{id}")
    int deleteGoodComment(String id);


}
    