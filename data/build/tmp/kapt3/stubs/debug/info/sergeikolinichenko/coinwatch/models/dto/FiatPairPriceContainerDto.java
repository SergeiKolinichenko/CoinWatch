package info.sergeikolinichenko.coinwatch.models.dto;

/**
 * Created by Sergei Kolinichenko on 07.12.2023 at 20:59 (GMT+3)
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Linfo/sergeikolinichenko/coinwatch/models/dto/FiatPairPriceContainerDto;", "", "fromSymbol", "", "toSymbols", "Lcom/google/gson/JsonObject;", "update", "", "(Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/Integer;)V", "getFromSymbol", "()Ljava/lang/String;", "getToSymbols", "()Lcom/google/gson/JsonObject;", "getUpdate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/Integer;)Linfo/sergeikolinichenko/coinwatch/models/dto/FiatPairPriceContainerDto;", "equals", "", "other", "hashCode", "toString", "data_debug"})
public final class FiatPairPriceContainerDto {
    @com.google.gson.annotations.SerializedName(value = "base")
    @org.jetbrains.annotations.Nullable
    private final java.lang.String fromSymbol = null;
    @com.google.gson.annotations.SerializedName(value = "rates")
    @org.jetbrains.annotations.Nullable
    private final com.google.gson.JsonObject toSymbols = null;
    @com.google.gson.annotations.SerializedName(value = "timestamp")
    @org.jetbrains.annotations.Nullable
    private final java.lang.Integer update = null;
    
    public FiatPairPriceContainerDto(@org.jetbrains.annotations.Nullable
    java.lang.String fromSymbol, @org.jetbrains.annotations.Nullable
    com.google.gson.JsonObject toSymbols, @org.jetbrains.annotations.Nullable
    java.lang.Integer update) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFromSymbol() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.gson.JsonObject getToSymbols() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getUpdate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.gson.JsonObject component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final info.sergeikolinichenko.coinwatch.models.dto.FiatPairPriceContainerDto copy(@org.jetbrains.annotations.Nullable
    java.lang.String fromSymbol, @org.jetbrains.annotations.Nullable
    com.google.gson.JsonObject toSymbols, @org.jetbrains.annotations.Nullable
    java.lang.Integer update) {
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