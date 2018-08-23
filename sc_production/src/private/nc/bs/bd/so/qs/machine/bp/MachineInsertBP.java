package nc.bs.bd.so.qs.machine.bp;

import java.util.Arrays;

import nc.bs.bd.bp.rule.BDPKLockSuperVORule;
import nc.bs.bd.bp.rule.BDUniqueRule;
import nc.bs.bd.bp.rule.BizLockRule;
import nc.bs.bd.bp.rule.FireEventRule;
import nc.bs.bd.bp.rule.NotNullValueRule;
import nc.bs.bd.bp.rule.StringFieldTrimRule;
import nc.bs.bd.bp.rule.WriteBusiLogRule;
import nc.bs.bd.bp.rule.insert.InsertAuditInfoRule;
import nc.bs.bd.bp.rule.insert.NotifyVersionChangeWhenDataInsertedRule;
import nc.bs.bd.bp.template.InsertBPTemplate;
import nc.bs.bd.so.qs.machine.plugin.bpplugin.MachinePluginPoint;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
import nc.vo.so.qs.mm.machinevo.MachineVO;

public class MachineInsertBP {
	
	public MachineInsertBP(){}
	
	public MachineVO[] insert(MachineVO[] vos){
		
		
		InsertBPTemplate<MachineVO> bpt=new InsertBPTemplate(MachinePluginPoint.INSERT);
		
		addBeforeRule(bpt.getAroundProcesser());
		addAfterRule(bpt.getAroundProcesser());
		
		MachineVO[] retObj=(MachineVO[])bpt.insert(vos);
		
		return retObj;
		
	}

	private void addBeforeRule(AroundProcesser<MachineVO> aroundProcesser) {
		// TODO 自动生成的方法存根
		
		aroundProcesser.addBeforeRule(new StringFieldTrimRule());
		
		aroundProcesser.addBeforeRule(new BDPKLockSuperVORule());
		
		aroundProcesser.addBeforeRule(new BizLockRule());
		
		aroundProcesser.addBeforeRule(new NotNullValueRule(Arrays.asList(new String[] { "machcode", "machname"})));
		
		aroundProcesser.addBeforeRule(new BDUniqueRule());
		
		aroundProcesser.addBeforeRule(new InsertAuditInfoRule());
		
		aroundProcesser.addBeforeRule(new FireEventRule("1001"));
		
	}

	private void addAfterRule(AroundProcesser<MachineVO> aroundProcesser) {
		// TODO 自动生成的方法存根
		
		aroundProcesser.addAfterRule(new NotifyVersionChangeWhenDataInsertedRule());
		
		aroundProcesser.addAfterRule(new FireEventRule("1002"));
		
		aroundProcesser.addAfterRule(new WriteBusiLogRule("add"));
		
	}

}
