package nc.bs.bd.so.qs.machine.bp;

import nc.bs.bd.bp.rule.BDPKLockSuperVORule;
import nc.bs.bd.bp.rule.BizLockRule;
import nc.bs.bd.bp.rule.FireEventRule;
import nc.bs.bd.bp.rule.VersionValidateRule;
import nc.bs.bd.bp.rule.WriteBusiLogRule;
import nc.bs.bd.bp.rule.delete.BDReferenceCheckerRule;
import nc.bs.bd.bp.rule.delete.NotifyVersionChangeWhenDataDeletedRule;
import nc.bs.bd.bp.template.DeleteBPTemplate;
import nc.bs.bd.so.qs.machine.plugin.bpplugin.MachinePluginPoint;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
//import nc.ui.so.xlx.driver.action.rule.DriverDeleteFilterRule;
import nc.vo.so.qs.mm.machinevo.MachineVO;

public class MachineDeleteBP {
	
	public MachineDeleteBP(){};
	
	public String[] delete(MachineVO[] vos){
		
		DeleteBPTemplate<MachineVO> bpt=new DeleteBPTemplate(MachinePluginPoint.DELETE);
		
		addBeforeRule(bpt.getAroundProcesser());
		
		addAfterRule(bpt.getAroundProcesser());
		
		String[] teStrings = bpt.delete(vos);
		
		return teStrings;
		
	}

	private void addAfterRule(AroundProcesser<MachineVO> ard) {
		// TODO 自动生成的方法存根
		
		ard.addAfterRule(new FireEventRule("1006"));
		
		ard.addAfterRule(new WriteBusiLogRule("delete"));
	}

	private void addBeforeRule(AroundProcesser<MachineVO> ard) {
		// TODO 自动生成的方法存根
		
		ard.addBeforeRule(new BDPKLockSuperVORule());
		ard.addBeforeRule(new BizLockRule());
		ard.addBeforeRule(new VersionValidateRule());
		ard.addBeforeRule(new BDReferenceCheckerRule());
		ard.addBeforeRule(new FireEventRule("1005"));
		ard.addBeforeRule(new NotifyVersionChangeWhenDataDeletedRule());
	}
	
	

}
