package nc.ui.so.qs.mm.machine.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import nc.bs.uif2.BusinessExceptionAdapter;
import nc.ui.querytemplate.filter.IFilter;
import nc.ui.querytemplate.querytree.FromWhereSQL;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.ui.querytemplate.value.IFieldValue;
import nc.ui.querytemplate.value.IFieldValueElement;
import nc.ui.so.qs.mm.machine.service.MachineAppModelService;
import nc.ui.uif2.IShowMsgConstant;
import nc.ui.uif2.ShowStatusBarMsgUtil;
import nc.ui.uif2.components.pagination.BillManagePaginationDelegator;
import nc.ui.uif2.components.pagination.IPaginationModelListener;
import nc.ui.uif2.components.pagination.IPaginationQueryService;
import nc.ui.uif2.components.pagination.PaginationModel;
import nc.ui.uif2.model.IAppModelDataManagerEx;
import nc.ui.uif2.model.IQueryAndRefreshManagerEx;
import nc.vo.logging.Debug;
import nc.vo.pub.BusinessException;

public class MachineInfoDataManager implements IAppModelDataManagerEx,IQueryAndRefreshManagerEx,IPaginationModelListener {
	
	private MachineInfoModel model;
	private PaginationModel paginationModel = null;
	private MachineAppModelService service;
	private BillManagePaginationDelegator delegator = null;
	private String sqlWhere = null;
	private String[] orgIDs = null;
	
	private IQueryScheme scheme = new IQueryScheme(){

		@Override
		public Object get(String arg0) {
			// TODO �Զ����ɵķ������
			return null;
		}

		@Override
		public String getName() {
			// TODO �Զ����ɵķ������
			return null;
		}

		@Override
		public FromWhereSQL getTableJoinFromWhereSQL() {
			// TODO �Զ����ɵķ������
			return null;
		}

		@Override
		public FromWhereSQL getTableListFromWhereSQL() {
			// TODO �Զ����ɵķ������
			return null;
		}

		@Override
		public String getWhereSQLOnly() {
			// TODO �Զ����ɵķ������
			return null;
		}

		@Override
		public void put(String arg0, Object arg1) {}
		
	};
	
	public String[] getOrgIDs() {
		return orgIDs;
	}

	public void setOrgIDs(String[] orgIDs) {
		this.orgIDs = orgIDs;
	}

	public MachineInfoModel getModel() {
		return model;
	}

	public void setModel(MachineInfoModel model) {
		this.model = model;
	}

	public PaginationModel getPaginationModel() {
		return paginationModel;
	}

	public void setPaginationModel(PaginationModel paginationModel) {
		this.paginationModel = paginationModel;
		paginationModel.addPaginationModelListener(this);
		paginationModel.setPaginationQueryService(new IPaginationQueryService(){

			@Override
			public Object[] queryObjectByPks(String[] pks) throws BusinessException {
				// TODO �Զ����ɵķ������
				return MachineInfoDataManager.this.service.queryVOsByPks(pks);
			}
			
		});
	}
	

	public MachineAppModelService getService() {
		return service;
	}

	public void setService(MachineAppModelService service) {
		this.service = service;
	}

	public BillManagePaginationDelegator getDelegator() {
		if (this.delegator == null) {
			this.delegator = new BillManagePaginationDelegator(getModel(), getPaginationModel());
		}
		return this.delegator;
	}

	@Override
	public void initModel() {
		// TODO �Զ����ɵķ������
		setMachineVOPKsTOPaginationModel(null);
	}
	
	private void setMachineVOPKsTOPaginationModel(String[] pks){
		
		try{
			
			this.paginationModel.setObjectPks(pks);
			
		}catch(BusinessException e){
			throw new BusinessExceptionAdapter(e);
		}
		
		
	}

	@Override
	public void refresh() {
		// TODO �Զ����ɵķ������
		initModelBySqlWhere(this.scheme);
	}

	@Override
	public void initModelBySqlWhere(String paramString) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void onStructChanged() {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void onDataReady() {
		// TODO �Զ����ɵķ������
		this.getDelegator().onDataReady();
	}

	@Override
	public void initModelBySqlWhere(IQueryScheme queryscheme) {
		// TODO �Զ����ɵķ������
		this.scheme=queryscheme;
		String[] MachinePKs=null;
		MachinePKs = queryMachineByCon(queryscheme.getWhereSQLOnly());
		setMachineVOPKsTOPaginationModel(MachinePKs);
	}

	private String[] queryMachineByCon(String con) {
		// TODO �Զ����ɵķ������
		this.sqlWhere=con;
		String[] MachinePks=null;
	
		List<String> list = new ArrayList();
		String[] permissionorgs = getFuncPermissionOrgIDs();
		String[] selectedorgs = getOrgID();
		
		if (ArrayUtils.isEmpty(selectedorgs)) {
			
			ShowStatusBarMsgUtil.showStatusBarMsg(IShowMsgConstant.getQueryNullInfo(), getModel().getContext());
			
			return MachinePks;
		}
		
		for (int i = 0; i < permissionorgs.length; i++) {
			
			for (int j = 0; j < selectedorgs.length; j++) {
				
				if (permissionorgs[i].equals(selectedorgs[j])) {
					list.add(permissionorgs[i]);
				}
				
			}
		}
		
		this.orgIDs = ((String[])list.toArray(new String[0]));
		
		try{
			
			MachinePks=this.getService().queryOrgMachineVOsBySql(this.orgIDs, this.sqlWhere);
			
		}catch(BusinessException e){
			Debug.error(e);
			throw new RuntimeException(e);
		}
		
		return MachinePks;
	}
	
	private String[] getOrgID(){
		
		Object obj = this.scheme.get("filters");
		
		if ((obj instanceof IFilter[])) {
			
			IFilter[] filters = (IFilter[])obj;
			
			IFieldValue value = null;
			
			List<IFieldValueElement> list = null;
			
			for (IFilter filter : filters) {
				
				if (filter.getFilterMeta().getFieldCode().equals("pk_org")) {
						
					value = filter.getFieldValue();
					
					if (value != null) {
						
						list = value.getFieldValues();
						
					}
					
					if ((list == null) || (list.size() <= 0)) break;
					
					this.orgIDs = new String[list.size()];
					
					int i = 0;
					
					for (IFieldValueElement element : list) {
						
						this.orgIDs[i] = element.getSqlString();
						
						i++;
						
					}
					
					break;
					
				}

			}
		}
		
		return this.orgIDs;
	}
	
	private String[] getFuncPermissionOrgIDs() {
		// TODO �Զ����ɵķ������
		return getModel().getContext().getFuncInfo().getFuncPermissionPkorgs();
	}


	@Override
	public void setShowSealDataFlag(boolean paramBoolean) {
		// TODO �Զ����ɵķ������

	}

}
