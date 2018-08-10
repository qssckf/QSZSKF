/*    */ package nc.ui.srmpub.action;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import nc.ui.pubapp.pub.power.PowerCheckUtils;
/*    */ import nc.ui.pubapp.uif2app.actions.EditAction;
/*    */ import nc.ui.uif2.model.AbstractAppModel;
/*    */ import nc.vo.pubapp.pattern.model.entity.bill.IBill;
/*    */ import nc.vo.pubapp.pub.power.PowerActionEnum;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SrmPubEditAction
/*    */   extends EditAction
/*    */ {
/*    */   private static final long serialVersionUID = -5898396965477693614L;
/*    */   private String permissioncode;
/*    */   private boolean powercheck;
/*    */   
/*    */   public SrmPubEditAction() {}
/*    */   
/*    */   public void doAction(ActionEvent e)
/*    */     throws Exception
/*    */   {
/* 34 */     IBill bill = (IBill)getModel().getSelectedData();
/* 35 */     if (isPowercheck()) {
/* 36 */       PowerCheckUtils.checkHasPermission(new IBill[] { bill }, getPermissioncode(), PowerActionEnum.EDIT.getActioncode(), "vbillcode");
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 41 */     super.doAction(e);
/*    */   }
/*    */   
/*    */   public String getPermissioncode() {
/* 45 */     return this.permissioncode;
/*    */   }
/*    */   
/*    */   public boolean isPowercheck() {
/* 49 */     return this.powercheck;
/*    */   }
/*    */   
/*    */   public void setPermissioncode(String permissioncode) {
/* 53 */     this.permissioncode = permissioncode;
/*    */   }
/*    */   
/*    */   public void setPowercheck(boolean powercheck) {
/* 57 */     this.powercheck = powercheck;
/*    */   }
/*    */ }

