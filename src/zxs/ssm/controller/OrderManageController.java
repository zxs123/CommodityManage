package zxs.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import zxs.ssm.po.ExpressInfo;
import zxs.ssm.po.Alterinfo;
import zxs.ssm.po.Commodityinfo;
import zxs.ssm.po.CommodityinfoExample;
import zxs.ssm.po.ExpressInfoExample;
import zxs.ssm.po.OrderDetail;
import zxs.ssm.po.OrderDetailExample;
import zxs.ssm.po.OrderInfo;
import zxs.ssm.po.OrderInfoExample;
import zxs.ssm.po.OrderdetailView;
import zxs.ssm.po.PhotedetailView;
import zxs.ssm.po.PhotoInfo;
import zxs.ssm.po.Users;
import zxs.ssm.services.CommodityManageService;
import zxs.ssm.services.OrderManageService;
import zxs.ssm.services.goodsRejectService;
import zxs.ssm.util.DataGridModel;

@Controller
@RequestMapping("/orderManage")
public class OrderManageController {

	@Autowired
	private CommodityManageService cmService;
	@Autowired
	private OrderManageService rmService;
	
	@Autowired
	private goodsRejectService gdService;
	@Autowired
	HttpSession session;
		
	//新建订单
	@RequestMapping("/orderInput")
	public String marqueManage() throws Exception{
		return "orderManage/OrderInput";
	}
	
	
	//订单列表
	@RequestMapping(value="/orderList",method=RequestMethod.POST)
	@ResponseBody         
	public Map<String, Object> queryMarqueList(HttpServletRequest request, DataGridModel dgm,OrderInfo orderInfo) throws Exception{
		System.out.println("".equals(request.getParameter("beginTime")));
		String beginTime=(request.getParameter("beginTime")==null
				||"".equals(request.getParameter("beginTime"))?"1900-01-01":request.getParameter("beginTime"));
		String endTime=(request.getParameter("endTime")==null
				||"".equals(request.getParameter("endTime"))?"3000-01-01":request.getParameter("endTime"));
		System.out.println("yyyy"+beginTime+endTime);
		return rmService.getOrderList(beginTime,endTime,dgm, orderInfo);
	}
	
	//订单信息
	@RequestMapping("/orderInfo")
	public String orderInfo() throws Exception{
		return "orderManage/OrderInfo";
	}
	
