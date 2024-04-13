package az.content.blocks;

import az.content.AZItems;
import az.world.blocks.distribution.ModDuct;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.meta.BlockGroup;

import static mindustry.type.ItemStack.with;

public class AZDistribution {
    public static Block
            hardenedConveyor, hardenedJunction, hardenedRouter, hardenedBridgeConveyor,
            impulseSorter, impulseReverseSorter, impulseOverflorGate, impulseUnderflowGate,

            hardenedUnloader;

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

        hardenedBridgeConveyor = new ItemBridge("hardened-bridge-conveyor"){{
            requirements(Category.distribution, with(AZItems.fors, 10));
            researchCost = with(AZItems.fors, 35);
            bridgeWidth = 8F;
            health = 170;
            range = 5;

            buildCostMultiplier = 2f;
            squareSprite = false;
        }};

        //sec2
        impulseSorter = new Sorter("impulse-sorter"){{
            requirements(Category.distribution, with(AZItems.fors, 4));
        }};

        impulseReverseSorter = new Sorter("impulse-reverse-sorter") {{
            requirements(Category.distribution, with(AZItems.fors, 4));
            invert = true;
        }};

        impulseOverflorGate = new OverflowGate("impulse-overflow-gate"){{
            requirements(Category.distribution, with(AZItems.fors, 6));
            buildCostMultiplier = 3;
        }};
        impulseUnderflowGate = new OverflowGate("impulse-underflow-gate") {{
            requirements(Category.distribution, with(AZItems.fors, 6));
            invert = true;
        }};

        hardenedUnloader = new Unloader("hardened-unloader") {{
            requirements(Category.distribution, with(AZItems.superdenseAlloy, 15, AZItems.fors, 5));
            health = 300;
            speed = 60.0f / 11.0f;

            group = BlockGroup.transportation;
            squareSprite = false;
        }};
    }
}
