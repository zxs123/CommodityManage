package zxs.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zxs.ssm.po.PhotedetailView;
import zxs.ssm.po.PhotedetailViewExample;

public interface PhotedetailViewMapper {
    int countByExample(PhotedetailViewExample example);

    int deleteByExample(PhotedetailViewExample example);

    int insert(PhotedetailView record);

    int insertSelective(PhotedetailView record);

    List<PhotedetailView> selectByExample(PhotedetailViewExample example);

    int updateByExampleSelective(@Param("record") PhotedetailView record, @Param("example") PhotedetailViewExample example);

    int updateByExample(@Param("record") PhotedetailView record, @Param("example") PhotedetailViewExample example);
}