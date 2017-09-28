package zxs.ssm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import zxs.ssm.mapper.UsersmanageMapper;
import zxs.ssm.po.Users;
import zxs.ssm.po.Usersmanage;
import zxs.ssm.po.UsersmanageExample;
import zxs.ssm.po.UsersmanageExample.Criteria;
import zxs.ssm.services.UsersManageService;
import zxs.ssm.util.DataGridModel;

public class UsersManageServiceImpl implements UsersManageService{

	@Autowired
	private UsersmanageMapper umMapper;
	
	@Override
	public Map<String, Object> getPageList(DataGridModel dgm, Users user) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>(2);
		List<Usersmanage> list = null;
		if (user != null && !("".equals(user))) {
			UsersmanageExample umExample = new UsersmanageExample();
			Criteria criteria = umExample.createCriteria();
			if(user.getUserId()!=null && !("".equals(user.getUserId()))){
				criteria.andUserIdEqualTo(user.getUserId());
			}
			if(user.getUserName()!=null && !("".equals(user.getUserName()))){
				criteria.andUserNameEqualTo(user.getUserName());
			}
			if(user.getUserDep()!=null && !("".equals(user.getUserDep()))){
				criteria.andDepIdEqualTo(user.getUserDep());
			}
			if(user.getUserRname()!=null && !("".equals(user.getUserRname())) && !("kongbai".equals(user.getUserRname()))){

				criteria.andUserRnameEqualTo(user.getUserRname());
			}
			list = umMapper.selectByExample(umExample);
		}else{
			list = umMapper.selectByExample(null);
		}
		int total = list.size();
		List<Usersmanage> list1 = new ArrayList<Usersmanage>();
		int start = (dgm.getPage() - 1) * dgm.getRows(), end = start + dgm.getRows();
		for (int i = start; i < end && i < total; i++) {
			list1.add(list.get(i));
		}
		result.put("total", total);
		result.put("rows", list1);
		return result;
	}

}
