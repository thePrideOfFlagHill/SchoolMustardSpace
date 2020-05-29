package com.springboot.mapper;

import com.springboot.domain.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 会飞的大野鸡
 * @create 2020/5/29
 * TODO:
 */

@Mapper
public interface WordMapper {
    @Select("select * from sensitive_words")
    @Results(value = {
            @Result(column = "words", property = "word")
    })
    List<Word> getWords();
}
