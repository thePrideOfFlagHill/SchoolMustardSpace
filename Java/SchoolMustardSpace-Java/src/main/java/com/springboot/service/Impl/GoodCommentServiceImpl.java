package com.springboot.service.Impl;

import com.springboot.domain.GoodComment;
import com.springboot.mapper.GoodCommentMapper;
import com.springboot.service.GoodCommentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GoodCommentServiceImpl
 * TODO
 * @description GoodCommentServiceImpl 服务实现层
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.5.1
 */
@Service
public class GoodCommentServiceImpl implements GoodCommentService {

    @Autowired
    private GoodCommentMapper goodCommentMapper;

    @Override
    public List<GoodComment> getAllGoodComment() {

        List<GoodComment> list = this.goodCommentMapper.getAllGoodComment();

        return list;

    }

    @Override
    public GoodComment queryGoodCommentById(String id){

        GoodComment goodComment = this.goodCommentMapper.queryGoodCommentById(id);

        return goodComment;
    }

    @Override
    public List<GoodComment> queryGoodCommentByUserId(String user_id){

        List<GoodComment> list = this.goodCommentMapper.queryGoodCommentByUserId(user_id);

        return list;
    }

    @Override
    public List<GoodComment> queryGoodCommentByTableId(String table_id){

        List<GoodComment> list = this.goodCommentMapper.queryGoodCommentByTableId(table_id);

        return list;
    }

    @Override
    public int insertGoodComment(GoodComment goodComment){

        int temp = this.goodCommentMapper.insertGoodComment(goodComment);

        return temp;

    }

    @Override
    public int updateGoodCommentContent(@Param("content") String content, @Param("id") String id){

        int temp = this.goodCommentMapper.updateGoodCommentContent(content,id);

        return temp;
    }

    @Override
    public int updateGoodCommentThumb(String id){

        int temp = this.goodCommentMapper.updateGoodCommentThumb(id);

        return temp;
    }

    @Override
    public int updateGoodCommentComment(String id){

        int temp = this.goodCommentMapper.updateGoodCommentComment(id);

        return temp;
    }

    @Override
    public int deleteGoodComment(String id){

        int temp = this.goodCommentMapper.deleteGoodComment(id);

        return temp;
    }

}
    