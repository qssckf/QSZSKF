package nc.bs.bd.so.qs.machine.bp.template;

import nc.bs.bd.so.qs.machine.bp.operator.VOUpdateWithFieldOpeator;
import nc.impl.pubapp.pattern.rule.plugin.IPluginPoint;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.impl.pubapp.pattern.rule.template.CompareOperatorTemplate;
import nc.impl.pubapp.pattern.rule.template.ICompareOperator;
import nc.vo.pub.SuperVO;

public class UpdateWithFiledsBPTemplate<E extends SuperVO> {
	
	private CompareOperatorTemplate<E> template;
	
	public UpdateWithFiledsBPTemplate(IPluginPoint point,String[] Fields){
		
		ICompareOperator<E> operator=null;
		
		if((Fields != null) && (Fields.length>0)){
			operator=new VOUpdateWithFieldOpeator(Fields);
		}else{
			operator=new VOUpdateWithFieldOpeator();
		}
		
		this.template = new CompareOperatorTemplate(point, operator);
		
	}
	
	public E[] update(E[] vos, E[] oldVos){
		
		return (E[])this.template.operate(vos, oldVos);
		
	}
	
	public CompareAroundProcesser<E> getAroundProcesser(){
		return this.template.getAroundProcesser();
	}

}
