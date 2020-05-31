package com.springboot.service.Impl;

import com.springboot.domain.Comment;
//import com.springboot.domain.GoodComment;
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

    /*@Override
    public List<Comment> getAllGoodComment() {

        List<Comment> list = this.goodCommentMapper.getAllGoodComment();

        return list;

    }*/

    @Override
    public Comment queryGoodCommentById(String id){

        Comment goodComment = this.goodCommentMapper.queryGoodCommentById(id);

        return goodComment;
    }

    /*@Override
    public List<Comment> queryGoodCommentByUserId(String user_id){

        List<Comment> list = this.goodCommentMapper.queryGoodCommentByUserId(user_id);

        return list;
    }*/

    /*@Override
    public List<Comment> queryGoodCommentByTableId(String table_id){

        List<Comment> list = this.goodCommentMapper.queryGoodCommentByTableId(table_id);

        return list;
    }*/

    @Override
    public List<Comment> select(int choice, String id){
        if(choice == 1){//获取全部物品租赁的评论
            return this.goodCommentMapper.getAllGoodComment();
        }
        else if(choice == 2){//根据user_id查询物品租赁评论
            return this.goodCommentMapper.queryGoodCommentByUserId(id);
        }
        else if(choice == 3){//根据table_id查询物品租赁评论
            return this.goodCommentMapper.queryGoodCommentByTableId(id);
        }
        return null;
    }

    @Override
    public int insertGoodComment(Comment goodComment){

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
