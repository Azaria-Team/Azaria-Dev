package hpl.content.blocks;

import hpl.content.HPLItems;
import hpl.world.blocks.distribution.ModDuct;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.*;

import static mindustry.type.ItemStack.with;
public class HPLDistribution {
    public static Block
            hardenedConveyor, hardenedJunction, hardenedRouter, hardenedBridgeConveyor,
            impulseSorter, impulseGate;

    public static void load() {

        //sec1
        hardenedConveyor = new ModDuct("hardened-conveyor") {{
            requirements(Category.distribution, with(HPLItems.fors, 1));
            researchCost = with(Category.distribution, HPLItems.fors, 5);

            health = 210;
            speed = 5f;

            junctionReplacement = HPLDistribution.hardenedJunction;
            bridgeReplacement = HPLDistribution.hardenedBridgeConveyor;
        }};

        hardenedJunction = new Junction("hardened-junction") {{
            requirements(Category.distribution, with(HPLItems.fors, 2));
            researchCost = with(HPLItems.fors, 10);

            health = 140;
            speed = 6f;

            capacity = 1;
            buildCostMultiplier = 6f;
            squareSprite = false;
        }};

        hardenedRouter = new Router("hardened-router") {{
            requirements(Category.distribution, with(HPLItems.fors, 3));
            researchCost = with(HPLItems.fors, 15);

            health = 230;
            speed = 16f;

            squareSprite = false;
        }};

        hardenedBridgeConveyor = new DuctBridge("hardened-bridge-conveyor"){{
            requirements(Category.distribution, with(HPLItems.fors, 10));
            researchCost = with(HPLItems.fors, 35);

            health = 170;
            speed = 4f;

            buildCostMultiplier = 2f;
            squareSprite = false;
        }};

        //sec2
        impulseSorter = new Sorter("impulse-sorter"){{
            requirements(Category.distribution, with(HPLItems.fors, 4));
        }};

        impulseGate = new OverflowGate("impulse-gate"){{
            requirements(Category.distribution, with(HPLItems.fors, 6));
            buildCostMultiplier = 3;
        }};
    }
}
