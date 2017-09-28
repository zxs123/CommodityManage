package zxs.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zxs.ssm.mapper.FunctionModuleMapper;
import zxs.ssm.po.FunctionModule;
import zxs.ssm.po.FunctionModuleExample;
import zxs.ssm.services.FunctionModuleService;

public class FunctionModuleServiceImpl implements FunctionModuleService {

	@Autowired
	private FunctionModuleMapper fmMapper;
	
	@Override
	public List<FunctionModule> selectAll() {
		List<FunctionModule> list = fmMapper.selectAll();
		return list;
	}

	@Override
	public List<FunctionModule> selectByExample(FunctionModuleExample example) {
		List<FunctionModule> list = fmMapper.selectByExample(example);
		return list;
	}

	@Override
	public FunctionModule selectByPrimaryKey(Integer fmId) {
		FunctionModule fm = fmMapper.selectByPrimaryKey(fmId);
		return fm;
	}

}
