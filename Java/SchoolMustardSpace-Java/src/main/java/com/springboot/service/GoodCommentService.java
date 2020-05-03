package com.springboot.service;

import com.springboot.domain.GoodComment;
import com.springboot.domain.TaskComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * GoodCommentService
 * TODO
 * @description 数据服务层 GoodCommentService
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.5.1
 */
public interface GoodCommentService {

    List<GoodComment> getAllGoodComment();

    GoodComment queryGoodCommentById(String id);

    List<GoodComment> queryGoodCommentByUserId(String user_id);

    List<GoodComment> queryGoodCommentByTableId(String table_id);

    int insertGoodComment(GoodComment goodComment);

    int updateGoodCommentContent(@Param("content") String content, @Param("id") String id);

    int updateGoodCommentThumb(String id);

    int updateGoodCommentComment(String id);

    int deleteGoodComment(String id);

}
