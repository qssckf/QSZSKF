package nc.ui.so.qs.mm.machine.action.interceptor;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor;
import nc.ui.uif2.NCAction;
import nc.ui.uif2.ShowStatusBarMsgUtil;
import nc.ui.uif2.actions.EditAction;
//import nc.vo.dm.en.CarStatus;
//import nc.vo.so.xlx.tran.CarVO;
import nc.vo.so.qs.mm.machinevo.MachineVO;
import nc.vo.so.qs.mm.en.MachineStatus;

public class MachineCardShowUpComponentInterceptor extends ShowUpComponentInterceptor {

	@Override
	public boolean beforeDoAction(Action action, ActionEvent e) {
		// TODO 自动生成的方法存根
		
		String status=null;
		
		if(action instanceof EditAction){
			
			Object vo=((EditAction)action).getModel().getSelectedData();
			
			if(vo instanceof MachineVO){
				status=((MachineVO)vo).getCstatus();
			}
			
		}
		
		if(status==null){
			return super.beforeDoAction(action, e);
		}else{
			if(status.equals(MachineStatus.Stop.value().toString())){
				ShowStatusBarMsgUtil.showStatusBarMsg("已停用数据不能修改！",((EditAction)action).getModel().getContext());
				return false;
			}else if(!(status.equals(MachineStatus.Enable.value().toString())) && !(status.equals(MachineStatus.UnEnable.value().toString()))){
				
				ShowStatusBarMsgUtil.showStatusBarMsg("运行状态数据不能修改！",((EditAction)action).getModel().getContext());
				return false;
			}
		}
		
		return true;
		
		
	}
	
	

}
