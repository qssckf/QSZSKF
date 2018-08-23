package nc.impl.so.qs.mm.machine;
/*
 * ʵ�ֽӿ�IMachineInfoService����Ϊʵ����
 */
import java.util.Collection;

import nc.bs.bd.bp.utils.MDQueryUtil;
import nc.bs.bd.paginationquery.BDBigDocPaginationQueryInfoVO;
import nc.bs.bd.paginationquery.BDBigDocPaginationQueryUtil;
import nc.bs.bd.paginationquery.BDBigDocQueryPaginationResultProcessor;
import nc.bs.bd.service.ValueObjWithErrLog;
import nc.bs.bd.so.qs.machine.bp.MachineDeleteBP;
import nc.bs.bd.so.qs.machine.bp.MachineDisableBP;
import nc.bs.bd.so.qs.machine.bp.MachineEnableBP;
import nc.bs.bd.so.qs.machine.bp.MachineInsertBP;
import nc.bs.bd.so.qs.machine.bp.MachineUnEnableBP;
import nc.bs.bd.so.qs.machine.bp.MachineUpdateBP;
import nc.itf.so.qs.mm.machine.IMachineInfoService;
import nc.md.persist.framework.IMDPersistenceQueryService;
import nc.md.persist.framework.MDPersistenceService;
import nc.vo.ecpubapp.pattern.exception.ExceptionUtils;
import nc.vo.pub.BusinessException;
import nc.vo.so.qs.mm.machinevo.MachineVO;

public class MachineServiceImpl implements IMachineInfoService {

	@Override
	public Object[] queryObjectByPks(String[] paramArrayOfString, boolean lazy) throws BusinessException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public MachineVO[] insert(MachineVO[] objs) throws BusinessException {
		// TODO �Զ����ɵķ������
		//��ʼ���ӿں�ʵ�����������
		try{
			
			MachineInsertBP bp = new MachineInsertBP();
			
			return bp.insert(objs);
			
		}catch(Exception e){
			ExceptionUtils.marsh(e);
		}
		
		return null;
	}

	@Override
	public String[] delete(MachineVO[] objs) throws BusinessException {
		// TODO �Զ����ɵķ������
		try{
			
			MachineDeleteBP bp = new MachineDeleteBP();
			
			return bp.delete(objs);
			
		}catch(Exception e){
			ExceptionUtils.marsh(e);
		}
		
		return null;
	}

	@Override
	public MachineVO[] update(MachineVO[] obs) throws BusinessException {
		// TODO �Զ����ɵķ������
		try{
			
			MachineVO[] oldvos=(MachineVO[])MDQueryUtil.lockValidateToRetrieveVO(obs);

			
			MachineUpdateBP bp = new MachineUpdateBP();
			
			return bp.update(obs, oldvos);
			
		}catch(Exception e){
			ExceptionUtils.marsh(e);
		}
		
		return null;
	}

	@Override
	public ValueObjWithErrLog enableMachine(MachineVO[] obs) throws BusinessException {
		// TODO �Զ����ɵķ������
		try{
			
			MachineVO[] oldobs=(MachineVO[])MDQueryUtil.lockValidateToRetrieveVO(obs);

			
			MachineEnableBP bp = new MachineEnableBP();
			
			return bp.enable(obs, oldobs);
			
		}catch(Exception e){
			ExceptionUtils.marsh(e);
		}
		
		return null;
	}

	@Override
	public ValueObjWithErrLog unenableMachine(MachineVO[] obs) throws BusinessException {
		// TODO �Զ����ɵķ������
		try{
			
			MachineVO[] oldobs=(MachineVO[])MDQueryUtil.lockValidateToRetrieveVO(obs);

			
			MachineUnEnableBP bp = new MachineUnEnableBP();
			
			return bp.unenable(obs, oldobs);
			
		}catch(Exception e){
			ExceptionUtils.marsh(e);
		}
		
		return null;
	}

	@Override
	public ValueObjWithErrLog disableMachine(MachineVO[] obs) throws BusinessException {
		// TODO �Զ����ɵķ������
		try{
			
			MachineVO[] oldobs=(MachineVO[])MDQueryUtil.lockValidateToRetrieveVO(obs);

			
			MachineDisableBP bp = new MachineDisableBP();
			
			return bp.disable(obs, oldobs);
			
		}catch(Exception e){
			ExceptionUtils.marsh(e);
		}
		
		return null;
	}

	@Override
	//��ѯ��������
	public String[] queryMachineVOPks(String sqlwhere) throws BusinessException {
		// TODO �Զ����ɵķ������
		
		BDBigDocPaginationQueryUtil paginQryUtil = new BDBigDocPaginationQueryUtil(new BDBigDocPaginationQueryInfoVO(MachineVO.getDefaultTableName(), MachineVO.PK_MACHINE, sqlwhere, MachineVO.MACHCODE), new ColumnListProcessor());
		BDBigDocQueryPaginationResultProcessor processor = new BDBigDocQueryPaginationResultProcessor();
		paginQryUtil.processor(processor);
		
		return processor.getTotalResult().toArray(new String[0]);
	}

	@Override
	//��ѯ���ض���
	public MachineVO[] queryMachineVOs(String sqlwhere, Boolean lazy) throws BusinessException {
		// TODO �Զ����ɵķ������
		Collection<?> col = getMDQueryService().queryBillOfVOByCond(MachineVO.class,sqlwhere,lazy);
		
		return (col == null) || (col.size() == 0) ? null:col.toArray(new MachineVO[0]);
		
	}
	
	private IMDPersistenceQueryService getMDQueryService() {
		return MDPersistenceService.lookupPersistenceQueryService();
	}
}
