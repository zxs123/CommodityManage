package zxs.ssm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import zxs.ssm.mapper.SystemroleMapper;
import zxs.ssm.po.Systemrole;
import zxs.ssm.po.SystemroleExample;
import zxs.ssm.po.SystemroleExample.Criteria;
import zxs.ssm.po.Users;
import zxs.ssm.services.SystemRoleService;
import zxs.ssm.util.DataGridModel;

public class SystemRoleServiceImpl implements SystemRoleService{

	@Autowired
	private SystemroleMapper srMapper;
	
	@Override
	public int countByExample(SystemroleExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(SystemroleExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer srId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Systemrole record) {
		return srMapper.insert(record);
	}

	@Override
	public int insertSelective(Systemrole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Systemrole> selectByExample(SystemroleExample example) {
		return srMapper.selectByExample(null);
	}

	@Override
	public Systemrole selectByPrimaryKey(Integer srId) {
		return srMapper.selectByPrimaryKey(srId);
	}

	@Override
	public int updateByExampleSelective(Systemrole record,
			SystemroleExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Systemrole record, SystemroleExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Systemrole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Systemrole record) {
		return srMapper.updateByPrimaryKey(record);
	}

	@Override
	public Map<String, Object> getPageList(DataGridModel dgm, Users user) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		System.out.println("Page:" + dgm.getPage() + ",Rows:" + dgm.getRows());
		List<Systemrole> list = null;
		list = srMapper.selectByExample(null);
		int total = list.size();
		List<Systemrole> list1 = new ArrayList<Systemrole>();
		int start = (dgm.getPage() - 1) * dgm.getRows(), end = start + dgm.getRows();
		for (int i = start; i < end && i < total; i++) {
			list1.add(list.get(i));
		}
		result.put("total", total);
		result.put("rows", list1);
		return result;
	}

	@Override
	public void deleteRole(List<String> srId) {
		if (srId != null && srId.size() > 0) {
			for (String srid : srId) {
				srMapper.deleteByPrimaryKey(Integer.valueOf(srid));
			}
		}
		
	}

	//根据角色名称查找角色编号
	@Override
	public int selectRoleIdByName(String roleName) {
		SystemroleExample srExample = new SystemroleExample();
		Criteria criteria = srExample.createCriteria();
		criteria.andSrNameEqualTo(roleName);
		System.out.println("角色名称为：：：："+roleName);
		List<Systemrole> list = srMapper.selectByExample(srExample);
		int roleId = 0;
		if(list!=null){
			for(int i=0;i<list.size();i++){
				roleId = list.get(i).getSrId();
			}
		}
		return roleId;
	}

	//根据角色id查找角色名称
	@Override
	public String selectNameById(Integer userPosition) {
		Systemrole role = srMapper.selectByPrimaryKey(userPosition);
		return role.getSrName();
	}

	
	
}
