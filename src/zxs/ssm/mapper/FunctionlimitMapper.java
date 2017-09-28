package zxs.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zxs.ssm.po.Functionlimit;
import zxs.ssm.po.FunctionlimitExample;

public interface FunctionlimitMapper {
    int countByExample(FunctionlimitExample example);

    int deleteByExample(FunctionlimitExample example);

    int deleteByPrimaryKey(Integer flId);

    int insert(Functionlimit record);

    int insertSelective(Functionlimit record);

    List<Functionlimit> selectByExample(FunctionlimitExample example);

    Functionlimit selectByPrimaryKey(Integer flId);

    int updateByExampleSelective(@Param("record") Functionlimit record, @Param("example") FunctionlimitExample example);

    int updateByExample(@Param("record") Functionlimit record, @Param("example") FunctionlimitExample example);

    int updateByPrimaryKeySelective(Functionlimit record);

    int updateByPrimaryKey(Functionlimit record);
}