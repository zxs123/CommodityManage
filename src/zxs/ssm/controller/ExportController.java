package zxs.ssm.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import zxs.ssm.bean.AlterList;
import zxs.ssm.bean.CommodityList;
import zxs.ssm.bean.OrderList;
import zxs.ssm.po.Altermanage;
import zxs.ssm.po.Commodityinfo;
import zxs.ssm.po.OrderInfo;
import zxs.ssm.po.OrderdetailView;
import zxs.ssm.services.OrderManageService;
import zxs.ssm.util.ExportExcel;

@Controller
@RequestMapping("/exportExcel")
public class ExportController {

	@Autowired
	private OrderManageService omService;
	@Autowired
	HttpSession session;

	//2017-4-30导出商品信息
	@SuppressWarnings("unchecked")
	@ResponseBody  
	@RequestMapping(value="/exportMarque",method=RequestMethod.POST)
	private void exportMarque(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		try {
			List<Commodityinfo> marquelist =  (List<Commodityinfo>) session.getAttribute("marqueList");
			File dir = new File("D:\\CommodityManageExport");  
	        if (!dir.exists()) {  
	            dir.mkdirs();  
	        }
	        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd_hhmmss");   
			String date = sDateFormat.format(new Date());   //获取当前时间
			String filePath = dir+"\\商品信息"+date+".xls";
			ExportExcel<CommodityList> ex = new ExportExcel<CommodityList>();
			List<CommodityList> dataset = new ArrayList<CommodityList>();
			String[] headers = { "商品型号", "商品名称", "商品类型", "商品规格","库存量","商品单位","是否启用" };
			for(int i=0;i<marquelist.size();i++){
				CommodityList cList = new CommodityList();
				cList.setCommoditymarque(marquelist.get(i).getCommoditymarque());
				cList.setCommodityname(marquelist.get(i).getCommodityname());
				cList.setCommodityscale(marquelist.get(i).getCommodityscale());
				cList.setCommoditytype(marquelist.get(i).getCommoditytype());
				cList.setCommodityunit(marquelist.get(i).getCommodityunit());
				cList.setInventorynum(marquelist.get(i).getInventorynum());
				if(marquelist.get(i).getQiyong()==1){
					cList.setQiyong("已启用");
				}else{
					cList.setQiyong("未启用");
				}
				dataset.add(cList);
			}
			OutputStream out = new FileOutputStream(filePath);
			ex.exportExcel(headers, dataset, out);
			out.close();
			ex.download(filePath, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//2017-4-30导出库存变更信息
	@SuppressWarnings("unchecked")
	@ResponseBody  
	@RequestMapping(value="/exportAlter",method=RequestMethod.POST)
	private void exportAlter(HttpServletRequest request, HttpServletResponse response)throws IOException  {
		try {
			List<Altermanage> alterList =  (List<Altermanage>) session.getAttribute("alterList");
			File dir = new File("D:\\CommodityManageExport");  
	        if (!dir.exists()) {  
	            dir.mkdirs();  
	        }
	        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd_hhmmss");   
			String date = sDateFormat.format(new Date());   //获取当前时间
			String filePath = dir+"\\库存变更信息"+date+".xls";
			ExportExcel<AlterList> ex = new ExportExcel<AlterList>();
			List<AlterList> dataset = new ArrayList<AlterList>();
			String[] headers = {"商品型号", "商品名称", "变更时间", "变更类型","变更数量","变更后库存量","商品单位","变更人员","备注"};
			for(int i=0;i<alterList.size();i++){
				AlterList aList = new AlterList();
				aList.setCommoditymarque(alterList.get(i).getCommoditymarque());
				aList.setCommodityname(alterList.get(i).getCommodityname());
				aList.setAltertime(alterList.get(i).getAltertime());
				aList.setAlternum(alterList.get(i).getAlternum());
				aList.setAltertype(alterList.get(i).getAltertype());
				aList.setAlterinventory(alterList.get(i).getAlterinventory());
				aList.setUserName(alterList.get(i).getUsername());
				aList.setAlterremark(alterList.get(i).getAlterremark()+" ");
				aList.setCommodityunit(alterList.get(i).getCommodityunit());
				dataset.add(aList);
			}
			OutputStream out = new FileOutputStream(filePath);
			ex.exportExcel(headers, dataset, out);
			out.close();
			ex.download(filePath, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//2017-07-02导出库存变更信息
	@SuppressWarnings("unchecked")
	@ResponseBody  
	@RequestMapping(value="/exportOrder",method=RequestMethod.POST)
	private void exportOrder(HttpServletRequest request, HttpServletResponse response)throws IOException  {
		try {
			List<OrderInfo> orderList = (List<OrderInfo>) session.getAttribute("orderList");
			System.out.println("orderList"+orderList);
			File dir = new File("D:\\CommodityManageExport");  
	        if (!dir.exists()) {  
	            dir.mkdirs();  
	        }
	        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmss");   
			String date = sDateFormat.format(new Date());   //获取当前时间
			String filePath = dir+"\\订单信息"+date+".xls";
			ExportExcel<OrderList> ex = new ExportExcel<OrderList>();
			List<OrderList> dataset = new ArrayList<OrderList>();
			String[] headers = {"五四打印助手批量打印", "        ", "        ", "        ","        ","        ","        ","        ","        ", "        ","     ","     ","    ","    ","        ", "      ","    ","     ","    ","    ","    "};
			OrderList firstList = new OrderList();
			firstList.setCustomerNum("客户编号");
			firstList.setCompanyName("单位名称");
			firstList.setCompanyJianCheng("单位简称");
			firstList.setAddress("联系地址");
			firstList.setCustomerEmail("邮政编码");
			firstList.setCustomerName("联系人");
			firstList.setTelephone1("联系人手机");
			firstList.setTelephone2("用户电话");
			firstList.setCustomerFax("用户传真");
			firstList.setProvince("所属省份");
			firstList.setCity("所属城市");
			firstList.setWebsite("网址");
			firstList.setRemarks("备注");
			firstList.setIsCustomer("是否客户");
			firstList.setIsSupplier("是否供应商");
			firstList.setBankName("开户银行");
			firstList.setBankNum("账号");
			firstList.setPinYin("拼音码");
			firstList.setCountry("国家");
			firstList.setTown("区镇");
			firstList.setEmail("邮箱");
			dataset.add(firstList);
			for(int i=0;i<orderList.size();i++){
				String index = i+1+"";
				OrderList oList = new OrderList();
				oList.setCustomerNum("S00000".substring(0,6-index.length())+index);
				oList.setCompanyName(orderList.get(i).getCustomerName());
				oList.setCompanyJianCheng(orderList.get(i).getCustomerName());
				oList.setAddress(orderList.get(i).getAddress());
				oList.setCustomerEmail(" ");
				oList.setCustomerName(orderList.get(i).getCustomerName());
				oList.setTelephone1(orderList.get(i).getTelephone1());
				oList.setTelephone2(orderList.get(i).getTelephone2());
				oList.setCustomerFax(" ");
				oList.setProvince(" ");
				oList.setCity(" ");
				oList.setWebsite(" ");
				
				List<OrderdetailView> Orderdetail = omService.getOrderDetail(orderList.get(i).getOrderNum());
				if(Orderdetail==null||"".equals(Orderdetail)){
					oList.setRemarks(" ");
				}else{
					String remarks= "";
					for(int j=0;j<Orderdetail.size();j++){
						remarks = remarks + Orderdetail.get(j).getCommoditymarque()+"("+Orderdetail.get(j).getCommodityNum()+") ";
					}
					oList.setRemarks(remarks);
				}
				
				oList.setIsCustomer("否");
				oList.setIsSupplier("否");
				oList.setBankName(" ");
				oList.setBankNum(" ");
				oList.setPinYin(" ");
				oList.setCountry(" ");
				oList.setTown(" ");
				oList.setEmail(" ");

				dataset.add(oList);
			}
			OutputStream out = new FileOutputStream(filePath);
			ex.exportExcel(headers, dataset, out);
			out.close();
			ex.download(filePath, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
