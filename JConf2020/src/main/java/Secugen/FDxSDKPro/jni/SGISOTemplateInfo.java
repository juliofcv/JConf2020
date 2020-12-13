/*  1:   */ package SecuGen.FDxSDKPro.jni;
/*  2:   */ 
/*  3:   */ public class SGISOTemplateInfo
/*  4:   */ {
/*  5:   */   public int TotalSamples;
/*  6:   */   public SGFingerInfo[] SampleInfo;
/*  7:   */   
/*  8:   */   public SGISOTemplateInfo()
/*  9:   */   {
/* 10:22 */     this.SampleInfo = new SGFingerInfo[225];
/* 11:23 */     for (int i = 0; i < 225; i++) {
/* 12:24 */       this.SampleInfo[i] = new SGFingerInfo();
/* 13:   */     }
/* 14:   */   }
/* 15:   */   
/* 16:   */   private void SetFingerInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
/* 17:   */   {
/* 18:33 */     this.SampleInfo[paramInt1].FingerNumber = paramInt2;
/* 19:34 */     this.SampleInfo[paramInt1].ViewNumber = paramInt3;
/* 20:35 */     this.SampleInfo[paramInt1].ImpressionType = paramInt4;
/* 21:36 */     this.SampleInfo[paramInt1].ImageQuality = paramInt5;
/* 22:   */   }
/* 23:   */ }



/* Location:           D:\gigaDatta\CLIENTES\G4S\DPI Match\drivers\SECUGEN\FDx SDK Pro for Java v1.4 rev593\FDxSDKPro.jar

 * Qualified Name:     SecuGen.FDxSDKPro.jni.SGISOTemplateInfo

 * JD-Core Version:    0.7.0.1

 */