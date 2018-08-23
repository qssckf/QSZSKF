package nc.bs.bd.so.qs.machine.plugin.bpplugin;

import nc.impl.pubapp.pattern.rule.plugin.IPluginPoint;

public enum MachinePluginPoint implements IPluginPoint {
	DELETE,  INSERT,  UPDATE,  UNENABLE, ENABLE,  DISABLE;

	@Override
	public String getComponent() {
		// TODO �Զ����ɵķ������
		return "MachineVO";
	}

	@Override
	public String getModule() {
		// TODO �Զ����ɵķ������
		return "so";
	}

	@Override
	public String getPoint() {
		// TODO �Զ����ɵķ������
		return getClass().getName() + "." + name();
	}

}
