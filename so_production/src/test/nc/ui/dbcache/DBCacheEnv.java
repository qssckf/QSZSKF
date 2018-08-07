/*    */ package nc.ui.dbcache;
/*    */ 
/*    */ 
/*    */ public class DBCacheEnv
/*    */ {
/*    */   public DBCacheEnv() {}
/*    */   
/*    */   public static boolean isCacheEnabled()
/*    */   {
/* 10 */     CacheInstance instance = CacheInstance.fetchCurrentCacheInstance();
/* 11 */     if (instance == null) {
/* 12 */       return false;
/*    */     }
/* 14 */     return instance.isUsable();
/*    */   }
/*    */   
/* 17 */   public static boolean isCacheInited() { CacheInstance instance = CacheInstance.fetchCurrentCacheInstance();
/* 18 */     if (instance == null) {
/* 19 */       return false;
/*    */     }
			 System.out.println("hello!");
/* 21 */     return instance.isCacheInited();
			
/*    */   }
/*    */ }

