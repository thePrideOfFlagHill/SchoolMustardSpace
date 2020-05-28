package com.springboot.service.Impl;

import com.springboot.domain.Comment;
//import com.springboot.domain.LostFoundComment;
import com.springboot.mapper.LostFoundCommentMapper;
import com.springboot.service.LostFoundCommentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * LostFoundCommentServiceImpl
 * TODO
 * @description LostFoundCommentServiceImpl 服务实现层
 * @author 221701412_theTuring  会飞的大野鸡
 * @version v 1.0.0
 * @since 2020.5.1
 */
@Service
public class LostFoundCommentServiceImpl implements LostFoundCommentService {

    @Autowired
    private LostFoundCommentMapper lostFoundCommentMapper;

    @Override
    public List<Comment> getAllLostFoundComment() {

        List<Comment> list = this.lostFoundCommentMapper.getAllLostFoundComment();

        return list;

    }

    @Override
    public Comment queryLostFoundCommentById(String id){

        Comment lostFoundComment = this.lostFoundCommentMapper.queryLostFoundCommentById(id);

        return lostFoundComment;
    }

    @Override
    public List<Comment> queryLostFoundCommentByUserId(String user_id){

        List<Comment> list = this.lostFoundCommentMapper.queryLostFoundCommentByUserId(user_id);

        return list;
    }

    @Override
    public List<Comment> queryLostFoundCommentByTableId(String table_id){

        List<Comment> list = this.lostFoundCommentMapper.queryLostFoundCommentByTableId(table_id);

        return list;
    }

    @Override
    public int insertLostFoundComment(Comment lostFoundComment){

        int temp = this.lostFoundCommentMapper.insertLostFoundComment(lostFoundComment);

        return temp;

    }

    @Override
    public int updateLostFoundCommentContent(@Param("content") String content, @Param("id") String id){

        int temp = this.lostFoundCommentMapper.updateLostFoundCommentContent(content,id);

        return temp;
    }

    @Override
    public int updateLostFoundCommentThumb(String id){

        int temp = this.lostFoundCommentMapper.updateLostFoundCommentThumb(id);

        return temp;
    }

    @Override
    public int updateLostFoundCommentComment(String id){

        int temp = this.lostFoundCommentMapper.updateLostFoundCommentComment(id);

        return temp;
    }

    @Override
    public int deleteLostFoundComment(String id){

        int temp = this.lostFoundCommentMapper.deleteLostFoundComment(id);

        return temp;
    }

}
