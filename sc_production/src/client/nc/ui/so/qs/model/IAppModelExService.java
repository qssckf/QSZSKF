package nc.ui.so.qs.model;

import nc.ui.uif2.model.IAppModelService;

public abstract interface IAppModelExService extends IAppModelService {
	
	public abstract Object enable(Object paramObject) throws Exception;
	
	public abstract Object unenable(Object paramObject) throws Exception;
	
	public abstract Object disable(Object paramObject) throws Exception;

 
}
