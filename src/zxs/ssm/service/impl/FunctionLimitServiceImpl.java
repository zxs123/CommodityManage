package zxs.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zxs.ssm.mapper.FunctionlimitMapper;
import zxs.ssm.po.Functionlimit;
import zxs.ssm.po.FunctionlimitExample;
import zxs.ssm.po.FunctionlimitExample.Criteria;
import zxs.ssm.services.FunctionLimitService;

public class FunctionLimitServiceImpl implements FunctionLimitService{

	@Autowired
	private FunctionlimitMapper flMapper;
	
	@Override
	public int countByExample(FunctionlimitExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(FunctionlimitExample example) {
		return flMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer flId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Functionlimit record) {
		return flMapper.insert(record);
	}

	@Override
	public int insertSelective(Functionlimit record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Functionlimit> selectByExample(FunctionlimitExample example) {
		List<Functionlimit> list = flMapper.selectByExample(example);
		return list;
	}

	@Override
	public Functionlimit selectByPrimaryKey(Integer flId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(Functionlimit record, FunctionlimitExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Functionlimit record, FunctionlimitExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Functionlimit record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Functionlimit record) {
		return flMapper.updateByPrimaryKey(record);
	}

	@SuppressWarnings("null")
	@Override
	//通过fl_roleid和fl_fmid查询记录是否存在
	public int findRecord(int roleId, int fmId) {
		FunctionlimitExample flExample = new FunctionlimitExample();
		Criteria criteria = flExample.createCriteria();
		criteria.andFlRoleidEqualTo(roleId);
		criteria.andFlFmidEqualTo(fmId);
		List<Functionlimit> list = flMapper.selectByExample(flExample);
		if(list!=null||list.size()>0){
			return list.size();
		}else{
			return 0;
		}
	}

}
