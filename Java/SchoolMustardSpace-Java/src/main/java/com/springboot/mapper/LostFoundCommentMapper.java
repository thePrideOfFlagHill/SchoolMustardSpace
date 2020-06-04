package com.springboot.mapper;

import com.springboot.domain.Comment;
//import com.springboot.domain.LostFoundComment;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * LostFoundCommentMapper
 * TODO
 * @description LostFoundCommentMapper
 * @author 221701412_theTuring  会飞的大野鸡
 * @version v 1.0.0
 * @since 2020.5.1
 */
@Mapper
public interface LostFoundCommentMapper {

    //查询全部
    @Select("select * from lost_and_found_comment order by publish_time desc")
    List<Comment> getAllLostFoundComment();

    //根据条目id查询具体任务评论
    @Select("SELECT * FROM lost_and_found_comment WHERE id =#{id}")
    Comment queryLostFoundCommentById(String id);

    //按上传者的owner_id查询具体任务评论
    @Select("SELECT * FROM lost_and_found_comment WHERE user_id =#{user_id} order by publish_time desc")
    List<Comment> queryLostFoundCommentByUserId(String user_id);

    //按任务表的table_id查询具体任务评论
    @Select("SELECT * FROM lost_and_found_comment WHERE table_id =#{table_id} order by publish_time desc")
    List<Comment> queryLostFoundCommentByTableId(String table_id);

    //发布插入任务评论
    @Insert("INSERT INTO lost_and_found_comment (id, user_id, content, publish_time, table_id, thumb_up, comment) "
            + "VALUES (#{id}, #{user_id}, #{content}, #{publish_time}, #{table_id}, #{thumb_up}, #{comment})")
    int insertLostFoundComment(Comment lostFoundComment);

    //更新任务评论内容
    @Update("UPDATE lost_and_found_comment SET `content`=#{content} WHERE id=#{id}")
    int updateLostFoundCommentContent(@Param("content") String content, @Param("id") String id);

    //更新任务 点赞数+1
    @Update("UPDATE lost_and_found_comment SET thumb_up = thumb_up + 1 WHERE id=#{id}")
    int updateLostFoundCommentThumb(String id);

    //更新任务 评论数+1
    @Update("UPDATE lost_and_found_comment SET comment = comment + 1 WHERE id=#{id}")
    int updateLostFoundCommentComment(String id);

    //删除任务
    @Delete("delete from lost_and_found_comment where id = #{id}")
    int deleteLostFoundComment(String id);


}
    