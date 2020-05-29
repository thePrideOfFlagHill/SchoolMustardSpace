package com.test.servicetest;

import com.springboot.MustardSpaceApplication;
import com.springboot.domain.Adminuser;
import com.springboot.service.AdminuserService;
import com.springboot.utils.encryptiontool.DesEncryption;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.springboot.utils.encryptiontool.DesEncryption.byte2Hex;

/**
 * @author 会飞的大野鸡
 * @create 2020/5/7
 * TODO:
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MustardSpaceApplication.class})
public class AdminuserServiceTest {

    @Autowired
    private AdminuserService adminuserService;


    /**
     * testLogin
     * TODO
     * @description testLogin
     * ≤‚ ‘µ«¬º ”√¿˝ 221701412 √‹¬Î 666666
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testLogin(){

        String account = "221701412";
        String password = "test666";

        // º”√‹
        byte[] secretArr = DesEncryption.encryptMode(password.getBytes());
        String str = byte2Hex(secretArr);

        String result = adminuserService.login(account,str);
        String expected = "succeed";

        Assert.assertEquals(expected,result);
    }

    /**
     * testRegister
     * TODO
     * @description testRegister
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testRegister(){

        Adminuser adminuser = new Adminuser();

        adminuser.setAccountNumber("test");
        adminuser.setPassword("test");
        adminuser.setAuthority(0);

        String result = adminuserService.register(adminuser);
        String expected = "succeed";

        Assert.assertEquals(expected,result);
    }

    /**
     * testFindPassword
     * TODO
     * @description testFindPassword
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testFindPassword(){


        String account = "221701412";
        String password = "test666";

        // º”√‹
        byte[] secretArr = DesEncryption.encryptMode(password.getBytes());
        String str = byte2Hex(secretArr);

        String result = adminuserService.findPassword(account,str);
        String expected = "succeed";

        Assert.assertEquals(expected,result);
    }

    /**
     * testChangePassword
     * TODO
     * @description testChangePassword
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testChangePassword(){


        String account = "221701412";
        String password = "test666";
        String newPassword = "test666";

        // º”√‹
        byte[] secretArr = DesEncryption.encryptMode(password.getBytes());
        String str = byte2Hex(secretArr);

        String result = adminuserService.changePassword(account,str,newPassword);
        String expected = "succeed";

        Assert.assertEquals(expected,result);
    }

    /**
     * testUpdateAdminuserMessage
     * TODO
     * @description testUpdateAdminuserMessage
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testUpdateAdminuserMessage(){

        Adminuser adminuser = new Adminuser();

        adminuser.setAccountNumber("test");
        adminuser.setPassword("test");
        adminuser.setAuthority(1);

        String result = adminuserService.updateAdminuserMessage(adminuser);
        String expected = "succeed";

        Assert.assertEquals(expected,result);
    }

    /**
     * testDeleteAdminuser
     * TODO
     * @description testDeleteAdminuser
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testDeleteAdminuser(){

        String account = "test";

        String result = adminuserService.deleteAdminuser(account);
        String expected = "succeed";

        Assert.assertEquals(expected,result);
    }

    /**
     * testQueryOneAdminuser
     * TODO
     * @description testQueryOneAdminuser
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testQueryOneAdminuser(){

        String account = "221701412";

        Adminuser adminuser = adminuserService.queryOneAdminuser(account);

        Assert.assertNotNull(adminuser);
    }

    /**
     * testQueryOneUserById
     * TODO
     * @description testQueryOneUserById
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testQueryOneUserById(){

        String id = "5";

        Adminuser adminuser = adminuserService.queryOneUserById(id);

        Assert.assertNotNull(adminuser);
    }

    /**
     * testSelectId
     * TODO
     * @description testSelectId
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testSelectId(){

        String account = "221701412";

        int result = adminuserService.selectId(account);

        int expected = 5;

        Assert.assertEquals(expected,result);
    }


}
