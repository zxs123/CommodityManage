package zxs.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zxs.ssm.po.OrderdetailView;
import zxs.ssm.po.OrderdetailViewExample;

public interface OrderdetailViewMapper {
    int countByExample(OrderdetailViewExample example);

    int deleteByExample(OrderdetailViewExample example);

    int insert(OrderdetailView record);

    int insertSelective(OrderdetailView record);

    List<OrderdetailView> selectByExample(OrderdetailViewExample example);

    int updateByExampleSelective(@Param("record") OrderdetailView record, @Param("example") OrderdetailViewExample example);

    int updateByExample(@Param("record") OrderdetailView record, @Param("example") OrderdetailViewExample example);
}