package zxs.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zxs.ssm.po.PhotoInfo;
import zxs.ssm.po.PhotoInfoExample;

public interface PhotoInfoMapper {
    int countByExample(PhotoInfoExample example);

    int deleteByExample(PhotoInfoExample example);

    int deleteByPrimaryKey(Integer photoId);

    int insert(PhotoInfo record);

    int insertSelective(PhotoInfo record);

    List<PhotoInfo> selectByExample(PhotoInfoExample example);

    PhotoInfo selectByPrimaryKey(Integer photoId);

    int updateByExampleSelective(@Param("record") PhotoInfo record, @Param("example") PhotoInfoExample example);

    int updateByExample(@Param("record") PhotoInfo record, @Param("example") PhotoInfoExample example);

    int updateByPrimaryKeySelective(PhotoInfo record);

    int updateByPrimaryKey(PhotoInfo record);
}