package com.springboot.mapper;

import com.springboot.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    查询数据库中是否存在与id和password一致的记录
     */
    @Select("select COUNT(*) from user where account_number = #{accountNumber} and password = #{password}")
    int selectUserByIdAndPassword(@Param("accountNumber")String accountNumber, @Param("password")String password );

    /*
    插入一条用户记录，字段只包含account_number和password
    数据库如果不存在相同的account_number则插入记录
     */
    @Insert("insert into user(account_number, password) select #{accountNumber},#{password} where not exists (select * from user where account_number = #{accountNumber}) ")
    int insertUser(@Param("accountNumber")String accountNumber,@Param("password")String password);
}
