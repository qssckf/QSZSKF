package nc.bs.bd.so.qs.machine.bp.operator;

import nc.bs.bd.baseservice.md.VOArrayUtil;
import nc.bs.bd.bp.utils.MDQueryUtil;
import nc.impl.pubapp.pattern.rule.template.ICompareOperator;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.so.pub.util.ArrayUtil;

import org.apache.commons.lang.ArrayUtils;


public class VOUpdateWithFieldOpeator<E extends SuperVO> implements ICompareOperator<E> {

	private String[] UpdateFileds;
	
	public String[] getUpdateFileds() {
		return UpdateFileds;
	}

	public void setUpdateFileds(String[] updateFileds) {
		UpdateFileds = updateFileds;
	}
	
	public VOUpdateWithFieldOpeator(){};
	
	public VOUpdateWithFieldOpeator(String[] fields){
		this.UpdateFileds=fields;
	}

	@Override
	public E[] operate(E[] vos, E[] oldVos) {
		// TODO 自动生成的方法存根
		try{
			if((!ArrayUtils.isEmpty(this.getUpdateFileds())) && (!ArrayUtil.isEmpty(vos))){
				
				MDQueryUtil.getMDService().updateBillWithAttrs(vos, this.getUpdateFileds());
				
				Object[] objs = MDQueryUtil.getMDQueryService().queryBillOfVOByPKsWithOrder(vos[0].getClass(), VOArrayUtil.getPrimaryKeyArray(vos), null);
				
				return (E[]) VOArrayUtil.convertToVOArray(vos[0].getClass(), objs);
				
			}
		}catch(BusinessException e){
			
			ExceptionUtils.wrappException(e);
			
		}
	
		
		return null;
	}

}
