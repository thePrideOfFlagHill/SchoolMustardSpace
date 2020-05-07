package com.springboot.utils.encryptiontool;

//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


/**
 * @author 会飞的大野鸡
 * @create 2020/5/6
 * TODO:
 */

public class DesEncryptionTest {

    @Test
    public void decryptMode() {
        String msg = "123123123";
        byte[] secretArr = new DesEncryption().encryptMode(msg.getBytes());
        String str = new DesEncryption().byte2Hex(secretArr);
        Assert.assertEquals(str , "7DD825A84D4F41B61C6CA960CB9C0AB9");
    }

    @Test
    public void byte2Hex() {
        String msg = "123123123";
        byte[] secretArr = DesEncryption.encryptMode(msg.getBytes());
        byte[] myMsgArr = new DesEncryption().decryptMode(secretArr);
        Assert.assertEquals("123123123" , new String(myMsgArr));
    }
}
