package com.test.servicetest;

import com.springboot.MustardSpaceApplication;

import com.springboot.domain.Comment;
import com.springboot.service.TaskCommentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @author 会飞的大野鸡
 * @create 2020/5/7
 * TODO:
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MustardSpaceApplication.class})
public class CommentServiceTest {

    @Autowired
    private TaskCommentService taskCommentService;

    /**
     * testGetAllTaskComment
     * TODO
     * @description testGetAllTaskComment
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testGetAllTaskComment(){

        List<Comment> list = taskCommentService.getAllTaskComment();

        Assert.assertNotNull(list);
    }


    /**
     * testQueryTaskCommentById
     * TODO
     * @description testQueryTaskCommentById
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testQueryTaskCommentById(){

        String id = "b51fb005-af3b-42c5-80ce-3b16531b7f30";

        Comment comment = taskCommentService.queryTaskCommentById(id);

        Assert.assertNotNull(comment);
    }

    /**
     * testQueryTaskCommentByUserId
     * TODO
     * @description testQueryTaskCommentByUserId
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testQueryTaskCommentByUserId(){

        String user_id = "1";

        List<Comment> list = taskCommentService.queryTaskCommentByUserId(user_id);

        Assert.assertNotNull(list);
    }

    /**
     * testQueryTaskCommentByTableId
     * TODO
     * @description testQueryTaskCommentByTableId
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testQueryTaskCommentByTableId(){

        String table_id = "04cc5c44-2c3e-488b-9947-1b1db08e81c1";

        List<Comment> list = taskCommentService.queryTaskCommentByTableId(table_id);

        Assert.assertNotNull(list);
    }

    /**
     * testInsertTaskComment
     * TODO
     * @description testInsertTaskComment
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testInsertTaskComment(){

        Comment comment = new Comment();

        comment.setId("test_uuid");
        comment.setTable_id("04cc5c44-2c3e-488b-9947-1b1db08e81c1");
        comment.setUser_id(1);
        comment.setPublish_time("ts");

        int result = taskCommentService.insertTaskComment(comment);
        int expected = 1;

        Assert.assertEquals(expected,result);
    }

    /**
     * testUpdateTaskCommentContent
     * TODO
     * @description testUpdateTaskCommentContent
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testUpdateTaskCommentContent(){

        String content = "content_test";
        String id = "b51fb005-af3b-42c5-80ce-3b16531b7f30";

        int result = taskCommentService.updateTaskCommentContent(content,id);
        int expected = 1;

        Assert.assertEquals(expected,result);
    }

    /**
     * testUpdateTaskCommentThumb
     * TODO
     * @description testUpdateTaskCommentThumb
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testUpdateTaskCommentThumb(){

        String id = "b51fb005-af3b-42c5-80ce-3b16531b7f30";

        int result = taskCommentService.updateTaskCommentThumb(id);
        int expected = 1;

        Assert.assertEquals(expected,result);
    }


    /**
     * testUpdateTaskCommentComment
     * TODO
     * @description testUpdateTaskCommentComment
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testUpdateTaskCommentComment(){

        String id = "b51fb005-af3b-42c5-80ce-3b16531b7f30";

        int result = taskCommentService.updateTaskCommentComment(id);
        int expected = 1;

        Assert.assertEquals(expected,result);
    }

    /**
     * testDeleteTaskComment
     * TODO
     * @description testDeleteTaskComment
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testDeleteTaskComment(){

        String id = "test_uuid";

        int result = taskCommentService.deleteTaskComment(id);
        int expected = 1;

        Assert.assertEquals(expected,result);
    }
}
