package zxs.ssm.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import zxs.ssm.mapper.ExpressInfoMapper;
import zxs.ssm.mapper.OrderDetailMapper;
import zxs.ssm.mapper.OrderInfoMapper;
import zxs.ssm.mapper.OrderdetailViewMapper;
import zxs.ssm.mapper.PhotedetailViewMapper;
import zxs.ssm.mapper.PhotoInfoMapper;
import zxs.ssm.po.ExpressInfo;
import zxs.ssm.po.ExpressInfoExample;
import zxs.ssm.po.OrderDetail;
import zxs.ssm.po.OrderDetailExample;
import zxs.ssm.po.OrderInfo;
import zxs.ssm.po.OrderInfoExample;
import zxs.ssm.po.OrderdetailView;
import zxs.ssm.po.OrderdetailViewExample;
import zxs.ssm.po.PhotedetailView;
import zxs.ssm.po.PhotedetailViewExample;
import zxs.ssm.po.PhotoInfo;
import zxs.ssm.po.PhotoInfoExample;
import zxs.ssm.services.OrderManageService;
import zxs.ssm.util.DataGridModel;

public class OrderManageServiceImpl  implements OrderManageService{

	@Autowired
	private OrderInfoMapper riMapper;
	@Autowired
	private ExpressInfoMapper eiMapper;
	@Autowired
	private OrderDetailMapper odMapper;
	@Autowired
	private OrderdetailViewMapper odViewMapper;
	@Autowired
	private PhotoInfoMapper piMapper;
	@Autowired
	private PhotedetailViewMapper photeDetailMapper;
	@Autowired
	HttpSession session;

