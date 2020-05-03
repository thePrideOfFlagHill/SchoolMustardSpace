package com.springboot.service;

import com.springboot.domain.GoodComment;
import com.springboot.domain.LostFoundComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * LostFoundCommentService
 * TODO
 * @description 数据服务层 LostFoundCommentService
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.5.1
 */
public interface LostFoundCommentService {

    List<LostFoundComment> getAllLostFoundComment();

    LostFoundComment queryLostFoundCommentById(String id);

    List<LostFoundComment> queryLostFoundCommentByUserId(String user_id);

    List<LostFoundComment> queryLostFoundCommentByTableId(String table_id);

    int insertLostFoundComment(LostFoundComment lostFoundComment);

    int updateLostFoundCommentContent(@Param("content") String content, @Param("id") String id);

    int updateLostFoundCommentThumb(String id);

    int updateLostFoundCommentComment(String id);

    int deleteLostFoundComment(String id);

}
