/*   1:    */ package SecuGen.FDxSDKPro.jni;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/*   2:    */ 
/*   3:    */ public class JSGFPLib
/*   4:    */ {
/*   5:    */   public long jniLoadStatus;
/*   6:    */   public static final int MAX_IMAGE_WIDTH_ALL_DEVICES = 260;
/*   7:    */   public static final int MAX_IMAGE_HEIGHT_ALL_DEVICES = 336;
/*   8:    */   
/*   9:    */   public JSGFPLib()
/*  10:    */   {
/*  11: 49 */     this.jniLoadStatus = Open();
/*  12:    */   }
/*  13:    */   
/*  14:    */   private long Open()
/*  15:    */   {
/*  16: 59 */     return SGFPM_Create();
/*  17:    */   }
/*  18:    */   
/*  19:    */   public long Close()
/*  20:    */   {
/*  21: 71 */     return SGFPM_Terminate();
/*  22:    */   }
/*  23:    */   

private final static String lib = "jnisgfplib";

private static File current = new java.io.File( "." );
    private static String path = "";
    
    static {
        try {
            path = current.getCanonicalPath();
            System.load(path+"\\"+lib+".dll");
        } catch (UnsatisfiedLinkError | IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
    }
/*  28:    */   
/*  29:    */   public String toString()
/*  30:    */   {
/*  31: 88 */     long l1 = Greeting();
/*  32: 89 */     long l2 = l1 >> 24 & 0xFF;
/*  33: 90 */     long l3 = l1 >> 16 & 0xFF;
/*  34: 91 */     long l4 = l1 >> 8 & 0xFF;
/*  35: 92 */     long l5 = l1 & 0xFF;
/*  36: 93 */     return "SecuGen JSGFPLib version: " + l2 + "." + l3 + "." + l4 + "." + l5;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public long EnumerateDevice(int[] paramArrayOfInt, SGDeviceList[] paramArrayOfSGDeviceList)
/*  40:    */   {
/*  41:106 */     int i = 10;
/*  42:107 */     long l = 2L;
/*  43:108 */     int[] arrayOfInt1 = new int[1];
/*  44:109 */     int[] arrayOfInt2 = new int[i];
/*  45:110 */     int[] arrayOfInt3 = new int[i];
/*  46:111 */     int[] arrayOfInt4 = new int[i];
/*  47:112 */     byte[] arrayOfByte = new byte[16 * i];
/*  48:113 */     if (this.jniLoadStatus == 0L)
/*  49:    */     {
/*  50:114 */       l = GetEnumeratedDevices(paramArrayOfInt, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfByte);
/*  51:115 */       if (l == 0L)
/*  52:    */       {
/*  53:116 */         if (paramArrayOfInt[0] > 10) {
/*  54:117 */           paramArrayOfInt[0] = 10;
/*  55:    */         }
/*  56:118 */         for (int j = 0; j < paramArrayOfInt[0]; j++)
/*  57:    */         {
/*  58:119 */           paramArrayOfSGDeviceList[j].devName = arrayOfInt2[j];
/*  59:120 */           paramArrayOfSGDeviceList[j].devID = arrayOfInt3[j];
/*  60:121 */           paramArrayOfSGDeviceList[j].devType = arrayOfInt4[j];
/*  61:122 */           paramArrayOfSGDeviceList[j].devName = arrayOfInt2[j];
/*  62:123 */           int k = 0;
/*  63:124 */           for (int m = 0; m < 16; m++)
/*  64:    */           {
/*  65:126 */             paramArrayOfSGDeviceList[j].setSNByte(k, arrayOfByte[(m + j * 16)]);
/*  66:127 */             k++;
/*  67:    */           }
/*  68:    */         }
/*  69:    */       }
/*  70:    */     }
/*  71:132 */     return l;
/*  72:    */   }
/*  73:    */   
/*  74:    */   private native long SGFPM_Create();
/*  75:    */   
/*  76:    */   private native long SGFPM_Terminate();
/*  77:    */   
/*  78:    */   private native long Greeting();
/*  79:    */   
/*  80:    */   private native long GetEnumeratedDevices(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, byte[] paramArrayOfByte);
/*  81:    */   
/*  82:    */   public native long GetLastError();
/*  83:    */   
/*  84:    */   public native long Init(long paramLong);
/*  85:    */   
/*  86:    */   public native long InitEx(long paramLong1, long paramLong2, long paramLong3);
/*  87:    */   
/*  88:    */   public native long SetTemplateFormat(short paramShort);
/*  89:    */   
/*  90:    */   public native long OpenDevice(long paramLong);
/*  91:    */   
/*  92:    */   public native long CloseDevice();
/*  93:    */   
/*  94:    */   public native long GetDeviceInfo(SGDeviceInfoParam paramSGDeviceInfoParam);
/*  95:    */   
/*  96:    */   public native long Configure(long paramLong);
/*  97:    */   
/*  98:    */   public native long SetBrightness(long paramLong);
/*  99:    */   
/* 100:    */   public native long SetLedOn(boolean paramBoolean);
/* 101:    */   
/* 102:    */   public native long GetImage(byte[] paramArrayOfByte);
/* 103:    */   
/* 104:    */   public native long GetImageEx(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3);
/* 105:    */   
/* 106:    */   public native long GetImageQuality(long paramLong1, long paramLong2, byte[] paramArrayOfByte, int[] paramArrayOfInt);
/* 107:    */   
/* 108:    */   public native long GetMaxTemplateSize(int[] paramArrayOfInt);
/* 109:    */   
/* 110:    */   public native long CreateTemplate(SGFingerInfo paramSGFingerInfo, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
/* 111:    */   
/* 112:    */   public native long GetTemplateSize(byte[] paramArrayOfByte, int[] paramArrayOfInt);
/* 113:    */   
/* 114:    */   public native long MatchTemplate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, boolean[] paramArrayOfBoolean);
/* 115:    */   
/* 116:    */   public native long GetMatchingScore(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int[] paramArrayOfInt);
/* 117:    */   
/* 118:    */   public native long GetTemplateSizeAfterMerge(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int[] paramArrayOfInt);
/* 119:    */   
/* 120:    */   public native long MergeAnsiTemplate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
/* 121:    */   
/* 122:    */   public native long GetAnsiTemplateInfo(byte[] paramArrayOfByte, SGANSITemplateInfo paramSGANSITemplateInfo);
/* 123:    */   
/* 124:    */   public native long MatchAnsiTemplate(byte[] paramArrayOfByte1, long paramLong1, byte[] paramArrayOfByte2, long paramLong2, long paramLong3, boolean[] paramArrayOfBoolean);
/* 125:    */   
/* 126:    */   public native long GetAnsiMatchingScore(byte[] paramArrayOfByte1, long paramLong1, byte[] paramArrayOfByte2, long paramLong2, int[] paramArrayOfInt);
/* 127:    */   
/* 128:    */   public native long GetIsoTemplateSizeAfterMerge(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int[] paramArrayOfInt);
/* 129:    */   
/* 130:    */   public native long MergeIsoTemplate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
/* 131:    */   
/* 132:    */   public native long GetIsoTemplateInfo(byte[] paramArrayOfByte, SGISOTemplateInfo paramSGISOTemplateInfo);
/* 133:    */   
/* 134:    */   public native long MatchIsoTemplate(byte[] paramArrayOfByte1, long paramLong1, byte[] paramArrayOfByte2, long paramLong2, long paramLong3, boolean[] paramArrayOfBoolean);
/* 135:    */   
/* 136:    */   public native long GetIsoMatchingScore(byte[] paramArrayOfByte1, long paramLong1, byte[] paramArrayOfByte2, long paramLong2, int[] paramArrayOfInt);
/* 137:    */   
/* 138:    */   public native long MatchTemplateEx(byte[] paramArrayOfByte1, short paramShort1, long paramLong1, byte[] paramArrayOfByte2, short paramShort2, long paramLong2, long paramLong3, boolean[] paramArrayOfBoolean);
/* 139:    */   
/* 140:    */   public native long GetMatchingScoreEx(byte[] paramArrayOfByte1, short paramShort1, long paramLong1, byte[] paramArrayOfByte2, short paramShort2, long paramLong2, int[] paramArrayOfInt);
/* 141:    */   
/* 142:    */   public native long GetMinexVersion(int[] paramArrayOfInt1, int[] paramArrayOfInt2);
/* 143:    */ }
