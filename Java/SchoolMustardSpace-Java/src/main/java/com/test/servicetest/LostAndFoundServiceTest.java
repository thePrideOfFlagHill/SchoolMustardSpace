package com.test.servicetest;

import com.springboot.MustardSpaceApplication;
import com.springboot.domain.LostAndFound;
import com.springboot.mapper.LostAndFoundMapper;
import com.springboot.service.LostAndFoundService;
import com.springboot.utils.datetool.DateResult;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @author 会飞的大野鸡
 * @create 2020/5/7
 * TODO:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MustardSpaceApplication.class})
public class LostAndFoundServiceTest {
    @Autowired
    private LostAndFoundService lostAndFoundService;

    @Test
    public void insertLostAndFound(){
        LostAndFound lostAndFound = new LostAndFound();
        lostAndFound.setId(UUID.randomUUID().toString());
        lostAndFound.setUserId(1);
        lostAndFound.setTitle("asd");
        lostAndFound.setContent("asd");
        lostAndFound.setImage("asd");
        lostAndFound.setLabel("asd");
        lostAndFound.setLocation("asd");
        lostAndFound.setTime(new DateResult().getCurrentTime());
        lostAndFound.setIsLost(11);
        String msg = lostAndFoundService.insertLostAndFound(lostAndFound);
        Assert.assertEquals(msg , "succeed");
    }

    @Test
    public void updateSome(){
        String msg1 = lostAndFoundService.updateSome(1 , "2f50029a-8335-4a19-b971-f37c0aa07c34");
        String msg2 = lostAndFoundService.updateSome(2 , "2f50029a-8335-4a19-b971-f37c0aa07c34");
        String msg3 = lostAndFoundService.updateSome(3 , "2f50029a-8335-4a19-b971-f37c0aa07c34");
        String msg4 = lostAndFoundService.updateSome(4 , "2f50029a-8335-4a19-b971-f37c0aa07c34");
        Assert.assertEquals(msg1 , "succeed");
        Assert.assertEquals(msg2 , "succeed");
        Assert.assertEquals(msg3 , "succeed");
        Assert.assertEquals(msg4 , "succeed");
    }

    @Test
    public void deleById(){
        LostAndFound lostAndFound = new LostAndFound();
        String id = UUID.randomUUID().toString();
        lostAndFound.setId(id);
        lostAndFound.setUserId(1);
        lostAndFound.setTitle("asd");
        lostAndFound.setContent("asd");
        lostAndFound.setImage("asd");
        lostAndFound.setLabel("asd");
        lostAndFound.setLocation("asd");
        lostAndFound.setTime(new DateResult().getCurrentTime());
        lostAndFound.setIsLost(11);
        lostAndFoundService.insertLostAndFound(lostAndFound);

        String msg = lostAndFoundService.deleteById(id);
        Assert.assertEquals(msg , "succeed");
    }

    @Test
    public void selectList(){
        List<LostAndFound> lostAndFounds = lostAndFoundService.selectList(1 , 1);
        List<LostAndFound> lostAndFounds1 = lostAndFoundService.selectList(2 , 1);
        Assert.assertNotNull(lostAndFounds);
        Assert.assertNotNull(lostAndFounds1);
    }

    @Test
    public void selectOne(){
        String id = "2f50029a-8335-4a19-b971-f37c0aa07c34";
        LostAndFound lostAndFound = new LostAndFound();
        lostAndFound = null;
        lostAndFound = lostAndFoundService.selectOne(id);
        Assert.assertNotNull(lostAndFound);
    }

    @Test
    public void selectLike(){
        List<LostAndFound> lostAndFounds = new LinkedList<LostAndFound>();
        List<LostAndFound> lostAndFounds1 = new LinkedList<LostAndFound>();
        List<LostAndFound> lostAndFounds2 = new LinkedList<LostAndFound>();
        lostAndFounds = null ; lostAndFounds1 =null; lostAndFounds2 = null;
        lostAndFounds = lostAndFoundService.selectLike(1 , "a");
        lostAndFounds1 = lostAndFoundService.selectLike(2 , "a");
        lostAndFounds2 = lostAndFoundService.selectLike(3 , "a");
        Assert.assertNotNull(lostAndFounds);
        Assert.assertNotNull(lostAndFounds1);
        Assert.assertNotNull(lostAndFounds2);
    }

    @Test
    public void updateImg(){
        int num = lostAndFoundService.updateImg("asd" , "2f50029a-8335-4a19-b971-f37c0aa07c34");
        Assert.assertEquals(1 , num);
    }
}
