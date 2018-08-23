package nc.itf.so.qs.mm.machine;

import nc.vo.pub.BusinessException;

public interface IMachineInfoPaginationQueryService {
	
	//实现档案的分页功能
	public abstract Object[] queryObjectByPks(String[] paramArrayOfString,boolean lazy) throws BusinessException;

}
