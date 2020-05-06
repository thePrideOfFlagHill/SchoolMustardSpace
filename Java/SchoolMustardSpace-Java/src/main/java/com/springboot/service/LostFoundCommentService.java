package com.springboot.service;

import com.springboot.domain.Comment;
//import com.springboot.domain.LostFoundComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * LostFoundCommentService
 * TODO
 * @description 数据服务层 LostFoundCommentService
 * @author 221701412_theTuring  会飞的大野鸡
 * @version v 1.0.0
 * @since 2020.5.1
 */
public interface LostFoundCommentService {

    List<Comment> getAllLostFoundComment();

    Comment queryLostFoundCommentById(String id);

    List<Comment> queryLostFoundCommentByUserId(String user_id);

    List<Comment> queryLostFoundCommentByTableId(String table_id);

    int insertLostFoundComment(Comment lostFoundComment);

    int updateLostFoundCommentContent(@Param("content") String content, @Param("id") String id);

    int updateLostFoundCommentThumb(String id);

    int updateLostFoundCommentComment(String id);

    int deleteLostFoundComment(String id);

}
