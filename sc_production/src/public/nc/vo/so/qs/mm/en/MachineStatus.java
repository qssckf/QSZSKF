/***************************************************************\
 *     The skeleton of this class is generated by an automatic *
 * code generator for NC product. It is based on Velocity.     *
\***************************************************************/
package nc.vo.so.qs.mm.en;

import nc.md.model.impl.MDEnum;
import nc.md.model.IEnumValue;
	
/**
 * <b> �ڴ˴���Ҫ��������Ĺ��� </b>
 * <p>
 *     �ڴ˴����Ӵ����������Ϣ
 * </p>
 * ��������:
 * @author 
 * @version NCPrj ??
 */
public class MachineStatus extends MDEnum{
	public MachineStatus(IEnumValue enumvalue){
		super(enumvalue);
	}
	
	public static final MachineStatus UnEnable = (MachineStatus)MDEnum.valueOf(MachineStatus.class, "0");
	public static final MachineStatus Enable = (MachineStatus)MDEnum.valueOf(MachineStatus.class, "1");
	public static final MachineStatus Stop = (MachineStatus)MDEnum.valueOf(MachineStatus.class, "2");
	

} 