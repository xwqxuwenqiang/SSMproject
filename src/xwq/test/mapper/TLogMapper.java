package xwq.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xwq.test.pojo.TLog;
import xwq.test.pojo.TLogExample;

public interface TLogMapper {
    int countByExample(TLogExample example);

    int deleteByExample(TLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TLog record);

    int insertSelective(TLog record);

    List<TLog> selectByExampleWithBLOBs(TLogExample example);

    List<TLog> selectByExample(TLogExample example);

    TLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TLog record, @Param("example") TLogExample example);

    int updateByExampleWithBLOBs(@Param("record") TLog record, @Param("example") TLogExample example);

    int updateByExample(@Param("record") TLog record, @Param("example") TLogExample example);

    int updateByPrimaryKeySelective(TLog record);

    int updateByPrimaryKeyWithBLOBs(TLog record);

    int updateByPrimaryKey(TLog record);
}