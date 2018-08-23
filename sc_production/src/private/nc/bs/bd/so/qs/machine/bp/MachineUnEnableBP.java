package nc.bs.bd.so.qs.machine.bp;

import nc.bs.bd.bp.rule.BDPKLockSuperVORule;
import nc.bs.bd.bp.rule.BizLockRule;
import nc.bs.bd.bp.rule.FireEventRule;
import nc.bs.bd.bp.rule.NotifyVersionChangeWhenDataUpdatedRule;
import nc.bs.bd.bp.rule.StringFieldTrimRule;
import nc.bs.bd.bp.rule.VersionValidateRule;
import nc.bs.bd.bp.rule.WriteBusiLogRule;
import nc.bs.bd.bp.rule.update.UpdateAuditInfoRule;
import nc.bs.bd.service.ValueObjWithErrLog;
import nc.bs.bd.so.qs.machine.bp.rule.MachineSetStatusRule;
import nc.bs.bd.so.qs.machine.plugin.bpplugin.MachinePluginPoint;
import nc.bs.bd.so.qs.machine.bp.template.UpdateWithFiledsBPTemplate;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
//import nc.ui.so.xlx.driver.action.rule.DriverSetStatusRule;
//import nc.ui.so.xlx.driver.action.rule.DriverUnEnableDataCheckFilterRule;
//import nc.ui.so.xlx.driver.action.rule.DriverUnEnableStatusFilterRule;
import nc.vo.so.qs.mm.en.MachineStatus;
import nc.vo.so.qs.mm.machinevo.MachineVO;

public class MachineUnEnableBP {
	
	public MachineUnEnableBP(){
		
	}
	
	public ValueObjWithErrLog unenable(MachineVO[] vos, MachineVO[] oldVos){
		
		ValueObjWithErrLog returnValue = new ValueObjWithErrLog();
		
		UpdateWithFiledsBPTemplate<MachineVO> bpt=new UpdateWithFiledsBPTemplate(MachinePluginPoint.UNENABLE,new String[]{MachineVO.CSTATUS,"modifier","modifiedtime"});
		
		addBeforeRule(bpt.getAroundProcesser(),returnValue);
		
		addAfterRule(bpt.getAroundProcesser());
		
		returnValue.setVos(bpt.update(vos,oldVos));
		
		return returnValue;
		
		
	}

	private void addAfterRule(CompareAroundProcesser<MachineVO> aroundProcesser) {
		// TODO 自动生成的方法存根
		
		aroundProcesser.addAfterRule(new NotifyVersionChangeWhenDataUpdatedRule());
		
		aroundProcesser.addAfterRule(new FireEventRule("1069"));
		
		aroundProcesser.addAfterRule(new WriteBusiLogRule("unEnable"));
		
	}

	private void addBeforeRule(CompareAroundProcesser<MachineVO> aroundProcesser, ValueObjWithErrLog returnValue) {
		// TODO 自动生成的方法存根
		
		 aroundProcesser.addBeforeRule(new StringFieldTrimRule());
		
		 aroundProcesser.addBeforeRule(new BizLockRule());
		 
//		 aroundProcesser.addBeforeRule(new DriverUnEnableStatusFilterRule());
//		 
//		 aroundProcesser.addBeforeRule(new DriverUnEnableDataCheckFilterRule(returnValue));
		 
		 aroundProcesser.addBeforeRule(new MachineSetStatusRule(MachineVO.CSTATUS,MachineStatus.UnEnable.value().toString()));
		 
		 aroundProcesser.addBeforeRule(new UpdateAuditInfoRule());
		 
		 aroundProcesser.addBeforeRule(new FireEventRule("1068"));
		 
	}

}
