package nc.itf.so.qs.mm.machine;
/*
 * �˴��ӿ�ΪNC��˵�EJB�ӿ�
 */
import nc.bs.bd.service.ValueObjWithErrLog;
import nc.itf.so.qs.mm.machine.IMachineInfoPaginationQueryService;
import nc.vo.pub.BusinessException;
import nc.vo.so.qs.mm.machinevo.MachineVO;


public abstract interface IMachineInfoService extends IMachineInfoPaginationQueryService{

	public abstract MachineVO[] insert(MachineVO[] objs) throws BusinessException;
	
	public abstract String[] delete(MachineVO[] objs) throws BusinessException;
	
	public abstract MachineVO[] update(MachineVO[] obs) throws BusinessException;
	
	public abstract ValueObjWithErrLog enableMachine(MachineVO[] obs) throws BusinessException;
	
	public abstract ValueObjWithErrLog unenableMachine(MachineVO[] obs) throws BusinessException;
	
	public abstract ValueObjWithErrLog disableMachine(MachineVO[] obs) throws BusinessException;
	
	public abstract String[] queryMachineVOPks(String sqlwhere) throws BusinessException;
	
	public abstract MachineVO[] queryMachineVOs(String sqlwhere,Boolean lazy) throws BusinessException;
	
	
}
