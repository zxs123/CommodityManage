package zxs.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zxs.ssm.po.FunctionModule;
import zxs.ssm.po.FunctionModuleExample;

public interface FunctionModuleMapper {
    int countByExample(FunctionModuleExample example);

    int deleteByExample(FunctionModuleExample example);

    int deleteByPrimaryKey(Integer fmId);

    int insert(FunctionModule record);

    int insertSelective(FunctionModule record);

    List<FunctionModule> selectByExample(FunctionModuleExample example);

    FunctionModule selectByPrimaryKey(Integer fmId);

    int updateByExampleSelective(@Param("record") FunctionModule record, @Param("example") FunctionModuleExample example);

    int updateByExample(@Param("record") FunctionModule record, @Param("example") FunctionModuleExample example);

    int updateByPrimaryKeySelective(FunctionModule record);

    int updateByPrimaryKey(FunctionModule record);
    
    List<FunctionModule> selectAll();
}