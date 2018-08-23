package nc.bs.bd.so.qs.machine.plugin.bpplugin;

import nc.impl.pubapp.pattern.rule.plugin.IPluginPoint;

public enum MachinePluginPoint implements IPluginPoint {
	DELETE,  INSERT,  UPDATE,  UNENABLE, ENABLE,  DISABLE;

	@Override
	public String getComponent() {
		// TODO 自动生成的方法存根
		return "MachineVO";
	}

	@Override
	public String getModule() {
		// TODO 自动生成的方法存根
		return "so";
	}

	@Override
	public String getPoint() {
		// TODO 自动生成的方法存根
		return getClass().getName() + "." + name();
	}

}
