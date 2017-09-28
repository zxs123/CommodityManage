package zxs.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import zxs.ssm.mapper.DepartmentMapper;
import zxs.ssm.po.Department;
import zxs.ssm.po.DepartmentExample;
import zxs.ssm.po.DepartmentExample.Criteria;
import zxs.ssm.services.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentMapper dmMapper;
	@Autowired
	private DepartmentMapper depMapper;

	@Override
	public List<String> selectDepNameList() {
		List<String> dmList = dmMapper.selectDepNameList();
		return dmList;
	}

	@Override
	public Map<String, Object> getAllJson() throws Exception {
		Map<String, Object> result = new HashMap<String, Object>(2);
		List<Department> list = dmMapper.selectByExample(null);
		result.put("total", list==null ? 0 : list.size());
		result.put("rows", list);
		return result;
	}

	@Override
	public List<Department> selectByExample(DepartmentExample example) {
		List<Department> dmList = dmMapper.selectByExample(example);
		return dmList;
	}

	
	//根据部门名称查找id
	@Override
	public String getDepIdByName(String depName) {
		DepartmentExample depExample = new DepartmentExample();
		Criteria criteria = depExample.createCriteria();
		criteria.andDepNameEqualTo(depName);
		List<Department> depList = depMapper.selectByExample(depExample);
		String depId = "";
		for(int i=0; i<depList.size(); i++){
			depId = depList.get(i).getDepId();
		}
		return depId;
	}

	//根据部门id查找部门名称
	@Override
	public String selectNameById(String userDep) {
		Department dep = depMapper.selectByPrimaryKey(userDep);
		return dep.getDepName();
	}

}
