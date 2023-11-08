package az.content.blocks;

import az.content.AZItems;
import az.world.blocks.distribution.ModDuct;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.*;

import static mindustry.type.ItemStack.with;

public class AZDistribution {
    public static Block
            hardenedConveyor, hardenedJunction, hardenedRouter, hardenedBridgeConveyor,
            impulseSorter, impulseGate;

    public static void load() {
        hardenedConveyor = new ModDuct("hardened-conveyor") {{
            requirements(Category.distribution, with(AZItems.fors, 1));
            health = 130;
            speed = 5f;
            researchCost = with(AZItems.fors, 5);
            junctionReplacement = AZDistribution.hardenedJunction;
            bridgeReplacement = AZDistribution.hardenedBridgeConveyor;
        }};
        hardenedJunction = new Junction("hardened-junction") {{
            requirements(Category.distribution, with(AZItems.fors, 2));
            researchCost = with(AZItems.fors, 10);
            speed = 6;
            capacity = 1;
            health = 140;
            buildCostMultiplier = 6f;
            squareSprite = false;
        }};
        hardenedRouter = new Router("hardened-router") {{
            requirements(Category.distribution, with(AZItems.fors, 3));
            researchCost = with(AZItems.fors, 15);
            speed = 16;
            squareSprite = false;
        }};
        impulseSorter = new Sorter("impulse-sorter"){{
            requirements(Category.distribution, with(AZItems.fors, 4));
        }};
        impulseGate = new OverflowGate("impulse-gate"){{
            requirements(Category.distribution, with(AZItems.fors, 6));
            buildCostMultiplier = 3f;
        }};
        hardenedBridgeConveyor = new DuctBridge("impulse-bridge-conveyor"){{
            requirements(Category.distribution, with(AZItems.fors, 10));
            researchCost = with(AZItems.fors, 20);
            health = 90;
            speed = 4f;
            buildCostMultiplier = 2f;
            researchCostMultiplier = 0.3f;
            squareSprite = false;
        }};
    }
}
