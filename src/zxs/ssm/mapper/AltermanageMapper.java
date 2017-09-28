package zxs.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zxs.ssm.po.Altermanage;
import zxs.ssm.po.AltermanageExample;

public interface AltermanageMapper {
    int countByExample(AltermanageExample example);

    int deleteByExample(AltermanageExample example);

    int insert(Altermanage record);

    int insertSelective(Altermanage record);

    List<Altermanage> selectByExample(AltermanageExample example);

    int updateByExampleSelective(@Param("record") Altermanage record, @Param("example") AltermanageExample example);

    int updateByExample(@Param("record") Altermanage record, @Param("example") AltermanageExample example);
}