package com.test.servicetest;
import com.springboot.MustardSpaceApplication;
import com.springboot.domain.User;
import com.springboot.service.UserService;
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
public class UserServiceTest {

    @Autowired
    private UserService userService;


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

        String result = userService.login(account,str);
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

        User user = new User();

        user.setAccountNumber("test");
        user.setPassword("test");

        String result = userService.register(user);
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

        String result = userService.findPassword(account,str);
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

        String result = userService.changePassword(account,str,newPassword);
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

        User user = new User();

        user.setAccountNumber("test");
        user.setPassword("test");

        String result = userService.updateUserMessage(user);
        String expected = "succeed";

        Assert.assertEquals(expected,result);
    }

    /**
     * testDeleteUser
     * TODO
     * @description testDeleteUser
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testDeleteUser(){

        String account = "test";

        String result = userService.deleteUser(account);
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
    public void testQueryOneUserById(){

        String id = "1";

        User user = userService.queryOneUserById(id);

        Assert.assertNotNull(user);
    }

    /**
     * testQueryOneUser
     * TODO
     * @description testQueryOneUser
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.6
     */
    @Test
    public void testQueryOneUser(){

        String id = "221701412";

        User user = userService.queryOneUser(id);

        Assert.assertNotNull(user);
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
    public void testSelectId(){

        String account = "221701412";

        int result = userService.selectId(account);

        int expected = 1;

        Assert.assertEquals(expected,result);
    }


}
