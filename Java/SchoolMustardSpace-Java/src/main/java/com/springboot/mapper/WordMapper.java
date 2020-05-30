package com.springboot.mapper;

import com.springboot.domain.Word;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 会飞的大野鸡
 * @create 2020/5/29
 * TODO:
 */

@Mapper
public interface WordMapper {

    //=================================== 增 ======================================
    //添加敏感词
    @Insert("insert into sensitive_words(words) values (#{words})")
    int addWord(@Param("words")String word);
    //=================================== 增 ======================================


    //=================================== 删 ======================================
    //通过Id或者名称或者类型删除
    @Delete("delete from sensitive_words where id = #{id}")
    int deleteById(@Param("id") int id);

    @Delete("delete from sensitive_words where words = #{word}")
    int deleteByWord(@Param("word") String words);

    @Delete("delete from sensitive_words where type = #{type}")
    int deleteByType(@Param("type") String type);
    //=================================== 删 ======================================


    //=================================== 查 ======================================
    @Select("select * from sensitive_words")
    @Results(value = {
            @Result(column = "words", property = "word")
    })
    List<Word> getWords();

    @Select("select if(exists(select words from sensitive_words where words = #{word}) , true , false)")
    boolean checkRepeat(@Param("word")String word);
    //=================================== 查 ======================================


    //=================================== 改 ======================================
    //修改敏感词
    @Update("update sensitive_words set words = #{newWord} where words = #{word}")
    int updateWord(@Param("word")String word , @Param("newWord")String newWord);
    //=================================== 改 ======================================

}
