package zxs.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zxs.ssm.po.Systemrole;
import zxs.ssm.services.SystemRoleService;


@Controller
@RequestMapping("/SystemRole")
public class SystemRoleController {

	@Autowired
	private SystemRoleService srService;
	
	@RequestMapping(value="/getRoleName")
	@ResponseBody
	private void getRoleName(HttpServletRequest request,
		HttpServletResponse response) {
		try {
			List<Systemrole> roleList = srService.selectByExample(null);
			String str = JSONArray.fromObject(roleList).toString();
			response.setHeader("Content-type", "text/html;charset=UTF-8"); 
			response.getWriter().write(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
