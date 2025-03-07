package org.example.chap4design;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PredicateParameterTest {
    private static final List<Asset> ASSETS = List.of(
            new Asset(Asset.AssetType.BOND, 100),
            new Asset(Asset.AssetType.STOCK, 200),
            new Asset(Asset.AssetType.BOND, 300),
            new Asset(Asset.AssetType.STOCK, 400)
    );
    private PredicateParameter uut = new PredicateParameter();

    @Test
    void testPredicateGetAll() {
        int sum = uut.sumValue(ASSETS, a -> true);

        assertThat(sum).isEqualTo(1_000);
    }

    @Test
    void testPredicateGetBonds() {
        int sum = uut.sumValue(ASSETS, a -> Asset.AssetType.BOND.equals(a.assetType()));

        assertThat(sum).isEqualTo(400);
    }

    @Test
    void testPredicateGetStocks() {
        int sum = uut.sumValue(ASSETS, a -> Asset.AssetType.STOCK.equals(a.assetType()));

        assertThat(sum).isEqualTo(600);
    }
}
