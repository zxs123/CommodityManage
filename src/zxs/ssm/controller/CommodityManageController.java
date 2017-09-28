package zxs.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import zxs.ssm.po.Alterinfo;
import zxs.ssm.po.Altermanage;
import zxs.ssm.po.Commodityinfo;
import zxs.ssm.po.PhotoInfo;
import zxs.ssm.po.Users;
import zxs.ssm.services.CommodityManageService;
import zxs.ssm.util.DataGridModel;

@Controller
@RequestMapping("/commodityManage")
public class CommodityManageController {

	@Autowired
	private CommodityManageService cmService;
	@Autowired
	HttpSession session;
		
	//型号管理
	@RequestMapping("/marqueManage")
	public String marqueManage() throws Exception{
		return "commodityManage/marqueManage";
	}
	
	//查询型号列表
	@RequestMapping(value="/marqueList",method=RequestMethod.POST)
	@ResponseBody         
	public Map<String, Object> queryMarqueList(DataGridModel dgm,Commodityinfo commodityInfo) throws Exception{
		return cmService.getMarqueList(dgm, commodityInfo);
	}

	//2017-4-30添加商品
	@ResponseBody  
	@RequestMapping(value="/saveMarque",method=RequestMethod.POST)
	private void save(HttpServletRequest request, HttpServletResponse response) {
		try {
			String commoditymarque = request.getParameter("commoditymarque");
			String commodityname = request.getParameter("commodityname");
			String commoditytype = request.getParameter("commoditytype");
			String commodityscale = request.getParameter("commodityscale");
			String commodityunit = request.getParameter("commodityunit"); 
			int qiyong = Integer.valueOf(request.getParameter("qiyong")); 
			Commodityinfo ci = new Commodityinfo();
			ci.setCommoditymarque(commoditymarque);
			ci.setCommodityname(commodityname);
			ci.setCommoditytype(commoditytype);
			ci.setCommodityscale(commodityscale);
			ci.setCommodityunit(commodityunit);
			ci.setQiyong(qiyong);
			ci.setInventorynum(0);
			ci.setZt(1);
			cmService.insertMarque(ci);
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

	//2016-4-30更新商品信息
	@ResponseBody  
	@RequestMapping(value="/updateMarque",method=RequestMethod.POST)
	private void updateUser(HttpServletRequest request, HttpServletResponse response) {
		try {
			int commodityid= Integer.valueOf(request.getParameter("commodityid"));
			String commodityname = request.getParameter("commodityname");
			String commoditytype = request.getParameter("commoditytype");
			String commodityscale = request.getParameter("commodityscale");
			String commodityunit = request.getParameter("commodityunit"); 
			int qiyong = Integer.valueOf(request.getParameter("qiyong")); 
			Commodityinfo ci = new Commodityinfo();
			ci.setCommodityid(commodityid);
			ci.setCommodityname(commodityname);
			ci.setCommoditytype(commoditytype);
			ci.setCommodityscale(commodityscale);
			ci.setCommodityunit(commodityunit);
			ci.setQiyong(qiyong);
			cmService.updateMarqueByPrimaryKeySelective(ci);
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
	
	//删除用户
	@RequestMapping(value="/deleteMarques",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deleteMarques(@RequestParam("commodityid") List<String> commodityid)throws Exception{
		//spring mvc 还可以将参数绑定为list类型
		Map<String, String> map = new HashMap<String, String>();
		try {
			cmService.deleteMarques(commodityid);
			map.put("mes", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
			throw e;
		}
		return map;//重定向
	}
	
	//功能有待完善
	@RequestMapping("test")
	public String error() {
		return "test/test";
	}
	
	//商品库存变更
	@RequestMapping("/inventoryAlter")
	public String inventoryAlter() throws Exception{
		return "commodityManage/inventoryAlter";
	}
	
	//查询型号列表
	@RequestMapping(value="/alterList",method=RequestMethod.POST)
	@ResponseBody         
	public Map<String, Object> queryAlterList(DataGridModel dgm, Altermanage inventoryAlter) throws Exception{
	    return cmService.getAlterList(dgm, inventoryAlter);
	}
	
	//获取所有的商品名称和商品型号
	@RequestMapping(value="/queryCommodity")
	@ResponseBody         
	public Map<String, Object> queryAll(HttpServletRequest request) throws Exception{
	    return cmService.getCommodityJson(); //可以返回map
	}
	
	/*@RequestMapping(value="/queryCommodity")
	@ResponseBody         
	public String queryAll(HttpServletRequest request) throws Exception{
		String term = request.getParameter("term");
		System.out.println("term======"+term);
	    return cmService.getCommodityJson(term); //可以返回map
	}*/
	
	//2017-4-30添加商品
	@ResponseBody  
	@RequestMapping(value="/saveAlter",method=RequestMethod.POST)
	private void saveAlter(HttpServletRequest request, HttpServletResponse response) {
		try {
			int commodityid = Integer.valueOf(request.getParameter("commodityid"));
			int inventorynum = Integer.valueOf(request.getParameter("inventorynum"));
			int alterNum = Integer.valueOf(request.getParameter("alternum"));
			String altertype = request.getParameter("altertype");
			Users user = (Users) session.getAttribute("baseUser");
			String userName = user.getUserName();
			SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
			String date = sDateFormat.format(new Date());   //获取当前时间
			Alterinfo alterInfo = new Alterinfo();
			alterInfo.setCommodityid(commodityid);
			alterInfo.setAltertime(date);
			alterInfo.setAltertype(altertype);
			alterInfo.setAlternum(alterNum);
			alterInfo.setAlterinventory(inventorynum+alterNum);
			alterInfo.setUsername(userName);
			alterInfo.setZt(1);
			cmService.insertAlter(alterInfo);
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
	

	//上传图片
	@ResponseBody  
	@RequestMapping(value="/picUpload",method=RequestMethod.POST)
	private ModelAndView picUpload(@RequestParam(value = "myfiles") MultipartFile file,HttpServletRequest request, HttpServletResponse response) {
		try {
			
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
	             photoInfo.setPhotoBz("变更照片");
	             //用photoType来区分照片类型1、订单照片2、变更照片3、快递照片
	             photoInfo.setPhotoType("2");
	             photoInfo.setPhotoZt(1);
	             photoInfo.setRelationNum(request.getParameter("alterid"));
	             //获取订单编号
	             Alterinfo alterInfo = cmService.selectAlterInfoById(request.getParameter("alterid"));
	             String orde_Num = alterInfo.getOrderNum()+"";
	             photoInfo.setOrderNum(orde_Num);;
	             photoInfo.setUserName(user.getUserName());
	             cmService.insertPhoto(photoInfo);
	             response.setContentType("text/html;charset=utf-8");
	 			//{"status":"fail" , "message":"操作失败!"}
	 			//String str = "上传成功!";
	             return new ModelAndView("redirect:/commodityManage/inventoryAlter.action");
	 			
//	 			try {
//	 				response.getWriter().write(str);
//	 			} catch (IOException e1) {
//	 				e1.printStackTrace();
//	 			}
		} catch (Exception e) {
		
			e.printStackTrace();
		} 
		return new ModelAndView("redirect:/commodityManage/inventoryAlter.action");
		
		
	}   
	
	//2017-08-13模糊查询代码
	//2017-4-30添加商品
	@ResponseBody  
	@RequestMapping(value="/testReserch",method=RequestMethod.POST)
	private void testReserch(HttpServletRequest request, HttpServletResponse response) {
		try {
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

	
}
