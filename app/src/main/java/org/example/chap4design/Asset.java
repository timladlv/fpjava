package org.example.chap4design;

public record Asset(AssetType assetType, int value) {
    public enum AssetType {BOND, STOCK}
}
