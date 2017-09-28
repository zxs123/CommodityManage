package zxs.ssm.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import zxs.ssm.po.Department;

public class CollectionTest {

	public static void main(String[] args) {
		
		Collection<Department> c = new ArrayList<Department>();
		for(int i=0;i<5;i++){
			Department dep = new Department();
			dep.setDepId("abc"+i);
			dep.setDepName("cba"+i);
			c.add(dep);
		}
		Iterator<Department> e = c.iterator();
		while(e.hasNext()){
			Department dd = e.next();
			System.out.println(dd.getDepId());
		}
	}
}
