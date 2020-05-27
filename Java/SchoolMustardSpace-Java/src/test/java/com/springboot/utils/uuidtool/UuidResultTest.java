package com.springboot.utils.uuidtool;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


/**
 * @author 会飞的大野鸡
 * @create 2020/5/6
 * TODO:
 */

public class UuidResultTest {

    @Test
    public void setUuidResult() {
        String uuid = new UuidResult().setUuidResult();
        String uuid1 = new UuidResult().setUuidResult();
        String uuid2 = new UuidResult().setUuidResult();
        String uuid3 = new UuidResult().setUuidResult();
        String uuid4 = new UuidResult().setUuidResult();

        Assert.assertNotEquals(uuid , uuid1);
        Assert.assertNotEquals(uuid , uuid2);
        Assert.assertNotEquals(uuid , uuid3);
        Assert.assertNotEquals(uuid , uuid4);
        Assert.assertNotEquals(uuid1 , uuid2);
        Assert.assertNotEquals(uuid1, uuid3);
        Assert.assertNotEquals(uuid1 , uuid4);
        Assert.assertNotEquals(uuid2 , uuid3);
        Assert.assertNotEquals(uuid2 , uuid4);
        Assert.assertNotEquals(uuid3 , uuid4);
    }
}
