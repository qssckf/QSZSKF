package nc.ui.so.qs.machine.view;

import nc.itf.scmpub.reference.uap.org.OrgUnitPubService;
import nc.ui.bd.ref.model.RegionDefaultRefTreeModel;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.bill.BillItem;
import nc.ui.pubapp.uif2app.view.ShowUpableBillForm;
import nc.ui.so.pub.keyvalue.CardKeyValue;
import nc.ui.uif2.IFunNodeClosingListener;
import nc.ui.uif2.ShowStatusBarMsgUtil;
import nc.ui.uif2.editor.BillForm;
import nc.vo.so.qs.mm.en.MachineStatus;
//import nc.vo.dm.en.CarStatus;
//import nc.vo.dm.en.CarType;
//import nc.vo.dm.en.TailerStatus;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.so.pub.keyvalue.IKeyValue;

public class MachineView extends ShowUpableBillForm {
	


	private IFunNodeClosingListener closingListener;
	
	public IFunNodeClosingListener getClosingListener() {
		return closingListener;
	}

	public void setClosingListener(IFunNodeClosingListener closingListener) {
		this.closingListener = closingListener;
	}

	@Override
	protected void setDefaultValue() {
		// TODO 自动生成的方法存根
		
		IKeyValue keyValue = new CardKeyValue(this.billCardPanel);
		
		String cartype=keyValue.getHeadStringValue("cartype");
		keyValue.setHeadValue("pk_group", getModel().getContext().getPk_group());
		keyValue.setHeadValue("pk_org", getModel().getContext().getPk_org());
		keyValue.setHeadValue("pk_org_v", OrgUnitPubService.getNewVIDByOrgID(getModel().getContext().getPk_org()));
		keyValue.setHeadValue("cstatus", MachineStatus.UnEnable.value().toString());

		//设置card界面是否能编辑
		this.billCardPanel.getHeadItem("pk_group").setEnabled(false);
		this.billCardPanel.getHeadItem("pk_org").setEnabled(false);
		this.billCardPanel.getHeadItem("pk_org_v").setEnabled(false);
		this.billCardPanel.getHeadItem("pk_car").setEnabled(false);
		this.billCardPanel.getHeadItem("cstatus").setEnabled(false);
		
//		if(CarType.BigCar.value().toString().equals(cartype)){
//			this.getBillCardPanel().getHeadItem("pk_tariler").setEnabled(true);
//		}else{
//			this.getBillCardPanel().getHeadItem("pk_tariler").setEnabled(false);
//		}
//		
//		
//		this.billCardPanel.getHeadTailItem("creator").setEnabled(false);
//		this.billCardPanel.getHeadTailItem("creationtime").setEnabled(false);
//		this.billCardPanel.getHeadTailItem("modifier").setEnabled(false);
//		this.billCardPanel.getHeadTailItem("modifiedtime").setEnabled(false);
//		
		
		
	}
	
	@Override
	protected void onEdit() {
		// TODO 自动生成的方法存根
		String status=this.getBillCardPanel().getHeadItem("cstatus").getValue();
		
		super.onEdit();
		
		SetItemEnableStatusWhenEdit(status);
		
	}

	private void SetItemEnableStatusWhenEdit(String status) {
		// TODO 自动生成的方法存根
		
		if(MachineStatus.Enable.value().toString().equals(status)){
			
			this.getBillCardPanel().getHeadItem("pk_group").setEnabled(false);
			
			this.getBillCardPanel().getHeadItem("pk_org").setEnabled(false);
			
			this.getBillCardPanel().getHeadItem("pk_org_v").setEnabled(false);
			
			this.getBillCardPanel().getHeadItem("pk_machine").setEnabled(false);
			
			this.getBillCardPanel().getHeadItem("machinecode").setEnabled(false);
			
			this.getBillCardPanel().getHeadItem("machinename").setEnabled(false);
			
			this.getBillCardPanel().getHeadItem("cartype").setEnabled(false);
			
//			if("2".equals(this.getBillCardPanel().getHeadItem("cartype").getValue())){
//				
//				this.getBillCardPanel().getHeadItem("pk_tariler").setEnabled(false);
//			}
			
			this.getBillCardPanel().getHeadItem("cstatus").setEnabled(false);
			
			this.getBillCardPanel().getHeadItem("engineno").setEnabled(false);
			
			this.billCardPanel.getHeadTailItem("creator").setEnabled(false);
			
			this.billCardPanel.getHeadTailItem("creationtime").setEnabled(false);
			
			this.billCardPanel.getHeadTailItem("modifier").setEnabled(false);
			
			this.billCardPanel.getHeadTailItem("modifiedtime").setEnabled(false);
			
			ShowStatusBarMsgUtil.showStatusBarMsg("数据已经启用，部分关键数据不能修改",this.getModel().getContext());
			
		}else if(MachineStatus.UnEnable.value().toString().equals(status)){
			
			this.getBillCardPanel().getHeadItem("pk_group").setEnabled(false);
			
			this.getBillCardPanel().getHeadItem("pk_org").setEnabled(false);
			
			this.getBillCardPanel().getHeadItem("pk_org_v").setEnabled(false);
			
			this.getBillCardPanel().getHeadItem("pk_car").setEnabled(false);
			
			this.getBillCardPanel().getHeadItem("cstatus").setEnabled(false);
			
//			if("2".equals(this.getBillCardPanel().getHeadItem("cartype").getValue())){
//				
//				this.getBillCardPanel().getHeadItem("pk_tariler").setEnabled(false);
//			}
			
			this.billCardPanel.getHeadTailItem("creator").setEnabled(false);
			
			this.billCardPanel.getHeadTailItem("creationtime").setEnabled(false);
			
			this.billCardPanel.getHeadTailItem("modifier").setEnabled(false);
			
			this.billCardPanel.getHeadTailItem("modifiedtime").setEnabled(false);
		}
		
		
		
	}
}
