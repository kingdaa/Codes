/*     */ import java.io.PrintStream;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class Timing
/*     */ {
/*   5 */   private static long counter = 0L;
/*     */ 
/*     */   private static long constant(int paramInt) {
/*   8 */     long l = 0L;
/*   9 */     for (int i = 0; i < paramInt; i++)
/*  10 */       l += 1L;
/*  11 */     return l;
/*     */   }
/*     */ 
/*     */   private static long logarithmic(int paramInt1, int paramInt2) {
/*  15 */     long l = 0L;
/*  16 */     for (int i = 1; i + i <= paramInt1; i += i)
/*  17 */       l += constant(paramInt2);
/*  18 */     return l;
/*     */   }
/*     */ 
/*     */   private static long sqrt(int paramInt1, int paramInt2) {
/*  22 */     long l = 0L;
/*  23 */     int i = 0; for (int j = 0; j < paramInt1; i++) {
/*  24 */       l += constant(paramInt2);
/*     */ 
/*  23 */       j += i;
/*     */     }
/*     */ 
/*  26 */     return l;
/*     */   }
/*     */ 
/*     */   public static long linearithmic(int paramInt1, int paramInt2) {
/*  30 */     if (paramInt1 == 0) return 0L;
/*  31 */     long l = 0L;
/*  32 */     for (int i = 0; i < paramInt1; i++)
/*  33 */       l += constant(paramInt2);
/*  34 */     return linearithmic(paramInt1 / 2, paramInt2) + l + linearithmic(paramInt1 / 2, paramInt2);
/*     */   }
/*     */ 
/*     */   private static long linear(int paramInt1, int paramInt2) {
/*  38 */     long l = 0L;
/*  39 */     for (int i = 0; i < paramInt1; i++)
/*  40 */       l += constant(paramInt2);
/*  41 */     return l;
/*     */   }
/*     */ 
/*     */   private static long linearsqrt(int paramInt1, int paramInt2) {
/*  45 */     long l = 0L;
/*  46 */     for (int i = 0; i < paramInt1; i++) {
/*  47 */       l += sqrt(paramInt1, paramInt2);
/*     */     }
/*  49 */     return l;
/*     */   }
/*     */ 
/*     */   private static long quadratic(int paramInt1, int paramInt2) {
/*  53 */     long l = 0L;
/*  54 */     for (int i = 0; i < paramInt1; i++)
/*  55 */       for (int j = 0; j < paramInt1; j++)
/*  56 */         l += constant(paramInt2);
/*  57 */     return l;
/*     */   }
/*     */ 
/*     */   private static long exponential(int paramInt1, int paramInt2) {
/*  61 */     if (paramInt1 == 0) return constant(paramInt2);
/*  62 */     return exponential(paramInt1 - 1, paramInt2) + exponential(paramInt1 - 1, paramInt2);
/*     */   }
/*     */ 
/*     */   private static long factorial(int paramInt1, int paramInt2) {
/*  66 */     if (paramInt1 == 0) return constant(paramInt2);
/*  67 */     long l = 0L;
/*  68 */     for (int i = 0; i < paramInt1; i++)
/*  69 */       l += factorial(paramInt1 - 1, paramInt2);
/*  70 */     return l;
/*     */   }
/*     */ 
/*     */   private static long divideAndConquer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
/*     */   {
/*  75 */     if (paramInt1 == 0) return 0L;
/*  76 */     long l = constant(paramInt2);
/*  77 */     for (int i = 0; i < paramInt3; i++) {
/*  78 */       l += divideAndConquer(paramInt1 / paramInt4, paramInt2, paramInt3, paramInt4);
/*     */     }
/*  80 */     return l;
/*     */   }
/*     */ 
/*     */   private static long powerLaw(int paramInt1, int paramInt2, double paramDouble)
/*     */   {
/*  85 */     long l1 = 0L;
/*  86 */     for (long l2 = 0L; l2 < Math.pow(paramInt1, paramDouble); l2 += 1L) {
/*  87 */       l1 += constant(paramInt2);
/*     */     }
/*  89 */     return l1;
/*     */   }
/*     */ 
/*     */   public static void trial(int paramInt, long paramLong) {
/*  93 */     if (paramInt <= 0) throw new IllegalArgumentException("N must be a positive integer");
/*  94 */     if (paramLong <= 0L) throw new IllegalArgumentException("seed must be a positive integer"); 
/*     */ Random localRandom = new Random(paramLong);
/*     */ 
/* 100 */     int i = 1 + localRandom.nextInt(20);
/* 101 */     double d1 = 1.2D + 2.1D * localRandom.nextDouble();
/*     */ 
/* 105 */     int j = 15;
/* 106 */     int k = 0; int m = 1;
/* 107 */     int n = 1; int i1 = 0;
/* 108 */     int i2 = k; int i3 = m;
/* 109 */     double d2 = Math.abs(d1);
/*     */     double d3;
/*     */     do { int i4 = k + n;
/* 116 */       int i5 = m + i1;
/* 117 */       d3 = i4 / i5;
/* 118 */       if (d1 < d3) { n = i4; i1 = i5; } else {
/* 119 */         k = i4; m = i5;
/*     */       }
/*     */ 
/* 122 */       double d4 = Math.abs(d3 - d1);
/* 123 */       if (d4 < d2) {
/* 124 */         i2 = i4;
/* 125 */         i3 = i5;
/* 126 */         d2 = d4;
/*     */       }
/*     */     }
/* 129 */     while (m + i1 <= j);
/*     */ 
/* 131 */     d1 = d3;
/*     */ 
/* 133 */     long l = powerLaw(paramInt, i, d1);
/* 134 */     counter += l;
/*     */   }
/*     */ 
/*     */   public static void main(String[] paramArrayOfString)
/*     */   {
/* 139 */     int i = 0;
/* 140 */     int j = 0;
/*     */ 
/* 142 */     if (paramArrayOfString.length != 2) {
/* 143 */       System.out.println("You must supply two postive integer command-line arguments: N and seed");
/* 144 */       return;
/*     */     }
/*     */     try {
/* 147 */       i = Integer.parseInt(paramArrayOfString[0]);
/* 148 */       j = Integer.parseInt(paramArrayOfString[1]);
/*     */     }
/*     */     catch (NumberFormatException localNumberFormatException) {
/* 151 */       System.out.println("You must supply two postive integer command-line arguments: N and seed");
/* 152 */       return;
/*     */     }
/*     */ 
/* 155 */     trial(i, j);
/*     */   }
/*     */ }

/* Location:           E:\Coursea\Algorithms I\Quiz1\
 * Qualified Name:     Timing
 * JD-Core Version:    0.6.0
 */