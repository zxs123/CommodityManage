package zxs.ssm.test;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zxs.ssm.services.DepartmentService;

@Component
public class DepTest {

	@Autowired
	private DepartmentService depService;
	/*private static DepTest  depTest ;

	 public void setTestService(DepartmentService depService) {  
	        this.depService = depService;  
	    } 
	 
	@PostConstruct     //关键二   通过@PostConstruct 和 @PreDestroy 方法 实现初始化和销毁bean之前进行的操作
    public void init() {  
		depTest = this;  
		depTest.depService = this.depService;   // 初使化时将已静态化的testService实例化
    } */
	
	@Test
	public void test() {
		String depName = depService.selectNameById("QYFZ");
		System.out.println(depName);
	}

}
