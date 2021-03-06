package com.springboot.mapper;

import com.springboot.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

/**
 * UserMapper
 * TODO
 * @description UserMapper
 * @author 221701429_黄晓东
 * @version v 1.0.0
 * @since 2020/4/26
 */
@Mapper
public interface UserMapper {
    /*
    查询数据库中是否存在与account_number和password一致的记录
     */
    @Select("select COUNT(*) from user where account_number = #{accountNumber} and password = #{password}")
    int selectUserByAccountNumberAndPassword(@Param("accountNumber") String accountNumber, @Param("password") String password );

    /*
    插入一条用户记录，数据库如果不存在相同的account_number则插入记录
     */
    @Insert("insert into user(account_number, password, sex, name, phone_number, head, address, info) " +
            "select #{accountNumber}, #{password}, #{sex}, #{name}, #{phoneNumber}, " +
            "#{head}, #{address}, #{info} where not exists " +
            "(select * from user where account_number = #{accountNumber})")
    int insertUser(User user);

    /*
    更新字段account_number符合条件的记录的password
     */
    @Update("update user set password = #{password} where account_number = #{accountNumber}")
    int updateUserPassword(@Param("accountNumber") String accountNumber, @Param("password") String password);

    /*
    更新用户记录
     */
    @Update("update user set account_number = #{accountNumber}, password = #{password}, sex = #{sex}," +
            " name = #{name}, phone_number = #{phoneNumber}, head = #{head}, address = #{address}, info = #{info} " +
            "where account_number = #{accountNumber}")
    int updateUser(User user);

    /*
    删除字段account_number符合条件的记录
     */
    @Delete("delete from user where account_number = #{accountNumber}")
    int deleteUserByAccountNumber(@Param("accountNumber") String accountNumber);

    /*
    查询user表中全部的用户信息
     */
    @Select("select id, account_number, password, sex, name, phone_number, head, address, info from user")
    @Results(value = {
            @Result(column = "account_number", property = "accountNumber"),
            @Result(column = "phone_number", property = "phoneNumber")
    })
    ArrayList<User> selectAllUser();

    /*
    查询user表中指定account_number的记录
     */
    @Select("select * from user where account_number = #{accountNumber}")
    @Results(value = {
            @Result(column = "account_number", property = "accountNumber"),
            @Result(column = "phone_number", property = "phoneNumber")
    })
    User selectUserByAccountNumber(@Param("accountNumber") String accountNumber);

    @Select("select * from user where id = #{id}")
    @Results(value = {
            @Result(column = "account_number", property = "accountNumber"),
            @Result(column = "phone_number", property = "phoneNumber")
    })
    User selectUserById(@Param("id") String id);


    @Select("select id from user where account_number = #{accountNumber}")
    int selectId(@Param("accountNumber") String accountNumber);
}
