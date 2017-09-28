package zxs.ssm.services;

import java.util.Map;

import zxs.ssm.po.Users;
import zxs.ssm.util.DataGridModel;

public interface UsersManageService {

	Map<String, Object> getPageList(DataGridModel dgm,Users user) throws Exception;
	
}
