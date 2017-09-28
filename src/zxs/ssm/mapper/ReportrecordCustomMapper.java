package zxs.ssm.mapper;

import java.util.List;

public interface ReportrecordCustomMapper {
	List<String> selectLastRepIdList(String userId);
	List<String> selectLastRepIdListInQuar(String userId);
}
