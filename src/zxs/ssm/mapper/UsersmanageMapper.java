package zxs.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zxs.ssm.po.Usersmanage;
import zxs.ssm.po.UsersmanageExample;

public interface UsersmanageMapper {
    int countByExample(UsersmanageExample example);

    int deleteByExample(UsersmanageExample example);

    int insert(Usersmanage record);

    int insertSelective(Usersmanage record);

    List<Usersmanage> selectByExample(UsersmanageExample example);

    int updateByExampleSelective(@Param("record") Usersmanage record, @Param("example") UsersmanageExample example);

    int updateByExample(@Param("record") Usersmanage record, @Param("example") UsersmanageExample example);
}