package zxs.ssm.services;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import zxs.ssm.po.Systemrole;
import zxs.ssm.po.SystemroleExample;
import zxs.ssm.po.Users;
import zxs.ssm.util.DataGridModel;

public interface SystemRoleService {

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

	Map<String, Object> getPageList(DataGridModel dgm, Users user);

	//自定义函数
	void deleteRole(List<String> srId);

	int selectRoleIdByName(String userPosition);

	String selectNameById(Integer userPosition);
	
}
