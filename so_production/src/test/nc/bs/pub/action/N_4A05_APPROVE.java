/*    */ package nc.bs.pub.action;
/*    */ 
/*    */ import java.util.Hashtable;
/*    */ import nc.bs.pub.compiler.AbstractCompiler2;
/*    */ import nc.vo.pub.BusinessException;
/*    */ import nc.vo.pub.compiler.PfParameterVO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class N_4A05_APPROVE
/*    */   extends AbstractCompiler2
/*    */ {
/* 16 */   private Hashtable m_keyHas = null;
/*    */   
/*    */   public N_4A05_APPROVE() {}
/*    */   
/*    */   private void setParameter(String key, Object value)
/*    */   {
/* 22 */     if (this.m_keyHas == null) {
/* 23 */       this.m_keyHas = new Hashtable();
/*    */     }
/* 25 */     if (value != null) {
/* 26 */       this.m_keyHas.put(key, value);
/*    */     }
/*    */   }
/*    */   
/*    */   public Object runComClass(PfParameterVO vo) throws BusinessException {
/* 31 */     this.m_tmpVo = vo;
/*    */     
/*    */ 
/* 34 */     setParameter("asc", this);
/*    */     
/* 36 */     setParameter("parameterVo", vo);
/*    */     
/* 38 */     return runClass("nc.impl.ali.rent.calculate.RentInCalculateImpl", "approveBillVOs", "&asc:nc.bs.pub.compiler.AbstractCompiler2,&parameterVo:nc.vo.pub.compiler.PfParameterVO", vo, this.m_keyHas);
/*    */   }
/*    */ }
