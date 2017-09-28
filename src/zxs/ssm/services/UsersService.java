package zxs.ssm.services;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import zxs.ssm.po.Users;
import zxs.ssm.po.UsersExample;
import zxs.ssm.util.DataGridModel;

public interface UsersService {
	int countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(String userId);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    
	public Users selectByIdAndPass(Users record);
	
	
	//下面是自己添加的函数
	Map<String, Object> getPageList(DataGridModel dgm,Users user) throws Exception;
	
	void deleteUsers(List<String> usersId) throws Exception;

	//查找企业发展部领导和院长工作部领导
	List<String> selectUsersId();
	
}
