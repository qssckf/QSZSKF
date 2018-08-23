package nc.ui.so.qs.mm.machine.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import nc.ui.so.qs.model.IAppModelExService;
//import nc.ui.so.xlx.tran.driver.service.DriverAppModelService;
import nc.ui.uif2.model.BillManageModel;
import nc.ui.uif2.model.IAppModelService;
import nc.ui.uif2.model.NullModelService;
import nc.ui.so.qs.mm.machine.service.MachineAppModelService;
import nc.vo.so.qs.mm.machinevo.MachineVO;


public class MachineInfoModel extends BillManageModel {

	@Override
	public void delete() throws Exception {
		// TODO 自动生成的方法存根
		
		if((getSelectedOperaRows() != null) && (getSelectedOperaRows().length > 0)){
			deleteMultiRows();
		}else{
			super.deleteSeletedRow();
		}
	}

	@Override
	protected void deleteMultiRows() throws Exception {
		// TODO 自动生成的方法存根
		
		Object[] delObjects = new Object[getSelectedOperaDatas().length];
		
		for (int i = 0; i < delObjects.length; i++) {
			delObjects[i] = getSelectedOperaDatas()[i];
		}
		
		dbDeleteMultiRows(delObjects);
//		directlyDelete(filterDeletedDriverVO(getDriverVOPks(),delObjects));
	}
	
//	private String[] getDriverVOPks(){
//		
//		return ((MachineAppModelService)this.getService()).getDeletedSucBalVOPks();
//		
//	}
	
//	private Object[] filterDeletedDriverVO(String[] DeletePks,Object[] objects){
//		
//		List<Object> filterObject = new ArrayList();
//		List<String> filterPk = new ArrayList();
//		filterPk = Arrays.asList(DeletePks);
//		for (Object obj : objects) {
//			MachineVO vo=(MachineVO)obj;	
//			if (filterPk.contains(vo.getPk_machine())) {
//				filterObject.add(vo);
//			}
//			
//		}
//		
//		return filterObject.toArray(new Object[filterObject.size()]);
//		
//	}
	
	@Override
	protected void dbDeleteMultiRows(Object... deletedObjects) throws Exception {
		// TODO 自动生成的方法存根
		getService().delete(deletedObjects);
	}
	
	
	
	
	
	

}
