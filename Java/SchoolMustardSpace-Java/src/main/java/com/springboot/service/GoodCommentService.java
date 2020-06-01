package com.springboot.service;

//import com.springboot.domain.GoodComment;
import com.springboot.domain.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * GoodCommentService
 * TODO
 * @description 数据服务层 GoodCommentService
 * @author 221701412_theTuring  会飞的大野鸡
 * @version v 1.0.0
 * @since 2020.5.1
 */
public interface GoodCommentService {

    //List<Comment> getAllGoodComment();

    Comment queryGoodCommentById(String id);

    //List<Comment> queryGoodCommentByUserId(String user_id);

    //List<Comment> queryGoodCommentByTableId(String table_id);

    List<Comment> select(int choice, String id);

    int insertGoodComment(Comment goodComment);

    //int updateGoodCommentContent(@Param("content") String content, @Param("id") String id);

    //int updateGoodCommentThumb(String id);

    //int updateGoodCommentComment(String id);

    int update(int choice, @Param("content") String content, @Param("id") String id);

    int deleteGoodComment(String id);

}
