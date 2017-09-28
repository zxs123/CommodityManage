package zxs.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zxs.ssm.po.ExpressInfo;
import zxs.ssm.po.ExpressInfoExample;
import zxs.ssm.po.ExpressInfoKey;

public interface ExpressInfoMapper {
    int countByExample(ExpressInfoExample example);

    int deleteByExample(ExpressInfoExample example);

    int deleteByPrimaryKey(ExpressInfoKey key);

    int insert(ExpressInfo record);

    int insertSelective(ExpressInfo record);

    List<ExpressInfo> selectByExample(ExpressInfoExample example);

    ExpressInfo selectByPrimaryKey(ExpressInfoKey key);

    int updateByExampleSelective(@Param("record") ExpressInfo record, @Param("example") ExpressInfoExample example);

    int updateByExample(@Param("record") ExpressInfo record, @Param("example") ExpressInfoExample example);

    int updateByPrimaryKeySelective(ExpressInfo record);

    int updateByPrimaryKey(ExpressInfo record);
}