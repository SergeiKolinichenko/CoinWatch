package info.sergeikolinichenko.coinwatch.models.db;

/**
 * Created by Sergei Kolinichenko on 26.10.2023 at 19:45 (GMT+3)
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003JY\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006!"}, d2 = {"Linfo/sergeikolinichenko/coinwatch/models/db/CoinPairPriceDb;", "", "fromSymbol", "", "fromSymbolImg", "toSymbol", "toSymbolSym", "price", "updateDate", "updateTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFromSymbol", "()Ljava/lang/String;", "getFromSymbolImg", "getPrice", "getToSymbol", "getToSymbolSym", "getUpdateDate", "getUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "data_debug"})
public final class CoinPairPriceDb {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String fromSymbol = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String fromSymbolImg = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String toSymbol = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String toSymbolSym = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String price = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String updateDate = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String updateTime = null;
    
    public CoinPairPriceDb(@org.jetbrains.annotations.NotNull
    java.lang.String fromSymbol, @org.jetbrains.annotations.Nullable
    java.lang.String fromSymbolImg, @org.jetbrains.annotations.NotNull
    java.lang.String toSymbol, @org.jetbrains.annotations.Nullable
    java.lang.String toSymbolSym, @org.jetbrains.annotations.Nullable
    java.lang.String price, @org.jetbrains.annotations.Nullable
    java.lang.String updateDate, @org.jetbrains.annotations.Nullable
    java.lang.String updateTime) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFromSymbol() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFromSymbolImg() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getToSymbol() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getToSymbolSym() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPrice() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getUpdateDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getUpdateTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final info.sergeikolinichenko.coinwatch.models.db.CoinPairPriceDb copy(@org.jetbrains.annotations.NotNull
    java.lang.String fromSymbol, @org.jetbrains.annotations.Nullable
    java.lang.String fromSymbolImg, @org.jetbrains.annotations.NotNull
    java.lang.String toSymbol, @org.jetbrains.annotations.Nullable
    java.lang.String toSymbolSym, @org.jetbrains.annotations.Nullable
    java.lang.String price, @org.jetbrains.annotations.Nullable
    java.lang.String updateDate, @org.jetbrains.annotations.Nullable
    java.lang.String updateTime) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}