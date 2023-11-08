package az.content;

import az.content.blocks.*;
import az.content.blocks.AZDistribution;

public class AZBlocks {
    public static void load() {
        AZCoreRelatedBlocks.load();
        AZDistribution.load();
        AZDrills.load();
        AZEnvironment.load();
        AZLiquidBlocks.load();
        AZPower.load();
        AZProduction.load();
        AZSandbox.load();
        AZTurrets.load();
        AZUnitRelatedBlocks.load();
        AZWalls.load();
    }
}
