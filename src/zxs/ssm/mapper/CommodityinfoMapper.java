package zxs.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zxs.ssm.po.Commodityinfo;
import zxs.ssm.po.CommodityinfoExample;

public interface CommodityinfoMapper {
    int countByExample(CommodityinfoExample example);

    int deleteByExample(CommodityinfoExample example);

    int deleteByPrimaryKey(Integer commodityid);

    int insert(Commodityinfo record);

    int insertSelective(Commodityinfo record);

    List<Commodityinfo> selectByExample(CommodityinfoExample example);

    Commodityinfo selectByPrimaryKey(Integer commodityid);

    int updateByExampleSelective(@Param("record") Commodityinfo record, @Param("example") CommodityinfoExample example);

    int updateByExample(@Param("record") Commodityinfo record, @Param("example") CommodityinfoExample example);

    int updateByPrimaryKeySelective(Commodityinfo record);

    int updateByPrimaryKey(Commodityinfo record);
}