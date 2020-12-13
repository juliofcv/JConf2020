/*   1:    */ package SecuGen.FDxSDKPro.jni;
/*   2:    */ 
/*   3:    */ public class SGDeviceList
/*   4:    */ {
/*   5:    */   public int devName;
/*   6:    */   public int devID;
/*   7:    */   public int devType;
/*   8:    */   private byte[] deviceSNbuf;
/*   9:    */   private byte deviceSNbuf0;
/*  10:    */   private byte deviceSNbuf1;
/*  11:    */   private byte deviceSNbuf2;
/*  12:    */   private byte deviceSNbuf3;
/*  13:    */   private byte deviceSNbuf4;
/*  14:    */   private byte deviceSNbuf5;
/*  15:    */   private byte deviceSNbuf6;
/*  16:    */   private byte deviceSNbuf7;
/*  17:    */   private byte deviceSNbuf8;
/*  18:    */   private byte deviceSNbuf9;
/*  19:    */   private byte deviceSNbuf10;
/*  20:    */   private byte deviceSNbuf11;
/*  21:    */   private byte deviceSNbuf12;
/*  22:    */   private byte deviceSNbuf13;
/*  23:    */   private byte deviceSNbuf14;
/*  24:    */   private byte deviceSNbuf15;
/*  25:    */   
/*  26:    */   public SGDeviceList()
/*  27:    */   {
/*  28: 13 */     this.devName = 0;
/*  29: 14 */     this.devID = 0;
/*  30: 15 */     this.devType = 0;
/*  31: 16 */     this.deviceSNbuf = new byte[16];
/*  32: 17 */     for (int i = 0; i < 16; i++) {
/*  33: 18 */       this.deviceSNbuf[i] = 32;
/*  34:    */     }
/*  35:    */   }
/*  36:    */   
/*  37:    */   public void setSNByte(int paramInt, byte paramByte)
/*  38:    */   {
/*  39: 42 */     switch (paramInt)
/*  40:    */     {
/*  41:    */     case 0: 
/*  42: 44 */       this.deviceSNbuf0 = paramByte;
/*  43: 45 */       break;
/*  44:    */     case 1: 
/*  45: 47 */       this.deviceSNbuf1 = paramByte;
/*  46: 48 */       break;
/*  47:    */     case 2: 
/*  48: 50 */       this.deviceSNbuf2 = paramByte;
/*  49: 51 */       break;
/*  50:    */     case 3: 
/*  51: 53 */       this.deviceSNbuf3 = paramByte;
/*  52: 54 */       break;
/*  53:    */     case 4: 
/*  54: 56 */       this.deviceSNbuf4 = paramByte;
/*  55: 57 */       break;
/*  56:    */     case 5: 
/*  57: 59 */       this.deviceSNbuf5 = paramByte;
/*  58: 60 */       break;
/*  59:    */     case 6: 
/*  60: 62 */       this.deviceSNbuf6 = paramByte;
/*  61: 63 */       break;
/*  62:    */     case 7: 
/*  63: 65 */       this.deviceSNbuf7 = paramByte;
/*  64: 66 */       break;
/*  65:    */     case 8: 
/*  66: 68 */       this.deviceSNbuf8 = paramByte;
/*  67: 69 */       break;
/*  68:    */     case 9: 
/*  69: 71 */       this.deviceSNbuf9 = paramByte;
/*  70: 72 */       break;
/*  71:    */     case 10: 
/*  72: 74 */       this.deviceSNbuf10 = paramByte;
/*  73: 75 */       break;
/*  74:    */     case 11: 
/*  75: 77 */       this.deviceSNbuf11 = paramByte;
/*  76: 78 */       break;
/*  77:    */     case 12: 
/*  78: 80 */       this.deviceSNbuf12 = paramByte;
/*  79: 81 */       break;
/*  80:    */     case 13: 
/*  81: 83 */       this.deviceSNbuf13 = paramByte;
/*  82: 84 */       break;
/*  83:    */     case 14: 
/*  84: 86 */       this.deviceSNbuf14 = paramByte;
/*  85: 87 */       break;
/*  86:    */     case 15: 
/*  87: 89 */       this.deviceSNbuf15 = paramByte;
/*  88:    */     }
/*  89:    */   }
/*  90:    */   
/*  91:    */   public byte[] deviceSN()
/*  92:    */   {
/*  93: 95 */     this.deviceSNbuf[0] = this.deviceSNbuf0;
/*  94: 96 */     this.deviceSNbuf[1] = this.deviceSNbuf1;
/*  95: 97 */     this.deviceSNbuf[2] = this.deviceSNbuf2;
/*  96: 98 */     this.deviceSNbuf[3] = this.deviceSNbuf3;
/*  97: 99 */     this.deviceSNbuf[4] = this.deviceSNbuf4;
/*  98:100 */     this.deviceSNbuf[5] = this.deviceSNbuf5;
/*  99:101 */     this.deviceSNbuf[6] = this.deviceSNbuf6;
/* 100:102 */     this.deviceSNbuf[7] = this.deviceSNbuf7;
/* 101:103 */     this.deviceSNbuf[8] = this.deviceSNbuf8;
/* 102:104 */     this.deviceSNbuf[9] = this.deviceSNbuf9;
/* 103:105 */     this.deviceSNbuf[10] = this.deviceSNbuf10;
/* 104:106 */     this.deviceSNbuf[11] = this.deviceSNbuf11;
/* 105:107 */     this.deviceSNbuf[12] = this.deviceSNbuf12;
/* 106:108 */     this.deviceSNbuf[13] = this.deviceSNbuf13;
/* 107:109 */     this.deviceSNbuf[14] = this.deviceSNbuf14;
/* 108:110 */     this.deviceSNbuf[15] = this.deviceSNbuf15;
/* 109:    */     
/* 110:    */ 
/* 111:    */ 
/* 112:    */ 
/* 113:    */ 
/* 114:    */ 
/* 115:117 */     return this.deviceSNbuf;
/* 116:    */   }
/* 117:    */ }


