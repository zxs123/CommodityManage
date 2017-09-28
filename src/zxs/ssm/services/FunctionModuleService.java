package zxs.ssm.services;

import java.util.List;

import zxs.ssm.po.FunctionModule;
import zxs.ssm.po.FunctionModuleExample;

public interface FunctionModuleService {

	public List<FunctionModule> selectAll();
	
	public List<FunctionModule> selectByExample(FunctionModuleExample example);
	
	public FunctionModule selectByPrimaryKey(Integer fmId);
	
}
