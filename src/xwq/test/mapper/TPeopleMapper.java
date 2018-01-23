package xwq.test.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xwq.test.pojo.TPeople;
import xwq.test.pojo.TPeopleExample;

public interface TPeopleMapper {
  
    int insert(TPeople record);

 
}