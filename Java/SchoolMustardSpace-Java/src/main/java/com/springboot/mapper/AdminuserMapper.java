package com.springboot.mapper;

import com.springboot.domain.Adminuser;
import com.springboot.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

/**
 * AdminuserMapper
 * TODO
 * @description AdminuserMapper
 * @author 221701429_黄晓东
 * @version v 1.0.0
 * @since 2020/4/29
 */
@Mapper
public interface AdminuserMapper {
    /*
    查询数据库中是否存在与account_number和password一致的记录
     */
    @Select("select COUNT(*) from adminuser where account_number = #{accountNumber} and password = #{password}")
    int selectAdminuserByAccountNumberAndPassword(@Param("accountNumber") String accountNumber, @Param("password") String password);

    /*
    插入一条管理员记录,数据库如果不存在相同的account_number则插入记录
     */
    @Insert("insert into adminuser(account_number, password, authority) " +
            "select #{accountNumber}, #{password}, #{authority}" +
            " where not exists (select * from adminuser where account_number = #{accountNumber})")
    int insertAdminuser(Adminuser adminuser);

    /*
    更新字段account_number符合条件的记录的password
     */
    @Update("update adminuser set password = #{password} where account_number = #{accountNumber}")
    int updateAdminuserPassword(@Param("accountNumber") String accountNumber, @Param("password") String password);

    /*
    更新管理员记录
     */
    @Update("update adminuser set account_number = #{accountNumber}, password = #{password}, authority = #{authority} " +
            "where account_number = #{accountNumber}")
    int updateAdminuser(Adminuser adminuser);

    /*
    删除字段account_number符合条件的记录
     */
    @Delete("delete from adminuser where account_number = #{accountNumber}")
    int deleteAdminuserByAccountNumber(@Param("accountNumber") String accountNumber);

    /*
    查询adminuser表中全部的管理员信息
     */
    @Select("select id, account_number, password, authority from adminuser")
    @Results(value = {@Result(column = "account_number", property = "accountNumber")})
    ArrayList<Adminuser> selectAllAdminuser();

    /*
    查询adminuser表中指定account_number的记录
     */
    @Select("select * from adminuser where account_number = #{accountNumber}")
    @Results(value = {@Result(column = "account_number", property = "accountNumber")})
    Adminuser selectAdminuserByAccountNumber(@Param("accountNumber") String accountNumber);



    @Select("select id from adminuser where account_number = #{accountNumber}")
    int selectId(@Param("accountNumber") String accountNumber);

    @Select("select * from adminuser where id = #{id}")
    @Results(value = {
            @Result(column = "account_number", property = "accountNumber")
    })
    Adminuser selectUserById(@Param("id") String id);
}
