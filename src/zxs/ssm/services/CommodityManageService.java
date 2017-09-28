package zxs.ssm.services;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import zxs.ssm.po.Alterinfo;
import zxs.ssm.po.Altermanage;
import zxs.ssm.po.Commodityinfo;
import zxs.ssm.po.PhotoInfo;
import zxs.ssm.util.DataGridModel;

public interface CommodityManageService {

	Map<String, Object> getMarqueList(DataGridModel dgm,Commodityinfo commodityInfo) throws Exception;

	void deleteMarques(List<String> commodityid);

	void insertMarque(Commodityinfo ci);

	void updateMarqueByPrimaryKeySelective(Commodityinfo ci);

	Map<String, Object> getAlterList(DataGridModel dgm,	Altermanage inventoryAlter);

	//String getCommodityJson(String term)  throws Exception;
	Map<String, Object> getCommodityJson()  throws Exception;

	void insertAlter(Alterinfo alterInfo);
	
	void insertPhoto(PhotoInfo photoInfo);
	
	Commodityinfo selectCommodityByPrimaryKey(int commodityId);

	Alterinfo selectAlterInfoById(String parameter);
	
}
