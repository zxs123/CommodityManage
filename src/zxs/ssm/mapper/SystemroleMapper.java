package zxs.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zxs.ssm.po.Systemrole;
import zxs.ssm.po.SystemroleExample;

public interface SystemroleMapper {
    int countByExample(SystemroleExample example);

    int deleteByExample(SystemroleExample example);

    int deleteByPrimaryKey(Integer srId);

    int insert(Systemrole record);

    int insertSelective(Systemrole record);

    List<Systemrole> selectByExample(SystemroleExample example);

    Systemrole selectByPrimaryKey(Integer srId);

    int updateByExampleSelective(@Param("record") Systemrole record, @Param("example") SystemroleExample example);

    int updateByExample(@Param("record") Systemrole record, @Param("example") SystemroleExample example);

    int updateByPrimaryKeySelective(Systemrole record);

    int updateByPrimaryKey(Systemrole record);
}