package zxs.ssm.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zxs.ssm.po.Department;
import zxs.ssm.services.DepartmentService;
@Controller
@RequestMapping("/dept")
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;
	
	@RequestMapping(value="/queryAll")
	@ResponseBody         
	public Map<String, Object> queryAll() throws Exception{
	    return deptService.getAllJson(); //可以返回map
	}
	
	@RequestMapping(value="/allList")
	@ResponseBody         
	public List<Department> allList() throws Exception{
	    return deptService.selectByExample(null); //也可以返回list
	}

	@RequestMapping(value="/getDepName")
	@ResponseBody
	private void getDepName(HttpServletRequest request,
			HttpServletResponse response) {
			try {
				List<Department> depList = deptService.selectByExample(null);
				String str = JSONArray.fromObject(depList).toString();
				response.setHeader("Content-type", "text/html;charset=UTF-8"); 
				response.getWriter().write(str);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}