	//生成订单编号
	@Override
	public String createOrderNum() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String date = sf.format(new Date());		
		String old_orderNum = riMapper.selectLastOrderNum(date);
		String orderNum = date + "001";
		if(old_orderNum !=null && !"".equals(old_orderNum)){
			int num = Integer.valueOf(old_orderNum.substring(7))+1;
			String Num = "00"+num;
			orderNum = date + Num.substring(Num.length()-3);
		}
		return orderNum;
	}
	
	 public int insert(OrderInfo record){
		 return riMapper.insert(record);
	 }

	@Override
	public int insert(OrderDetail od) {
		return odMapper.insert(od);
	}

	@Override
	public Map<String, Object> getOrderList(String beginTime,String endTime, DataGridModel dgm,
			OrderInfo orderInfo) {
		OrderInfoExample oiExample=new OrderInfoExample();
		zxs.ssm.po.OrderInfoExample.Criteria criteria=oiExample.createCriteria();
		criteria.andCreateTimeBetween(beginTime+" 00:00:00", endTime+" 23:59:59");
		if (orderInfo != null && !("".equals(orderInfo))) {
			
			if(orderInfo.getOrderZt()!=null && !("".equals(orderInfo.getOrderZt()))){
				criteria.andOrderZtEqualTo(orderInfo.getOrderZt());
			}
			if(orderInfo.getOrderType()!=null && !("".equals(orderInfo.getOrderType()))){
				criteria.andOrderTypeEqualTo(orderInfo.getOrderType());
			}
			if(orderInfo.getCustomerName()!=null && !("".equals(orderInfo.getCustomerName()))){
				criteria.andCustomerNameEqualTo(orderInfo.getCustomerName());
			}
			if(orderInfo.getTelephone1()!=null && !("".equals(orderInfo.getTelephone1()))){
				criteria.andTelephone1EqualTo(orderInfo.getTelephone1());
			}
		}
		oiExample.setOrderByClause("Order_Num desc");
		List<OrderInfo> list = riMapper.selectByExample(oiExample);
		session.setAttribute("orderList", list);
		Map<String, Object> result = new HashMap<String, Object>(2);
		int total = list.size();
		List<OrderInfo> list1 = new ArrayList<OrderInfo>();
		int start = (dgm.getPage() - 1) * dgm.getRows(), end = start + dgm.getRows();
		for (int i = start; i < end && i < total; i++) {
			list1.add(list.get(i));
		}
		result.put("total", total);
		result.put("rows", list1);
		return result;
	}
	
	@Override
	public List<OrderdetailView> getOrderDetail(String orderNum){
		List<OrderdetailView> list = new ArrayList<OrderdetailView>();
		OrderdetailViewExample odExample = new OrderdetailViewExample();
		zxs.ssm.po.OrderdetailViewExample.Criteria criteria = odExample.createCriteria();
		criteria.andOrderNumEqualTo(orderNum);
		list = odViewMapper.selectByExample(odExample);
		return list;
	}
	
	@Override
	public Map<String, Object> getOrderDetail2(DataGridModel dgm,
			OrderDetail orderDetail,String orderNum) {
	    System.out.println("天堂鸟你"+orderNum);
		OrderDetailExample odExample = new OrderDetailExample();
		zxs.ssm.po.OrderDetailExample.Criteria criteria = odExample.createCriteria();
		criteria.andOrderNumEqualTo(orderNum);
		List<OrderDetail> list = odMapper.selectByExample(odExample);
		session.setAttribute("orderList", list);
		Map<String, Object> result = new HashMap<String, Object>(2);
		
		int total = list.size();
		List<OrderDetail> list1 = new ArrayList<OrderDetail>();
		int start = (dgm.getPage() - 1) * dgm.getRows(), end = start + dgm.getRows();
		for (int i = start; i < end && i < total; i++) {
			list1.add(list.get(i));
		}
		result.put("total", total);
		result.put("rows", list1);
		return result;
	}
	
	@Override
	public Map<String, Object> getExpressInfo(DataGridModel dgm,
			OrderDetail orderDetail,String orderNum) {
	    System.out.println("天堂鸟你"+orderNum);
		ExpressInfoExample odExample = new ExpressInfoExample();
		zxs.ssm.po.ExpressInfoExample.Criteria criteria = odExample.createCriteria();
		criteria.andOrderNumEqualTo(orderNum);
		List<ExpressInfo> list = eiMapper.selectByExample(odExample);
		session.setAttribute("orderList", list);
		Map<String, Object> result = new HashMap<String, Object>(2);
		
		int total = list.size();
		List<ExpressInfo> list1 = new ArrayList<ExpressInfo>();
		int start = (dgm.getPage() - 1) * dgm.getRows(), end = start + dgm.getRows();
		for (int i = start; i < end && i < total; i++) {
			list1.add(list.get(i));
		}
		result.put("total", total);
		result.put("rows", list1);
		return result;
	}
	
	@Override
	public int updateOrderInfoByKey(OrderInfo order){
		return riMapper.updateByPrimaryKey(order);
	}
	
	@Override
	public int deleteOrderDetailByKey(String orderNum){
		return odMapper.deleteOrderDetailByOderNum(orderNum);
	}
	@Override
	public int insertExpress(ExpressInfo express){
		return eiMapper.insert(express);
	}

	@Override
	public Map<String, Object> getExpressList(String beginTime,String endTime,DataGridModel dgm,
			ExpressInfo expressInfo) {
		ExpressInfoExample eiExample = new ExpressInfoExample();
		List<ExpressInfo> list = null;
		zxs.ssm.po.ExpressInfoExample.Criteria criteria=eiExample.createCriteria();
//		criteria.andExpressZtEqualTo(0);
		criteria.andUpdateTimeBetween(beginTime+" 00:00:00", endTime+" 23:59:59");
		if (expressInfo != null && !("".equals(expressInfo))) {
			
			if(expressInfo.getOrderNum()!=null && !("".equals(expressInfo.getOrderNum()))){
				criteria.andOrderNumEqualTo(expressInfo.getOrderNum());
			}
			if(expressInfo.getExpressNum()!=null && !("".equals(expressInfo.getExpressNum()))){
				criteria.andExpressNumEqualTo(expressInfo.getExpressNum());
			}
			if(expressInfo.getExpressCompany()!=null && !("".equals(expressInfo.getExpressCompany()))){
				criteria.andExpressCompanyEqualTo(expressInfo.getExpressCompany());
			}
			if(expressInfo.getUpdateUser()!=null && !("".equals(expressInfo.getUpdateUser()))){
				criteria.andUpdateUserEqualTo(expressInfo.getUpdateUser());
			}
			if(expressInfo.getExpressZt()!=null && !("".equals(expressInfo.getExpressZt()))){
				System.out.println("expressInfo.getExpressZt()==="+expressInfo.getExpressZt());
				if("1".equals(expressInfo.getExpressZt())||expressInfo.getExpressZt()==1){
					criteria.andExpressZtEqualTo(3);
				}else{
					criteria.andExpressZtNotEqualTo(3);
				}
				
			}
		}
		list = eiMapper.selectByExample(eiExample);
		session.setAttribute("expressList", list);
		Map<String, Object> result = new HashMap<String, Object>(2);
		int total = list.size();
		List<ExpressInfo> list1 = new ArrayList<ExpressInfo>();
		
		int start = (dgm.getPage() - 1) * dgm.getRows(), end = start + dgm.getRows();
		for (int i = start; i < end && i < total; i++) {
			list1.add(list.get(i));
		}
		result.put("total", total);
		result.put("rows", list1);
		return result;
	}
	
	
	//退换货更新订单信息表
	public void updateOrderInfoByPrimaryKey(OrderInfo orderInfo){
		riMapper.updateByPrimaryKey(orderInfo);
	}
	//退换货更新快递表
	public void updateExpressInfoByPrimaryKey(ExpressInfo expressInfo){
			eiMapper.updateByPrimaryKey(expressInfo);
	}
	
	@Override
	public Map<String, Object> getPhotoList(String beginTime,String endTime,DataGridModel dgm,
			PhotedetailView photoDetail) {
		PhotedetailViewExample piExample = new PhotedetailViewExample();
		List<PhotedetailView> list = null;
		zxs.ssm.po.PhotedetailViewExample.Criteria criteria=piExample.createCriteria();
		criteria.andCommitTimeBetween(beginTime+" 00:00:00", endTime+" 23:59:59");
		if (photoDetail != null && !("".equals(photoDetail))) {
			if(photoDetail.getPhotoType()!=null && !("".equals(photoDetail.getPhotoType()))){
				criteria.andPhotoTypeEqualTo(photoDetail.getPhotoType());
			}
			if(photoDetail.getRelationNum()!=null && !("".equals(photoDetail.getRelationNum()))){
				criteria.andRelationNumEqualTo(photoDetail.getRelationNum());
			}
			if(photoDetail.getUserName()!=null && !("".equals(photoDetail.getUserName()))){
				criteria.andUserNameEqualTo(photoDetail.getUserName());
			}
			if(photoDetail.getPhotoBz()!=null && !("".equals(photoDetail.getPhotoBz()))){
				criteria.andPhotoBzLike(photoDetail.getPhotoBz());//模糊查询
			}
			if(photoDetail.getCustomerName()!=null && !("".equals(photoDetail.getCustomerName()))){
				criteria.andCustomerNameEqualTo(photoDetail.getCustomerName());
			}
			if(photoDetail.getTelephone1()!=null && !("".equals(photoDetail.getTelephone1()))){
				criteria.andTelephone1EqualTo(photoDetail.getTelephone1());
			}
		}
		list = photeDetailMapper.selectByExample(piExample);
		session.setAttribute("photoList", list);
		Map<String, Object> result = new HashMap<String, Object>(2);
		int total = list.size();
		List<PhotedetailView> list1 = new ArrayList<PhotedetailView>();
		
		int start = (dgm.getPage() - 1) * dgm.getRows(), end = start + dgm.getRows();
		for (int i = start; i < end && i < total; i++) {
			list1.add(list.get(i));
		}
		result.put("total", total);
		result.put("rows", list1);
		return result;
	}

	@Override
	public List<OrderInfo> getOrderByTelephone(String telephone) {
		OrderInfoExample oiExample = new OrderInfoExample();
		List<OrderInfo> list = null;
		zxs.ssm.po.OrderInfoExample.Criteria criteria1=oiExample.createCriteria();
		if(telephone!=null){
			criteria1.andTelephone1EqualTo(telephone);
		}
		zxs.ssm.po.OrderInfoExample.Criteria criteria2=oiExample.createCriteria();
		if(telephone!=null){
			criteria2.andTelephone2EqualTo(telephone);
		}
		oiExample.or(criteria2);
		oiExample.setOrderByClause("Create_Time desc");
		list = riMapper.selectByExample(oiExample);
		return list;
	}

	@Override
	public OrderInfo selectOrderInfoByPrimerKey(String orderNum) {
		return riMapper.selectByPrimaryKey(orderNum);
	}

	@Override
	public boolean deleteOrderInfoByKey(String orderNum) {
		try{
			riMapper.deleteByPrimaryKey(orderNum);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
