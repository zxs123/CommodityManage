package zxs.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zxs.ssm.po.Alterinfo;
import zxs.ssm.po.AlterinfoExample;

public interface AlterinfoMapper {
    int countByExample(AlterinfoExample example);

    int deleteByExample(AlterinfoExample example);

    int deleteByPrimaryKey(Integer alterid);

    int insert(Alterinfo record);

    int insertSelective(Alterinfo record);

    List<Alterinfo> selectByExample(AlterinfoExample example);

    Alterinfo selectByPrimaryKey(Integer alterid);

    int updateByExampleSelective(@Param("record") Alterinfo record, @Param("example") AlterinfoExample example);

    int updateByExample(@Param("record") Alterinfo record, @Param("example") AlterinfoExample example);

    int updateByPrimaryKeySelective(Alterinfo record);

    int updateByPrimaryKey(Alterinfo record);
}