	//2017-4-30添加订单信息
	@ResponseBody
	@RequestMapping(value="/saveOrder",method=RequestMethod.POST)
	private void saveOrder(HttpServletRequest request, HttpServletResponse response) {
		try {
			String flag = request.getParameter("flag");
			String customerName = request.getParameter("customerName");
			String telephone1 = request.getParameter("telephone1");
			String telephone2 = request.getParameter("telephone2");
			String address = request.getParameter("address"); 
			String orderType = request.getParameter("orderType");
			String orderNum = "";
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sf.format(new Date());
			Users user = (Users) session.getAttribute("baseUser");
			OrderInfo order = new OrderInfo();
			if("1".equals(flag)){
				orderNum = rmService.createOrderNum();
				order.setOrderNum(orderNum);
				order.setCreateTime(date);
				order.setUserId(user.getUserName());
				order.setIsSent(0);
			}else{
				orderNum = request.getParameter("orderNum");
				order = rmService.selectOrderInfoByPrimerKey(orderNum);
				if("3".equals(flag)){
					order.setIsSent(1);
					order.setSentUser(user.getUserName());
					order.setSendTime(date);;
				}
			}
			order.setIsQuery(0);
			order.setIsReturn(0);
			order.setLastUpdatetime(date);
			order.setLastUpdateuser(user.getUserName());
			order.setCustomerName(customerName);
			order.setTelephone1(telephone1);
			order.setTelephone2(telephone2);
			order.setAddress(address);
			order.setOrderType(orderType);
			order.setOrderBz("用于备注该订单是否退货、换货或者其他信息");
			if("1".equals(flag)||"2".equals(flag)){
				order.setOrderZt(1);
			}else{
				order.setOrderZt(2);
			}
			
			if("1".equals(flag)){
				rmService.insert(order);
			}else{
				rmService.updateOrderInfoByKey(order);
				rmService.deleteOrderDetailByKey(orderNum);
			}
						
			//添加订单的商品详情
			String[] commoditymarques = request.getParameterValues("commoditymarque1");
			String[] purchaseNums = request.getParameterValues("purchaseNum");	
			String[] commodityids = request.getParameterValues("commodityId");
			OrderDetail od = new OrderDetail();
			for(int i=0;i<commoditymarques.length;i++){
				System.out.println("commodityids["+i+"]==============="+commodityids[i]);
				od.setCommodityMarque(commoditymarques[i]);
				od.setOrderNum(orderNum);
				od.setCommodityNum(Integer.valueOf(purchaseNums[i]));
				od.setDetailZt(0);
				rmService.insert(od);
				if("3".equals(flag)){
					//插入库存变更表
					Commodityinfo cInfo = cmService.selectCommodityByPrimaryKey(Integer.valueOf(commodityids[i]));
					Alterinfo alterinfo=new Alterinfo();
					alterinfo.setCommodityid(Integer.valueOf(commodityids[i]));
					alterinfo.setAltertime(date);
					alterinfo.setAltertype("销售出库");
					alterinfo.setAlternum(0-Integer.valueOf(purchaseNums[i]));
					alterinfo.setAlterinventory(cInfo.getInventorynum()-Integer.valueOf(purchaseNums[i]));
					cInfo.setInventorynum(cInfo.getInventorynum()-Integer.valueOf(purchaseNums[i]));
					alterinfo.setUsername(user.getUserName());
					alterinfo.setOrderNum(orderNum);
					alterinfo.setAlterremark(" ");
					alterinfo.setZt(1);
					gdService.insertAlter(alterinfo);
					cmService.updateMarqueByPrimaryKeySelective(cInfo);
				}
			}
			
			if("3".equals(flag)){
				//添加订单的商品详情
				String[] expressNum = request.getParameterValues("expressNum");
				String[] expressCompany = request.getParameterValues("expressCompany");
				String[] expressCost = request.getParameterValues("expressCost");
				String[] updateTime = request.getParameterValues("updateTime");
				ExpressInfo express = new ExpressInfo();
				for(int i=0;i<expressNum.length;i++){
					express.setOrderNum(orderNum);
					express.setExpressNum(expressNum[i]);
					express.setExpressCompany(expressCompany[i]);
					express.setExpressCost(Double.valueOf(expressCost[i]));
					express.setUpdateTime(updateTime[i]);
					express.setUpdateUser(user.getUserName());
					express.setExpressZt(0);
					rmService.insertExpress(express);
				}
			}
			
			response.setContentType("text/html;charset=utf-8");
			//{"status":"ok" , "message":"操作成功"}
			String str = "{\"status\":\"ok\" , \"message\":\"操作成功!\"}";
			response.getWriter().write(str);
		} catch (Exception e) {
			response.setContentType("text/html;charset=utf-8");
			//{"status":"fail" , "message":"操作失败!"}
			String str = "{\"status\":\"fail\" , \"message\":\"操作失败!\"}";
			try {
				response.getWriter().write(str);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	//获取订单详情
	@ResponseBody
	@RequestMapping(value = "/getOrderDetail")
	public List<OrderdetailView> getOrderDetail(
			@RequestParam(value = "orderNum", required = true) String orderNum,
			HttpServletRequest request){
		List<OrderdetailView> list = new ArrayList<OrderdetailView>();
		try {
			System.out.println(orderNum+":"+orderNum);
			list = rmService.getOrderDetail(orderNum);
			System.out.println(list.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	//查看订单详情
    @ResponseBody
	@RequestMapping(value="/getOrderDetail2",method=RequestMethod.POST)
	public Map<String, Object> queryOrderDetail(@RequestParam String orderNum,DataGridModel dgm,OrderDetail orderDetail) throws Exception{
		return rmService.getOrderDetail2(dgm, orderDetail,orderNum);
	}
    //查看快递信息
    @ResponseBody
	@RequestMapping(value="/getExpressInfo",method=RequestMethod.POST)
	public Map<String, Object> getExpressInfo(@RequestParam String orderNum,DataGridModel dgm,OrderDetail orderDetail) throws Exception{
		return rmService.getExpressInfo(dgm, orderDetail,orderNum);
	}
    //查看照片信息
    @ResponseBody
	@RequestMapping(value="/getPhotoInfo",method=RequestMethod.POST)
	public Map<String, Object> getPhotoInfo(@RequestParam String orderNum,DataGridModel dgm,OrderDetail orderDetail) throws Exception{
		return null;
	}
	/**
	 * 退换货管理
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/goodsReject")
	public String goodsReject() throws Exception{
		return "orderManage/goodsReject";
	}
	//查询快递
	@RequestMapping(value="/expressList",method=RequestMethod.POST)
	@ResponseBody         
	public Map<String, Object> queryExpressList(HttpServletRequest request, DataGridModel dgm,ExpressInfo expressInfo) throws Exception{
		System.out.println("".equals(request.getParameter("beginTime")));
		String beginTime=(request.getParameter("beginTime")==null
				||"".equals(request.getParameter("beginTime"))?"1900-01-01":request.getParameter("beginTime"));
		String endTime=(request.getParameter("endTime")==null
				||"".equals(request.getParameter("endTime"))?"3000-01-01":request.getParameter("endTime"));
		System.out.println("yyyy"+beginTime+endTime);
		return rmService.getExpressList(beginTime,endTime,dgm, expressInfo);
	}

	/**
	 * 退换货流程
	 * @param request
	 * @param response
	 */
	@ResponseBody  
	@RequestMapping(value="/goodsRejectConfirm",method=RequestMethod.POST)
	private void goodsRejectConfirm(HttpServletRequest request, HttpServletResponse response) {
		try {
			Users user = (Users) session.getAttribute("baseUser");//获取当前操作用户
			if(user==null||"".equals(user)){
				return ;
			}
			String orderNum = request.getParameter("orderNum");
			String expressNum = request.getParameter("expressNum");
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		    java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
		    String str_date1 = formatter.format(currentTime); //将日期时间格式化  
			//更新快递表
		    ExpressInfo ei = new ExpressInfo();
			ExpressInfoExample eiExample = new ExpressInfoExample();
			zxs.ssm.po.ExpressInfoExample.Criteria criteria=eiExample.createCriteria();
			criteria.andOrderNumEqualTo(orderNum);
			criteria.andExpressNumEqualTo(expressNum);			
			ei=gdService.selectByExample(eiExample).get(0);
			ei.setExpressZt(3);
			rmService.updateExpressInfoByPrimaryKey(ei);
			//更新订单表			
			OrderInfo oi = new OrderInfo();
			OrderInfoExample oiExample = new OrderInfoExample();
			zxs.ssm.po.OrderInfoExample.Criteria criteria2=oiExample.createCriteria();
			criteria2.andOrderNumEqualTo(orderNum);
			oi=gdService.selectByExample(oiExample).get(0);
			oi.setIsReturn(1);
			oi.setReturnTime(str_date1);
			oi.setReturnUser(user.getUserName());
			oi.setOrderBz("退换货！旧订单号："+orderNum);
			oi.setOrderZt(3);
			rmService.updateOrderInfoByPrimaryKey(oi);
			
			//更新库存表,回滚库存量
			OrderDetailExample odExample = new OrderDetailExample();
			zxs.ssm.po.OrderDetailExample.Criteria criteria3=odExample.createCriteria();
			criteria3.andOrderNumEqualTo(orderNum);
			List<OrderDetail> list=new ArrayList<OrderDetail>();
			list=gdService.selectByExample(odExample);
			
			for(int i=0;i<list.size();i++){
				int goodsNum=0;
				OrderDetail od2 = list.get(i);				
				String goodsType=od2.getCommodityMarque();
				goodsNum=od2.getCommodityNum();
				Commodityinfo ci = new Commodityinfo();
				CommodityinfoExample ciExample = new CommodityinfoExample();
				zxs.ssm.po.CommodityinfoExample.Criteria criteria4=ciExample.createCriteria();
				criteria4.andCommoditymarqueEqualTo(goodsType);
				ci=gdService.selectByExample(ciExample).get(0);


				//插入库存变更表
				Alterinfo alterinfo=new Alterinfo();
				
				alterinfo.setCommodityid(ci.getCommodityid());
				
				alterinfo.setAltertime(str_date1);
				
				alterinfo.setAltertype("退货入库");
				
				alterinfo.setAlternum(goodsNum);
				
				alterinfo.setAlterinventory(ci.getInventorynum()+goodsNum);
				
				alterinfo.setUsername(user.getUserName());
				
				alterinfo.setOrderNum(orderNum);
				
				alterinfo.setAlterremark(" ");
				
				alterinfo.setZt(3);
				
				gdService.insertAlter(alterinfo);
				
				//商品表回滚库存
//				System.out.println("原库存"+ci.getInventorynum()+"变更"+goodsNum);
				ci.setInventorynum(ci.getInventorynum()+goodsNum);
//				System.out.println("变更后"+ci.getInventorynum());
				gdService.updateCi(ci);
				//同时对订单详细表做逻辑删除操作，通过DetailZt来标识
				od2.setDetailZt(3);
				gdService.updateOd(od2);
				
			}
			
		
			response.setContentType("text/html;charset=utf-8");
			String str = "{\"status\":\"ok\" , \"message\":\"操作成功!\"}";
			response.getWriter().write(str);			
		} catch (Exception e) {
			response.setContentType("text/html;charset=utf-8");
			String str = "{\"status\":\"fail\" , \"message\":\"操作失败!\"}";
			try {
				response.getWriter().write(str);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	/**
	 * 照片信息查看
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/photoInfo")
	public String photoInfo() throws Exception{
		return "orderManage/photoCheck";
	}
	/**
	 * 获取所有的照片
	 */
	@RequestMapping(value="/photoList",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getPhotoList(HttpServletRequest request,DataGridModel dgm,PhotedetailView photoDetail) throws Exception{
		System.out.println("".equals(request.getParameter("beginTime")));
		String beginTime=(request.getParameter("beginTime")==null
				||"".equals(request.getParameter("beginTime"))?"1900-01-01":request.getParameter("beginTime"));
		String endTime=(request.getParameter("endTime")==null
				||"".equals(request.getParameter("endTime"))?"3000-01-01":request.getParameter("endTime"));
		System.out.println("yyyy"+beginTime+endTime);
		return rmService.getPhotoList(beginTime,endTime,dgm, photoDetail);
	}
	
	//查询邮费
	@RequestMapping("/expressCost")
	public String expressCost() throws Exception{
		return "orderManage/expressCost";
	}
	
	//上传图片
	@ResponseBody  
	@RequestMapping(value="/picUpload",method=RequestMethod.POST)
	private ModelAndView picUpload(@RequestParam(value = "myfiles") MultipartFile file,HttpServletRequest request, HttpServletResponse response) {
		try {
			String flag=request.getParameter("flag");
			System.out.println("开始");
			String filePath = request.getSession().getServletContext()  
	                 .getRealPath("/") + "upload/" + file.getOriginalFilename();  
	             System.out.println(filePath);  
	             File saveDir = new File(filePath);  
	             if (!saveDir.getParentFile().exists())  
	                 saveDir.getParentFile().mkdirs();  
	              System.err.println(filePath);  
	             // 转存文件  
	             file.transferTo(saveDir);
	             
	             //插入照片表
	             PhotoInfo photoInfo=new PhotoInfo();
	             Users user = (Users) session.getAttribute("baseUser");//获取当前操作用户
	         	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			    java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
			    String str_date1 = formatter.format(currentTime); //将日期时间格式化
	             photoInfo.setCommitTime(str_date1);
	             photoInfo.setPhoto("/upload/" + file.getOriginalFilename());
	             photoInfo.setUserName(user.getUserName());
	             photoInfo.setPhotoZt(1);
	             System.out.println("标志"+flag);
	             if(flag.equals("1")){
	            	 System.out.println("订单");
	            	 photoInfo.setPhotoBz("订单照片");
		             //用photoType来区分照片类型1、订单照片2、变更照片3、快递照片
		             photoInfo.setPhotoType("1");
		             photoInfo.setOrderNum(request.getParameter("orderNum"));
		             photoInfo.setRelationNum(request.getParameter("orderNum")); 
	             }
	             else if(flag.equals("2")){
	            	 System.out.println("快递");
	            	 photoInfo.setPhotoBz("快递照片");
		             //用photoType来区分照片类型1、订单照片2、变更照片3、快递照片
		             photoInfo.setPhotoType("3");
		             photoInfo.setOrderNum(request.getParameter("orderNum"));
		             photoInfo.setRelationNum(request.getParameter("expressNum")); 
	             }
	             
	             
	             cmService.insertPhoto(photoInfo);
	             response.setContentType("text/html;charset=utf-8");
	 			//{"status":"fail" , "message":"操作失败!"}
	             return new ModelAndView("redirect:/orderManage/orderInfo.action");

//	 			try {
//	 				//response.getWriter().write(str);
//	 			} catch (IOException e1) {
//	 				e1.printStackTrace();
//	 			}
		} catch (Exception e) {
		
			e.printStackTrace();
		} 
		return new ModelAndView("redirect:/orderManage/orderInfo.action");
	}   
	
	/**
	 * 客户查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/customerQuery")
	public String customerQuery() throws Exception{
		return "customer/customerQuery";
	}
	
	/**
	 * 查询结果
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/comfirmOrderInfo")
	public String comfirmOrderInfo(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		String telephone = request.getParameter("telephone");
		String type = request.getParameter("type");
		if(telephone == null || "".equals(telephone)||telephone.length() == 0){
			return "customer/noResult";
		}
		List<OrderInfo> orderlist = rmService.getOrderByTelephone(telephone);		
		OrderInfo oi1 = orderlist.get(0);
		if("1".equals(type)){
			oi1.setIsQuery(1);
			rmService.updateOrderInfoByKey(oi1);
		}
		model.addAttribute("orderlist",orderlist);
		return "customer/queryResult";
	}
	
	/**
	 * 查询结果
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryResult")
	public String queryResult(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		String telephone = request.getParameter("telephone");
		System.out.println(telephone);
		if(telephone == null || "".equals(telephone)||telephone.length() == 0){
			return "customer/noResult";
		}
		List<OrderInfo> orderlist = rmService.getOrderByTelephone(telephone);
		if(orderlist == null || "".equals(orderlist)||orderlist.size() == 0){
			return "customer/noResult";
		}else{
			OrderInfo oi1 = orderlist.get(0);
			if(oi1.getIsQuery()==0 && oi1.getIsSent()==0){
				model.addAttribute("OrderInfo",oi1);
				List<OrderdetailView> list = rmService.getOrderDetail(oi1.getOrderNum());
				model.addAttribute("orderDetailList",list);
				return "customer/confirmOrderInfo";
			}else{
				model.addAttribute("orderlist",orderlist);
				return "customer/queryResult";
			}
		}
	}
	
	/*
	 * 删除订单2017-09-10
	 * 梦想工作室
	 */
	@RequestMapping(value="/deleteOrder",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deleteOrder(@RequestParam("orderNum") String orderNum)throws Exception{
		//spring mvc 还可以将参数绑定为list类型
		System.out.println("orderNum===="+orderNum);
		Map<String, String> map = new HashMap<String, String>();
		try {
			if(rmService.deleteOrderInfoByKey(orderNum)){
				rmService.deleteOrderDetailByKey(orderNum);
			}
			map.put("mes", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
			throw e;
		}
		return map;//重定向
	}
	
	//2016-4-30更新商品信息
	@ResponseBody  
	@RequestMapping(value="/updateExpress",method=RequestMethod.POST)
	private void updateExpress(HttpServletRequest request, HttpServletResponse response) {
		try {
			Users user = (Users) session.getAttribute("baseUser");//获取当前操作用户
			String orderNum_old= request.getParameter("orderNum_old");
			String expressNum_old = request.getParameter("expressNum_old");
			
			ExpressInfoExample eiExample = new ExpressInfoExample();
			zxs.ssm.po.ExpressInfoExample.Criteria criteria=eiExample.createCriteria();
			criteria.andOrderNumEqualTo(orderNum_old);
			criteria.andExpressNumEqualTo(expressNum_old);
			gdService.deleteByExample(eiExample);
			
			String expressNum = request.getParameter("expressNum");
			String expressCompany = request.getParameter("expressCompany");
			String expressCost = request.getParameter("expressCost");  
			ExpressInfo express = new ExpressInfo();
			express.setOrderNum(orderNum_old);
			express.setExpressNum(expressNum);
			express.setExpressCompany(expressCompany);
			express.setExpressCost(Double.valueOf(expressCost));
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sf.format(new Date());
			express.setUpdateTime(date);
			express.setUpdateUser(user.getUserName());
			express.setExpressZt(0);
			rmService.insertExpress(express);
			response.setContentType("text/html;charset=utf-8");
			String str = "{\"status\":\"ok\" , \"message\":\"操作成功!\"}";
			response.getWriter().write(str);			
		} catch (Exception e) {
			response.setContentType("text/html;charset=utf-8");
			String str = "{\"status\":\"fail\" , \"message\":\"操作失败!\"}";
			try {
				response.getWriter().write(str);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}	
}
