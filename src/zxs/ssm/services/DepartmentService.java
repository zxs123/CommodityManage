package zxs.ssm.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import zxs.ssm.po.Department;
import zxs.ssm.po.DepartmentExample;

@Service
public interface DepartmentService {

	List<String> selectDepNameList();
	List<Department> selectByExample(DepartmentExample example);
	Map<String, Object> getAllJson() throws Exception ;
	String getDepIdByName(String string);
	String selectNameById(String userDep);
}
