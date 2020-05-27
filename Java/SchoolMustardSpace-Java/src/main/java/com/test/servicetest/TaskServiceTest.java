package com.test.servicetest;

import com.springboot.MustardSpaceApplication;
import com.springboot.domain.Task;
import com.springboot.service.TaskService;
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
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    /**
     * testGetAllTask
     * TODO
     * @description testGetAllTask
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testGetAllTask(){

        List<Task> list = taskService.getAllTask();

        Assert.assertNotNull(list);
    }


    /**
     * testGetAllTask
     * TODO
     * @description testQueryTaskById
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testQueryTaskById(){

        String id = "10c6512b-6681-4b7a-a038-bb8367ea80f4";

        Task task = taskService.queryTaskById(id);

        Assert.assertNotNull(task);
    }

    /**
     * testQueryTaskByUserId
     * TODO
     * @description testQueryTaskByUserId
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testQueryTaskByUserId(){

        String id = "10c6512b-6681-4b7a-a038-bb8367ea80f4";

        List<Task> list = taskService.queryTaskByUserId(id);

        Assert.assertNotNull(list);
    }

    /**
     * testGetLikeContent
     * TODO
     * @description testGetLikeContent
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testGetLikeContent(){

        String content = "test";

        List<Task> list = taskService.getLikeContent(content);

        Assert.assertNotNull(list);
    }

    /**
     * testGetLikeTitle
     * TODO
     * @description testGetLikeTitle
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testGetLikeTitle(){

        String title = "test";

        List<Task> list = taskService.getLikeTitle(title);

        Assert.assertNotNull(list);
    }

    /**
     * testGetLikeLabel
     * TODO
     * @description testGetLikeLabel
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testGetLikeLabel(){

        String label = "test";

        List<Task> list = taskService.getLikeLabel(label);

        Assert.assertNotNull(list);
    }

    /**
     * testInsertTask
     * TODO
     * @description testInsertTask
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testInsertTask(){

        Task task = new Task();

        task.setId("test_uuid");
        task.setUser_id(1);
        task.setTitle("test");
        task.setIs_done(0);
        task.setStart_time("st");
        task.setEnd_time("et");

        int result = taskService.insertTask(task);
        int expected = 1;

        Assert.assertEquals(expected,result);
    }

    /**
     * testUpdateTask
     * TODO
     * @description testUpdateTask
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testUpdateTask(){

        Task task = new Task();

        task.setId("test_uuid");
        task.setUser_id(1);
        task.setTitle("update_test");
        task.setIs_done(0);
        task.setStart_time("st");
        task.setEnd_time("et");

        int result = taskService.updateTask(task);
        int expected = 0;

        Assert.assertEquals(expected,result);
    }

    /**
     * testUpdateTaskIs_done
     * TODO
     * @description testUpdateTaskIs_done
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testUpdateTaskIs_done(){

        int done = 1;
        String id = "test_uuid";

        int result = taskService.updateTaskIs_done(done,id);
        int expected = 1;

        Assert.assertEquals(expected,result);
    }

    /**
     * testUpdateTaskThumb
     * TODO
     * @description testUpdateTaskThumb
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testUpdateTaskThumb(){

        String id = "04cc5c44-2c3e-488b-9947-1b1db08e81c1";

        int result = taskService.updateTaskThumb(id);
        int expected = 1;

        Assert.assertEquals(expected,result);
    }

    /**
     * testUpdateTaskCollect
     * TODO
     * @description testUpdateTaskCollect
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testUpdateTaskCollect(){

        String id = "04cc5c44-2c3e-488b-9947-1b1db08e81c1";

        int result = taskService.updateTaskCollect(id);
        int expected = 1;

        Assert.assertEquals(expected,result);
    }

    /**
     * testUpdateTaskComment
     * TODO
     * @description testUpdateTaskComment
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testUpdateTaskComment(){

        String id = "04cc5c44-2c3e-488b-9947-1b1db08e81c1";

        int result = taskService.updateTaskComment(id);
        int expected = 1;

        Assert.assertEquals(expected,result);
    }

    /**
     * testUpdateTaskImageUrl
     * TODO
     * @description testUpdateTaskImageUrl
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testUpdateTaskImageUrl(){

        String image = "image_test";
        String id = "04cc5c44-2c3e-488b-9947-1b1db08e81c1";

        int result = taskService.updateTaskImageUrl(image,id);
        int expected = 1;

        Assert.assertEquals(expected,result);
    }

    /**
     * testDeleteTask
     * TODO
     * @description testDeleteTask
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testDeleteTask(){

        String id = "test_uuid";

        int result = taskService.deleteTask(id);
        int expected = 1;

        Assert.assertEquals(expected,result);
    }

}
