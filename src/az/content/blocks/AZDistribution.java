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
        //sec1
        hardenedConveyor = new ModDuct("hardened-conveyor") {{
            requirements(Category.distribution, with(AZItems.fors, 1));
            researchCost = with(AZItems.fors, 5);

            health = 210;
            speed = 5f;

            junctionReplacement = AZDistribution.hardenedJunction;
            bridgeReplacement = AZDistribution.hardenedBridgeConveyor;
        }};

        hardenedJunction = new Junction("hardened-junction") {{
            requirements(Category.distribution, with(AZItems.fors, 2));
            researchCost = with(AZItems.fors, 10);

            health = 140;
            speed = 6f;

            capacity = 1;
            buildCostMultiplier = 6f;
            squareSprite = false;
        }};

        hardenedRouter = new Router("hardened-router") {{
            requirements(Category.distribution, with(AZItems.fors, 3));
            researchCost = with(AZItems.fors, 15);

            health = 230;
            speed = 16f;

            squareSprite = false;
        }};

        hardenedBridgeConveyor = new DuctBridge("hardened-bridge-conveyor"){{
            requirements(Category.distribution, with(AZItems.fors, 10));
            researchCost = with(AZItems.fors, 35);

            health = 170;
            speed = 4f;

            buildCostMultiplier = 2f;
            squareSprite = false;
        }};

        //sec2
        impulseSorter = new Sorter("impulse-sorter"){{
            requirements(Category.distribution, with(AZItems.fors, 4));
        }};

        impulseGate = new OverflowGate("impulse-gate"){{
            requirements(Category.distribution, with(AZItems.fors, 6));
            buildCostMultiplier = 3;
        }};
    }
}
