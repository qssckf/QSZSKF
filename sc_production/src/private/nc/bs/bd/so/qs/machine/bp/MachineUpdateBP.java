package nc.bs.bd.so.qs.machine.bp;

import java.util.Arrays;

import nc.bs.bd.bp.rule.BDPKLockSuperVORule;
import nc.bs.bd.bp.rule.BDUniqueRule;
import nc.bs.bd.bp.rule.BizLockRule;
import nc.bs.bd.bp.rule.NotNullValueRule;
import nc.bs.bd.bp.rule.NotifyVersionChangeWhenDataUpdatedRule;
import nc.bs.bd.bp.rule.StringFieldTrimRule;
import nc.bs.bd.bp.rule.update.FireUpdateEventRule;
import nc.bs.bd.bp.rule.update.UpdateAuditInfoRule;
import nc.bs.bd.bp.rule.update.WriteUpdateBusiLogRule;
import nc.bs.bd.bp.template.UpdateBPTemplate;
import nc.bs.bd.so.qs.machine.plugin.bpplugin.MachinePluginPoint;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.so.qs.mm.machinevo.MachineVO;

public class MachineUpdateBP {
	
	public MachineUpdateBP(){}
	
	public MachineVO[] update(MachineVO[] vos,MachineVO[] Oldvos){
		
		UpdateBPTemplate<MachineVO> bpt=new UpdateBPTemplate(MachinePluginPoint.UPDATE);
		
		addBeforeRule(bpt.getAroundProcesser());
		
		addAfterRule(bpt.getAroundProcesser());
		
		return bpt.update(vos, Oldvos);

	}

	private void addAfterRule(CompareAroundProcesser<MachineVO> compareAroundProcesser) {
		// TODO 自动生成的方法存根
		compareAroundProcesser.addAfterRule(new NotifyVersionChangeWhenDataUpdatedRule());
		
		compareAroundProcesser.addAfterRule(new FireUpdateEventRule("1004"));
		
		compareAroundProcesser.addAfterRule(new WriteUpdateBusiLogRule());
	}

	private void addBeforeRule(CompareAroundProcesser<MachineVO> compareAroundProcesser) {
		// TODO 自动生成的方法存根
		
		compareAroundProcesser.addBeforeRule(new StringFieldTrimRule());
		
		compareAroundProcesser.addBeforeRule(new BDPKLockSuperVORule());
		
		compareAroundProcesser.addBeforeRule(new BizLockRule());
		
		compareAroundProcesser.addBeforeRule(new NotNullValueRule(Arrays.asList(new String[] {  "code", "name" })));
		
		compareAroundProcesser.addBeforeRule(new BDUniqueRule());
		
		compareAroundProcesser.addBeforeRule(new UpdateAuditInfoRule());
		 
		compareAroundProcesser.addBeforeRule(new FireUpdateEventRule("1003")); 
		
	}

}
