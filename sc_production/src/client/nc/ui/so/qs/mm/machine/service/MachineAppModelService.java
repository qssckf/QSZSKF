package nc.ui.so.qs.mm.machine.service;
/*
 * 客户端的service
 */
import nc.bs.bd.service.ValueObjWithErrLog;
import nc.bs.framework.common.NCLocator;
import nc.itf.so.qs.mm.machine.IMachineInfoService;
import nc.ui.so.qs.model.IAppModelExService;
import nc.vo.uif2.LoginContext;
import nc.vo.bd.pub.sqlutil.BDSqlInUtil;
import nc.vo.pub.BusinessException;
import nc.vo.so.qs.mm.machinevo.MachineVO;;

public class MachineAppModelService implements IAppModelExService {
	
	private IMachineInfoService service;
	
	private String[] deletedSucBalVOPks = null;
	
	public String[] getDeletedSucBalVOPks() {
		return deletedSucBalVOPks;
	}

	public void setDeletedSucBalVOPks(String[] deletedSucBalVOPks) {
		this.deletedSucBalVOPks = deletedSucBalVOPks;
	}

	public IMachineInfoService getService() {

		if(this.service==null){
			//通过ejb层来获取get方法
			//单例模式
			this.service=(IMachineInfoService)NCLocator.getInstance().lookup(IMachineInfoService.class);
		}
		
		return service;
		
	}

	@Override
	public void delete(Object object) throws Exception {
		// TODO 自动生成的方法存根
		Object[] objects = null;
		if (object.getClass().isArray()) {
			objects = (Object[])object;
			MachineVO[] vos=new MachineVO[objects.length];
			for(int i = 0; i < objects.length; i++){
				vos[i]=(MachineVO)objects[i];
			}
			
			setDeletedSucBalVOPks(this.getService().delete(vos));
		}else{
			setDeletedSucBalVOPks(this.getService().delete(new MachineVO[]{(MachineVO)object}));
		}
	}

	@Override
	public Object insert(Object obj) throws Exception {
		// TODO 自动生成的方法存根
		return this.getService().insert(new MachineVO[]{(MachineVO)obj})[0];
	}

	@Override
	public Object[] queryByDataVisibilitySetting(LoginContext arg0)
			throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Object update(Object obj) throws Exception {
		// TODO 自动生成的方法存根
		return this.service.update(new MachineVO[]{(MachineVO)obj})[0];
	}

	@Override
	public ValueObjWithErrLog enable(Object object) throws Exception {
		// TODO 自动生成的方法存根
		
		if(object instanceof MachineVO[]){
			
			return this.getService().enableMachine((MachineVO[])object);
			
		}else{
			
			return this.getService().enableMachine(new MachineVO[]{(MachineVO)object});
		}
			
	}

	@Override
	public ValueObjWithErrLog unenable(Object object) throws Exception {
		// TODO 自动生成的方法存根
	
		if(object instanceof MachineVO[]){
			
			return this.getService().unenableMachine((MachineVO[])object);
			
		}else{
			
			return this.getService().unenableMachine(new MachineVO[]{(MachineVO)object});
		}
	}

	@Override
	public ValueObjWithErrLog disable(Object object) throws Exception {
		// TODO 自动生成的方法存根
		
		if(object instanceof MachineVO[]){
			
			return this.getService().disableMachine((MachineVO[])object);
			
		}else{
			
			return this.getService().disableMachine(new MachineVO[]{(MachineVO)object});
		}
		
	}
	
	public Object[] queryVOsByPks(String[] pks) throws BusinessException{
		
		return this.getService().queryObjectByPks(pks, false);
		
	}
	
	public String[] queryOrgMachineVOsBySql(String[] orgIDs, String condition) throws BusinessException{
		
		 StringBuilder builder = new StringBuilder();
		 
		 builder.append("(" + condition + ")");
		
		 String inSql = BDSqlInUtil.getInSql(orgIDs, false);
		 
		 builder.append(" and (pk_org in ").append(inSql + ")");
		 
		 return this.getService().queryMachineVOPks(builder.toString());
		
		
	}

}
