package zxs.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zxs.ssm.po.Inventoryinfo;
import zxs.ssm.po.InventoryinfoExample;

public interface InventoryinfoMapper {
    int countByExample(InventoryinfoExample example);

    int deleteByExample(InventoryinfoExample example);

    int deleteByPrimaryKey(Integer commodityid);

    int insert(Inventoryinfo record);

    int insertSelective(Inventoryinfo record);

    List<Inventoryinfo> selectByExample(InventoryinfoExample example);

    Inventoryinfo selectByPrimaryKey(Integer commodityid);

    int updateByExampleSelective(@Param("record") Inventoryinfo record, @Param("example") InventoryinfoExample example);

    int updateByExample(@Param("record") Inventoryinfo record, @Param("example") InventoryinfoExample example);

    int updateByPrimaryKeySelective(Inventoryinfo record);

    int updateByPrimaryKey(Inventoryinfo record);
}