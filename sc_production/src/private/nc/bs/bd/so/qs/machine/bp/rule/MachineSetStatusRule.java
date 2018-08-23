package nc.bs.bd.so.qs.machine.bp.rule;

import nc.impl.pubapp.pattern.rule.IRule;
import nc.vo.pub.SuperVO;
//import nc.vo.so.qs.mm.machinevo.MachineVO;

public class MachineSetStatusRule<E extends SuperVO> implements IRule<E> {
	
	private String statusField;
	private String value;
	
	public MachineSetStatusRule(String statusField,String value){
		
		this.statusField=statusField;
		this.value=value;
	}

	@Override
	public void process(E[] vos) {
		// TODO 自动生成的方法存根
		for (E vo : vos) {
			vo.setAttributeValue(this.statusField,this.value);
		}
	}

}
