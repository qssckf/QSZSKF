package nc.itf.so.qs.mm.machine;

import nc.vo.pub.BusinessException;

public interface IMachineInfoPaginationQueryService {
	
	//ʵ�ֵ����ķ�ҳ����
	public abstract Object[] queryObjectByPks(String[] paramArrayOfString,boolean lazy) throws BusinessException;

}
