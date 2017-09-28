package zxs.ssm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.et.mvc.JsonView;
import com.et.mvc.View;

import zxs.ssm.po.Functionlimit;
import zxs.ssm.po.FunctionlimitExample;
import zxs.ssm.po.FunctionModule;
import zxs.ssm.po.Systemrole;
import zxs.ssm.po.Users;
import zxs.ssm.po.FunctionlimitExample.Criteria;
import zxs.ssm.services.DepartmentService;
import zxs.ssm.services.FunctionLimitService;
import zxs.ssm.services.FunctionModuleService;
import zxs.ssm.services.SystemRoleService;
import zxs.ssm.services.UsersManageService;
import zxs.ssm.services.UsersService;
import zxs.ssm.util.DataGridModel;

@Controller
@RequestMapping("/systemManage")
public class SystemManageController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private UsersManageService umService;
	@Autowired
	private FunctionLimitService flService;
	@Autowired
	private FunctionModuleService fmService;
	@Autowired
	private SystemRoleService srService;
	@Autowired
	HttpSession session;
	
	//用户管理
	@RequestMapping("/userManage")
	public String test() throws Exception{
		return "systemManage/userManage";
	}
	
	//获取用户的信息
	@RequestMapping("/getUsers")
	public View getUsers() throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		List<Users> users = usersService.selectByExample(null);
		result.put("total", users.size());
		result.put("rows", users);		
		return new JsonView(result);
	}
	
	//查询用户列表
	@RequestMapping(value="/queryUserList",method=RequestMethod.POST)
	@ResponseBody         
	public Map<String, Object> queryUserList(DataGridModel dgm,Users user) throws Exception{
	    return umService.getPageList(dgm, user);
	}
	
	//查询权限列表
	@RequestMapping(value="/roleList",method=RequestMethod.POST)
	@ResponseBody         
	public Map<String, Object> roleList(DataGridModel dgm,Users user) throws Exception{
		return srService.getPageList(dgm, user);
	}

	//2016-3-12添加用户
	@ResponseBody  
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	private void save(HttpServletRequest request, HttpServletResponse response) {
		try {
			String userId = request.getParameter("userId");
			String userName = request.getParameter("userName");
			String userSex = request.getParameter("userSex");
			String userDep = request.getParameter("userDep");
			int userPosition = Integer.valueOf(request.getParameter("userPosition"));
			String userCellphone = request.getParameter("userCellphone");
			String userTel = request.getParameter("userTel");
			String userEmail = request.getParameter("userEmail");
			String userIdcard = request.getParameter("userIdcard");
			Users user = new Users();
			user.setUserId(userId);
			user.setUserPassword(userId);
			user.setUserName(userName);
			user.setUserRname("1");
			user.setUserSex(userSex);
			user.setUserDep(userDep);
			user.setUserPosition(userPosition);
			user.setUserCellphone(userCellphone);
			user.setUserTel(userTel);;
			user.setUserEmail(userEmail);
			user.setUserIdcard(userIdcard);
			usersService.insert(user);
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

	//2016-3-12更新用户信息
	@ResponseBody  
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	private void updateUser(HttpServletRequest request, HttpServletResponse response) {
		try {
			String userId = request.getParameter("userId");
			Users user = usersService.selectByPrimaryKey(userId);
			String userName = request.getParameter("userName");
			String userSex = request.getParameter("userSex");
			String depId = request.getParameter("userDep");
			String userCellphone = request.getParameter("userCellphone");
			String userTel = request.getParameter("userTel");
			String userEmail = request.getParameter("userEmail");
			String userIdcard = request.getParameter("userIdcard"); 
			int roleId = Integer.valueOf(request.getParameter("userPosition")); 
			user.setUserId(userId);
			user.setUserPassword(userId);
			user.setUserName(userName);
			user.setUserRname("1");
			user.setUserSex(userSex);
			user.setUserDep(depId);
			user.setUserPosition(roleId);
			user.setUserCellphone(userCellphone);
			user.setUserTel(userTel);;
			user.setUserEmail(userEmail);
			user.setUserIdcard(userIdcard);
			usersService.updateByPrimaryKey(user);
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
	
	//2016-3-14添加角色
	@ResponseBody  
	@RequestMapping(value="/saveRole",method=RequestMethod.POST)
	private void saveRole(HttpServletRequest request, HttpServletResponse response) {
		try {
			String srName = request.getParameter("srId");
			String srReid = request.getParameter("srName");
			String position = "0";
			if("领导".equals(srReid)){
				position = "1";
			}else{
				position = "0";
			}
			String s = request.getParameter("role");
			s = new String(s.getBytes("ISO-8859-1"),"UTF-8");
			String[] sss = s.split(",");
			Systemrole sr = new Systemrole();
			sr.setSrName(srName);
			sr.setSrReid(position);
			srService.insert(sr);
			int srId= sr.getSrId();
			insertFunctionLimit(srId,sss);//根据srId更新FunctionLimit表
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
	

	//2016-3-14更新角色
	@ResponseBody  
	@RequestMapping(value="/updateRole",method=RequestMethod.POST)
	private void updateRole(HttpServletRequest request, HttpServletResponse response) {
		try {
			int srId = Integer.valueOf(request.getParameter("srId"));
			String srName = request.getParameter("srName");
			String srReid = request.getParameter("srReid");
			
			//修改SystemRole表中的角色信息
			Systemrole sr = srService.selectByPrimaryKey(srId);
			sr.setSrName(srName);
			sr.setSrReid(srReid);
			srService.updateByPrimaryKey(sr);
			
			FunctionlimitExample flExample = new FunctionlimitExample();
			Criteria criteria = flExample.createCriteria();
			criteria.andFlRoleidEqualTo(srId);
			flService.deleteByExample(flExample);
			
			//从前台获取角色所有权限信息
			String s = request.getParameter("role");
			s = new String(s.getBytes("ISO-8859-1"),"UTF-8");
			String[] sss = s.split(",");
			
			insertFunctionLimit(srId,sss);//根据srId更新FunctionLimit表
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
	
	
	//删除用户
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deleteUser(@RequestParam("userId") List<String> userId)throws Exception{
		//spring mvc 还可以将参数绑定为list类型
		Map<String, String> map = new HashMap<String, String>();
		try {
			usersService.deleteUsers(userId);
			map.put("mes", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
			throw e;
		}
		return map;//重定向
	}
			
	//初始化密码
	@RequestMapping(value="/initializeP",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> initializeP(@RequestParam("userId") List<String> userId, HttpServletRequest request)throws Exception{
		//spring mvc 还可以将参数绑定为list类型
		Map<String, String> map = new HashMap<String, String>();
		try {
			for(int i=0;i<userId.size();i++){
				Users user = usersService.selectByPrimaryKey(userId.get(i));
				user.setUserPassword(userId.get(i));
				usersService.updateByPrimaryKey(user);
			}
			map.put("mes", "初始化密码成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "初始化密码失败");
			throw e;
		}
		return map;//重定向
	}

	//权限管理
	@RequestMapping("/privilegeManage")
	public String prilivigeManage() throws Exception{
		return "systemManage/privilegeManage";
	}
	
	//获取权限
	@RequestMapping("/getOrgTree")
	public String main(
			Model model,Locale locale ) {
		try {	
			List<FunctionModule> fmList = fmService.selectByExample(null);
			model.addAttribute("privileges", fmList);
			Users user = (Users) session.getAttribute("baseUser");
			System.out.println(user);
			int position = user.getUserPosition();  //获取用户角色
			FunctionlimitExample flExample = new FunctionlimitExample();
			Criteria criteria = flExample.createCriteria();
			criteria.andFlRoleidEqualTo(position);			
			List<Functionlimit> flList2 = flService.selectByExample(flExample);   //通过角色查询权限
			List<FunctionModule> fmList2 = new ArrayList<FunctionModule>();
			for(Iterator<Functionlimit> iterator = flList2.iterator();iterator.hasNext();){  
				Functionlimit fl = iterator.next();
				FunctionModule fm = fmService.selectByPrimaryKey(fl.getFlFmid());
				fmList2.add(fm);
	        }
			model.addAttribute("privileges2", fmList2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "systemManage/test";
	}
	
	//2016-3-2返回json数据
	@ResponseBody  
	@RequestMapping(value="/getJson",method=RequestMethod.POST)
	public String  getJson(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//获取系统所有功能权限，保存到fmList中
        List<FunctionModule> fmList = fmService.selectByExample(null);		
        Users user = (Users) session.getAttribute("baseUser");
		int position = user.getUserPosition();  //获取用户角色
		FunctionlimitExample flExample = new FunctionlimitExample();
		Criteria criteria = flExample.createCriteria();
		criteria.andFlRoleidEqualTo(position);
		List<Functionlimit> flList2 = flService.selectByExample(flExample);   //通过角色查询权限
		List<FunctionModule> fmList2 = new ArrayList<FunctionModule>();//将该角色的功能权限保存在fmList2中
		for(Iterator<Functionlimit> iterator = flList2.iterator();iterator.hasNext();){  
			Functionlimit fl = iterator.next();
			FunctionModule fm = fmService.selectByPrimaryKey(fl.getFlFmid());
			fmList2.add(fm);
        }
		List<Map> list2 = new ArrayList();
		int mn=1;
		for(int i=0;i<fmList.size();i++){
			FunctionModule fm = fmList.get(i);			
			if(fm.getFmCategory()==-1){
				List<Map> list1 = new ArrayList();
				for(int j=0;j<fmList.size();j++){
					FunctionModule fm1 = fmList.get(j);
					Map<String,Object> result1 = new HashMap<String,Object>();
					if(fm1.getFmCategory()==fm.getFmId()||(fm1.getFmCategory().equals(fm.getFmId()))){						
						List<Map> list = new ArrayList();
						for(int k=0;k<fmList.size();k++){							
							FunctionModule fm2 = fmList.get(k);	
							if(fm2.getFmCategory()==fm1.getFmId()||fm2.getFmCategory().equals(fm1.getFmId())){
								Map<String,Object> result2 = new HashMap<String,Object>();
								result2.put("text", fm2.getFmName());
								for(int m=0;m<fmList2.size();m++){
									FunctionModule fm3 = fmList2.get(m);
									if(fm3.getFmId().equals(fm2.getFmId())||fm3.getFmId()==fm2.getFmId()){
										result2.put("checked", "ture");//以后包含该权限
									}
								}
								list.add(result2);
							}
						}						
						result1.put("id", ++mn);
						result1.put("text", fm1.getFmName());	
						result1.put("State", "closed");	
						result1.put("children", list);
						list1.add(result1);
						result1=null;
					}					
				}
				Map<String,Object> result = new HashMap<String,Object>();
				result.put("id", 1);
				result.put("text", fm.getFmName());	
				result.put("children", list1);
				list2.add(result);
			}
		}
		ObjectMapper objectMapper = new ObjectMapper();
        String jsonString=objectMapper.writeValueAsString(list2);
        System.out.println(jsonString);
        return jsonString;
	}
	
	//删除角色
	@RequestMapping(value="/deleteRole",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deleteRole(@RequestParam("srId") List<String> srId)throws Exception{
		//spring mvc 还可以将参数绑定为list类型
		Map<String, String> map = new HashMap<String, String>();
		try {
			srService.deleteRole(srId);
			map.put("mes", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
			throw e;
		}
		return map;//重定向
	}

	//根据srId更新FunctionLimit表2016-3-16
	private void insertFunctionLimit(int srId,String[] sss) {
		List<FunctionModule> fmList = fmService.selectByExample(null);
		for(int i = 0;i<fmList.size();i++){
			for(int j=0;j<sss.length;j++){
				if(sss[j].equals(fmList.get(i).getFmName())||sss[j]==fmList.get(i).getFmName()){
					Functionlimit fl = new Functionlimit();
					if(fmList.get(i).getFmCategory()!=-1){
						int n = flService.findRecord(srId, fmList.get(i).getFmCategory());
						if(n==0){
							fl.setFlFmid(fmList.get(i).getFmCategory());
							fl.setFlRoleid(srId);
							flService.insert(fl);
						}
					}
					fl.setFlFmid(fmList.get(i).getFmId());
					fl.setFlRoleid(srId);
					flService.insert(fl);
				}
			}
		}
	}
	
}
