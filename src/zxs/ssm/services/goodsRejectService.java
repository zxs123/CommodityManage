package zxs.ssm.services;

import java.util.List;

import zxs.ssm.po.Alterinfo;
import zxs.ssm.po.Commodityinfo;
import zxs.ssm.po.CommodityinfoExample;
import zxs.ssm.po.ExpressInfoExample;
import zxs.ssm.po.ExpressInfo;
import zxs.ssm.po.OrderDetail;
import zxs.ssm.po.OrderDetailExample;
import zxs.ssm.po.OrderInfo;
import zxs.ssm.po.OrderInfoExample;


public interface goodsRejectService {
	public List<ExpressInfo> selectByExample(ExpressInfoExample eiExample);
	public List<OrderInfo> selectByExample(OrderInfoExample oiExample);
	public List<OrderDetail> selectByExample(OrderDetailExample odExample);
	public List<Commodityinfo> selectByExample(CommodityinfoExample ciExample);
	public void updateCi(Commodityinfo ci);
	public void updateOd(OrderDetail od);
	public void insertAlter(Alterinfo ai);
	public void deleteByExample(ExpressInfoExample eiExample);
}
