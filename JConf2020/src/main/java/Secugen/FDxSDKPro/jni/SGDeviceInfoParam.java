/*   1:    */ package SecuGen.FDxSDKPro.jni;
/*   2:    */ 
/*   3:    */ public class SGDeviceInfoParam
/*   4:    */ {
/*   5:    */   public int deviceID;
/*   6:    */   public int comPort;
/*   7:    */   public int comSpeed;
/*   8:    */   public int imageWidth;
/*   9:    */   public int imageHeight;
/*  10:    */   public int contrast;
/*  11:    */   public int brightness;
/*  12:    */   public int gain;
/*  13:    */   public int imageDPI;
/*  14:    */   public int FWVersion;
/*  15:    */   private byte[] deviceSNbuf;
/*  16:    */   private byte deviceSNbuf0;
/*  17:    */   private byte deviceSNbuf1;
/*  18:    */   private byte deviceSNbuf2;
/*  19:    */   private byte deviceSNbuf3;
/*  20:    */   private byte deviceSNbuf4;
/*  21:    */   private byte deviceSNbuf5;
/*  22:    */   private byte deviceSNbuf6;
/*  23:    */   private byte deviceSNbuf7;
/*  24:    */   private byte deviceSNbuf8;
/*  25:    */   private byte deviceSNbuf9;
/*  26:    */   private byte deviceSNbuf10;
/*  27:    */   private byte deviceSNbuf11;
/*  28:    */   private byte deviceSNbuf12;
/*  29:    */   private byte deviceSNbuf13;
/*  30:    */   private byte deviceSNbuf14;
/*  31:    */   private byte deviceSNbuf15;
/*  32:    */   
/*  33:    */   public SGDeviceInfoParam()
/*  34:    */   {
/*  35: 20 */     this.deviceID = 0;
/*  36: 21 */     this.deviceSNbuf = new byte[16];
/*  37: 22 */     for (int i = 0; i < 16; i++) {
/*  38: 23 */       this.deviceSNbuf[i] = 32;
/*  39:    */     }
/*  40: 24 */     this.comPort = 0;
/*  41: 25 */     this.comSpeed = 0;
/*  42: 26 */     this.imageWidth = 0;
/*  43: 27 */     this.imageHeight = 0;
/*  44: 28 */     this.contrast = 0;
/*  45: 29 */     this.brightness = 0;
/*  46: 30 */     this.gain = 0;
/*  47: 31 */     this.imageDPI = 0;
/*  48: 32 */     this.FWVersion = 0;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public byte[] deviceSN()
/*  52:    */   {
/*  53: 99 */     this.deviceSNbuf[0] = this.deviceSNbuf0;
/*  54:100 */     this.deviceSNbuf[1] = this.deviceSNbuf1;
/*  55:101 */     this.deviceSNbuf[2] = this.deviceSNbuf2;
/*  56:102 */     this.deviceSNbuf[3] = this.deviceSNbuf3;
/*  57:103 */     this.deviceSNbuf[4] = this.deviceSNbuf4;
/*  58:104 */     this.deviceSNbuf[5] = this.deviceSNbuf5;
/*  59:105 */     this.deviceSNbuf[6] = this.deviceSNbuf6;
/*  60:106 */     this.deviceSNbuf[7] = this.deviceSNbuf7;
/*  61:107 */     this.deviceSNbuf[8] = this.deviceSNbuf8;
/*  62:108 */     this.deviceSNbuf[9] = this.deviceSNbuf9;
/*  63:109 */     this.deviceSNbuf[10] = this.deviceSNbuf10;
/*  64:110 */     this.deviceSNbuf[11] = this.deviceSNbuf11;
/*  65:111 */     this.deviceSNbuf[12] = this.deviceSNbuf12;
/*  66:112 */     this.deviceSNbuf[13] = this.deviceSNbuf13;
/*  67:113 */     this.deviceSNbuf[14] = this.deviceSNbuf14;
/*  68:114 */     if (this.deviceSNbuf15 == 0) {
/*  69:115 */       this.deviceSNbuf[15] = 32;
/*  70:    */     } else {
/*  71:117 */       this.deviceSNbuf[15] = this.deviceSNbuf15;
/*  72:    */     }
/*  73:118 */     return this.deviceSNbuf;
/*  74:    */   }
/*  75:    */ }
