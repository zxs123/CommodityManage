package zxs.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zxs.ssm.mapper.AlterinfoMapper;
import zxs.ssm.mapper.CommodityinfoMapper;
import zxs.ssm.mapper.ExpressInfoMapper;
import zxs.ssm.mapper.OrderDetailMapper;
import zxs.ssm.mapper.OrderInfoMapper;
import zxs.ssm.po.Alterinfo;
import zxs.ssm.po.Commodityinfo;
import zxs.ssm.po.CommodityinfoExample;
import zxs.ssm.po.ExpressInfo;
import zxs.ssm.po.ExpressInfoExample;
import zxs.ssm.po.OrderDetail;
import zxs.ssm.po.OrderDetailExample;
import zxs.ssm.po.OrderInfo;
import zxs.ssm.po.OrderInfoExample;
import zxs.ssm.services.goodsRejectService;

public class goodsRejectServiceImpl implements goodsRejectService {
	@Autowired
	ExpressInfoMapper eiMapper ;
	@Autowired
	OrderInfoMapper oiMapper ;
	@Autowired
	OrderDetailMapper odMapper ;
	@Autowired
	CommodityinfoMapper ciMapper ;
	@Autowired
	AlterinfoMapper aiMapper;
	
	
	@Override
	public List<ExpressInfo> selectByExample(ExpressInfoExample eiExample) {
		// TODO Auto-generated method stub
		return eiMapper.selectByExample(eiExample);
	}

	@Override
	public List<OrderInfo> selectByExample(OrderInfoExample oiExample) {
		// TODO Auto-generated method stub
		return oiMapper.selectByExample(oiExample);
	}

	@Override
	public List<OrderDetail> selectByExample(OrderDetailExample odExample) {
		// TODO Auto-generated method stub
		return odMapper.selectByExample(odExample);
	}

	@Override
	public List<Commodityinfo> selectByExample(CommodityinfoExample ciExample) {
		// TODO Auto-generated method stub
		return ciMapper.selectByExample(ciExample);
	}

	@Override
	public void updateCi(Commodityinfo ci) {
		// TODO Auto-generated method stub
		ciMapper.updateByPrimaryKey(ci);

	}

	@Override
	public void updateOd(OrderDetail od) {
		// TODO Auto-generated method stub
		odMapper.updateByPrimaryKey(od);

	}

	@Override
	public void insertAlter(Alterinfo ai) {
		// TODO Auto-generated method stub
		aiMapper.insert(ai);
	}

	@Override
	public void deleteByExample(ExpressInfoExample eiExample) {
		// TODO Auto-generated method stub
		eiMapper.deleteByExample(eiExample);
	}
	
	

}
