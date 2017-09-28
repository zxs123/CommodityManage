package zxs.ssm.services;

import java.util.List;
import java.util.Map;
import zxs.ssm.po.ExpressInfo;
import zxs.ssm.po.OrderDetail;
import zxs.ssm.po.OrderInfo;
import zxs.ssm.po.OrderdetailView;
import zxs.ssm.po.PhotedetailView;
import zxs.ssm.po.PhotoInfo;
import zxs.ssm.util.DataGridModel;

public interface OrderManageService {

	String createOrderNum();   //生成订单编号
	
	int insert(OrderInfo order);

	int insert(OrderDetail od);

	Map<String, Object> getOrderList(String beginTime,String endTime,DataGridModel dgm, OrderInfo orderInfo);
	
	List<OrderdetailView> getOrderDetail(String orderNum);
	
	Map<String, Object> getOrderDetail2(DataGridModel dgm,OrderDetail orderDetail,String orderNum);
	
	Map<String, Object> getExpressInfo(DataGridModel dgm,OrderDetail orderDetail,String orderNum);
	
	int updateOrderInfoByKey(OrderInfo order);
	
	int deleteOrderDetailByKey(String orderNum);
	
	int insertExpress(ExpressInfo express);

	Map<String, Object> getExpressList(String beginTime,String endTime,DataGridModel dgm, ExpressInfo expressInfo);
	
	void updateOrderInfoByPrimaryKey(OrderInfo orderInfo);
	
	void updateExpressInfoByPrimaryKey(ExpressInfo expressInfo);
	
	Map<String, Object> getPhotoList(String beginTime,String endTime,DataGridModel dgm, PhotedetailView photoDetail);

	List<OrderInfo> getOrderByTelephone(String telephone);

	OrderInfo selectOrderInfoByPrimerKey(String orderNum);

	boolean deleteOrderInfoByKey(String orderNum);



}
