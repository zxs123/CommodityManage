package zxs.ssm.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import net.sf.json.JSONArray;
import zxs.ssm.mapper.AlterinfoMapper;
import zxs.ssm.mapper.AltermanageMapper;
import zxs.ssm.mapper.CommodityinfoMapper;
import zxs.ssm.mapper.PhotoInfoMapper;
import zxs.ssm.po.Alterinfo;
import zxs.ssm.po.Altermanage;
import zxs.ssm.po.AltermanageExample;
import zxs.ssm.po.Commodityinfo;
import zxs.ssm.po.CommodityinfoExample;
import zxs.ssm.po.PhotoInfo;
import zxs.ssm.po.Users;
import zxs.ssm.services.CommodityManageService;
import zxs.ssm.util.DataGridModel;

public class CommodityManageServiceImpl implements CommodityManageService{

	@Autowired
	private CommodityinfoMapper ciMapper;
	@Autowired
	private AltermanageMapper amMapper;
	@Autowired
	private AlterinfoMapper alterMapper;
	@Autowired
	private PhotoInfoMapper photoMapper;
	@Autowired
	HttpSession session;

	@Override
	public Map<String, Object> getMarqueList(DataGridModel dgm,	Commodityinfo commodityInfo) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>(2);
		List<Commodityinfo> list = null;
		CommodityinfoExample ciExample = new CommodityinfoExample();
		zxs.ssm.po.CommodityinfoExample.Criteria criteria = ciExample.createCriteria();
		criteria.andZtEqualTo(1);
		if (commodityInfo != null && !("".equals(commodityInfo))) {
			
			if(commodityInfo.getCommodityname()!=null && !("".equals(commodityInfo.getCommodityname()))){
				criteria.andCommoditynameEqualTo(commodityInfo.getCommodityname());
			}
			if(commodityInfo.getCommoditymarque()!=null && !("".equals(commodityInfo.getCommoditymarque()))){
				criteria.andCommoditymarqueEqualTo(commodityInfo.getCommoditymarque());
			}
			if(commodityInfo.getQiyong()!=null && commodityInfo.getQiyong()!=-1 && !("kongbai".equals(commodityInfo.getQiyong()))){
				criteria.andQiyongEqualTo(commodityInfo.getQiyong());
			}			
		}
		list = ciMapper.selectByExample(ciExample);
		session.setAttribute("marqueList", list);
		int total = list.size();
		List<Commodityinfo> list1 = new ArrayList<Commodityinfo>();
		int start = (dgm.getPage() - 1) * dgm.getRows(), end = start + dgm.getRows();
		for (int i = start; i < end && i < total; i++) {
			list1.add(list.get(i));
		}
		result.put("total", total);
		result.put("rows", list1);
		return result;
	}

	@Override
	//删除商品信息
	public void deleteMarques(List<String> commodityid) {
		if (commodityid != null && commodityid.size() > 0) {
			for (String cId : commodityid) {
				Commodityinfo cInfo = ciMapper.selectByPrimaryKey(Integer.valueOf(cId));
				cInfo.setZt(0);
				ciMapper.updateByPrimaryKey(cInfo);
				
				//逻辑删除商品信息后，需要插入一条商品更改信息
				Users user = (Users) session.getAttribute("baseUser");
				String userName = user.getUserName();
				SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
				String date = sDateFormat.format(new Date());   //获取当前时间
				Alterinfo alterInfo = new Alterinfo();
				alterInfo.setCommodityid(Integer.valueOf(cId));
				alterInfo.setAltertime(date);
				alterInfo.setAltertype("手动调整");
				alterInfo.setAlternum(0-cInfo.getInventorynum());
				alterInfo.setAlterinventory(0);
				alterInfo.setAlterremark("连带删除");
				alterInfo.setUsername(userName);
				alterInfo.setZt(1);
				alterMapper.insert(alterInfo);
			}
		}		
	}

	@Override
	//新增商品信息
	public void insertMarque(Commodityinfo ci) {
		ciMapper.insert(ci);		
	}

	@Override
	public void updateMarqueByPrimaryKeySelective(Commodityinfo ci) {
		ciMapper.updateByPrimaryKeySelective(ci);
		
	}

	@Override
	public Map<String, Object> getAlterList(DataGridModel dgm, Altermanage inventoryAlter) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		List<Altermanage> list = null;
		list = amMapper.selectByExample(null);
		AltermanageExample amExample = new AltermanageExample();
		zxs.ssm.po.AltermanageExample.Criteria criteria = amExample.createCriteria();
		criteria.andZtNotEqualTo(0);
		if (inventoryAlter != null && !("".equals(inventoryAlter))) {		
			if(inventoryAlter.getCommodityid()!=null && !("".equals(inventoryAlter.getCommodityid()))){
				criteria.andCommodityidEqualTo(inventoryAlter.getCommodityid());
			}
			if(inventoryAlter.getAltertype()!=null && !("0".equals(inventoryAlter.getAltertype()))&&!("".equals(inventoryAlter.getAltertype()))){
				criteria.andAltertypeEqualTo(inventoryAlter.getAltertype());
			}
		}		
		list = amMapper.selectByExample(amExample);
		session.setAttribute("alterList", list);
		int total = list.size();
		List<Altermanage> list1 = new ArrayList<Altermanage>();
		int start = (dgm.getPage() - 1) * dgm.getRows(), end = start + dgm.getRows();
		for (int i = start; i < end && i < total; i++) {
			list1.add(list.get(i));
		}
		result.put("total", total);
		result.put("rows", list1);
		return result;
	}
	
	@Override
	public Map<String, Object> getCommodityJson() throws Exception {
		Map<String, Object> result = new HashMap<String, Object>(2);
		List<Commodityinfo> list = null;
		CommodityinfoExample ciExample = new CommodityinfoExample();
		zxs.ssm.po.CommodityinfoExample.Criteria criteria = ciExample.createCriteria();
		list = ciMapper.selectByExample(ciExample);
		//list = ciMapper.selectByExample(null);
		List<String> list2 = new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			list2.add(list.get(i).getCommoditymarque());
		}
		String json =JSONArray.fromObject(list2).toString();
		result.put("total", list==null ? 0 : list.size());
		result.put("rows", list);
		return result;

	}
	
	//模糊查询
	/*@Override
	public String getCommodityJson(String term) throws Exception {
		//Map<String, Object> result = new HashMap<String, Object>(2);
		List<Commodityinfo> list = null;
		CommodityinfoExample ciExample = new CommodityinfoExample();
		zxs.ssm.po.CommodityinfoExample.Criteria criteria = ciExample.createCriteria();
		if(term!=null){
			criteria.andCommoditymarqueLike("%"+term+"%");
		}
		list = ciMapper.selectByExample(ciExample);
		//list = ciMapper.selectByExample(null);
		List<String> list2 = new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			list2.add(list.get(i).getCommoditymarque());
		}
		String json =JSONArray.fromObject(list2).toString();
		result.put("total", list==null ? 0 : list.size());
		result.put("rows", list);
		return json;
	}*/

	@Override
	public void insertAlter(Alterinfo alterInfo) {
		alterMapper.insert(alterInfo);
	}
	
	@Override
	public void insertPhoto(PhotoInfo photoInfo){
		photoMapper.insert(photoInfo);
	}

	@Override
	public Commodityinfo selectCommodityByPrimaryKey(int commodityId) {
		return ciMapper.selectByPrimaryKey(commodityId);
	}

	@Override
	public Alterinfo selectAlterInfoById(String alterid) {
		 return alterMapper.selectByPrimaryKey(Integer.valueOf(alterid));
		
	}
}
