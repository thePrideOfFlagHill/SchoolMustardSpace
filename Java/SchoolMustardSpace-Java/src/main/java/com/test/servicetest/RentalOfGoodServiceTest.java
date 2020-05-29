package com.test.servicetest;

import com.springboot.MustardSpaceApplication;
import com.springboot.domain.RentalOfGood;
import com.springboot.service.RentalOfGoodService;
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
public class RentalOfGoodServiceTest {
    @Autowired
    private RentalOfGoodService rentalOfGoodService;

    @Test
    public void insertRentalOfGood(){
        String uuid = UUID.randomUUID().toString();
        RentalOfGood rentalOfGood = new RentalOfGood();
        rentalOfGood.setId(uuid);
        rentalOfGood.setUserId(1);
        rentalOfGood.setTitle("title");
        rentalOfGood.setContent("content");
        rentalOfGood.setImage("image");
        rentalOfGood.setLabel("label");
        rentalOfGood.setLocation("location");
        rentalOfGood.setUnitPrice("unitPrice");
        rentalOfGood.setStartTime("startTime");
        rentalOfGood.setEndTime("endTime");
        rentalOfGood.setNewDegree(95);
        String msg = rentalOfGoodService.insertRentalOfGood(rentalOfGood);
        Assert.assertEquals(msg , "succeed");
    }

    @Test
    public void insertTime(){
        String msg1 = rentalOfGoodService.insertTime(1 , "5aa20998-5c3c-4318-baca-2fa8acbbf49b");
        String msg2 = rentalOfGoodService.insertTime(2 , "5aa20998-5c3c-4318-baca-2fa8acbbf49b");
        Assert.assertEquals(msg1 , "succeed");
        Assert.assertEquals(msg2 , "succeed");
    }

    @Test
    public void updateSome(){
        String msg1 = rentalOfGoodService.updateSome(1 , "5aa20998-5c3c-4318-baca-2fa8acbbf49b");
        String msg2 = rentalOfGoodService.updateSome(2 , "5aa20998-5c3c-4318-baca-2fa8acbbf49b");
        String msg3 = rentalOfGoodService.updateSome(3 , "5aa20998-5c3c-4318-baca-2fa8acbbf49b");
        String msg4 = rentalOfGoodService.updateSome(4 , "5aa20998-5c3c-4318-baca-2fa8acbbf49b");
        Assert.assertEquals(msg1 , "succeed");
        Assert.assertEquals(msg2 , "succeed");
        Assert.assertEquals(msg3 , "succeed");
        Assert.assertEquals(msg4 , "succeed");
    }

    @Test
    public void deleteById(){
        String uuid = UUID.randomUUID().toString();
        RentalOfGood rentalOfGood = new RentalOfGood();
        rentalOfGood.setId(uuid);
        rentalOfGood.setUserId(1);
        rentalOfGood.setTitle("title");
        rentalOfGood.setContent("content");
        rentalOfGood.setImage("image");
        rentalOfGood.setLabel("label");
        rentalOfGood.setLocation("location");
        rentalOfGood.setUnitPrice("unitPrice");
        rentalOfGood.setStartTime("startTime");
        rentalOfGood.setEndTime("endTime");
        rentalOfGood.setNewDegree(95);
        rentalOfGoodService.insertRentalOfGood(rentalOfGood);
        String msg = rentalOfGoodService.deleteById(uuid);
        Assert.assertEquals(msg , "succeed");
    }

    @Test
    public void selectList(){
        List<RentalOfGood> rentalOfGoods = new LinkedList<RentalOfGood>();
        List<RentalOfGood> rentalOfGoods1 = new LinkedList<RentalOfGood>();
        rentalOfGoods = null; rentalOfGoods1 = null;
        rentalOfGoods = rentalOfGoodService.selectList(1 , 1);
        rentalOfGoods1 = rentalOfGoodService.selectList(1 , 1);
        Assert.assertNotNull(rentalOfGoods);
        Assert.assertNotNull(rentalOfGoods1);
    }

    @Test
    public void selectOne(){
        RentalOfGood rentalOfGood = new RentalOfGood();
        rentalOfGood = null;
        rentalOfGood = rentalOfGoodService.selectOne("5aa20998-5c3c-4318-baca-2fa8acbbf49b");
        Assert.assertNotNull(rentalOfGood);
    }

    @Test
    public void selectLike(){
        List<RentalOfGood> rentalOfGoods = new LinkedList<RentalOfGood>();
        List<RentalOfGood> rentalOfGoods1 = new LinkedList<RentalOfGood>();
        List<RentalOfGood> rentalOfGoods2 = new LinkedList<RentalOfGood>();
        rentalOfGoods = null; rentalOfGoods1 = null; rentalOfGoods2 = null;
        rentalOfGoods = rentalOfGoodService.selectLike(1 , "a");
        rentalOfGoods1 = rentalOfGoodService.selectLike(2 , "a");
        rentalOfGoods2 = rentalOfGoodService.selectLike(3 , "a");
        Assert.assertNotNull(rentalOfGoods);
        Assert.assertNotNull(rentalOfGoods1);
        Assert.assertNotNull(rentalOfGoods2);
    }

    @Test
    public void updateImg(){
        int num = rentalOfGoodService.updateImg("asd" , "5aa20998-5c3c-4318-baca-2fa8acbbf49b");
        Assert.assertEquals(1 , num);
    }
}
