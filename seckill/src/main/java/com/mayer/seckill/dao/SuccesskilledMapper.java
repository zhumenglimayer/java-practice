package com.mayer.seckill.dao;

import com.mayer.seckill.entity.Successkilled;
import com.mayer.seckill.entity.SuccesskilledExample;
import com.mayer.seckill.entity.SuccesskilledKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuccesskilledMapper {
    long countByExample(SuccesskilledExample example);

    int deleteByExample(SuccesskilledExample example);

    int deleteByPrimaryKey(SuccesskilledKey key);

    int insert(Successkilled record);

    int insertSelective(Successkilled record);

    List<Successkilled> selectByExample(SuccesskilledExample example);

    Successkilled selectByPrimaryKey(SuccesskilledKey key);

    int updateByExampleSelective(@Param("record") Successkilled record, @Param("example") SuccesskilledExample example);

    int updateByExample(@Param("record") Successkilled record, @Param("example") SuccesskilledExample example);

    int updateByPrimaryKeySelective(Successkilled record);

    int updateByPrimaryKey(Successkilled record);
}